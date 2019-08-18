package com.example.demo.service;

import com.example.demo.entity.Image;
import com.example.demo.entity.UserImage;

import java.util.ArrayList;

/**
 * UserImageService:
 *
 * @author XvYanPeng
 * @date 2019/8/17 20:26
 */
public interface UserImageService {
    void insertUserImageMapping(int userId, String imagePath);

    void insertUserImage(UserImage userImage);
    ArrayList<Image> getUserImagesByUserId(int userId);
}
