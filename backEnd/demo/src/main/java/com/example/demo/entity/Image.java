package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Image:图片实体类，对应着数据库的image_collection_image
 *
 * @author XvYanPeng
 * @date 2019/8/15 18:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    Integer id;
    String imagePath;
}
