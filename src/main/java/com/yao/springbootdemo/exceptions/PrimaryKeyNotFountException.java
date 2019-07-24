package com.yao.springbootdemo.exceptions;

/**
 * <p>自定义主键没找到异常
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/24 0:51
 */
public class PrimaryKeyNotFountException extends RuntimeException {

    public PrimaryKeyNotFountException() {
        super("主键不存在");
    }

}
