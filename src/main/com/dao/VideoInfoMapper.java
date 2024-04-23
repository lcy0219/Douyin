package com.dao;

import com.entity.VideoInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 视频信息表 Mapper 接口
 * </p>
 *
 * @author chenyuan
 * @since 2023年11月28日
 */
@Mapper
public interface VideoInfoMapper extends BaseMapper<VideoInfo> {

    @Select("SELECT * FROM video_info WHERE created_at < #{now}")
    List<VideoInfo> getVideoListBefore(LocalDateTime now);
}
