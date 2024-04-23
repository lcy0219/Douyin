package com.service.impl;

import com.entity.UserProfile;
import com.dao.UserProfileMapper;
import com.service.UserProfileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户基本信息表 服务实现类
 * </p>
 *
 * @author chenyuan
 * @since 2023年11月28日
 */
@Service
public class UserProfileServiceImpl extends ServiceImpl<UserProfileMapper, UserProfile> implements UserProfileService {

}
