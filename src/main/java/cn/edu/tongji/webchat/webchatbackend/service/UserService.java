package cn.edu.tongji.webchat.webchatbackend.service;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.webchat.webchatbackend.model.Friend;
import cn.edu.tongji.webchat.webchatbackend.model.User;
import cn.edu.tongji.webchat.webchatbackend.repository.FriendRepository;
import cn.edu.tongji.webchat.webchatbackend.repository.UserRepository;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
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
        // 注册不需要鉴权
        return userRepository.save(user);
    }

    public Friend addFriend(Friend friend) { //这也得鉴权
        if (StpUtil.isLogin()) {
            return friendRepository.save(friend);
        } else {
            return null;
        }
    }

    @Transactional
    public Friend deleteFriend(Long userId, Long friendId) {
        if (StpUtil.isLogin()) {
            if (friendRepository.findFriendByFriendIdAndUserId(friendId, userId) != null)
                return friendRepository.deleteFriendByFriendIdAndUserId(friendId, userId);
            else
                return new Friend();
        } else
            return null;
    }

    public Friend findFriend(Long friendId, Long userId) {
        if (StpUtil.isLogin()) {
            if (friendRepository.findFriendByFriendIdAndUserId(friendId, userId) == null)
                return new Friend();//返回空的试试？
            else
                return friendRepository.findFriendByFriendIdAndUserId(friendId, userId);
        } else
            return null;
    }

    public User findUser(Long userId) {
        if (StpUtil.isLogin()) {
            if (userRepository.findUserByUserId(userId) == null)
                return new User();//返回空的试试？
            else
                return userRepository.findUserByUserId(userId);
        } else
            return null;
    }

    public List<Friend> findFriendList(Long userId) { // 返回空
        if (StpUtil.isLogin()) {
            if (friendRepository.findFriendsByUserId(userId) == null)
                return new ArrayList<Friend>();
            else
                return friendRepository.findFriendsByUserId(userId);
        } else
            return null;
    }
}
