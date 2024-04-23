package com.dao;

import com.entity.UserProfile;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * <p>
 * 用户基本信息表 Mapper 接口
 * </p>
 *
 * @author chenyuan
 * @since 2023年11月28日
 */
@Mapper
public interface UserProfileMapper extends BaseMapper<UserProfile> {

    @Insert("INSERT INTO user_profile(name, created_at) values(#{name}, #{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUserProfile(UserProfile userProfile);

}
