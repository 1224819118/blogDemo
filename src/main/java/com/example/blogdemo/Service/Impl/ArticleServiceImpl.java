package com.example.blogdemo.Service.Impl;

import com.example.blogdemo.Dao.ArticleDao;
import com.example.blogdemo.Dao.mideaDao;
import com.example.blogdemo.Service.ArticleService;
import com.example.blogdemo.entity.Article;
import com.example.blogdemo.entity.Kind;
import com.example.blogdemo.entity.Tag;
import com.example.blogdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    mideaDao mideaDao;
    @Autowired
    ArticleDao articleDao;

    @Override
    public List<Article> showArticleList() {
        return articleDao.selectAll();
    }

    @Override
    public List<Article> showUserArticles(int userId) {
        return articleDao.selectByUser(userId);
    }

    @Override
    public int addNewArticle(Article article,int userId) {
        return articleDao.insert(article,userId);
    }

    @Override
    public int deleteArticle(Article article) {

        mideaDao.deleteArticle_commitByArticleId(article.getId());
        mideaDao.deleteArticle_kindByArticleId(article.getId());
        mideaDao.deleteArticle_tagByArticleId(article.getId());
        return articleDao.delete(article.getId());

    }

    @Override
    public int updateArticle(Article article) {
        return articleDao.update(article);
    }

    @Override
    public int setArticleKind(Article article, int kindId) {
        return mideaDao.insertArticle_kind(article.getId(),kindId);
    }

    @Override
    public int setArticleTag(Article article, int tagId) {
        return mideaDao.insertArticle_tag(article.getId(),tagId);
    }
}
