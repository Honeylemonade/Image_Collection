package com.example.demo.controller;

import com.example.demo.dto.AuthorityInfomation;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtToken;
import com.example.demo.util.RequestResult;
import com.example.demo.util.RequestResultImpl.RequestFail;
import com.example.demo.util.RequestResultImpl.RequestSuccess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * UserControler:
 *
 * @author XvYanPeng
 * @date 2019/8/16 19:11
 */
@RestController
@Api(tags = "用户接口")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "用户登陆")
    @PostMapping("/login")
    public RequestResult signIn(@RequestBody User user) {
        try {
            User tempUser = userService.selectUserByUserNameAndPassword(user);
            if (tempUser != null) {
                //查找到的用户不为空，则获取用户id以及token
                AuthorityInfomation authorityInfomation = new AuthorityInfomation();
                authorityInfomation.setId(tempUser.getId());
                authorityInfomation.setToken(JwtToken.getToken(tempUser));
                return new RequestSuccess("登入成功", authorityInfomation);
            } else {
                return new RequestFail("登入失败");
            }
        } catch (Exception e) {
            return new RequestFail("登入失败");
        }
    }

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public RequestResult signUp(@RequestBody User user) {
        try {
            userService.insertUser(user);
            return new RequestSuccess("注册成功", "goodJob");
        } catch (Exception e) {
            return new RequestFail("注册失败");
        }
    }
}
