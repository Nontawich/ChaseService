package com.chase.chaseservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProvinceDto implements Serializable {
    private String provinceId;
    private String provinceName;

    public ProvinceDto(String provinceId, String provinceName) {
        this.provinceId = provinceId;
        this.provinceName = provinceName;
    }
}
