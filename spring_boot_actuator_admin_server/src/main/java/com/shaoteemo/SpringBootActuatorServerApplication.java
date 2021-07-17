package com.shaoteemo;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//开启Spring Boot Admin服务端
@EnableAdminServer
public class SpringBootActuatorServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootActuatorServerApplication.class, args);
	}

}
