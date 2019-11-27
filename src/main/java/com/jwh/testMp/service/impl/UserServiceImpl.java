package com.jwh.testMp.service.impl;

import com.jwh.testMp.entity.User;
import com.jwh.testMp.mapper.UserMapper;
import com.jwh.testMp.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lazzaro
 * @since 2019-11-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
