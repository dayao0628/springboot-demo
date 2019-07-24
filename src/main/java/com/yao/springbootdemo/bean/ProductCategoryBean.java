package com.yao.springbootdemo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * <p>商品类目表
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/21 17:31
 */
@Entity
@DynamicUpdate
@Table(name = "product_category")
@Component
@Data
public class ProductCategoryBean {

    /**
     * 商品类目ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /**
     * 商品类目名称
     */
    @NotBlank(message = "类目名称不能为空")
    private String categoryName;

    /**
     * 商品类目类型
     */
    @NotNull(message = "类目类型不能为空")
    private Integer categoryType;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 最后一次更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
