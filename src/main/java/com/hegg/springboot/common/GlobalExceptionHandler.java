package com.hegg.springboot.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @description    ：全局异常处理类：通过使用@ControllerAdvice定义统一的异常处理类
 * @author        ：hegg
 * @createdate    ：2019/3/28 028 20:06
 * @version        : 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error/error";

    //@ExceptionHandler用来定义函数针对的异常类型，最后将Exception对象和请求URL映射到error.html中
    //2020-05-08 11:40 github在线编辑改文件于当前行
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
}
