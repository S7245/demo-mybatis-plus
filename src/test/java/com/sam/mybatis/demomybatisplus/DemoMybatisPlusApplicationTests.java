package com.sam.mybatis.demomybatisplus;

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
