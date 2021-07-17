package com.shaoteemo.dao;

import com.shaoteemo.pojo.User;

import java.util.List;

public interface UserDao {
    void insertUser(User user);

    List<User> selectUserAll();

    User selectUserById(Integer id);

    void updateUser(User user);

    void dropUser(Integer id);
}
