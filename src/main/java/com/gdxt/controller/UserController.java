package com.gdxt.controller;

import com.gdxt.entity.User;
import com.gdxt.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author WangXin
 * @Date 2023/6/13 14:17
 */

/**
 *  测试类
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();

        for(User user:userList){
            System.out.println(user);
        }

        return userList;
    }

    @GetMapping("/queryUserById")
    public User queryUserById(){

        User user = userMapper.queryUserById(1);
        return user;

    }


    @GetMapping("/addUser")
    public String addUser(){
        userMapper.addUser(new User(21,"阿毛","123456"));
        return "添加成功";

    }

    @GetMapping("/updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(1,"秃驴","123465"));
        return "更改成功";
    }


    @GetMapping("/deleteUser")
    public String deleteUser(){
        userMapper.deleteUser(1);
        return "删除成功";

    }

}
