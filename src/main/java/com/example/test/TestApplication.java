package com.example.test;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@SpringBootApplication
@Configuration
@EnableConfigurationProperties({PropertiesConfig.class})
public class TestApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TestApplication.class, args);
		_PropertiesConfig _propertiesConfig = new _PropertiesConfig();
		System.out.println(_propertiesConfig.desc);


	}

}
