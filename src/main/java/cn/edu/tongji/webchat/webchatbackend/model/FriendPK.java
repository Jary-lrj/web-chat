package cn.edu.tongji.webchat.webchatbackend.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FriendPK implements Serializable {
    private long friendId;
    private long userId;

    @Column(name = "friend_id")
    @Id
    public long getFriendId() {
        return friendId;
    }

    public void setFriendId(long friendId) {
        this.friendId = friendId;
    }

    @Column(name = "user_id")
    @Id
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendPK friendPK = (FriendPK) o;
        return friendId == friendPK.friendId && userId == friendPK.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(friendId, userId);
    }
}
