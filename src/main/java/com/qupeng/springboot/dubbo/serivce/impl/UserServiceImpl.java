package com.qupeng.springboot.dubbo.serivce.impl;

import com.qupeng.springboot.dubbo.mapper.UserMapper;
import com.qupeng.springboot.model.User;
import com.qupeng.springboot.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service //Spring的配置
@Service(timeout = 10000) //dubbo的配置
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        //return new User();
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateUserById(Integer id) {
//        return 100;
        User user = new User();
        user.setId(id);
        user.setPhone("1370000000x");
        return userMapper.updateByPrimaryKeySelective(user);
    }
}