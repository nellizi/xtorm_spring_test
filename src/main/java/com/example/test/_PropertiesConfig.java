package com.example.test;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class _PropertiesConfig {

    Properties prop = null;

    public String hostname;
    public String username;
    public String password;
    public String desc;
    public int port;

    public _PropertiesConfig() throws IOException {
        prop = new Properties();
        try {
            prop.load(new FileInputStream(
                    "./application.properties"));
        } catch (IOException e) {
            System.out.println("파일 불러오기 오류 -> " + e);
            throw e;
        }

        hostname = prop.getProperty("hostname");
        username = prop.getProperty("username");
        password = prop.getProperty("password");
        desc = prop.getProperty("desc");
        port = Integer.parseInt(prop.getProperty("port"));

    }
}