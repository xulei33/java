package com.propn.service;


import com.propn.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsers(Integer userId);
}
