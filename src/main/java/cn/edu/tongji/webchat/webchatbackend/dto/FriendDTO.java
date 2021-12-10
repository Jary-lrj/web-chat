package cn.edu.tongji.webchat.webchatbackend.dto;/*
    @Created by Jary-Li on 2021/12/10. All rights reserved.
    @Name: web-chat
    @Description：
*/

import java.sql.Timestamp;

public class FriendDTO {
    private Long friendId;
    private String friendName;
    private String friendEmail;
    private String friendMotto;
    private String friendAvatarLink;
    private Long friendLevel;
    private Timestamp friendCreateTime;

    public FriendDTO(Long friendId, String friendName, String friendEmail, String friendMotto, String friendAvatarLink, Long friendLevel, Timestamp friendCreateTime) {
        this.friendId = friendId;
        this.friendName = friendName;
        this.friendEmail = friendEmail;
        this.friendMotto = friendMotto;
        this.friendAvatarLink = friendAvatarLink;
        this.friendLevel = friendLevel;
        this.friendCreateTime = friendCreateTime;
    }

    public FriendDTO(Long friendId, String friendName, String friendMotto, String friendAvatarLink) {
        this.friendId = friendId;
        this.friendName = friendName;
        this.friendMotto = friendMotto;
        this.friendAvatarLink = friendAvatarLink;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getFriendEmail() {
        return friendEmail;
    }

    public void setFriendEmail(String friendEmail) {
        this.friendEmail = friendEmail;
    }

    public String getFriendMotto() {
        return friendMotto;
    }

    public void setFriendMotto(String friendMotto) {
        this.friendMotto = friendMotto;
    }

    public String getFriendAvatarLink() {
        return friendAvatarLink;
    }

    public void setFriendAvatarLink(String friendAvatarLink) {
        this.friendAvatarLink = friendAvatarLink;
    }

    public Long getFriendLevel() {
        return friendLevel;
    }

    public void setFriendLevel(Long friendLevel) {
        this.friendLevel = friendLevel;
    }

    public Timestamp getFriendCreateTime() {
        return friendCreateTime;
    }

    public void setFriendCreateTime(Timestamp friendCreateTime) {
        this.friendCreateTime = friendCreateTime;
    }

    @Override
    public String toString() {
        return "{" +
                "friendId=" + friendId +
                ", friendName='" + friendName + '\'' +
                ", friendEmail='" + friendEmail + '\'' +
                ", friendMotto='" + friendMotto + '\'' +
                ", friendAvatarLink='" + friendAvatarLink + '\'' +
                ", friendLevel=" + friendLevel +
                ", friendCreateTime=" + friendCreateTime +
                '}';
    }
}
