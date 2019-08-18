package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User:对应着数据库中的image_collection_user
 *
 * @author XvYanPeng
 * @date 2019/8/15 18:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    Integer id;
    String userName;
    String password;
}
