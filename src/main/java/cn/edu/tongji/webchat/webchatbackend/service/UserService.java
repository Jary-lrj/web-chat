package cn.edu.tongji.webchat.webchatbackend.service;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.webchat.webchatbackend.model.Friend;
import cn.edu.tongji.webchat.webchatbackend.model.User;
import cn.edu.tongji.webchat.webchatbackend.repository.FriendRepository;
import cn.edu.tongji.webchat.webchatbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    @Resource
    private FriendRepository friendRepository;
    @Resource
    private UserRepository userRepository;

    public User login(Long userId, String password) {
        if (userRepository.findUserByUserId(userId) == null || userRepository.findUserByUserIdAndUserPassword(userId, password) == null)
            return null;
        else {
            StpUtil.login(userId);
            return userRepository.findUserByUserIdAndUserPassword(userId, password);
        }
    }

    public User register(User user) {
        return userRepository.save(user);
    }

    public Friend addFriend(Friend friend) {
        return friendRepository.save(friend);
    }

    @Transactional
    public Friend deleteFriend(Long userId, Long friendId) {
        return friendRepository.deleteFriendByFriendIdAndUserId(friendId, userId);
    }

    public Friend findFriend(Long friendId, Long userId) {
        return friendRepository.findFriendByFriendIdAndUserId(friendId, userId);
    }

    public User findUser(Long userId) {
        return userRepository.findUserByUserId(userId);
    }

    public List<Friend> findFriendList(Long userId) {
        return friendRepository.findFriendsByUserId(userId);
    }
}
