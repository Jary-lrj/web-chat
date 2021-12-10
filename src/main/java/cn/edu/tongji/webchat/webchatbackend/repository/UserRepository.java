package cn.edu.tongji.webchat.webchatbackend.repository;

import cn.edu.tongji.webchat.webchatbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserId(Long userId);

    User findUserByUserIdAndUserPassword(Long userId, String userPassword);

    @Query(value = "select u.user_id,u.user_name,u.user_password,u.user_email,u.user_motto,u.user_avatar_link,u.user_level,u.user_create_time from user u left join friend f on u.user_id=f.friend_id where f.user_id = (:userId)", nativeQuery = true)
    List<User> findFriendList(@Param("userId") Long userId);
}
