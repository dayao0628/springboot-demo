package com.yao.springbootdemo.service.impl;

import com.yao.springbootdemo.service.ProductCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void save() {
    }

    @Test
    public void validate() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void findAll() {
        productCategoryService.findAll();
    }

    @Test
    public void findById() {
    }
}