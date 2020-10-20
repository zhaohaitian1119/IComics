package com.gruop.cmoic.service.impl;

import com.gruop.cmoic.mapper.ChapterMapper;
import com.gruop.cmoic.mapper.ComicMapper;
import com.gruop.cmoic.mapper.NewsMapper;
import com.gruop.cmoic.mapper.UserMapper;
import com.gruop.cmoic.pojo.*;
import com.gruop.cmoic.service.IndexServicezht;
import org.apache.commons.io.filefilter.MagicNumberFileFilter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-18 14:16
 */

@Service("indexService")
public class IndexServicezhtImpl implements IndexServicezht {

    @Resource
    ComicMapper comicMapper;
    @Resource
    ChapterMapper chapterMapper;
    @Resource
    NewsMapper newsMapper;
    @Resource
    UserMapper userMapper;

    @Override
    public List<Comic> selAll() {
        List<Comic> comics = comicMapper.selectOrderHeatasc();
        return comics;
    }

    @Override
    public List<Comic> selComicOrderheat() {
        List<Comic> comics = comicMapper.selectOrderHeatdesc();
        return comics;
    }

    @Override
    public List<Chapter> selChapterOrderupdatime() {
        List<Chapter> chapters = chapterMapper.selectByExample(null);
        return chapters;
    }

    @Override
    public Comic selComicById(Integer id) {
        Comic comic = comicMapper.selectByPrimaryKey(id);
        return comic;
    }

    @Override
    public List<News> selNewsByComicId(Integer id) {
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        criteria.andNewsidEqualTo(id);
        List<News> news = newsMapper.selectByExample(example);
        return news;
    }

    @Override
    public List<User> selUserById(Integer id) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<User> users = userMapper.selectByExample(example);
        return users;
    }

    @Override
    public Chapter selByComicsdiBychapternum(Integer comicsid, Integer chapternum) {
        ChapterExample example = new ChapterExample();
        ChapterExample.Criteria criteria = example.createCriteria();
        criteria.andComicsidEqualTo(comicsid);
        criteria.andChapternumEqualTo(chapternum);
        List<Chapter> chapters = chapterMapper.selectByExample(example);
        Chapter chapter = chapters.get(0);
        return chapter;
    }

    @Override
    public List<Comic> selComicsById(Integer id) {
        ComicExample example = new ComicExample();
        ComicExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<Comic> comicList = comicMapper.selectByExample(example);
        return comicList;
    }
}
