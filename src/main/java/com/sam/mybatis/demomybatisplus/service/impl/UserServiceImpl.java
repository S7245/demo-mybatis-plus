package com.sam.mybatis.demomybatisplus.service.impl;

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

}




