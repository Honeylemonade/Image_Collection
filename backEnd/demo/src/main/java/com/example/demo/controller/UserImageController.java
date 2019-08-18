package com.example.demo.controller;

import com.example.demo.entity.Image;
import com.example.demo.mapper.UserImageMapper;
import com.example.demo.service.UserImageService;
import com.example.demo.util.RequestResult;
import com.example.demo.util.RequestResultImpl.RequestFail;
import com.example.demo.util.RequestResultImpl.RequestSuccess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * VideoController:
 *
 * @author XvYanPeng
 * @date 2019/7/27 9:49
 */
@RestController
@Api(tags = "用户图像controller")
public class UserImageController {
    @Autowired
    UserImageService userImageService;
    //默认是使用函数名称作为接口的解释
    @ApiOperation(value = "上传图片")
    @PostMapping("/image")
    public RequestResult uploadImage(@RequestParam("imageFile") MultipartFile imageFile, @RequestHeader HttpHeaders headers) throws Exception {
        try {
            //获取发送图片的用户id和token
            int id = Integer.valueOf(headers.get("id").get(0));
            String token = headers.get("token").get(0);
            //文件名为用户id+当前时间戳+一个（0≤x<100）的随机数+文件原名称
            String fileName = id
                    + String.valueOf(System.currentTimeMillis())
                    + new Random().nextInt(100)
                    + imageFile.getOriginalFilename();
            String filePath = "E:/image/";
            File dest = new File(filePath + fileName);
            imageFile.transferTo(dest);
            //将用户和图片访问路径存入数据库
            userImageService.insertUserImageMapping(id, fileName);
            return new RequestSuccess("上传成功", "上传成功");
        } catch (Exception e) {
            System.out.println(e);
            return new RequestFail("上传失败");
        }
    }
    @ApiOperation(value = "根据用户id查找用户收藏的图片")
    @GetMapping("/userImage/{userId}")
    public RequestResult getUserImageByUserId(@PathVariable("userId") int userId) {
        try {
            ArrayList<Image> imageArrayList = userImageService.getUserImagesByUserId(userId);
            return new RequestSuccess("请求成功", imageArrayList);
        } catch (Exception e) {
            System.out.println(e);
            return new RequestFail("获取用户图片失败");
        }
    }

    @ApiOperation(value = "测试接口")
    @GetMapping("/test")
    public RequestResult test() {
        return new RequestSuccess("请求成功", "请求结果");
    }
}
