package com.gruop.cmoic.service.impl;

import com.gruop.cmoic.mapper.AdminMapper;
import com.gruop.cmoic.mapper.ComicMapper;
import com.gruop.cmoic.mapper.InformationMapper;
import com.gruop.cmoic.mapper.UserMapper;
import com.gruop.cmoic.pojo.*;
import com.gruop.cmoic.service.AdminServicezht;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-16 11:38
 */
@Service("")
public class AdminServiceImplzht implements AdminServicezht {

    @Resource
    UserMapper userMapper;
    @Resource
    AdminMapper adminMapper;
    @Resource
    InformationMapper informationMapper;
    @Resource
    ComicMapper comicMapper;

    //用户数量
    @Override
    public int countUser() {
        return userMapper.countByExample(null);
    }
    //留言数量
    @Override
    public int countMessage() {
        return informationMapper.countByExample(null);
    }
    //热度总量
    @Override
    public int getHeats() {
        int heats = comicMapper.getHeats();
        return heats;
    }
    //管理员总量
    @Override
    public int countAdmin() {
        return adminMapper.countByExample(null);
    }
    //评论总数
    @Override
    public List<Information> getComments() {
        List<Information> information = informationMapper.selectByExample(null);
        return information;
    }
    //漫画总量
    @Override
    public List<Comic> getComics() {
        List<Comic> comics = comicMapper.selectByExample(null);
        return comics;
    }
    //封号总量
    @Override
    public List<User> getCloseUsers() {
        return userMapper.getCloseUsers();
    }

    @Override
    public List<Comic> getComicSByOther(Comic comic) {
        return comicMapper.getComicSByOther(comic);
    }
}
