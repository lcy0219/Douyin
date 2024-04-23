package com.service.impl;

import com.dao.UserProfileMapper;
import com.entity.UserCredentials;
import com.dao.UserCredentialsMapper;
import com.entity.UserProfile;
import com.service.UserCredentialsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户登录信息表 服务实现类
 * </p>
 *
 * @author chenyuan
 * @since 2023年11月28日
 */
@Service
public class UserCredentialsServiceImpl extends ServiceImpl<UserCredentialsMapper, UserCredentials> implements UserCredentialsService {

    @Autowired
    UserCredentialsMapper userCredentialsMapper;

    @Autowired
    UserProfileMapper userProfileMapper;


    @Override
    public Long login(String username, String password) {
        UserCredentials user = userCredentialsMapper.getUserCredentialsByUserName(username);
        if(user.getPassword().equals(password)){
            return user.getUserId();
        }else {
            return null;
        }

    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Long register(String username, String password) {
        UserProfile userProfile = new UserProfile(
                null,
                username,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                LocalDateTime.now(),
                null,
                null);
        userProfileMapper.insert(userProfile);
        userCredentialsMapper.insertUserCredentials(userProfile.getId(), username, password, userProfile.getCreatedAt());
        return userProfile.getId();
    }

    @Override
    public UserProfile getUser(Long id) {
        return userProfileMapper.selectById(id);
    }


}
