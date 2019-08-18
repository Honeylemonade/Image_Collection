package com.example.demo.mapper;

import com.example.demo.entity.Image;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * ImageMapper:
 *
 * @author XvYanPeng
 * @date 2019/8/16 18:50
 */
@Component
@Mapper
public interface ImageMapper {
    void insertImage(Image image);

    Image selectImageByImagePath(String imagePath);
}
