package com.example.blogdemo.Service.Impl;

import com.example.blogdemo.Dao.CommitDao;
import com.example.blogdemo.Dao.UserDao;
import com.example.blogdemo.Dao.mideaDao;
import com.example.blogdemo.Service.UserService;
import com.example.blogdemo.entity.Article;
import com.example.blogdemo.entity.Commit;
import com.example.blogdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    mideaDao mideaDao;
    @Autowired
    CommitDao commitDao;
    @Autowired
    UserDao userDao;
    @Override
    public User login(String userName, String password) {
        User user = userDao.selectOneByName(userName);
        if (user.getPassword().equals(password)){

            return user;
        }else {
            user.setUserName("false");
            return  user;
        }

    }

    @Override
    public int register(User user) {
        return  userDao.insertOne(user);
    }

    @Override
    public int cancelUser(User user) {
        return userDao.delete(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.update(user);
    }

    @Override
    public int addNewCommit(Commit commit, int articleId, int userId) {
        commitDao.insertOne(commit);
        return mideaDao.insertArticleCommit(commit.getId(),articleId,userId);
    }


}
