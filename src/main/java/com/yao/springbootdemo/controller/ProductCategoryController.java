package com.yao.springbootdemo.controller;

import com.yao.springbootdemo.bean.ProductCategoryBean;
import com.yao.springbootdemo.dto.ResultDto;
import com.yao.springbootdemo.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>商品类目控制器
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/21 17:54
 */
@RestController
@RequestMapping("/product")
public class ProductCategoryController {

    /**
     * 注入类目业务
     */
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 查询所有类目
     *
     * @return ProductCategoryBeans
     */
    @GetMapping("/categories")
    public List<ProductCategoryBean> getProductCategoryAllList() {
        return productCategoryService.findAll();
    }

    /**
     * 添加一个类目
     *
     * @param productCategoryBean productCategoryBean
     * @return ProductCategoryBean
     */
    @PostMapping(value = "/category", produces = "application/json;charset=UTF-8")
    public ResultDto<ProductCategoryBean> addProductCategoryBean(@Valid @RequestBody ProductCategoryBean productCategoryBean, BindingResult br) {
        return productCategoryService.save(productCategoryBean, br);
    }

    /**
     * 根据类目ID查找唯一类目
     *
     * @param categoryId categoryId
     * @return ProductCategoryBean
     */
    @GetMapping(value = "/category/{categoryId}")
    public ProductCategoryBean findProductCategoryBeanByCategoryId(@PathVariable("categoryId") Integer categoryId) {
        return productCategoryService.findById(categoryId);
    }

    /**
     * 更新类目情况
     *
     * @param categoryId          categoryId
     * @param productCategoryBean productCategoryBean
     * @return ProductCategoryBean
     */
    @PutMapping(value = "/category/{categoryId}", produces = "application/json;charset=UTF-8")
    public ResultDto<ProductCategoryBean> update(@PathVariable("categoryId") Integer categoryId, @Valid @RequestBody ProductCategoryBean productCategoryBean, BindingResult br) {
        productCategoryBean.setCategoryId(categoryId);
        return productCategoryService.save(productCategoryBean, br);
    }

    /**
     * 根据ID删除类目
     *
     * @param categoryId categoryId
     * @return String
     */
    @DeleteMapping(value = "/category/{categoryId}")
    public String delete(@PathVariable("categoryId") Integer categoryId) {
        productCategoryService.deleteById(categoryId);
        return "success";
    }

}
