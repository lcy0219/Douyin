package com.controller.interaction;


import com.service.VideoUserLikeService;
import com.utils.JwtUtils;
import com.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/douyin/favorite/")
public class FavoriteController {

    @Autowired
    VideoUserLikeService videoUserLikeService;

    @PostMapping("action/")
    public HashMap<String, Object> like(@RequestParam("video_id") Long videoId, @RequestParam String token, @RequestParam("action_type") int actionType) throws IOException {
        videoUserLikeService.like(JwtUtils.verify(token) ,videoId, actionType);
        HashMap<String, Object> response = new HashMap<>();
        ResponseUtils.setResponse(response, 0, "点赞成功");

        return response;
    }

    @GetMapping("list/")
    public HashMap<String, Object> showFavoriteVideoList(@RequestParam("user_id") Long userId) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        ResponseUtils.setResponse(response, 0, "点赞成功", videoUserLikeService.showFavoriteVideoList(userId));

        return response;
    }

}
