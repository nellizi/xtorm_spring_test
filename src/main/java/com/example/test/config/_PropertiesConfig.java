package com.example.test.config;

import org.springframework.core.io.ClassPathResource;
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
//            prop.load(new FileInputStream("application.properties"));
            prop.load(new ClassPathResource("application.properties").getInputStream());
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