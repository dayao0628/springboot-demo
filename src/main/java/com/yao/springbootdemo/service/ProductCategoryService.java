package com.yao.springbootdemo.service;

import com.yao.springbootdemo.bean.ProductCategoryBean;
import com.yao.springbootdemo.dto.ResultDto;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * <p>商品类目的业务接口
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/21 22:22
 */
public interface ProductCategoryService {

    /**
     * 查找所有类目
     *
     * @return List<ProductCategoryBean>
     */
    List<ProductCategoryBean> findAll();

    /**
     * 根据主键查找
     *
     * @param categoryId ID
     * @return ProductCategoryBean
     */
    ProductCategoryBean findById(Integer categoryId);

    /**
     * 保存类目
     *
     * @param productCategoryBean param
     * @param br                  表单校验结果
     * @return ResultDto
     */
    ResultDto save(ProductCategoryBean productCategoryBean, BindingResult br);

    /**
     * 根据主键删除
     *
     * @param categoryId ID
     */
    void deleteById(Integer categoryId);

    /**
     * 校验结果提交表单
     *
     * @param br     表单验证结果
     * @return 验证的结果
     */
    ResultDto validate(BindingResult br);


}
