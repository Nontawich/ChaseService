package com.chase.chaseservice.services.impl;

import com.chase.chaseservice.domain.*;
import com.chase.chaseservice.dto.*;
import com.chase.chaseservice.repository.*;
import com.chase.chaseservice.services.interfaces.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MasterServieImpl implements MasterService {

    public MasterServieImpl() {
    }

    public MasterServieImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    ProvinceRepository provinceRepository;

    @Autowired
    SubDistrictRepository subDistrictRepository;

    @Autowired
    TitleRepository titleRepository;

    @Autowired
    EducationTypeRepository educationTypeRepository;

    @Autowired
    SexualRepository sexualRepository;

    @Override
    public List<ModuleDto> getMenu(String personType, String locale) {
        List<ModuleDto> moduleList = new ArrayList<ModuleDto>();
        List<Object[]> backOfficeModule = menuRepository.getMenu(Integer.valueOf(personType),  locale);
        List<MenuDto> menu = new ArrayList<MenuDto>();
        String tempMenu = "";
        if (null != backOfficeModule) {
            Integer i = 0;
            ModuleDto backOfficeDto = new ModuleDto();
            MenuDto backofficeMenuDto = new MenuDto();
            menu = new ArrayList<MenuDto>();
            for (Object[] module : backOfficeModule) {
                if (String.valueOf(module[0]).equals(tempMenu)) {
                    backofficeMenuDto = new MenuDto(String.valueOf(module[4]), String.valueOf(module[5]), String.valueOf(module[6]), String.valueOf(module[7]), String.valueOf(module[9]));
                    menu.add(backofficeMenuDto);
                } else {
                    if (i != 0) {
                        backOfficeDto.setMenu(menu);
                        moduleList.add(backOfficeDto);
                    }
                    menu = new ArrayList<MenuDto>();
                    tempMenu = String.valueOf(module[0]);
                    backOfficeDto = new ModuleDto(String.valueOf(module[0]), String.valueOf(module[1]), String.valueOf(module[2]), String.valueOf(module[3]), String.valueOf(module[8]), String.valueOf(module[10]));
                    if (!String.valueOf(module[4]).equalsIgnoreCase("null")) {
                        backofficeMenuDto = new MenuDto(String.valueOf(module[4]), String.valueOf(module[5]), String.valueOf(module[6]), String.valueOf(module[7]), String.valueOf(module[9]));
                        menu.add(backofficeMenuDto);
                    }
                }
                if (i == backOfficeModule.size() - 1) {
                    backOfficeDto.setMenu(menu);
                    moduleList.add(backOfficeDto);
                }
                i++;
            }
        }
        return moduleList;
    }

    @Override
    public RegisterPageDto getRegisterPage(String locale){

        List<TitleDto> titleList = new ArrayList<TitleDto>();
        List<ProvinceDto> provinceList = new ArrayList<ProvinceDto>();
        List<EducationTypeDto> educationTypeList = new ArrayList<EducationTypeDto>();
        List<SexualDto> sexualDtoList = new ArrayList<SexualDto>();

        List<MsTitleEntity> titleEntityList = titleRepository.getAllByStatusEqualsOrderByTitleId("A");
        List<MsProvinceEntity> provinceEntityList = provinceRepository.getAllByStatusEqualsOrderByProvinceNameAsc("A");
        List<MsEducationTypeEntity> educationTypeEntityList = educationTypeRepository.getAllByStatusEqualsOrderBySeqAsc("A");
        List<MsSexualEntity> sexualEntityList = sexualRepository.getAllByStatusEqualsOrderBySexualIdAsc("A");

        for(MsTitleEntity msTitleEntity:titleEntityList){
            titleList.add(new TitleDto(String.valueOf(msTitleEntity.getTitleId()), String.valueOf(locale.equalsIgnoreCase("TH") ?
                    msTitleEntity.getTitleNameTh() : msTitleEntity.getTitleNameEn())));
        }

        for(MsSexualEntity msSexualEntity:sexualEntityList){
            sexualDtoList.add(new SexualDto(String.valueOf(msSexualEntity.getSexualId()), String.valueOf(locale.equalsIgnoreCase("TH") ?
                    msSexualEntity.getSexualNameTh() : msSexualEntity.getSexualNameEn())));
        }

        for (MsProvinceEntity msProvinceEntity : provinceEntityList) {
            provinceList.add(new ProvinceDto(String.valueOf(msProvinceEntity.getProvinceId()),
                    String.valueOf(msProvinceEntity.getProvinceName() )));
        }

        for (MsEducationTypeEntity msEducationTypeEntity : educationTypeEntityList) {
            educationTypeList.add(new EducationTypeDto(String.valueOf(msEducationTypeEntity.getEducationId()),
                    String.valueOf(locale.equalsIgnoreCase("TH") ?
                            msEducationTypeEntity.getEducationNameTh() : msEducationTypeEntity.getEducationNameEn())));
        }
        RegisterPageDto registerPageDto = new RegisterPageDto(titleList,provinceList,educationTypeList,sexualDtoList);
        return registerPageDto;
    }


    @Override
    public List<DistrictDto> getDistrictByProvince(String provinceId){

        List<DistrictDto> districtDtoList = new ArrayList<DistrictDto>();
        List<MsDistrictEntity> districtEntityList = new ArrayList<MsDistrictEntity>();
        districtEntityList = districtRepository.getAllByStatusEqualsAndProvinceIdEqualsOrderByDistrictName("A", Integer.valueOf(provinceId));
        for(MsDistrictEntity districtEntity:districtEntityList){
            districtDtoList.add(new DistrictDto(String.valueOf(districtEntity.getDistrictId())
                    , String.valueOf(districtEntity.getDistrictName()), String.valueOf(districtEntity.getPostCode())));
        }

        return districtDtoList;
    }

    @Override
    public List<SubDistrictDto> getSubDistrictByDistrict(String districtId){
        List<SubDistrictDto> subDistrictDtoList = new ArrayList<SubDistrictDto>();
        List<MsSubDistrictEntity> subDistrictEntityList = new ArrayList<MsSubDistrictEntity>();
        subDistrictEntityList = subDistrictRepository.getAllByDistrictIdEqualsOrderBySubDistrictName(Integer.valueOf(districtId));
        for(MsSubDistrictEntity msSubDistrictEntity :subDistrictEntityList){
            subDistrictDtoList.add(new SubDistrictDto(String.valueOf(msSubDistrictEntity.getSubDistrictId())
                    , String.valueOf(msSubDistrictEntity.getSubDistrictName())));
        }

        return subDistrictDtoList;
    }
}
