package com.service;

import com.entity.UserCredentials;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.UserProfile;

/**
 * <p>
 * 用户登录信息表 服务类
 * </p>
 *
 * @author chenyuan
 * @since 2023年11月28日
 */
public interface UserCredentialsService extends IService<UserCredentials> {


    Long login(String username, String password);

    Long register(String username, String password);

    UserProfile getUser(Long id);
}
