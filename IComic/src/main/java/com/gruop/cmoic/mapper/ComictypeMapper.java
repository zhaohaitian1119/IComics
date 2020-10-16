package com.gruop.cmoic.mapper;

import com.gruop.cmoic.pojo.Comictype;
import com.gruop.cmoic.pojo.ComictypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComictypeMapper {
    int countByExample(ComictypeExample example);

    int deleteByExample(ComictypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Comictype record);

    int insertSelective(Comictype record);

    List<Comictype> selectByExample(ComictypeExample example);

    Comictype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Comictype record, @Param("example") ComictypeExample example);

    int updateByExample(@Param("record") Comictype record, @Param("example") ComictypeExample example);

    int updateByPrimaryKeySelective(Comictype record);

    int updateByPrimaryKey(Comictype record);
}