package com.example.blogdemo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 文章表(Article)表实体类
 *
 * @author makejava
 * @since 2020-02-14 13:42:30
 */
@SuppressWarnings("serial")
@Data
public class Article extends Model<Article> {
    //主键
    private Integer id;
    //用户ID
    private User user;
    //文章储存地址
    private String location;

//    private List<Commit> commitList;
//    private List<Kind> kindList;
//    private List<Tag> tagList;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }