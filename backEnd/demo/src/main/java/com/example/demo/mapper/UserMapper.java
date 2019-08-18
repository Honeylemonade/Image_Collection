package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * UserMapper:
 *
 * @author XvYanPeng
 * @date 2019/8/15 19:06
 */
@Mapper
@Component
public interface UserMapper {
    /**
     * @return com.example.demo.entity.User
     * @description 根据id查找相应用户
     * @params [id]
     * @date 2019/8/15
     */
    User selectUserById(Integer id);

    /**
     * @return void
     * @description 插入用户
     * @params [user]
     * @date 2019/8/15
     */
    void insertUser(User user);

    /**
     * @return com.example.demo.entity.User
     * @description 根据用户名和密码查找用户，对应着登陆接口
     * @params [user]
     * @date 2019/8/16
     */
    User selectUserByUserNameAndPassword(User user);
}
