package com.gruop.cmoic.mapper;

import com.gruop.cmoic.pojo.Comic;
import com.gruop.cmoic.pojo.ComicExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComicMapper {
    int countByExample(ComicExample example);

    int deleteByExample(ComicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Comic record);

    int insertSelective(Comic record);

    List<Comic> selectByExample(ComicExample example);

    Comic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Comic record, @Param("example") ComicExample example);

    int updateByExample(@Param("record") Comic record, @Param("example") ComicExample example);

    int updateByPrimaryKeySelective(Comic record);

    int updateByPrimaryKey(Comic record);
}