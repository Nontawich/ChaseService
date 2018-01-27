package com.chase.chaseservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DistrictDto implements Serializable {
    private String districtId;
    private String districtName;
    private String postalCode;

    public DistrictDto(String districtId, String districtName, String postalCode) {
        this.districtId = districtId;
        this.districtName = districtName;
        this.postalCode = postalCode;
    }
}
