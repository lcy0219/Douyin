package com.service;

import com.entity.VideoComment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 视频评论表 服务类
 * </p>
 *
 * @author chenyuan
 * @since 2023年11月28日
 */
public interface VideoCommentService extends IService<VideoComment> {


    void comment(Long userId, Long videoId, String comment, Long commentId, int actionType);

    List<VideoComment> showCommentByVideoId(Long videdoId);
}
