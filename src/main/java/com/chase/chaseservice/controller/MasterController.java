package com.chase.chaseservice.controller;

import com.chase.chaseservice.dto.DistrictDto;
import com.chase.chaseservice.dto.ModuleDto;
import com.chase.chaseservice.dto.RegisterPageDto;
import com.chase.chaseservice.dto.SubDistrictDto;
import com.chase.chaseservice.services.interfaces.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/master")
public class MasterController {

 @Autowired
 private MasterService masterService;


    @RequestMapping(value = "/getMenu" , method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public HashMap<String,Object> getCafeteriaByPersonType(@RequestParam(value = "personType", required = false) String personType ,
                                                           @RequestParam(value = "locale", required = false) String locale,
                                                           @RequestBody(required = false) Map<String, Object> payload,
                                                           HttpServletRequest request) {
        HashMap<String,Object> result =new HashMap<String,Object>();
        List<ModuleDto> moduleList = new ArrayList<ModuleDto>();
        if(request.getMethod().equals("GET")){
            moduleList = masterService.getMenu(personType,locale);
        }else{
            moduleList = masterService.getMenu(String.valueOf(payload.get("personType")),String.valueOf(payload.get("locale")));
        }
        result.put("module",moduleList);
        return result;
    }


    @RequestMapping(value = "/getMasterRegisterList" , method = { RequestMethod.GET, RequestMethod.POST  })
    @ResponseBody
    public HashMap<String,Object> getCafeteriaByPersonType(@RequestParam(value = "locale", required = false) String locale,
            @RequestBody(required = false) Map<String, Object> payload , HttpServletRequest request) {
        HashMap<String,Object> result =new HashMap<String,Object>();
        RegisterPageDto registerPageDto = new RegisterPageDto();
        if(request.getMethod().equals("GET")) {
            registerPageDto = masterService.getRegisterPage(locale);
        }else{
            registerPageDto = masterService.getRegisterPage(String.valueOf(payload.get("locale")));
        }
        result.put("registerPageDto",registerPageDto);
        return result;
    }



    @RequestMapping(value = "/getDistrictByProvince" , method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public HashMap<String,Object> getDistrictByProvine(@RequestParam(value = "provinceId" , required = false) String provinceId,
                                                       @RequestBody(required = false) Map<String, Object> payload, HttpServletRequest request) {
        HashMap<String,Object> result =new HashMap<String,Object>();
        List<DistrictDto> districtDtoList = new ArrayList<DistrictDto>();
        if(request.getMethod().equals("GET")) {
            districtDtoList = masterService.getDistrictByProvince(provinceId);
        }else{
            districtDtoList = masterService.getDistrictByProvince(String.valueOf(payload.get("provinceId")));
        }
        result.put("districtList",districtDtoList);
        return result;
    }

    @RequestMapping(value = "/getSubDistrictByDistrict" , method = {RequestMethod.GET, RequestMethod.POST  })
    @ResponseBody
    public HashMap<String,Object> getSubDistrictByDistrict(@RequestParam(value = "districtId" , required = false) String districtId,
                                                           @RequestBody(required = false) Map<String, Object> payload, HttpServletRequest request) {
        HashMap<String,Object> result =new HashMap<String,Object>();
        List<SubDistrictDto> subDistrictDtoList = new ArrayList<SubDistrictDto>();
        if(request.getMethod().equals("GET")) {
            subDistrictDtoList = masterService.getSubDistrictByDistrict(districtId);
        }else{
            subDistrictDtoList = masterService.getSubDistrictByDistrict(String.valueOf(payload.get("districtId")));
        }
        result.put("subDistrictList",subDistrictDtoList);
        return result;
    }

}
