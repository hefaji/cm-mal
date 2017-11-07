package com.xiaobaidu.mall;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

@EnableEurekaClient
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class MonitorApp extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(MonitorApp.class, args);

	}

}
