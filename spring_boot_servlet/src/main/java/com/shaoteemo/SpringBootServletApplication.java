package com.shaoteemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan //1.在SpringBoot启动的时候会扫描@WebServlet注解，并将该类实例化
public class SpringBootServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootServletApplication.class,args);
    }
}
