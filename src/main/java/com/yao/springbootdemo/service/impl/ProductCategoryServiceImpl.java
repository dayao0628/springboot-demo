package com.yao.springbootdemo.service.impl;

import com.yao.springbootdemo.bean.ProductCategoryBean;
import com.yao.springbootdemo.dto.ResultDto;
import com.yao.springbootdemo.exceptions.PrimaryKeyNotFountException;
import com.yao.springbootdemo.repository.ProductCategoryRepository;
import com.yao.springbootdemo.service.ProductCategoryService;
import com.yao.springbootdemo.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * <p>商品类目业务层实现类
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/21 22:27
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResultDto save(ProductCategoryBean productCategoryBean, BindingResult br) {
        ResultDto result = validate(br);
        if (result != null) {
            return result;
        }

        if (productCategoryBean.getCategoryId() == null) {
            productCategoryBean.setCreateTime(new Date());
            productCategoryBean.setUpdateTime(new Date());
        } else {

            ProductCategoryBean oldBean = findById(productCategoryBean.getCategoryId());
            productCategoryBean.setCategoryId(oldBean.getCategoryId());
            productCategoryBean.setCreateTime(oldBean.getCreateTime());
            productCategoryBean.setUpdateTime(new Date());
        }
        productCategoryBean = productCategoryRepository.save(productCategoryBean);

        return ResultUtils.success(productCategoryBean);
    }

    @Override
    public ResultDto validate(BindingResult br) {
        if (br == null) {
            return null;
        }
        if (br.hasErrors()) {
            return ResultUtils.error(Objects.requireNonNull(br.getFieldError()).getDefaultMessage());
        }
        return null;
    }


    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteById(Integer categoryId) {
        productCategoryRepository.deleteById(categoryId);
    }

    @Override
    public List<ProductCategoryBean> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategoryBean findById(Integer categoryId) {
        Optional<ProductCategoryBean> optional = productCategoryRepository.findById(categoryId);
        if (optional != null && optional.isPresent()) {
            return optional.get();
        }
        throw new PrimaryKeyNotFountException();
    }
}
