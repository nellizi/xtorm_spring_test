package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.io.IOException;

@SpringBootApplication
//@EnableAspectJAutoProxy(proxyTargetClass=true)   //aop 사용
public class TestApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TestApplication.class, args);

	}

}
