package com.zeyigou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zeyigou.mapper.TbBrandMapper;
import com.zeyigou.pojo.TbBrand;
import com.zeyigou.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wf
 * @date 2020-11-12 20:22
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper brandMapper;
    //1.查询所有品牌
    @Override
    public List<TbBrand> findAll() {
        return brandMapper.selectAll();
    }
}
