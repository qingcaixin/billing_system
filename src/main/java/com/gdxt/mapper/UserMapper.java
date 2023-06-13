package com.gdxt.mapper;

import com.gdxt.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author WangXin
 * @Date 2023/6/13 14:13
 */

@Mapper
public interface UserMapper {
    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);


}
