package cn.edu.tongji.webchat.webchatbackend.controller;

import cn.dev33.satoken.stp.StpUtil;
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
import java.util.List;

@Api(tags = "用户操作")
@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {
    @Resource
    private UserService userService;

    // 登录
    @ApiOperation("用户登录")
    @GetMapping("/login")
    public ResponseEntity<String> userLogin(@RequestParam("user_id") Long userId, @RequestParam("user_pwd") String userPassword) {
        if (userService.login(userId, userPassword) == null)
            return ResponseEntity.status(200).body("登录失败");
        else
            return ResponseEntity.status(200).body(StpUtil.getTokenValue());
    }

    // 注册 - 返回注册的用户名、密码、账号
    @ApiOperation("用户注册")
    @PostMapping("/register")
    public ResponseEntity<String> userRegister(@RequestBody User user) {
        userService.register(user);
        return ResponseEntity.status(200).body("注册成功");
    }

    // 添加好友，需要鉴权
    @ApiOperation("添加好友")
    @PostMapping("/friend")
    public ResponseEntity<String> addFriend(@RequestBody Friend friend) {
        if (!StpUtil.isLogin())
            return ResponseEntity.status(401).body("您尚未登录");
        return userService.addFriend(friend) != null ? ResponseEntity.status(200).body("添加成功") : ResponseEntity.status(200).body("该用户不存在");
    }

    // 删除好友，也需要鉴权
    @ApiOperation("删除好友")
    @DeleteMapping("/friend/{friend_id}")
    public ResponseEntity<String> deleteFriend(@PathVariable("friend_id") Long friendId) {
        if (!StpUtil.isLogin())
            return ResponseEntity.status(401).body("您尚未登录");
        return userService.deleteFriend(StpUtil.getLoginIdAsLong(), friendId) != null ? ResponseEntity.status(200).body("删除好友成功") : ResponseEntity.status(200).body("该好友不存在");
    }

    //找已经添加的好友，也需要鉴权 - 需要返回好友的一些信息
    @ApiOperation("查找已经添加的好友")
    @GetMapping("/friend/{friend_id}")
    public ResponseEntity<Friend> findFriend(@PathVariable("friend_id") Long friendId) {
        if (!StpUtil.isLogin())
            return ResponseEntity.status(401).body(null);
        return ResponseEntity.status(200).body(userService.findFriend(friendId, StpUtil.getLoginIdAsLong()));
    }

    // 找用户，也需要鉴权 - 需要返回用户的一些信息
    @ApiOperation("查找用户")
    @GetMapping("/{user_id}")
    public ResponseEntity<User> findUser(@PathVariable("user_id") Long userId) {
        if (!StpUtil.isLogin())
            return ResponseEntity.status(401).body(null);
        return ResponseEntity.status(200).body(userService.findUser(userId));
    }

    // 找好友列表，也需要鉴权 - 需要返回好友列表，里面每个项目都需要一些信息
    @ApiOperation("查找好友列表")
    @GetMapping("/friend_list/{user_id}")
    public ResponseEntity<List<Friend>> findFriendList(@PathVariable("user_id") Long userId) {
        if (!StpUtil.isLogin())
            return ResponseEntity.status(401).body(null);
        return ResponseEntity.status(200).body(userService.findFriendList(userId));
    }

    // 修改用户信息，也需要鉴权 - 这就返回个修改成功就行了吧？让用户自己看去
    // TODO:这jb为什么非要修改主码，你妈的
    @ApiOperation("修改用户信息")
    @PutMapping("/{user_id}")
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