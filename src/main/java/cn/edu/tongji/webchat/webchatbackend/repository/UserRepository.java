package cn.edu.tongji.webchat.webchatbackend.repository;

import cn.edu.tongji.webchat.webchatbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserId(Long userId);

    User findUserByUserIdAndUserPassword(Long userId, String userPassword);
}
