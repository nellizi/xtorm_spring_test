package com.example.test;

import com.windfire.apis.asysConnectData;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
public class CommonAspect {

    asysConnectData con = null;
    @Autowired
    AppController appController;

    public asysConnectData getCon() {
        return this.con;
    }

    @Pointcut("execution(* com.example.test.AppController.multi*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void CommonAspect(JoinPoint joinPoint) {
        System.out.println("con before work: "+ con);

        _PropertiesConfig prop = null;
        try {
            prop = new _PropertiesConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        con = new asysConnectData(prop.hostname, prop.port, prop.desc, prop.username, prop.password);
        System.out.println("PointCut: "+ con);
        appController.setCon(con);
    }

    @After("pointCut()")
    public void disconnect(JoinPoint joinPoint) {
        System.out.println("after work");
        if (con != null) {
            con.close();
            this.con = null;
            appController.setCon(con);
            System.out.println("con in AfterWork: "+con);
        }
    }
}
