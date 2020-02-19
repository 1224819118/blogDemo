package com.example.blogdemo.Dao;

import com.example.blogdemo.Dao.DaoProvider.UserProvider;
import com.example.blogdemo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface UserDao {
    /**
     *
     * @return userList集合
     */
    @Select("select * from user")
    public List<User> selectAll();

    /**
     *
     * @param userName
     * @return
     */
    @Select("select * from user where userName=#{userName}")
    public User selectOneByName(String userName);

    /**
     *
     * @param id:user的主键
     * @return user
     */
    @Select("select * from user where id=#{id}")
    public User selectOneById(int id);

    /**
     *
     * @param user:要插入的user对象
     * @return 执行代码的行数
     */
    @Insert("insert into user values(#{id},#{userName},#{password},#{nickName},#{profile},#{imageName})")
    public int insertOne(User user);

    /**
     *
     * @param user
     * @return
     */
    @Delete("delete from user where id=#{id}")
    public int delete(User user);

    /**
     *
     * @param user
     * @return
     */
    @UpdateProvider(type = UserProvider.class,method = "updateUserSql")
    public int update(User user);
}
