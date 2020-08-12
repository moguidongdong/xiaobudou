package com.mayikt.order.tony.dao;

import org.apache.ibatis.annotations.Insert;

public interface IOrderMapper {

    @Insert("insert into t_order_user (id, name, age)values(#{id}, #{name}, #{age})")
    int insert(Integer id, String name, Integer age);

}
