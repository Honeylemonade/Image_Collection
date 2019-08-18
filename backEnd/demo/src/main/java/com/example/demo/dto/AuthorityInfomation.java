package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AuthorityInfomation:
 *
 * @author XvYanPeng
 * @date 2019/8/17 8:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityInfomation {
    private Integer id;
    private String Token;
}
