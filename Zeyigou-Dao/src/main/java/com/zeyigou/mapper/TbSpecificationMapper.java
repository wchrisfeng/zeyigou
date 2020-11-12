package com.zeyigou.mapper;


import com.zeyigou.pojo.TbSpecification;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface TbSpecificationMapper extends Mapper<TbSpecification> {

    //查询所有的规格列表
    List<Map> findSpecList();
}