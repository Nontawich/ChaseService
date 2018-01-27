package com.chase.chaseservice.dto;


import lombok.Data;

import java.util.List;

@Data
public class CandidateDetailDto {

    private String id;
    private String fullName;
    private String fileId;
    private String sexual;
    private String age;
    private String email;
    private String idCard;
    private String phone;
    private String mobile;
    private String workingExp;
    private String expSalary;
    private String addressNo;
    private String subDistrict;
    private String district;
    private String province;
    private String postCode;
    private String institute;
    private String year;
    private String faculty;
    private String branch;
    private String gpax;
    List<WorkingInfoDto> workinghis;

    public CandidateDetailDto(String id, String fullName, String fileId, String sexual, String age, String email, String idCard, String phone, String mobile, String workingExp, String expSalary, String addressNo, String subDistrict, String district, String province, String postCode, String institute, String year, String faculty, String branch, String gpax, List<WorkingInfoDto> workinghis) {
        this.id = id;
        this.fullName = fullName;
        this.fileId = fileId;
        this.sexual = sexual;
        this.age = age;
        this.email = email;
        this.idCard = idCard;
        this.phone = phone;
        this.mobile = mobile;
        this.workingExp = workingExp;
        this.expSalary = expSalary;
        this.addressNo = addressNo;
        this.subDistrict = subDistrict;
        this.district = district;
        this.province = province;
        this.postCode = postCode;
        this.institute = institute;
        this.year = year;
        this.faculty = faculty;
        this.branch = branch;
        this.gpax = gpax;
        this.workinghis = workinghis;
    }

    public CandidateDetailDto() {
    }
}
