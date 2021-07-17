package com.shaoteemo;

import com.shaoteemo.listener.SecondListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan//①在spring Boot 启动时会扫描@WebServlet,@WebFilter,@WebListener 注解，并将该类实例化
public class SpringBootListenerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootListenerApplication.class,args);
    }

    @Bean
    public ServletListenerRegistrationBean<SecondListener> getServletListenerRegistrationBean(){
        return new ServletListenerRegistrationBean<>(new SecondListener());
    }

}
