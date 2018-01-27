package com.chase.chaseservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TitleDto implements Serializable {
    private String titleId;
    private String titleName;

    public TitleDto(String titleId, String titleName) {
        this.titleId = titleId;
        this.titleName = titleName;
    }
}
