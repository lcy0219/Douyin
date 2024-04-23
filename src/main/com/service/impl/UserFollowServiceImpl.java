package com.service.impl;

import com.entity.UserFollow;
import com.dao.UserFollowMapper;
import com.service.UserFollowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户关注关系表 服务实现类
 * </p>
 *
 * @author chenyuan
 * @since 2023年11月28日
 */
@Service
public class UserFollowServiceImpl extends ServiceImpl<UserFollowMapper, UserFollow> implements UserFollowService {

}
