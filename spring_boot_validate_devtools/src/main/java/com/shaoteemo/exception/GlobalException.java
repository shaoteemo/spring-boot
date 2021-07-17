package com.shaoteemo.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

//@Configuration
@Component

public class GlobalException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof ConstraintViolationException){
            modelAndView.setViewName("findUser");
        }
        modelAndView.addObject("error",e.getMessage().split(":")[e.getMessage().split(":").length-1]);
        return modelAndView;
    }
}
