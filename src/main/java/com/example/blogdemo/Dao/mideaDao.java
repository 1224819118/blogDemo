package com.example.blogdemo.Dao;

import com.example.blogdemo.entity.Article;
import com.example.blogdemo.entity.Commit;
import com.example.blogdemo.entity.Kind;
import com.example.blogdemo.entity.Tag;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mideaDao")
public interface mideaDao {

    /**
     * 按照文章查评论
     * @param articleId
     * @return
     */
    @Select("select commitId from article_commit where articleId=#{articleId}")
    public List<Integer> selectCommitByArticle(int articleId);

    /**
     * 按照用户查评论
     * @param userId
     * @return
     */
    @Select("select commitId from article_commit where userId=#{userId}")
    public List<Integer> selectCommitByUser(int userId);

    /**
     * 按照文章查类别
     * @param articleId
     * @return
     */
    @Select("select kindId from article_kind where articleId=#{articleId}")
    public List<Integer> selectKind(int articleId);

    /**
     * 按照文章查标签
     * @param articleId
     * @return
     */
    @Select("select tagId from article_tag where articleId=#{articleId}")
    public List<Integer> selectTag(int articleId);

    /**
     * 插入新的评论关系
     * @param commitId
     * @param articleId
     * @param userId
     * @return
     */
    @Insert("insert into article_commit(articleId,commitId,userId) values(#{articleId},#{commitId},#{userId})")
    public int insertArticleCommit(int commitId,int articleId,int userId);

    /**
     * 创建新的类别关系
     * @return
     */
    @Insert("insert into article_kind(articleId,kindId) values(#{articleId},#{kindId})")
    public int insertArticle_kind(int articleId,int kindId);

    /**
     * 创建新的标签关系
     * @return
     */
    @Insert("insert into article_tag(articleId,tagId) values(#{articleId},#{tagId})")
    public int insertArticle_tag(int articleId,int tagId);

    /**
     *
     * @param kindId
     * @return
     */
    @Delete("delete from article_kind where kindId=#{kindId}")
    public int deleteArticle_kindByKindId(int kindId);

    /**
     *
     * @param tagId
     * @return
     */
    @Delete("delete from article_tag where tagId=#{tagId}")
    public int deleteArticle_tagByTagId(int tagId);

    /**
     *
     * @param commitId
     * @return
     */
    @Delete("delete from article_commit where commitId=#{commitId}")
    public int deleteArticle_commitByCommitId(int commitId);

    /**
     *
     * @param articleId
     * @return
     */
    @Delete("delete from article_kind where kindId=#{articleId}")
    public int deleteArticle_kindByArticleId(int articleId);

    /**
     *
     * @param articleId
     * @return
     */
    @Delete("delete from article_tag where tagId=#{articleId}")
    public int deleteArticle_tagByArticleId(int articleId);

    /**
     *
     * @param articleId
     * @return
     */
    @Delete("delete from article_commit where commitId=#{articleId}")
    public int deleteArticle_commitByArticleId(int articleId);
}
