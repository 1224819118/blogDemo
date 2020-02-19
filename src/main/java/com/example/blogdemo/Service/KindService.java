package com.example.blogdemo.Service;

import com.example.blogdemo.entity.Kind;

import java.util.List;

public interface KindService {


    public List<Kind> getKindList();

    /**
     * 添加新的类
     * @param kind
     */
    public int addNewKind(Kind kind);

    /**
     * 删除某个类
     * @param kind
     */
    public int deleteKind(Kind kind);
}
