package cn.edu.tongji.webchat.webchatbackend.dto;/*
    @Created by Jary-Li on 2021/12/10. All rights reserved.
    @Name: web-chat
    @Description：
*/

import lombok.Getter;
import lombok.Setter;

public class RegisterDTO {

    private Long userId;
    private String userName;
    private String userPassword;

    public RegisterDTO(Long userId, String userName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
