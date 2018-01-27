package com.chase.chaseservice.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.io.Serializable;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class MenuDto implements Serializable {
    private String id;
    private String menuCode;
    private String menuName;
    private String enable;
    private String menuPath;


    public MenuDto() {
    }

    public MenuDto(String id,  String menuCode, String menuName, String enable, String menuPath) {
        this.id = id;
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.enable = enable;
        this.menuPath = menuPath;
    }
}
