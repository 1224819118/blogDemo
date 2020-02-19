package com.example.blogdemo.Service;

import com.example.blogdemo.entity.Tag;

import java.util.List;

public interface TagService {

    public List<Tag> getTagList();
    /**
     * 添加新的标签
     * @param tag
     */
    public int addNewTag(Tag tag);
}
