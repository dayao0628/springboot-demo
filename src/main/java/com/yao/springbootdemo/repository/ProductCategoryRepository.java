package com.yao.springbootdemo.repository;

import com.yao.springbootdemo.bean.ProductCategoryBean;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>商品类目表操作数据库接口类
 * <p>ProductCategoryRepository
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/21 17:51
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryBean, Integer> {
}
