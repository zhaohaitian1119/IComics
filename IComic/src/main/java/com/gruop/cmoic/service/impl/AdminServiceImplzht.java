package com.gruop.cmoic.service.impl;

import com.gruop.cmoic.mapper.*;
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
public class AdminServiceImplzht implements AdminServicezht{

    @Resource
    UserMapper userMapper;
    @Resource
    AdminMapper adminMapper;
    @Resource
    InformationMapper informationMapper;
    @Resource
    ComicMapper comicMapper;
    @Resource
    ChapterMapper chapterMapper;

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

    @Override
    public int addComic(Comic comic) {
        return comicMapper.insert(comic);
    }

    @Override
    public int deleteComicById(Integer id) {
        return comicMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Chapter> selBycomicsId(Integer comicsId) {
        ChapterExample example = new ChapterExample();
        ChapterExample.Criteria criteria = example.createCriteria();
        criteria.andComicsidEqualTo(comicsId);
        List<Chapter> chapters = chapterMapper.selectByExample(example);
        return chapters;
    }

    @Override
    public List<Chapter> getChapter(String chapterName) {
        ChapterExample example = new ChapterExample();
        ChapterExample.Criteria criteria = example.createCriteria();
        criteria.andChapternameLike("%"+chapterName+"%");
        List<Chapter> chapters = chapterMapper.selectByExample(example);
        return chapters;
    }

    @Override
    public int addChapter(Chapter chapter) {
        int i = chapterMapper.insertSelective(chapter);
        return i;
    }

    @Override
    public int deleteChapterById(Integer id) {
        int i = chapterMapper.deleteByPrimaryKey(id);
        return i;
    }
}
