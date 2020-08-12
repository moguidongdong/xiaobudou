package com.mayikt.member.tony.dao;

import org.apache.ibatis.annotations.Insert;

public interface IMemberMapper {

    @Insert("insert into t_member_user (id, name, age)values(#{id}, #{name}, #{age})")
    int insert(Integer id, String name, Integer age);
}
