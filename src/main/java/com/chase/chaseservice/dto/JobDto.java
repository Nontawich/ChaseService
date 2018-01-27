package com.chase.chaseservice.dto;

import lombok.Data;

@Data
public class JobDto {
    private String companyName;
    private String jobType;
    private String position;
    private String startYear;
    private String endYear;
    private String salary;
}
