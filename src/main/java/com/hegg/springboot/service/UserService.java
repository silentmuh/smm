package com.hegg.springboot.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.hegg.springboot.model.User;

import java.util.List;

public interface UserService {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> getAllUser();

    Page<User> findByPage(Integer pageNum, Integer pageSize);

    PageInfo<User> findByPageInfo(Integer pageNum, Integer pageSize);

}
