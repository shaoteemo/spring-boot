package com.shaoteemo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.Map;

/**
 * 所属项目：spring_boot
 * 所属包：com.shaoteemo.util
 *
 * Thymeleaf模板引擎工具类
 *
 * @author ShaoTeemo
 * @date 2021/7/18
 * @since 1.0
 */
@Component
public class TemplateUtil {

    /*模板引擎*/
    @Autowired
    private SpringTemplateEngine templateEngine;

    public String getThymeLeafTemplate(String  template, Map<String , Object> variable){
        Context context = new Context();
        context.setVariables(variable);
        return this.templateEngine.process(template, context);
    }

}
