package com.chase.chaseservice.services.impl;

import com.chase.chaseservice.domain.CandidateEducationEntity;
import com.chase.chaseservice.domain.CandidateEntity;
import com.chase.chaseservice.domain.CandidateWorkEntity;
import com.chase.chaseservice.domain.RegisterListViewEntity;
import com.chase.chaseservice.dto.*;
import com.chase.chaseservice.domain.RegisteDetailEntity;
import com.chase.chaseservice.repository.*;
import com.chase.chaseservice.services.interfaces.RegistarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class RegisterServiceImpl implements RegistarService{

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    CandidateEducationRepository candidateEducationRepository;

    @Autowired
    CandidateWorkingRepository candidateWorkingRepository;

    @Autowired
    RegisterListRepository registerListRepository;

    @Autowired
    RegisterDetailRepository registerDetailRepository;



    @Override
    public Integer saveRequestForm(RegisterDto registerDto){
        Integer registerId = new Integer(0);
        DateFormat format = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
        Date birthDate = new Date();
        CandidateEntity candidateEntity = new CandidateEntity();
        try {
             birthDate = format.parse(registerDto.getCandidateBirthDate());
             candidateEntity = new CandidateEntity(
                    Integer.valueOf(registerDto.getCandidateTitleId()),
                            registerDto.getCandidateName(), registerDto.getCandidateSurName() ,
                            registerDto.getCandidateIdCard(), birthDate,
                            registerDto.getCandidateAddressNo(), Integer.valueOf(registerDto.getCandidateDistrict()),
                    Integer.valueOf(registerDto.getCandidateSubDistrict()), Integer.valueOf(registerDto.getCandidateProvince()),
                    registerDto.getCandidatePostalCode(),registerDto.getExperience(),registerDto.getExpectSalary()
                    ,registerDto.getCandidatePicture(), new Date(), new Date(), "W",
                    registerDto.getCandidateEmail(),registerDto.getCandidatePhone(),registerDto.getCandidateMobile(),Integer.valueOf(registerDto.getAvaliableId()), Integer.valueOf(registerDto.getSexual())
                    );
             candidateEntity = candidateRepository.save(candidateEntity);
             registerId = candidateEntity.getCanId();
            if(registerId != null&&registerId!=0){
                List<CandidateWorkEntity> candidateWorkEntityList = new ArrayList<CandidateWorkEntity>();
                CandidateEducationEntity candidateEducationEntity = new CandidateEducationEntity(
                        Integer.valueOf(registerDto.getEducation().getEducationType()), registerDto.getEducation().getEducationFaculty(),
                        registerDto.getEducation().getEducationBranch(),registerDto.getEducation().getEducationInstitute(),
                        registerId,registerDto.getEducation().getEducationStart(),registerDto.getEducation().getEducationEnd(),
                        "A",registerDto.getEducation().getEducationGpa()
                );

                for (JobDto jobDto:registerDto.getJobDto()) {
                    candidateWorkEntityList.add(new CandidateWorkEntity(jobDto.getCompanyName(),jobDto.getJobType(),registerId,
                            jobDto.getSalary(),jobDto.getStartYear(),jobDto.getEndYear(),"A",new Date(), new Date()));
                }

                candidateEducationRepository.save(candidateEducationEntity);
                candidateWorkingRepository.save(candidateWorkEntityList);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch(Exception e2){
            e2.printStackTrace();
            candidateRepository.delete(candidateEntity);
        }
        return registerId;
    }

    public List<CandidateListDto> getRegisterList(Map<String, Object> payload ){
        List<CandidateListDto> registerList = new ArrayList<CandidateListDto>();
        String idCard = String.valueOf(payload.get("idCard")).equalsIgnoreCase("null")? "%%" : "%"+ String.valueOf(payload.get("idCard"))+"%";
        String fullName = String.valueOf(payload.get("fullName")).equalsIgnoreCase("null")? "%%" : "%"+ String.valueOf(payload.get("fullName"))+"%";

        List<RegisterListViewEntity> registerListViewEntityList = registerListRepository.getAllByIdCardLikeAndCandidateFullNameLikeOrderByCandidateFullNameAsc(idCard,fullName);
        for ( RegisterListViewEntity registerListViewEntity: registerListViewEntityList){
            CandidateListDto candidateListDto = new CandidateListDto(String.valueOf(registerListViewEntity.getCandidateId()), registerListViewEntity.getCandidateFullName(),
                    registerListViewEntity.getAge(), registerListViewEntity.getRegisterDate(), registerListViewEntity.getStatus(),registerListViewEntity.getSexual(),
                    registerListViewEntity.getIdCard(), registerListViewEntity.getFileId()
                    );
            registerList.add(candidateListDto);
        }
        return registerList;
    }

    public CandidateDetailDto getCandidateDetail(Map<String, Object> payload ){
        CandidateDetailDto candidateDetailDto = new CandidateDetailDto();
        RegisteDetailEntity registeDetailEntity  = registerDetailRepository.getFirstByCandidateIdEquals(Integer.valueOf(payload.get("id").toString()));
       List<WorkingInfoDto> workingInfoDtoList = new ArrayList<WorkingInfoDto>();
        candidateDetailDto= new CandidateDetailDto(String.valueOf(registeDetailEntity.getCandidateId()), registeDetailEntity.getCandidateFullname(), registeDetailEntity.getFileId()
        ,registeDetailEntity.getSexual(),registeDetailEntity.getAge(),registeDetailEntity.getEmail(),registeDetailEntity.getCandidateIdCard(),registeDetailEntity.getPhone(),
                registeDetailEntity.getMobile(),registeDetailEntity.getExp(),registeDetailEntity.getExpSalary(),registeDetailEntity.getAddressNo(),
                registeDetailEntity.getSubDistrictName(),registeDetailEntity.getDistrictName(),registeDetailEntity.getProvinceName(),registeDetailEntity.getPostalCode(),registeDetailEntity.getInstitute(),
                registeDetailEntity.getYearEdu(), registeDetailEntity.getFaculty(),registeDetailEntity.getBranch(),registeDetailEntity.getGpa(),null);

        List<CandidateWorkEntity> candidateWorkEntityList = candidateWorkingRepository.getAllByCandidateIdEqualsOrderByJobStartAsc(Integer.valueOf(payload.get("id").toString()));

        for(CandidateWorkEntity candidateWorkEntity:candidateWorkEntityList){
            WorkingInfoDto workingInfoDto = new WorkingInfoDto(candidateWorkEntity.getCompanyName(),candidateWorkEntity.getJobType(),
                    String.valueOf(candidateWorkEntity.getJobStart()) + " - " +String.valueOf(candidateWorkEntity.getJobEnd()),candidateWorkEntity.getSalary() );
            workingInfoDtoList.add(workingInfoDto);
        }
        candidateDetailDto.setWorkinghis(workingInfoDtoList);
        return candidateDetailDto;
    }
}
