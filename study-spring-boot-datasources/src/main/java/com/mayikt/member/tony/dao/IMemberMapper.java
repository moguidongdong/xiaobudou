package com.mayikt.member.tony.dao;

import com.mayikt.member.tony.entity.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IMemberMapper {

    @Insert("insert into t_member_user (id, name, age)values(#{id}, #{name}, #{age})")
    int insert(Integer id, String name, Integer age);

    @Select("select * from t_member_user")
    List<Member> queryAll();
}
