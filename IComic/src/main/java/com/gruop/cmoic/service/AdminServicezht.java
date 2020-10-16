package com.gruop.cmoic.service;

import com.gruop.cmoic.pojo.Chapter;
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
    //添加漫画
    int addComic(Comic comic);
    //删除漫画
    int deleteComicById(Integer id);
    //根据漫画id 查询漫画章节
    List<Chapter> selBycomicsId(Integer comicsId);
    //根据章节名查询
    List<Chapter> getChapter(String chapterName);
    //修改增加漫画章节
    int addChapter(Chapter chapter);
    //删除章节
    int deleteChapterById(Integer id);
}
