package com.zeyigou.sellergoods.service;

import com.zeyigou.pojo.PageResult;
import com.zeyigou.pojo.TbBrand;

import java.util.List;

/**
 * @author wf
 * @date 2020-11-12 20:21
 */
public interface BrandService {
    List<TbBrand> findAll();

    PageResult findByPage(int page, int pageSize);

    PageResult search(int page, int pageSize, TbBrand brand);

    void insert(TbBrand brand);

    void update(TbBrand brand);

    void delete(String[] ids);
}
