package com.utils;

import com.entity.UserProfile;
import com.entity.VideoComment;
import com.entity.VideoInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseUtils {
    public static void setResponse(Map<String, Object> response, int statusCode, String statusMessage, Long userid, String token){
        response.put("status_code", statusCode);
        response.put("status_msg", statusMessage);
        response.put("user_id", userid);
        response.put("token", token);

    }

    public static void setResponse(Map<String, Object> response, int statusCode, String statusMessage, UserProfile user){
        response.put("status_code", statusCode);
        response.put("status_msg", statusMessage);
        response.put("user", user);

    }

    public static void setResponse(HashMap<String, Object> response, int statusCode, String statusMessage) {
        response.put("status_code", statusCode);
        response.put("status_msg", statusMessage);
    }

    public static void setResponse(HashMap<String, Object> response, int statusCode, String statusMessage, List<?> videos) {
        response.put("status_code", statusCode);
        response.put("status_msg", statusMessage);
        if(videos == null || videos.size() == 0) return;
        if(videos.get(0) instanceof VideoInfo) response.put("video_list", videos);
        else if(videos.get(0) instanceof VideoComment) response.put("comment_list", videos);
    }


}
