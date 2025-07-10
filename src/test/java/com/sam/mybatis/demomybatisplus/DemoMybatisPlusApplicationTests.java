package com.sam.mybatis.demomybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sam.mybatis.demomybatisplus.mapper.UserMapper;
import com.sam.mybatis.demomybatisplus.pojo.User;
import com.sam.mybatis.demomybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoMybatisPlusApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void updateUserByEmailTest(){
        //boolean count = userService.updateEmailById();
        //System.out.println(count);

        // 写法一：使用 LambdaUpdateWrapper (非链式)
//        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
//        updateWrapper.eq(User::getId,1).set(User::getEmail,"test");
//        boolean update = userService.update(updateWrapper);
//        System.out.println(update);

        User user = new User();
        user.setEmail("zhangsan");

        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(User::getId,1);

        userService.update(user,updateWrapper);
    }

    @Test
    void updateUserByEmailTest1(){
        //boolean count = userService.updateEmailById();
        //System.out.println(count);

         // 写法一：使用 LambdaUpdateWrapper (非链式)
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(User::getId,1).set(User::getEmail,"test");
        boolean update = userService.update(updateWrapper);
        System.out.println(update);

    }

    @Test
    void updateUserByEmailTest2(){
        //boolean count = userService.updateEmailById();
        //System.out.println(count);

        User user = new User();
        user.setEmail("zhangsan");

        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(User::getId,1);

        userService.update(user,updateWrapper);
    }

    @Test
    void countUsersAboveAge10Test(){
        long count = userService.countUsersAboveAge10();
        System.out.println(count);
    }

    @Test
    void countQueryWrapper(){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.gt(User::getAge,10);

        long count = userService.count(queryWrapper);
        System.out.println(count);
    }

    @Test
    void countTest(){
        // 查询用户表中的总记录数
        long totalUsers = userService.count(); // 调用 count 方法
        System.out.println("Total users: " + totalUsers);
    }



    @Test
    void page() {
        // 假设要进行无条件的分页查询，每页显示10条记录，查询第1页
        IPage<User> page = new Page<>(1, 3);
        IPage<User> userPage = userService.page(page); // 调用 page 方法
        List<User> userList = userPage.getRecords();
        long total = userPage.getTotal();

        System.out.println("Total users: " + total);
        for (User user : userList) {
            System.out.println("User: " + user);
        }
    }

    @Test
    void contextLoads() {
        // 查询用户表中的总记录数
        long count = userService.count();
        System.out.println("Total users: " + count);
    }
}
