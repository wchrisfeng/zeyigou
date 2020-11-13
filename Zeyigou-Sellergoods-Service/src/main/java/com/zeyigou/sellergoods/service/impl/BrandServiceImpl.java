package com.zeyigou.sellergoods.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zeyigou.mapper.TbBrandMapper;
import com.zeyigou.pojo.PageResult;
import com.zeyigou.pojo.TbBrand;
import com.zeyigou.pojo.TbBrandExample;
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
    //2.分页查询
    @Override
    public PageResult findByPage(int page, int pageSize) {
        //2.1)开始分页
        PageHelper.startPage(page,pageSize);
        //2.2)得到实例对象
        TbBrandExample example = new TbBrandExample();
        //2.3)得到查询出的TbBrand品牌集合
        List<TbBrand> tbBrands = brandMapper.selectByExample(example);
        //2.4)得到Page<TbBrand>对象
        Page<TbBrand> brandPage = (Page<TbBrand>) tbBrands;
        //2.5)返回PageResult对象
        return new PageResult(brandPage.getTotal(),brandPage.getResult());
    }

    //3.带条件的分页查询
    @Override
    public PageResult search(int page, int pageSize, TbBrand brand) {
        //3.1)开始分页
        PageHelper.startPage(page,pageSize);
        //3.2)创建实例对象
        TbBrandExample example = new TbBrandExample();
        //3.3)得到条件判断对象
        TbBrandExample.Criteria criteria = example.createCriteria();
        //3.4)条件判断
        if(brand != null){
            if(StrUtil.isNotBlank(brand.getName())){
                criteria.andNameLike("%"+brand.getName()+"%");
            }
            if(StrUtil.isNotBlank(brand.getFirstChar())){
                criteria.andFirstCharEqualTo(brand.getFirstChar());
            }
        }
        //3.5)得到TbBrand集合
        List<TbBrand> tbBrands = brandMapper.selectByExample(example);
        //3.6)将集合转换为Page<TbBrand>对象
        Page<TbBrand> brandPage = (Page<TbBrand>) tbBrands;
        //3.7)返回PageResult对象
        return new PageResult(brandPage.getTotal(),brandPage.getResult());
    }
    //4.添加品牌
    @Override
    public void insert(TbBrand brand) {
        brandMapper.insert(brand);
    }
    //5.修改品牌
    @Override
    public void update(TbBrand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }
    //6.批量删除品牌
    @Override
    public void delete(String[] ids) {
        //6.1)遍历id数组
        for (String id : ids) {
            //6.2)删除
            brandMapper.deleteByPrimaryKey(id);
        }
    }
}
