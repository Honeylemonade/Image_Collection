package com.example.demo.service;

import com.example.demo.entity.User;

/**
 * UserService:
 *
 * @author XvYanPeng
 * @date 2019/8/16 19:09
 */
public interface UserService {

    User selectUserByUserNameAndPassword(User user);

    void insertUser(User user);
}
