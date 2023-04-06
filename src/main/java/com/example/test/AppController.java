package com.example.test;

import com.windfire.apis.asys.asysUsrElement;
import com.windfire.apis.asysConnectData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {

    @GetMapping("/test")
//    @ResponseBody
    public String upload(){
        System.out.println("upload");

        return "upload";
    }


    private asysConnectData con = null;
    public AppController(){
        con = new asysConnectData("127.0.0.1",2102,"desc","SUPER","SUPER");
    }

    public void create() {
        asysUsrElement uePage1 = new asysUsrElement(con);
        uePage1.m_localFile = "/createtest/hi.txt";
        uePage1.m_descr = "ScanedImage";
        uePage1.m_cClassId = "BASIC";
        uePage1.m_userSClass = "SUPER";
        uePage1.m_eClassId = "IMAGE";
        String gateway = "XTORM_MAIN";

        uePage1.addIndexValue("TEST_INDEX_TABLE", "FILE_NAME", "new");
        uePage1.addIndexValue("TEST_INDEX_TABLE", "FILE_EXTENSION", "new");
        uePage1.addIndexValue("TEST_INDEX_TABLE", "USER_ID", "new");


        int ret = uePage1.create(gateway);

        if (ret != 0) {
            System.out.println("Error, create normal, " + uePage1.getLastError());
        } else {
            System.out.println("Success, create normal, " + uePage1.m_elementId);
        }
    }

    public void download(){
        asysUsrElement uePage1 = new asysUsrElement(con);
        String elementId = "2023040609335700";
        uePage1.m_elementId = "XTORM_MAIN::" + elementId + "::IMAGE";
        String localfile = "C:\\test\\0406_2down.txt";     // 이 경로, 이름으로 다운됨.
        int ret = uePage1.getContent(localfile);

        if (ret != 0)
            System.out.println("Error, download normal, " + uePage1.getLastError());
        else
            System.out.println("Success, download normal, " + uePage1.m_elementId);
    }

    public void delete() {
        asysUsrElement uePage1 = new asysUsrElement(con);
        String elementId = "2023040609300100";
        uePage1.m_elementId = "XTORM_MAIN::" + elementId + "::IMAGE";
        int ret = uePage1.delete();

        if (ret != 0) {
            System.out.println("Error, failed to delete, " + uePage1.getLastError());
        } else {
            System.out.println("Success, delete is done, " + uePage1.m_elementId);
        }
    }

    public void replace(){
        asysUsrElement uePage1 = new asysUsrElement(con);
        String elementId = "2023040609335700";
        uePage1.m_elementId = "XTORM_MAIN::" + elementId + "::IMAGE";
        int ret = uePage1.replaceContent("C:\\test\\change.txt");
        if (ret != 0){
            System.out.println("Error, failed to replace, " + uePage1.getLastError());
        }else{
            System.out.println("Success, replace is done, " + uePage1.m_elementId);
        }
    }


}
