package com.chase.chaseservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubDistrictDto  implements Serializable{
    private String subDistrictId;
    private String subDistrictName;

    public SubDistrictDto(String subDistrictId, String subDistrictName) {
        this.subDistrictId = subDistrictId;
        this.subDistrictName = subDistrictName;
    }
}
