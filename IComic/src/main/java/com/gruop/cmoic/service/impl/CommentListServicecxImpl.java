package com.gruop.cmoic.service.impl;

import com.gruop.cmoic.mapper.InformationMapper;
import com.gruop.cmoic.mapper.NewsMapper;
import com.gruop.cmoic.pojo.News;
import com.gruop.cmoic.pojo.NewsExample;
import com.gruop.cmoic.service.CommentListServicecx;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("commentListService")
public class CommentListServicecxImpl implements CommentListServicecx {
    @Resource
    NewsMapper newsMapper;

    @Override
    public List<News> selectAll(int pageIndex, int pageSize) {
        return newsMapper.selectByExample(null);
    }

    @Override
    public List<News> selectNewsId(Integer newsid, int pageIndex, int pageSize) {
        NewsExample newsExample=new NewsExample();
        NewsExample.Criteria criteria = newsExample.createCriteria();
        if(newsid!=null&&newsid!=0){
            criteria.andNewsidEqualTo(newsid);
        }else{
            return newsMapper.selectByExample(null);
        }
        return newsMapper.selectByExample(newsExample);
    }

    @Override
    public List<News> select() {
        return newsMapper.selectByExample(null);
    }

    @Override
    public int del(int id) {
        return newsMapper.deleteByPrimaryKey(id);
    }
}
