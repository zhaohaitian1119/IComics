package com.gruop.cmoic.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gruop.cmoic.mapper.UserMapper;
import com.gruop.cmoic.pojo.User;
import com.gruop.cmoic.pojo.UserExample;
import com.gruop.cmoic.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public List<User> selectByusernameAndloginaccountAndsex(String username, String loginaccount, String sex, Integer pageNum, Integer pageSize) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (username != "" && username.isEmpty() == false) {
            criteria.andUsernameLike("%" + username + "%");
        }
        if (loginaccount != "" && loginaccount.isEmpty() == false) {
            criteria.andLoginaccountEqualTo(loginaccount);
        }
        if (sex != "" && sex.isEmpty() == false) {
            criteria.andSexEqualTo(sex);
        }
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("id desc");
        List<User> users = userMapper.selectByExample(example);
        return users;
    }

    @Override
    public int addUser(User user) {
        int insert = userMapper.insert(user);
        return insert;
    }

    @Override
    public User selectByloginaccount(String loginaccount) {
        User user = null;
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andLoginaccountEqualTo(loginaccount);
        List<User> users = userMapper.selectByExample(example);
        if (users.size() > 0) {
            user = users.get(0);
        }
        return user;
    }

    @Override
    public int delByid(Integer id) {
        int i = userMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int upduserstatus(User user) {
        int i = userMapper.updateByPrimaryKeySelective(user);
        return i;
    }
}
