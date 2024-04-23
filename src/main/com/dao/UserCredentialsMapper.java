package com.dao;

import com.entity.UserCredentials;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;

/**
 * <p>
 * 用户登录信息表 Mapper 接口
 * </p>
 *
 * @author chenyuan
 * @since 2023年11月28日
 */
@Mapper
public interface UserCredentialsMapper extends BaseMapper<UserCredentials> {

    @Select("SELECT * FROM user_credentials WHERE username = #{username}")
    UserCredentials getUserCredentialsByUserName(String username);

    @Insert("INSERT INTO user_credentials(user_id, username, password, created_at) values(#{user_id},#{username},#{password}, #{created_at})")
    void insertUserCredentials(long user_id, String username, String password, LocalDateTime created_at);
}
