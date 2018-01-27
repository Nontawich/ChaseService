package com.chase.chaseservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CandidateListDto implements Serializable{

    private String candidateId;
    private String candidateFullName;
    private String candidateAge;
    private String candidateRegisterDate;
    private String candidateStatus;
    private String candidateSexual;
    private String candidateIdCard;
    private String candidateFileId;
    public CandidateListDto() {
    }


    public CandidateListDto(String candidateId, String candidateFullName, String candidateAge, String candidateRegisterDate, String candidateStatus, String candidateSexual, String candidateIdCard, String candidateFileId) {
        this.candidateId = candidateId;
        this.candidateFullName = candidateFullName;
        this.candidateAge = candidateAge;
        this.candidateRegisterDate = candidateRegisterDate;
        this.candidateStatus = candidateStatus;
        this.candidateSexual = candidateSexual;
        this.candidateIdCard = candidateIdCard;
        this.candidateFileId = candidateFileId;
    }
}
