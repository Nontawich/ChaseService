package com.chase.chaseservice.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RegisterPageDto implements Serializable {
    private List<TitleDto> titleList;
    private List<ProvinceDto> provinceList;
    private List<EducationTypeDto> educationTypeList;
    private List<SexualDto> sexualDtoList;

    public RegisterPageDto(List<TitleDto> titleList, List<ProvinceDto> provinceList, List<EducationTypeDto> educationTypeList,List<SexualDto> sexualDtoList) {
        this.titleList = titleList;
        this.provinceList = provinceList;
        this.educationTypeList = educationTypeList;
        this.sexualDtoList = sexualDtoList;
    }

    public RegisterPageDto(){

    }
}
