package com.gruop.cmoic.service;

import com.gruop.cmoic.pojo.Information;
import com.gruop.cmoic.pojo.News;

import java.util.List;

public interface MessageServicecx {
    List<Information> selectAll(int pageIndex, int pageSize);
    int del(int id);
}
