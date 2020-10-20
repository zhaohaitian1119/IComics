package com.gruop.cmoic.service;

import com.gruop.cmoic.pojo.User;

public interface IndexUserService {
    //根据账号登录
    User selectByloginaccount(String loginaccount);

    //根据id查询
    User selectByid(Integer id);

}
