package com.zeyigou.mapper;


import com.zeyigou.pojo.TbBrand;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface TbBrandMapper extends Mapper<TbBrand> {

    //查询所有的品牌列表
    List<Map> selectBrandList();
}