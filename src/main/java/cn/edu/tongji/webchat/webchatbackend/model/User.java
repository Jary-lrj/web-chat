package cn.edu.tongji.webchat.webchatbackend.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@DynamicInsert
@DynamicUpdate
public class User {
    private long userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userMotto;
    private String userAvatarLink;
    private Long userLevel;
    private Timestamp userCreateTime;

    @Id
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_password")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "user_motto")
    public String getUserMotto() {
        return userMotto;
    }

    public void setUserMotto(String userMotto) {
        this.userMotto = userMotto;
    }

    @Basic
    @Column(name = "user_avatar_link")
    public String getUserAvatarLink() {
        return userAvatarLink;
    }

    public void setUserAvatarLink(String userAvatarLink) {
        this.userAvatarLink = userAvatarLink;
    }

    @Basic
    @Column(name = "user_level")
    public Long getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Long userLevel) {
        this.userLevel = userLevel;
    }

    @Basic
    @Column(name = "user_create_time")
    public Timestamp getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Timestamp userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(userName, user.userName) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userMotto, user.userMotto) && Objects.equals(userAvatarLink, user.userAvatarLink) && Objects.equals(userLevel, user.userLevel) && Objects.equals(userCreateTime, user.userCreateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userEmail, userMotto, userAvatarLink, userLevel, userCreateTime);
    }
}
