package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserImage:对应着数据库中的image_collection_user_image表
 *
 * @author XvYanPeng
 * @date 2019/8/15 19:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserImage {
    Integer userId;
    Integer imageId;
}
