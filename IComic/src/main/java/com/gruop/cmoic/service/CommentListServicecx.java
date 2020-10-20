package com.gruop.cmoic.service;

import com.gruop.cmoic.pojo.News;

import java.util.List;

public interface CommentListServicecx {
    List<News> selectAll(int pageIndex,int pageSize);
    List<News> selectNewsId(Integer newsid,int pageIndex,int pageSize);
    List<News> select();
    int del(int id);
}
