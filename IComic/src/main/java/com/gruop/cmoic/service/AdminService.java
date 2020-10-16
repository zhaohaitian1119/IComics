package com.gruop.cmoic.service;

import com.gruop.cmoic.pojo.Admin;

public interface AdminService {
    Admin selectByUserName(String userName);

}
