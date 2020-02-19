package com.example.blogdemo.Dao;

import com.example.blogdemo.entity.Kind;
import com.example.blogdemo.entity.Tag;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("kindDao")
public interface KindDao {

    /**
     *
     * @return
     */
    @Select("select * from kind")
    public List<Kind> selectAll();
    /**
     *
     * @return
     */
    @Insert("insert into kind(name) values(#{name})")
    public int insertOne(Kind kind);

    /**
     *
     * @param kind
     * @return
     */
    @Delete("delete from kind where name=#{name}")
    public int delete(Kind kind);
}
