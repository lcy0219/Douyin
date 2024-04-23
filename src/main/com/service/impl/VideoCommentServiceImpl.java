package com.service.impl;

import com.entity.VideoComment;
import com.dao.VideoCommentMapper;
import com.service.VideoCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 视频评论表 服务实现类
 * </p>
 *
 * @author chenyuan
 * @since 2023年11月28日
 */
@Service
public class VideoCommentServiceImpl extends ServiceImpl<VideoCommentMapper, VideoComment> implements VideoCommentService {

    @Override
    public void comment(Long userId, Long videoId, String comment, Long commentId, int actionType){
        if(actionType == 1){
            this.baseMapper.insert(new VideoComment(
                    null,
                    videoId,
                    userId,
                    comment,
                    LocalDateTime.now(),
                    null,
                    null
                    ));
        }else if(actionType == 2){
            this.baseMapper.deleteById(commentId);
        }
    }

    @Override
    public List<VideoComment> showCommentByVideoId(Long videdoId){
        Map<String, Object> map = new HashMap<>();
        map.put("video_id", videdoId);
        return this.baseMapper.selectByMap(map);
    }

}
