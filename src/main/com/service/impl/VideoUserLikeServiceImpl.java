package com.service.impl;

import com.dao.VideoInfoMapper;
import com.entity.VideoInfo;
import com.entity.VideoUserLike;
import com.dao.VideoUserLikeMapper;
import com.service.VideoUserLikeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户点赞视频 服务实现类
 * </p>
 *
 * @author chenyuan
 * @since 2023年11月28日
 */
@Service
public class VideoUserLikeServiceImpl extends ServiceImpl<VideoUserLikeMapper, VideoUserLike> implements VideoUserLikeService {

    @Autowired
    VideoInfoMapper videoInfoMapper;

    @Override
    public void like(Long userId, Long videoId, int actionType) {
        if(actionType == 1) {
            this.baseMapper.insert(new VideoUserLike(userId, videoId));
            VideoInfo videoInfo = videoInfoMapper.selectById(videoId);
            videoInfo.setFavoriteCount(videoInfo.getFavoriteCount() + 1);
            videoInfoMapper.updateById(videoInfo);
        }else if(actionType ==2) {
            Map<String, Object> map = new HashMap<>();
            map.put("user_id", userId);
            map.put("video_id", videoId);
            this.baseMapper.deleteByMap(map);
            VideoInfo videoInfo = videoInfoMapper.selectById(videoId);
            videoInfo.setFavoriteCount(videoInfo.getFavoriteCount() - 1);
            videoInfoMapper.updateById(videoInfo);
        }
    }

    @Override
    public List<VideoInfo> showFavoriteVideoList(Long userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        List<VideoUserLike> videoUserLikes = this.baseMapper.selectByMap(map);
        List<Long> ids = new ArrayList<>();
        for(VideoUserLike videoUserLike: videoUserLikes){
            ids.add(videoUserLike.getVideoId());
        }
        if(ids.size() > 0) return videoInfoMapper.selectBatchIds(ids);
        else return null;
    }
}
