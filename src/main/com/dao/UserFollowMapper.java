package com.dao;

import com.entity.UserFollow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户关注关系表 Mapper 接口
 * </p>
 *
 * @author chenyuan
 * @since 2023年11月28日
 */
@Mapper
public interface UserFollowMapper extends BaseMapper<UserFollow> {

}
