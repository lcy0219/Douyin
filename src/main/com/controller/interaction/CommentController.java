package com.controller.interaction;


import com.service.VideoCommentService;
import com.utils.JwtUtils;
import com.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/douyin/comment/")
public class CommentController {

    @Autowired
    VideoCommentService videoCommentService;

    @PostMapping("action/")
    public HashMap<String, Object> like(@RequestParam("video_id") Long videoId,
                                        @RequestParam String token,
                                        @RequestParam("action_type") int actionType,
                                        @RequestParam(value = "comment_text", required = false) String comment,
                                        @RequestParam(value = "comment_id", required = false) Long commentId) throws IOException {
        videoCommentService.comment(JwtUtils.verify(token), videoId, comment, commentId, actionType);
        HashMap<String, Object> response = new HashMap<>();
        if(actionType == 1) {
            ResponseUtils.setResponse(response, 0, "评论成功");
        }else if(actionType == 2){
            ResponseUtils.setResponse(response, 0, "删除评论成功");
        }

        return response;
    }

    @GetMapping("list/")
    public HashMap<String, Object> showCommentList(@RequestParam("video_id") Long videoId) throws IOException {
        HashMap<String, Object> response = new HashMap<>();
        ResponseUtils.setResponse(response, 0, "评论成功", videoCommentService.showCommentByVideoId(videoId));

        return response;
    }
}
