package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl:
 *
 * @author XvYanPeng
 * @date 2019/8/16 19:10
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUserByUserNameAndPassword(User user) {
        return userMapper.selectUserByUserNameAndPassword(user);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
