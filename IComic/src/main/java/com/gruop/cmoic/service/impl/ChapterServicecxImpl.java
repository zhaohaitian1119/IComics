package com.gruop.cmoic.service.impl;

import com.github.pagehelper.PageHelper;
import com.gruop.cmoic.mapper.ChapterMapper;
import com.gruop.cmoic.pojo.Chapter;
import com.gruop.cmoic.pojo.ChapterExample;
import com.gruop.cmoic.pojo.Comic;
import com.gruop.cmoic.service.ChapterServicecx;
import com.gruop.cmoic.service.ComicServicecx;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("chapterService")
public class ChapterServicecxImpl implements ChapterServicecx {
    @Resource
    ChapterMapper chapterMapper;
    @Resource
    ComicServicecx comicServicecx;

    @Override
    public List<Chapter> selectAll() {
        Chapter chapter=new Chapter();
        List<Chapter> chapters = chapterMapper.selectByExample(null);
        for(Chapter chapter1:chapters){
            if(chapter1.getComicsid()!=null){
                Comic comic = comicServicecx.selectComic(1);
                chapter1.setComic(comic);
            }
        }
        return chapters;
    }
}
