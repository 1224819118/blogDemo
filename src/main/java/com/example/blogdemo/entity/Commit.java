package com.example.blogdemo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 评论表(Commit)表实体类
 *
 * @author makejava
 * @since 2020-02-14 13:42:30
 */
@SuppressWarnings("serial")
public class Commit extends Model<Commit> {
    //主键
    private Integer id;
    //评论
    private String text;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

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