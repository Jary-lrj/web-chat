package cn.edu.tongji.webchat.webchatbackend.service;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.webchat.webchatbackend.model.Friend;
import cn.edu.tongji.webchat.webchatbackend.model.User;
import cn.edu.tongji.webchat.webchatbackend.repository.FriendRepository;
import cn.edu.tongji.webchat.webchatbackend.repository.UserRepository;
import cn.edu.tongji.webchat.webchatbackend.util.JpaUtil;
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

    public Friend addFriend(Friend friend) { //这也得鉴权
        if (userRepository.findUserByUserId(friend.getFriendId()) == null)
            return null;
        return friendRepository.save(friend);
    }


    public Friend deleteFriend(Long userId, Long friendId) {
        if (friendRepository.findFriendByFriendIdAndUserId(friendId, userId) != null) {
            Friend friend = friendRepository.findFriendByFriendIdAndUserId(friendId, userId);
            friendRepository.deleteFriendByFriendIdAndUserId(friendId, userId);
            return friend;
        } else
            return null;
    }

    public Friend findFriend(Long friendId, Long userId) {
        if (friendRepository.findFriendByFriendIdAndUserId(friendId, userId) != null)
            return friendRepository.findFriendByFriendIdAndUserId(friendId, userId);
        else
            return null;
    }

    public User findUser(Long userId) {
        if (userRepository.findUserByUserId(userId) != null)
            return userRepository.findUserByUserId(userId);
        else
            return null;
    }

    public List<Friend> findFriendList(Long userId) { // 返回空
        if (friendRepository.findFriendsByUserId(userId) != null)
            return friendRepository.findFriendsByUserId(userId);
        else
            return null;
    }

    // 修改用户信息
    public User updateUserInfo(Long userId, User after) {
        if (userRepository.findUserByUserId(userId) == null)
            return null;
        User before = userRepository.findUserByUserId(userId);
        if (after != null) {
            JpaUtil.copyNotNullProperties(after, before);
            return userRepository.save(before);
        }
        return null;
    }
}
