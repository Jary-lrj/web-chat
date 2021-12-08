package cn.edu.tongji.webchat.webchatbackend.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Objects;

@Entity
@DynamicUpdate
@DynamicInsert
@IdClass(FriendPK.class)
public class Friend {
    private long friendId;
    private long userId;

    @Id
    @Column(name = "friend_id")
    public long getFriendId() {
        return friendId;
    }

    public void setFriendId(long friendId) {
        this.friendId = friendId;
    }

    @Id
    @Column(name = "user_id")
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
        Friend friend = (Friend) o;
        return friendId == friend.friendId && userId == friend.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(friendId, userId);
    }
}
