package com.yao.springbootdemo.enums;

/**
 * <p>返回结果状态码枚举类
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/23 23:48
 */
public enum ResultCodeEnum {

    /**
     * 结果成功
     */
    SUCCESS(200, "success"),

    /**
     * 结果失败
     */
    ERROR(500, "error");

    private Integer code;

    private String message;


    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
