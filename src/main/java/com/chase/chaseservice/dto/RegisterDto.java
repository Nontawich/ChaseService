package com.chase.chaseservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class RegisterDto {

    private String candidateTitleId;
    private String candidateName;
    private String candidateSurName;
    private String candidateIdCard;
    private String candidateBirthDate;
    private String candidateAddressNo;
    private String candidateDistrict;
    private String candidateSubDistrict;
    private String candidateProvince;
    private String candidatePostalCode;
    private String expectSalary;
    private String candidatePicture;
    private String candidateEmail;
    private String candidatePhone;
    private String candidateMobile;
    private String experience;
    private String avaliableId;
    private String sexual;
    EducationDto education;
    private List<JobDto> jobDto;
}
