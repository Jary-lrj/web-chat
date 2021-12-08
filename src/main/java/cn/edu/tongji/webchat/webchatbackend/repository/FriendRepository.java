package cn.edu.tongji.webchat.webchatbackend.repository;

import cn.edu.tongji.webchat.webchatbackend.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {
    Friend deleteFriendByFriendIdAndUserId(Long friendId, Long userId);

    Friend findFriendByFriendIdAndUserId(Long friendId, Long userId);

    List<Friend> findFriendsByUserId(Long userId);
}
