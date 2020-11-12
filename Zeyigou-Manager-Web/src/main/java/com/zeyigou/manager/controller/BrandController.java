package com.zeyigou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zeyigou.pojo.TbBrand;
import com.zeyigou.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wf
 * @date 2020-11-12 20:18
 */
@RestController
@RequestMapping("brand")
public class BrandController {
    @Reference
    private BrandService brandService;
    //1.查询所有品牌
    @RequestMapping("list")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }
}
