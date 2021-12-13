package cn.edu.tongji.webchat.webchatbackend.dto;/*
    @Created by Jary-Li on 2021/12/13. All rights reserved.
    @Name: web-chat
    @Description：
*/

public class LoginDTO {
    private String chattoken;
    private String userName;

    public LoginDTO(String chattoken, String userName) {
        this.chattoken = chattoken;
        this.userName = userName;
    }

    public String getChattoken() {
        return chattoken;
    }

    public void setChattoken(String chattoken) {
        this.chattoken = chattoken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "{" +
                "chattoken='" + chattoken + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
