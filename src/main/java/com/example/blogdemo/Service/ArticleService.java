package com.example.blogdemo.Service;


import com.example.blogdemo.entity.Article;
import com.example.blogdemo.entity.Kind;
import com.example.blogdemo.entity.Tag;
import com.example.blogdemo.entity.User;

import java.util.List;

public interface ArticleService {

    /**
     * 查看全部文章
     * @return
     */
    public List<Article> showArticleList();

    /**
     * 展示某个用户的所有文章
     * @param userId
     * @return
     */
    public List<Article> showUserArticles(int userId);

    /**
     * 写新的文章
     * @param article
     */
    public int addNewArticle(Article article,int userId);

    /**
     * 删除文章
     * @param article
     */
    public int deleteArticle(Article article);

    /**
     * 更新文章
     * @param article
     */
    public int updateArticle(Article article);

    /**
     * 为文章分类
     * @param article
     * @param kindId
     */
    public int setArticleKind(Article article, int kindId);

    /**
     * 为文章设置标签
     * @param article
     * @param tagId
     */
    public int setArticleTag(Article article, int tagId);



}
