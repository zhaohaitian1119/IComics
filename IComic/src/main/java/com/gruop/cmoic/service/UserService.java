package com.gruop.cmoic.service;

import com.gruop.cmoic.pojo.User;

import java.util.List;

public interface UserService {

    //根据用户名 登录账号 性别 查询 含分页
    List<User> selectByusernameAndloginaccountAndsex(String username, String loginaccount, String sex, Integer pageNum, Integer pageSize);

    //添加用户
    int addUser(User user);

    //根据登录账号查询
    User selectByloginaccount(String loginaccount);

    //删除
    int delByid(Integer id);

    //封号
    int upduserstatus(User user);


    //查询封号用户的信息
    List<User> selectByusernameAnduserstatus(String loginaccount, Integer userstatus, Integer pageNum, Integer pageSize);
}
