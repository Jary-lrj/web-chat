package cn.edu.tongji.webchat.webchatbackend.dto;/*
    @Created by Jary-Li on 2021/12/10. All rights reserved.
    @Name: web-chat
    @Description：
*/

public class UserDTO {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userAvatarLink;
    private Long userLevel;

    public UserDTO(Long userId, String userName, String userEmail, String userAvatarLink, Long userLevel) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAvatarLink = userAvatarLink;
        this.userLevel = userLevel;
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAvatarLink() {
        return userAvatarLink;
    }

    public void setUserAvatarLink(String userAvatarLink) {
        this.userAvatarLink = userAvatarLink;
    }

    public Long getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Long userLevel) {
        this.userLevel = userLevel;
    }

    @Override
    public String toString() {
        return "{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userAvatarLink='" + userAvatarLink + '\'' +
                ", userLevel=" + userLevel +
                '}';
    }
}
