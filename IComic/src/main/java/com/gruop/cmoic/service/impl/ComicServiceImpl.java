package com.gruop.cmoic.service.impl;

import com.github.pagehelper.PageHelper;
import com.gruop.cmoic.mapper.ComicMapper;
import com.gruop.cmoic.pojo.Comic;
import com.gruop.cmoic.pojo.ComicExample;
import com.gruop.cmoic.service.ComicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ComicServiceImpl implements ComicService {
    @Resource
    ComicMapper comicMapper;


    @Override
    public List<Comic> selectAll(String area, String ccode) {
        ComicExample example = new ComicExample();
        ComicExample.Criteria criteria = example.createCriteria();
        if (area.equals(" ") == false) {
            criteria.andAddressEqualTo(area);
        }
        if (ccode.equals(" ") == false) {
            criteria.andCcodeEqualTo(ccode);
        }
        List<Comic> comics = comicMapper.selectByExample(example);
        return comics;
    }

    @Override
    public List<Comic> selectByType(Integer comiclistid) {
        ComicExample example = new ComicExample();
        ComicExample.Criteria criteria = example.createCriteria();
        if (comiclistid != 0) {
            criteria.andTypeEqualTo(comiclistid);
        }
        List<Comic> comics = comicMapper.selectByExample(example);
        return comics;
    }


}
