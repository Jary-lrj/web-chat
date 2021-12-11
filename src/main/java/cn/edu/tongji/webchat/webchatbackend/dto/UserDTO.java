package cn.edu.tongji.webchat.webchatbackend.dto;/*
    @Created by Jary-Li on 2021/12/10. All rights reserved.
    @Name: web-chat
    @Description：
*/

import java.sql.Timestamp;

public class UserDTO {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userAvatarLink;
    private String userMotto;
    private Long userLevel;
    private Timestamp userCreateTime;

    public UserDTO(Long userId, String userName, String userEmail, String userAvatarLink, String userMotto, Long userLevel, Timestamp userCreateTime) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAvatarLink = userAvatarLink;
        this.userMotto = userMotto;
        this.userLevel = userLevel;
        this.userCreateTime = userCreateTime;
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

    public String getUserMotto() {
        return userMotto;
    }

    public void setUserMotto(String userMotto) {
        this.userMotto = userMotto;
    }

    public Long getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Long userLevel) {
        this.userLevel = userLevel;
    }

    public Timestamp getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Timestamp userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    @Override
    public String toString() {
        return "{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userAvatarLink='" + userAvatarLink + '\'' +
                ", userMotto='" + userMotto + '\'' +
                ", userLevel=" + userLevel +
                ", userCreateTime=" + userCreateTime +
                '}';
    }
}
