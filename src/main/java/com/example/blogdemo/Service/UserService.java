package com.example.blogdemo.Service;

import com.example.blogdemo.entity.Article;
import com.example.blogdemo.entity.Commit;
import com.example.blogdemo.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {


    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    public User login(String userName,String password);

    /**
     * 注册
     * @param user
     */
    public int  register(User user);

    /**
     * 注销用户
     * @param user
     */
    public int cancelUser(User user);

    /**
     * 修改用户信息
     * @param user
     */
    public int updateUser(User user);

    /**
     * 用户对文章进行评论
     * @param commit
     * @param articleId
     * @param userId
     * @return
     */
    public int addNewCommit(Commit commit, int articleId,int userId);


}
