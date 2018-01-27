package com.chase.chaseservice.dto;

import lombok.Data;

@Data
public class WorkingInfoDto {
    private String companyName;
    private String position;
    private String year;
    private String salary;

    public WorkingInfoDto(String companyName, String position, String year, String salary) {
        this.companyName = companyName;
        this.position = position;
        this.year = year;
        this.salary = salary;
    }

    public WorkingInfoDto() {
    }
}
