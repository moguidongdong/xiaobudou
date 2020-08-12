package com.kenneth.ex.dao;


import com.kenneth.ex.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT * FROM t_user where id = #{id}")
    User findById(@Param("id") Integer id);

    @Insert("INSERT INTO t_user (id, name, age)values(#{id}, #{name}, #{age})")
    int insert(@Param("id") Integer id, @Param("name") String name, @Param("age") Integer age);
}
