package com.example.blogdemo.Service.Impl;

import com.example.blogdemo.Dao.KindDao;
import com.example.blogdemo.Dao.mideaDao;
import com.example.blogdemo.Service.KindService;
import com.example.blogdemo.entity.Kind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("kindService")
public class KindServiceImpl implements KindService {

    @Autowired
    mideaDao mideaDao;
    @Autowired
    KindDao kindDao;

    @Override
    public List<Kind> getKindList() {
        return kindDao.selectAll();
    }

    @Override
    public int addNewKind(Kind kind) {
        return kindDao.insertOne(kind);
    }

    @Override
    public int deleteKind(Kind kind) {

        mideaDao.deleteArticle_kindByKindId(kind.getId());
        System.out.println(kind);
        return kindDao.delete(kind);
    }
}
