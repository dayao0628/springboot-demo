package com.yao.springbootdemo.utils;

import com.yao.springbootdemo.dto.ResultDto;
import com.yao.springbootdemo.enums.ResultCodeEnum;

/**
 * <p>封装返回结果的方法
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/23 23:42
 */
public class ResultUtils {

    /**
     * 返回成功的结果，统一格式
     *
     * @param object 返回前端的数据
     * @return 统一的结果模板
     */
    public static ResultDto success(Object object) {
        ResultDto result = new ResultDto();
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        result.setData(object);
        return result;
    }

    /**
     * 返回失败的结果，统一格式
     *
     * @param message 失败的原因
     * @return 统一的结果模板
     */
    public static ResultDto error(String message) {
        ResultDto result = new ResultDto();
        result.setCode(ResultCodeEnum.ERROR.getCode());
        result.setMessage(message);
        return result;
    }

}
