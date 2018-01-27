package com.chase.chaseservice.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ModuleDto implements Serializable {
    private String id;
    private String moduleCode;
    private String moduleName;
    private String enable;
    private String modulePath;
    private String moduleIcon;
    private List<MenuDto> menu;


    public ModuleDto() {
    }

    public ModuleDto(String id,  String moduleCode, String moduleName, String enable, String modulePath, String moduleIcon) {
        this.id = id;
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.enable = enable;
        this.modulePath = modulePath;
        this.moduleIcon = moduleIcon;
    }
}
