package com.gruop.cmoic.service.impl;

import com.gruop.cmoic.mapper.UserMapper;
import com.gruop.cmoic.pojo.User;
import com.gruop.cmoic.pojo.UserExample;
import com.gruop.cmoic.service.IndexUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("indexUserService")
public class IndexUserServiceImpl implements IndexUserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User selectByloginaccount(String loginaccount) {
        User user = null;
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (loginaccount != "") {
            criteria.andLoginaccountEqualTo(loginaccount);
        }
        List<User> users = userMapper.selectByExample(example);
        if (users.size() > 0) {
            user = users.get(0);
        }
        return user;
    }

    @Override
    public User selectByid(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
