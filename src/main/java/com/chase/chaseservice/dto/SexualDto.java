package com.chase.chaseservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SexualDto  implements Serializable {

    private String sexualId;
    private String sexualName;

    public SexualDto(String sexualId, String sexualName) {
        this.sexualId = sexualId;
        this.sexualName = sexualName;
    }
}
