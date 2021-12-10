package cn.edu.tongji.webchat.webchatbackend.dto;/*
    @Created by Jary-Li on 2021/12/10. All rights reserved.
    @Name: web-chat
    @Description：
*/

public class FriendListDTO {
    private Long friendId;
    private String friendName;
    private String friendMotto;
    private String friendAvatarLink;

    public FriendListDTO(Long friendId, String friendName, String friendMotto, String friendAvatarLink) {
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

    @Override
    public String toString() {
        return "{" +
                "friendId=" + friendId +
                ", friendName='" + friendName + '\'' +
                ", friendMotto='" + friendMotto + '\'' +
                ", friendAvatarLink='" + friendAvatarLink + '\'' +
                '}';
    }
}
