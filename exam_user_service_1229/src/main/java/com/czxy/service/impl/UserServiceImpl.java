package com.czxy.service.impl;

import com.czxy.domain.User;
import com.czxy.mapper.UserMapper;
import com.czxy.service.UserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        Example example = new Example(User.class);
        Example.Criteria c = example.createCriteria();
        c.andEqualTo("username",user.getUsername());
        c.andEqualTo("password",user.getPassword());
        User user1 = userMapper.selectOneByExample(example);
        return user1;
    }
}
