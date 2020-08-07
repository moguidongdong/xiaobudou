package com.utils;

public interface BasicMapper<T> {

    int deleteByPrimaryKey(T t);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(T key);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

}
