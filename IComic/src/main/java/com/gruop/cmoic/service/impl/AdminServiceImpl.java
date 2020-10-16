package com.gruop.cmoic.service.impl;

import com.gruop.cmoic.mapper.AdminMapper;
import com.gruop.cmoic.pojo.Admin;
import com.gruop.cmoic.pojo.AdminExample;
import com.gruop.cmoic.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminMapper adminMapper;

    @Override
    public Admin selectByUserName(String userName) {
        Admin admin = null;
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        if (userName != "") {
            criteria.andUsernameEqualTo(userName);
        }
        List<Admin> admins = adminMapper.selectByExample(example);
        if (admins.size() > 0) {
            admin = admins.get(0);
        }
        return admin;
    }
}
