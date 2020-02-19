package com.example.blogdemo.Dao;

import com.example.blogdemo.entity.Tag;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tagDao")
public interface TagDao {

    @Select("select * from tag")
    public List<Tag> selectAll();
    /**
     *
     * @param tag
     * @return
     */
    @Insert("insert into tag(name) values(#{name})")
    public int insertOne(Tag tag);

    /**
     *
     * @param tag
     * @return
     */
    @Delete("delete from tag where name=#{name}")
    public int delete(Tag tag);

}
