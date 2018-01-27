package com.chase.chaseservice.controller;


import com.chase.chaseservice.domain.ChaseDocument;
import com.chase.chaseservice.dto.*;
import com.chase.chaseservice.services.interfaces.DocumentManagementService;
import com.chase.chaseservice.services.interfaces.RegistarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/register")
@CrossOrigin(maxAge = 3600)
public class RegisterController {

    @Autowired
    private DocumentManagementService docService ;

    @Autowired
    private RegistarService registarService;

    private final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    private static String UPLOADED_FOLDER = "D://temp//";




    @RequestMapping(value = "/saveCandidate" , method = { RequestMethod.POST  })
    @ResponseBody
    public HashMap<String,Object> saveCandidate( @RequestBody(required = true) Map<String, Object> payload ) {
        HashMap<String,Object> result =new HashMap<String,Object>();
        ObjectMapper mapper = new ObjectMapper();
        RegisterDto registerDto = mapper.convertValue(payload, RegisterDto.class);
        Integer regisId = registarService.saveRequestForm(registerDto);
        if(regisId!=0&&regisId!=null){
            result.put("result",1);
            result.put("regisId",regisId);
        }else{
            result.put("result",2);
        }
        ;
        return result;
    }



    @RequestMapping(value = "/getCandidateList" , method = { RequestMethod.POST  })
    @ResponseBody
    public  HashMap<String,Object>  getCandidateList( @RequestBody(required = true) Map<String, Object> payload ) {
        HashMap<String,Object> result = new HashMap<String,Object>();
        List<CandidateListDto> candidateListDto = registarService.getRegisterList(payload);
        result.put("candidateList",candidateListDto);
        return result;
    }



    @RequestMapping(value = "/getCandidateDetail" , method = { RequestMethod.POST  })
    @ResponseBody
    public  HashMap<String,Object>  getCandidateDetail( @RequestBody(required = true) Map<String, Object> payload ) {
        HashMap<String,Object> result = new HashMap<String,Object>();
        CandidateDetailDto candidateDetailDto = registarService.getCandidateDetail(payload);
        result.put("candidateDetail",candidateDetailDto);
        return result;
    }


    // Multiple file upload
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public HashMap<String,Object> uploadFileMulti(
            @RequestParam("regisId") String regisId,
            @RequestParam("files") MultipartFile[] uploadfiles) {
        HashMap<String,Object> result = new HashMap<String,Object>();
        String uploadedFileName = Arrays.stream(uploadfiles).map(x -> x.getOriginalFilename())
                .filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));

        if (StringUtils.isEmpty(uploadedFileName)) {
            result.put("result", "99");
            return result;
        }

        try {
            saveUploadedFiles(regisId,1,Arrays.asList(uploadfiles));

        } catch (Exception e) {
            result.put("result", "99");
            return result;
        }

         result.put("result", "1");
        return result;

    }


    //list by owner
    @RequestMapping(value="/file/list/{owner:.+}" , method = RequestMethod.GET)
    @ResponseBody
    public List<ChaseDocumentDto> listFileByOwner(@PathVariable String owner) {
        List<ChaseDocumentDto> acfsDoc = new ArrayList<>();
        try{
            acfsDoc = docService.findByOwner(owner);
        }catch (Exception e) {
            e.printStackTrace();
            return acfsDoc;
        }

        return acfsDoc;
    }

    //list file History
    @RequestMapping( value="/file/history/{fileid:.+}" , method = RequestMethod.GET)
    @ResponseBody
    public List<ChaseDocumentDto> listFileHistory(@PathVariable String fileid) {
        List<ChaseDocumentDto> acfsDoc = new ArrayList<>();
        try{
            acfsDoc = getDocByIdRec(Long.valueOf(fileid), acfsDoc);
        }catch (Exception e) {
            e.printStackTrace();
            return acfsDoc;
        }

        return acfsDoc;
    }

    //Download
    @GetMapping("/file/download/{fileid:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String fileid) {
        Resource files = null;
        String filename = "";
        try{
            ChaseDocument acfsDoc = docService.findById(Long.valueOf(fileid));
            filename = acfsDoc.getFilename();
            Path path = Paths.get(getPathById(fileid,false)+getMD5(fileid));
            Resource resource = new UrlResource(path.toUri());
            if(resource.exists() || resource.isReadable()) {
                files = resource;
            }
            else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+filename+"\"").body(files);
    }

    @DeleteMapping("/file/delete/{fileid:.+}")
    @ResponseBody
    public ResponseEntity<Resource> deleteFile(@PathVariable String fileid) {
        Resource files = null;
        String filename = "";
        try{
            ChaseDocument acfsDoc = docService.findById(Long.valueOf(fileid));
            filename = acfsDoc.getFilename();
            acfsDoc = docService.deleteFile(acfsDoc);
            if(acfsDoc.getStatus().equalsIgnoreCase("I")){
                filename = acfsDoc.getFilename();
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("Successfully delete - " + filename, HttpStatus.OK);
    }

    @PostMapping("/file/update")
    public ResponseEntity<?> updateFile(
            @RequestParam("owner") String owner,
            @RequestParam("oldid") String oldid,
            @RequestParam("updateby") String updateby,
            @RequestParam("memo") String memo,
            @RequestParam("fileType") String fileType,
            @RequestParam("file") MultipartFile uploadfile) {

        logger.debug("Single file upload!");

        if (uploadfile.isEmpty()) {
            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }

        try {
            ChaseDocument acfsDoc = docService.findById(Long.valueOf(oldid));
            docService.deleteFile(acfsDoc);
            saveUploadedFiles(owner,acfsDoc.getVersion()+1,Arrays.asList(uploadfile));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("Successfully uploaded - " +
                uploadfile.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);

    }

    //save file
    private void saveUploadedFiles(String owner, int version, List<MultipartFile> files) throws Exception {

        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue; //next pls
            }
            ///Gen id
            Long id = ThreadLocalRandom.current().nextLong(999999999999L);
            String realPath = getPathById(id.toString(),true);
            if(realPath.length() > 0){
                byte[] bytes = file.getBytes();
                Path path = Paths.get(realPath+getMD5(id.toString()));
                Files.write(path, bytes);

                ////Insert DB
                ChaseDocument acfsDoc = new ChaseDocument();
                acfsDoc.setDmid(id);
                acfsDoc.setFilename(file.getOriginalFilename());
                acfsDoc.setOwner(Integer.valueOf(owner));
                acfsDoc.setUpdatedate(new Date());
                acfsDoc.setCreateBy(Integer.valueOf(owner));
                acfsDoc.setCreateDate(new Date());
                acfsDoc.setVersion(version);
                acfsDoc.setStatus("A");
                docService.add(acfsDoc);
            }
        }

    }

    private String getPathById(String id,boolean createOrNot) throws Exception{
        String path = "";
        boolean success = false;
        String md = getMD5(id);
        List<String> pathMd5Raw = splitStringByNumber(md);
        String pathMd5 = String.join("/", pathMd5Raw);

        if(createOrNot)
            success = (new File(UPLOADED_FOLDER+"/"+pathMd5)).mkdirs();
        return UPLOADED_FOLDER+"/"+pathMd5+"/";
    }

    private String getMD5(String id) throws Exception{
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(id.getBytes(),0, id.length());
        String hashedPass = new BigInteger(1,messageDigest.digest()).toString(16);
        if (hashedPass.length() < 32) {
            hashedPass = "0" + hashedPass;
        }

        return hashedPass;
    }

    private List<String> splitStringByNumber(String text) throws Exception{
        List<String> strings = new ArrayList<String>();
        int index = 0;
        while (index < text.length()) {
            strings.add(text.substring(index, Math.min(index + 4,text.length())));
            index += 4;
        }
        return strings;
    }

    private List<ChaseDocumentDto> getDocByIdRec(Long id, List<ChaseDocumentDto> oldList) throws Exception{
        ChaseDocument doc = docService.findById(id);
        if(doc!=null) {
//            oldList.add(new ChaseDocumentDto(doc.getDmid(), doc.getFilename(), doc.getVersion(), doc.getOwner(), doc.getDmidparent(),doc.getStatus(), doc.getMemo(),
//                    doc.getFileStatus(), doc.getCreateBy(), doc.getCreateDate(), doc.getFileMode(), doc.getUpdatedate(), doc.getUpdateby(), doc.getFileTypeId()));
        }
        if(doc.getDmidparent() != null){
            getDocByIdRec(doc.getDmidparent(),oldList);
        }
        return oldList;
    }
}
