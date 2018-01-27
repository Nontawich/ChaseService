package com.chase.chaseservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EducationTypeDto implements Serializable{
    private String educationId;
    private String educationName;

    public EducationTypeDto(String educationId, String educationName) {
        this.educationId = educationId;
        this.educationName = educationName;
    }
}
