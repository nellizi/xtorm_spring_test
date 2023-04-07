package com.example.test;

import com.windfire.apis.asys.asysUsrElement;
import com.windfire.apis.asysConnectData;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class AppService {
    public void create(asysConnectData con, String filePath) {
        asysUsrElement uePage1 = new asysUsrElement(con);
        //uePage1.m_localFile = "/createtest/hi.txt";
        uePage1.m_localFile = filePath;
        uePage1.m_descr = "ScanedImage";
        uePage1.m_cClassId = "BASIC";
        uePage1.m_userSClass = "SUPER";
        uePage1.m_eClassId = "IMAGE";
        String gateway = "XTORM_MAIN";

        int ret = uePage1.create(gateway);

        if (ret != 0) {
            System.out.println("Error, create normal, " + uePage1.getLastError());
        } else {
            System.out.println("Success, create normal, " + uePage1.m_elementId);
        }
    }


    public void createStream(asysConnectData con, InputStream _inputStream) throws IOException, IOException {
        asysUsrElement uePage1 = new asysUsrElement(con);
        uePage1.m_descr = "ScanedImage";
        uePage1.m_cClassId = "BASIC";
        uePage1.m_userSClass = "SUPER";
        uePage1.m_eClassId = "IMAGE";
        String gateway = "XTORM_MAIN";

        InputStream inputStream = _inputStream;
        try {
            int ret = uePage1.create(gateway, inputStream, "", "");
            if (ret != 0)
                System.out.println("Error, create stream, " + uePage1.getLastError());
            else
                System.out.println("Success, create stream, " + uePage1.m_elementId);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
        }
    }







    public void download(asysConnectData con){
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

    public void delete(asysConnectData con) {
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

    public void replace(asysConnectData con){
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
