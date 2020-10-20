package com.gruop.cmoic.service;

import com.gruop.cmoic.pojo.Comic;
import org.springframework.stereotype.Controller;

import java.util.List;

public interface ComicService {
    //分类首页默认查询全部  并根据地区和进度查询
    List<Comic> selectAll(String area, String ccode);

    //根据题材查询漫画
    List<Comic> selectByType(Integer comiclistid);
}
