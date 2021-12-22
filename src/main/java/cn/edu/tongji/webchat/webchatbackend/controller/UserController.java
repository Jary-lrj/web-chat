package cn.edu.tongji.webchat.webchatbackend.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.webchat.webchatbackend.dto.*;
import cn.edu.tongji.webchat.webchatbackend.model.Friend;
import cn.edu.tongji.webchat.webchatbackend.model.User;
import cn.edu.tongji.webchat.webchatbackend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

// TODO:进程id 26246
@Api(tags = "用户操作")
@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {
    @Resource
    private UserService userService;

    // 登录，这应该不太需要，往里面存个token就行了
    @ApiOperation("用户登录")
    @GetMapping("/login")
    @CrossOrigin
    public ResponseEntity<LoginDTO> userLogin(@RequestParam("user_id") Long userId, @RequestParam("user_pwd") String userPassword) {
        if (userService.login(userId, userPassword) == null) {
            LoginDTO data = new LoginDTO("登录失败", "登录失败");
            return ResponseEntity.status(200).body(data);
        } else {
            LoginDTO data = new LoginDTO(StpUtil.getTokenValue(), userService.findUser(userId).getUserName());
            return ResponseEntity.status(200).body(data);
        }
    }

    // 注册 - 返回注册的用户名、密码、账号
    @ApiOperation("用户注册")
    @PostMapping("/register")
    @CrossOrigin
    public ResponseEntity<RegisterDTO> userRegister(@RequestBody User user) {
        userService.register(user);
        RegisterDTO userAccount = new RegisterDTO(user.getUserId(), user.getUserName(), user.getUserPassword());
        return ResponseEntity.status(200).body(userAccount);
    }

    // 添加好友，需要鉴权
    @ApiOperation("添加好友")
    @PostMapping("/friend")
    @CrossOrigin
    public ResponseEntity<String> addFriend(@RequestBody Friend friend) {
        if (!StpUtil.isLogin())
            return ResponseEntity.status(401).body("您尚未登录");
        else if (friend.getUserId() != StpUtil.getLoginIdAsLong())
            return ResponseEntity.status(401).body("您无权操作");
        return userService.addFriend(friend) != null ? ResponseEntity.status(200).body("添加成功") : ResponseEntity.status(200).body("该用户不存在");
    }

    // 删除好友，也需要鉴权
    @ApiOperation("删除好友")
    @DeleteMapping("/friend/{friend_id}")
    @CrossOrigin
    public ResponseEntity<String> deleteFriend(@PathVariable("friend_id") Long friendId) {
        if (!StpUtil.isLogin())
            return ResponseEntity.status(401).body("您尚未登录");
        return userService.deleteFriend(StpUtil.getLoginIdAsLong(), friendId) != null ? ResponseEntity.status(200).body("删除好友成功") : ResponseEntity.status(200).body("该好友不存在");
    }

    //找已经添加的好友，也需要鉴权 - 需要返回好友的一些信息
    @ApiOperation("查找已经添加的好友")
    @GetMapping("/friend/{friend_id}")
    @CrossOrigin
    public ResponseEntity<FriendDTO> findFriend(@PathVariable("friend_id") Long friendId) {
        if (!StpUtil.isLogin())
            return ResponseEntity.status(401).body(null);
        User friend = userService.findUser(friendId);
        FriendDTO friendDTO = new FriendDTO(friend.getUserId(), friend.getUserName(), friend.getUserEmail(), friend.getUserMotto(), friend.getUserAvatarLink(), friend.getUserLevel(), friend.getUserCreateTime());
        return ResponseEntity.status(200).body(friendDTO);
    }

    // 找用户，也需要鉴权 - 需要返回用户的一些信息
    @ApiOperation("查找用户")
    @GetMapping("/{user_id}")
    @CrossOrigin
    public ResponseEntity<UserDTO> findUser(@PathVariable("user_id") Long userId) {
        if (!StpUtil.isLogin())
            return ResponseEntity.status(401).body(null);
        User user = userService.findUser(userId);
        UserDTO userDTO = new UserDTO(user.getUserId(), user.getUserName(), user.getUserEmail(), user.getUserAvatarLink(), user.getUserMotto(), user.getUserLevel(), user.getUserCreateTime());
        return ResponseEntity.status(200).body(userDTO);
    }

    // 找好友列表，也需要鉴权 - 需要返回好友列表，里面每个项目都需要一些信息，通过测试！！！
    @ApiOperation("查找好友列表")
    @GetMapping("/friend_list/{user_id}")
    @CrossOrigin
    public ResponseEntity<List<FriendListDTO>> findFriendList(@PathVariable("user_id") Long userId) {
        if (!StpUtil.isLogin())
            return ResponseEntity.status(401).body(null);
        List<User> friendListOrigin = userService.findFriendList(userId);
        List<FriendListDTO> friendList = new ArrayList<>();
        for (User u : friendListOrigin) {
            FriendListDTO friendListDTO = new FriendListDTO(u.getUserId(), u.getUserName(), u.getUserMotto(), u.getUserAvatarLink());
            friendList.add(friendListDTO);
        }
        return ResponseEntity.status(200).body(friendList);
    }

    // 修改用户信息，也需要鉴权 - 这就返回个修改成功就行了吧？让用户自己看去
    // TODO:这jb为什么非要修改主码，你妈的
    @ApiOperation("修改用户信息")
    @PutMapping("/{user_id}")
    @CrossOrigin
    public ResponseEntity<String> updateUserInfo(@PathVariable("user_id") Long userId, @RequestBody User update) {
        if (!StpUtil.isLogin())
            return ResponseEntity.status(401).body("您尚未登录");
        else if (StpUtil.getLoginIdAsLong() != userId)
            return ResponseEntity.status(401).body("您无权操作");
        update.setUserId(userId);
        userService.updateUserInfo(userId, update);
        return ResponseEntity.status(200).body("修改用户信息成功");
    }
}