package com.controller.basis;

import com.entity.UserProfile;
import com.service.UserCredentialsService;
import com.service.VideoInfoService;
import com.utils.JwtUtils;
import com.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/douyin/publish/")
public class VideoController {

    @Autowired
    VideoInfoService videoInfoService;

    @PostMapping("action/")
    public HashMap<String, Object> uploadVideo(@RequestParam MultipartFile data, @RequestParam String title, @RequestParam String token) throws IOException {
        videoInfoService.publishVideo(data.getBytes(), title, JwtUtils.verify(token));
        HashMap<String, Object> response = new HashMap<>();
        ResponseUtils.setResponse(response, 0, "发布成功");

        return response;
    }

    @GetMapping("list/")
    public HashMap<String, Object> getVideoList(@RequestParam String token){
        Long id = JwtUtils.verify(token);
        HashMap<String, Object> response = new HashMap<>();
        ResponseUtils.setResponse(response, 0, "获取点赞视频成功", videoInfoService.showVideoList(id));
        return response;
    }
}
