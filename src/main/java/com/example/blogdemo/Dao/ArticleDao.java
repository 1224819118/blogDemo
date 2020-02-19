package com.example.blogdemo.Dao;

import com.example.blogdemo.entity.Article;
import com.example.blogdemo.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("articleDao")
public interface ArticleDao {

    /**
     *
     * @return
     */
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "userId",property = "user",one = @One(select = "com.example.blogdemo.Dao.UserDao.selectOneById",fetchType = FetchType.EAGER)),
            @Result(column = "location",property = "location")
    })
    @Select("select * from article")
    public List<Article> selectAll();

    /**
     *
     * @param id
     * @return
     */
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "userId",property = "user",one = @One(select = "com.example.blogdemo.Dao.UserDao.selectOneById",fetchType = FetchType.EAGER)),
            @Result(column = "location",property = "location")
    })
    @Select("select * from article id=#{id}")
    public Article selectOne(int id);

    /**
     *
     * @param userId
     * @return
     */
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "userId",property = "user",one = @One(select = "com.example.blogdemo.Dao.UserDao.selectOneById",fetchType = FetchType.EAGER)),
            @Result(column = "location",property = "location")
    })
    @Select("select * from article where userId=#{userId}")
    public List<Article> selectByUser(int userId);

    /**
     *
     * @return
     */
    @Insert("insert into article(userId,location) values(#{userID},#{article.location}) ")
    public int insert(@Param("article") Article article, @Param("userID") int userId);

    /**
     *
     * @param articleId
     * @return
     */
    @Delete("delete from article where id=#{articleId}")
    public int delete(int articleId);

    /**
     *
     * @param article
     * @return
     */
    @Update("update article set location=#{location} where id=#{id}")
    public int update(Article article);

}
