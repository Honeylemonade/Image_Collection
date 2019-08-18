package com.example.demo.service.impl;

import com.example.demo.entity.Image;
import com.example.demo.entity.UserImage;
import com.example.demo.mapper.ImageMapper;
import com.example.demo.mapper.UserImageMapper;
import com.example.demo.service.UserImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * UserImageServiceImpl:
 *
 * @author XvYanPeng
 * @date 2019/8/17 20:28
 */
@Service
public class UserImageServiceImpl implements UserImageService {
    @Autowired
    UserImageMapper userImageMapper;
    @Autowired
    ImageMapper imageMapper;

    @Override
    @Async
    public void insertUserImageMapping(int userId, String imagePath) {
        //将图片插入image表
        imageMapper.insertImage(new Image(null, imagePath));
        //得到图片
        Image image = imageMapper.selectImageByImagePath(imagePath);
        System.out.println(image);
        //将用户id和图片id的映射插入到关系表中
        userImageMapper.insertUserImage(new UserImage(userId, image.getId()));
    }

    @Override
    public void insertUserImage(UserImage userImage) {
        userImageMapper.insertUserImage(userImage);
    }

    @Override
    public ArrayList<Image> getUserImagesByUserId(int userId) {
        return userImageMapper.getUserImagesByUserId(userId);
    }
}
