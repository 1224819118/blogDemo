package com.example.blogdemo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户表(User)表实体类
 *
 * @author makejava
 * @since 2020-02-14 13:42:30
 */
@SuppressWarnings("serial")
@Data
public class User extends Model<User> {
    //主键
    private Integer id;
    //用户名
    private String userName;
    //密码
    private String password;
    //昵称
    private String nickName;
    //个人简介
    private String profile;
    //头像地址
    private String imageName;



}