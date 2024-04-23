package com.dao;

import com.entity.VideoComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 视频评论表 Mapper 接口
 * </p>
 *
 * @author chenyuan
 * @since 2023年11月28日
 */
@Mapper
public interface VideoCommentMapper extends BaseMapper<VideoComment> {

}
