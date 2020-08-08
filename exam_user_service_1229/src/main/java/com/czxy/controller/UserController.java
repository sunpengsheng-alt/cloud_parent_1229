package com.czxy.controller;

import com.czxy.domain.User;
import com.czxy.service.UserService;
import com.czxy.utils.BaseResult;
import com.czxy.utils.JwtUtils;
import com.czxy.utils.RasUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final  String pub = "G:\\ras\\ras.pub";
    private static final  String pri = "G:\\ras\\ras.pri";
    @Resource
    private UserService userService;


    @PostMapping("/login")
    public BaseResult login(@RequestBody User user){
        User user1 = userService.login(user);
        if (user1 != null){
            String s = "";
            try {
                s = JwtUtils.generateToken(user1, 300, RasUtils.getPrivateKey(pri));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(s);
            return BaseResult.ok("登录成功").append("token",s);
        }
        return BaseResult.error("用户名或密码错误");
    }
}
