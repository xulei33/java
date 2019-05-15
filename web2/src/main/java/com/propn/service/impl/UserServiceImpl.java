package com.propn.service.impl;

import com.propn.entity.User;
import com.propn.dao.mapper.UserMapper;
import com.propn.entity.UserExample;
import com.propn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers(Integer userId) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (!"".equals(userId == null ? "" : userId)) {
            criteria.andIdEqualTo(Long.valueOf(userId));
        }
        return userMapper.selectByExample(example);

    }
}