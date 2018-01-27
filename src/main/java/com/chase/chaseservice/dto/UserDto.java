package com.chase.chaseservice.dto;

import lombok.Data;

@Data
public class UserDto {

    private String userId;
    private String userName;
    private String fullName;
    private String roleId;

    public UserDto() {
        super();
    }

    public UserDto(String userId, String userName,  String fullName, String roleId) {
        this.userId = userId;
        this.userName = userName;
        this.fullName = fullName;
        this.roleId = roleId;
    }
}
