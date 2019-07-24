package com.yao.springbootdemo.dto;

import lombok.Data;

/**
 * <p>
 * <p>返回单个结果的数据模板
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/23 23:39
 */
@Data
public class ResultDto<T> {

    private Integer code;

    private String message;

    private T data;
}
