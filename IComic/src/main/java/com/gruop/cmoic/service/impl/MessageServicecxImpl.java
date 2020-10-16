package com.gruop.cmoic.service.impl;

import com.gruop.cmoic.mapper.InformationMapper;
import com.gruop.cmoic.mapper.NewsMapper;
import com.gruop.cmoic.pojo.Information;
import com.gruop.cmoic.pojo.InformationExample;
import com.gruop.cmoic.pojo.News;
import com.gruop.cmoic.pojo.NewsExample;
import com.gruop.cmoic.service.MessageServicecx;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("messageService")
public class MessageServicecxImpl implements MessageServicecx{
    @Resource
    InformationMapper informationMapper;

//    @Override
//    public List<News> selectAll(String username, int pageIndex, int pageSize) {
//        return null;
//    }

    @Override
    public List<Information> selectAll(int pageIndex, int pageSize) {
        return informationMapper.selectByExample(null);
    }

    @Override
    public int del(int id) {
        return informationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Information> selByUserName(String username) {
        InformationExample example = new InformationExample();
        InformationExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike("%"+username+"%");
        List<Information> information = informationMapper.selectByExample(example);
        return information;
    }
}
