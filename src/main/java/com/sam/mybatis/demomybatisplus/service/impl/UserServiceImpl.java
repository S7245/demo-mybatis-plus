package com.sam.mybatis.demomybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sam.mybatis.demomybatisplus.pojo.User;
import com.sam.mybatis.demomybatisplus.service.UserService;
import com.sam.mybatis.demomybatisplus.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author liushan
* @description 针对表【user】的数据库操作Service实现
* @createDate 2025-07-10 13:16:00
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public Long countUsersAboveAge10() {
        return this.lambdaQuery().gt(User::getAge, 10).count();
    }

    @Override
    public boolean updateEmailById() {
        User user = new User();
        user.setEmail("new@mai.com");

        return this.lambdaUpdate().set(User::getEmail, user.getEmail()).eq(User::getId,1).update();
        //return this.lambdaUpdate().set();
    }
}




