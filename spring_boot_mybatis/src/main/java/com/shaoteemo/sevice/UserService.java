package com.shaoteemo.sevice;

import com.shaoteemo.pojo.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> findUsers();

    User preUpdateUser(Integer id);

    void modifyUserById(User user);

    void dropUserById(Integer id);

}
