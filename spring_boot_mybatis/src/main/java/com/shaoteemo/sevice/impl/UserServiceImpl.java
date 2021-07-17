package com.shaoteemo.sevice.impl;

import com.shaoteemo.mapper.UserMapper;
import com.shaoteemo.pojo.User;
import com.shaoteemo.pojo.UserExample;
import com.shaoteemo.sevice.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public void addUser(User user) {
        this.userMapper.insert(user);
    }

    @Override
    public List<User> findUsers() {
        PageHelper.startPage(1,10);
        List<User> list = this.userMapper.selectByExample(new UserExample());
        PageInfo<User> page = new PageInfo<>(list);
        log.info(page.toString());
        return list;
    }

    @Override
    public User preUpdateUser(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void modifyUserById(User user) {
        this.userMapper.updateByPrimaryKey(user);
    }

    @Override
    @Transactional
    public void dropUserById(Integer id) {
        this.userMapper.deleteByPrimaryKey(id);
    }
}
