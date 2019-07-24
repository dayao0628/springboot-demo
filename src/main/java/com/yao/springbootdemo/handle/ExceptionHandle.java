package com.yao.springbootdemo.handle;

import com.yao.springbootdemo.dto.ResultDto;
import com.yao.springbootdemo.utils.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>异常捕获处理类
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/24 1:06
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultDto handle(Exception e) {
        return ResultUtils.error(e.getMessage());
    }
}
