package com.service;

import com.entity.VideoInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 视频信息表 服务类
 * </p>
 *
 * @author chenyuan
 * @since 2023年11月28日
 */
public interface VideoInfoService extends IService<VideoInfo> {

    void publishVideo(byte[] data, String title, Long id);

    List<VideoInfo> showVideoList(Long id);

    List<VideoInfo> showVideoWithoutLogin();
}
