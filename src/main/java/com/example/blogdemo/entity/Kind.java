package com.example.blogdemo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 博客表(Kind)表实体类
 *
 * @author makejava
 * @since 2020-02-14 13:42:30
 */
@SuppressWarnings("serial")
public class Kind extends Model<Kind> {
    //主键
    private Integer id;
    //类别
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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