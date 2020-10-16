package com.gruop.cmoic.mapper;

import com.gruop.cmoic.pojo.Relational;
import com.gruop.cmoic.pojo.RelationalExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelationalMapper {
    int countByExample(RelationalExample example);

    int deleteByExample(RelationalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Relational record);

    int insertSelective(Relational record);

    List<Relational> selectByExample(RelationalExample example);

    Relational selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Relational record, @Param("example") RelationalExample example);

    int updateByExample(@Param("record") Relational record, @Param("example") RelationalExample example);

    int updateByPrimaryKeySelective(Relational record);

    int updateByPrimaryKey(Relational record);
}