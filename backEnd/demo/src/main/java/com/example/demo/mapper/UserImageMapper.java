package com.example.demo.mapper;

import com.example.demo.entity.Image;
import com.example.demo.entity.UserImage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * UserImageMapper:
 *
 * @author XvYanPeng
 * @date 2019/8/16 18:50
 */
@Component
@Mapper
public interface UserImageMapper {
    void insertUserImage(UserImage userImage);
    ArrayList<Image> getUserImagesByUserId(int userId);
}
