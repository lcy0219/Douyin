package com.dao;

import com.entity.VideoUserLike;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户点赞视频 Mapper 接口
 * </p>
 *
 * @author chenyuan
 * @since 2023年11月28日
 */
@Mapper
public interface VideoUserLikeMapper extends BaseMapper<VideoUserLike> {

}
