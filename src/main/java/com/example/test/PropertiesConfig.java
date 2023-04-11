package com.example.test;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Getter
@Setter
@ConfigurationProperties(prefix = "spring.datasource")
public class PropertiesConfig {

    public String hostname;

    public String username;

    public String password;

    public String desc;
    public String port;




}
