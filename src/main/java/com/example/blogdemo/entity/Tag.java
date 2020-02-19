package com.example.blogdemo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Tag)表实体类
 *
 * @author makejava
 * @since 2020-02-14 13:42:30
 */
@SuppressWarnings("serial")
public class Tag extends Model<Tag> {
    //主键
    private Integer id;
    //标签
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