package com.hegg.springboot.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.hegg.springboot.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> getAllUser();

    Page<User> findByPage();

    PageInfo<User> findByPageInfo();
}