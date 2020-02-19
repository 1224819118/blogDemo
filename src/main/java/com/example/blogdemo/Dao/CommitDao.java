package com.example.blogdemo.Dao;

import com.example.blogdemo.entity.Commit;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository("commitDao")
public interface CommitDao {
    /**
     *
     * @param commit
     * @return
     */
    @Insert("insert into commit(text) values(#{text})")
    public int insertOne(Commit commit);

    /**
     *
     * @param commit
     * @return
     */
    @Delete("delete from commit where id=#{id}")
    public int delete(Commit commit);
}
