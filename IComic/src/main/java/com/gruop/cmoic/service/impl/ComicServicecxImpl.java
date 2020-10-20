package com.gruop.cmoic.service.impl;

import com.gruop.cmoic.mapper.ComicMapper;
import com.gruop.cmoic.pojo.Comic;
import com.gruop.cmoic.pojo.ComicExample;
import com.gruop.cmoic.service.ComicServicecx;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("comicService")
public class ComicServicecxImpl implements ComicServicecx {
    @Resource
    ComicMapper comicMapper;

    @Override
    public Comic selectComic(Integer id) {
        ComicExample comicExample=new ComicExample();
        ComicExample.Criteria criteria = comicExample.createCriteria();
        criteria.andIdEqualTo(id);
        return comicMapper.selectByPrimaryKey(id);
    }
}
