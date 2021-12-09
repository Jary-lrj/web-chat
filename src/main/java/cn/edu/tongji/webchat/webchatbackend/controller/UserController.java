package cn.edu.tongji.webchat.webchatbackend.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.webchat.webchatbackend.model.Friend;
import cn.edu.tongji.webchat.webchatbackend.model.User;
import cn.edu.tongji.webchat.webchatbackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {
    @Resource
    private UserService userService;

    // 登录
    @GetMapping("/login")
    public ResponseEntity<String> userLogin(@RequestParam("user_id") Long userId, @RequestParam("user_pwd") String userPassword) {
        if (userService.login(userId, userPassword) == null)
            return ResponseEntity.status(200).body("登录失败");
        else
            return ResponseEntity.status(200).body(StpUtil.getTokenValue());
    }

    // 注册
    @PostMapping("/register")
    public ResponseEntity<String> userRegister(@RequestBody User user) {
        userService.register(user);
        return ResponseEntity.status(200).body("注册成功");
    }

//    // 加好友
//    @PostMapping("/friend")
//    public ResponseEntity<String> addFriend(@RequestBody Friend friend) {
//        //TODO:思考没鉴权和鉴权失败的区别？
//    }
}
