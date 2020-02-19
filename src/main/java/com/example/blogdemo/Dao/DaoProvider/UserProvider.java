package com.example.blogdemo.Dao.DaoProvider;

import com.example.blogdemo.entity.User;
import org.apache.ibatis.jdbc.SQL;

public class UserProvider {
    public String updateUserSql(User user){
        SQL sql = new SQL();
        sql.UPDATE("user");
        if(user.getUserName()!=null){
            sql.SET("userName=#{userName}");
        } if (user.getPassword()!=null){
            sql.SET("password=#{password}");
        } if (user.getNickName()!=null){
            sql.SET("nickName=#{nickName}");
        } if (user.getProfile()!=null){
            sql.SET("profile=#{profile}");
        } if (user.getImageName()!=null){
            sql.SET("imageName=#{imageName}");
        }
        sql.WHERE("id=#{id}");
        return sql.toString();
    }
}
