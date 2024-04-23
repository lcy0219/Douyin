package com.controller.basis;

import com.dao.UserCredentialsMapper;
import com.dao.UserProfileMapper;
import com.entity.UserCredentials;
import com.entity.UserProfile;
import com.service.UserCredentialsService;
import com.utils.JwtUtils;
import com.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/douyin/user/")
public class UserController {

    @Autowired
    UserCredentialsService userCredentialsService;

    @PostMapping("login/")
    public HashMap<String, Object> login(@RequestParam String username, @RequestParam String password){
        Long id = userCredentialsService.login(username, password);
        HashMap<String, Object> response = new HashMap<>();
        if(id != null){
            ResponseUtils.setResponse(response, 0, "登录成功", id, JwtUtils.createToken(id));
        }else {
            ResponseUtils.setResponse(response, -1, "登录失败", id, null);
        }

        return response;
    }

    @PostMapping("register/")
    public HashMap<String, Object> register(@RequestParam String username, @RequestParam String password){
        Long id = userCredentialsService.register(username, password);
        HashMap<String, Object> response = new HashMap<>();
        ResponseUtils.setResponse(response, 0, "注册成功", id, null);

        return response;
    }

    @GetMapping("")
    public HashMap<String, Object> userInfo(@RequestParam("user_id") Long id){
        UserProfile userProfile = userCredentialsService.getUser(id);
        HashMap<String, Object> response = new HashMap<>();
        ResponseUtils.setResponse(response, 0, "我的信息", userProfile);

        return response;
    }
}
