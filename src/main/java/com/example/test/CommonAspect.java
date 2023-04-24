package com.example.test;

import com.windfire.apis.asysConnectData;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.web.servlet.ConditionalOnMissingFilterBean;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
public class CommonAspect {

    asysConnectData con = null;

    public asysConnectData getCon() {
        return this.con;
    }

    @Before("pointCut()")
    public void CommonAspect(JoinPoint joinPoint) {

        System.out.println("before work");

        _PropertiesConfig prop = null;
        try {
            prop = new _PropertiesConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        con = new asysConnectData(prop.hostname, prop.port, prop.desc, prop.username, prop.password);
        System.out.println("PointCut: "+ con);
        new AppController().setCon(con);
    }
    @Pointcut("execution(* com.example.test..*.*(..))")
    public void pointCut(){}

//    @Before("pointCut()")
//    public void createConnection(JoinPoint joinPoint) {
//
//        System.out.println("before work");
//
//        _PropertiesConfig prop = null;
//        try {
//            prop = new _PropertiesConfig();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        con = new asysConnectData(prop.hostname, prop.port, prop.desc, prop.username, prop.password);
//        System.out.println(con);
//    }



    public void disconnect(asysConnectData con) {
        System.out.println("after work");

        if (con != null) {
            con.close();
            this.con = null;
        }
    }

}
