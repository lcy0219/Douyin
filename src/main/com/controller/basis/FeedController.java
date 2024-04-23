package com.controller.basis;

import com.entity.UserProfile;
import com.service.VideoInfoService;
import com.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/douyin/feed")
public class FeedController {

    @Autowired
    VideoInfoService videoInfoService;

    @GetMapping("")
    public HashMap<String, Object> userInfo(){

        HashMap<String, Object> response = new HashMap<>();
        ResponseUtils.setResponse(response, 0, "我的信息", videoInfoService.showVideoWithoutLogin());

        return response;
    }
}
