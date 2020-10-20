package com.gruop.cmoic.service;

import com.gruop.cmoic.pojo.Chapter;
import com.gruop.cmoic.pojo.Comic;
import com.gruop.cmoic.pojo.News;
import com.gruop.cmoic.pojo.User;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-18 14:11
 */
public interface IndexServicezht {
    //查询前五名热度最高的漫画
    List<Comic> selAll();
    //热度较低的漫画
    List<Comic> selComicOrderheat();
    //查询章节 按照更新时间 升序
    List<Chapter> selChapterOrderupdatime();
    //根据id查询漫画详情
    Comic selComicById(Integer id);
    //根据漫画id查询评论
    List<News> selNewsByComicId(Integer id);
    //查询全部用户
    List<User> selUserById(Integer id);
    //根据漫画id和章节id查询章节信息
    Chapter selByComicsdiBychapternum(Integer comicsid,Integer chapternum);
    //根据id查漫画
    List<Comic> selComicsById(Integer id);
}
