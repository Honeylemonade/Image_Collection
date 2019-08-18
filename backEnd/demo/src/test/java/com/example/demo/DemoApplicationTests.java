package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.mapper.ImageMapper;
import com.example.demo.mapper.UserImageMapper;
import com.example.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    ImageMapper imageMapper;
    @Autowired
    UserImageMapper userImageMapper;

    @Test
    public void test() {
        System.out.println(userImageMapper.getUserImagesByUserId(6));
    }

}
