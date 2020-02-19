package com.example.blogdemo.Service.Impl;

import com.example.blogdemo.Dao.TagDao;
import com.example.blogdemo.Service.TagService;
import com.example.blogdemo.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tagService")
public class TagServiceImpl implements TagService {
    @Autowired
    TagDao tagDao;

    @Override
    public List<Tag> getTagList() {
        return tagDao.selectAll();
    }

    @Override
    public int addNewTag(Tag tag) {
        return tagDao.insertOne(tag);
    }
}
