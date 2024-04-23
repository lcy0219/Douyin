package com.service;

import com.entity.VideoInfo;
import com.entity.VideoUserLike;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户点赞视频 服务类
 * </p>
 *
 * @author chenyuan
 * @since 2023年11月28日
 */
public interface VideoUserLikeService extends IService<VideoUserLike> {


    void like(Long userId, Long videoId, int actionType);

    List<VideoInfo> showFavoriteVideoList(Long userId);
}
