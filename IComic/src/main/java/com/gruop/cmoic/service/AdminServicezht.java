package com.gruop.cmoic.service;

import com.gruop.cmoic.pojo.Comic;
import com.gruop.cmoic.pojo.Information;
import com.gruop.cmoic.pojo.User;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-16 11:28
 */
public interface AdminServicezht {
    //查询用户数量
    int countUser();
    //留言数量
    int countMessage();
    //获取热度总数
    int getHeats();
    //管理员数量
    int countAdmin();
    // 查询所有评论
    List<Information> getComments();
    //查询所有漫画（按更新时间排序）
    List<Comic> getComics();
    //查询所有封号的用户信息
    List<User> getCloseUsers();
    //通过漫画名或作者或状态或地区 查询漫画
    List<Comic> getComicSByOther(Comic comic);
}
