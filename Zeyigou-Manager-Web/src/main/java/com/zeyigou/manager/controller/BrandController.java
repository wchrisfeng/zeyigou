package com.zeyigou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zeyigou.pojo.PageResult;
import com.zeyigou.pojo.Result;
import com.zeyigou.pojo.TbBrand;
import com.zeyigou.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    //2.分页查询
    @RequestMapping("findByPage")
    public PageResult findByPage(@RequestParam(defaultValue = "1") int page, int pageSize){
        //2.1)根据分页条件查询
        return brandService.findByPage(page,pageSize);
    }

    //3.带条件的分页
    @RequestMapping("search")
    public PageResult search(int page,int pageSize,@RequestBody(required = false) TbBrand brand){
        return brandService.search(page,pageSize,brand);
    }
    //4.添加品牌
    @RequestMapping("add")
    public Result insertBrand(@RequestBody TbBrand brand){
        try {
            brandService.insert(brand);
            return new Result(true,"添加品牌成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加品牌失败");
        }
    }
    //5.修改品牌
    @RequestMapping("update")
    public Result updateBrand(@RequestBody TbBrand brand){
        try {
            brandService.update(brand);
            return new Result(true,"修改品牌成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改品牌失败");
        }
    }

    //6.批量删除品牌
    @RequestMapping("delete")
    public Result delete(String[] ids){
        try {
            brandService.delete(ids);
            return new Result(true,"批量删除品牌成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"批量删除品牌失败");
        }
    }
}
