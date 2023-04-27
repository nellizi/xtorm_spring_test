package com.example.test;

import com.windfire.apis.asys.asysUsrElement;
import com.windfire.apis.asysConnectData;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class AppService {
    public void create(asysConnectData con, String filePath) {
        asysUsrElement uePage1 = new asysUsrElement(con);
        uePage1.m_localFile = filePath;
        uePage1.m_descr = "filePath";
        uePage1.m_cClassId = "BASIC"; //xtorm 관리파일의 라이프사이클 정의 ID
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

    public void multipartUpload(asysConnectData con, InputStream _inputStream, String extension) throws IOException, IOException {

        asysUsrElement uePage1 = new asysUsrElement(con);
        uePage1.m_descr = extension;
        uePage1.m_cClassId = "BASIC";
        uePage1.m_userSClass = "SUPER";
        uePage1.m_eClassId = "IMAGE";
        String gateway = "XTORM_MAIN";
        String path = _inputStream.toString();

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

//    public void download(asysConnectData con ){
//        asysUsrElement uePage1 = new asysUsrElement(con);
//        String elementId = "2023040609335700";
//        uePage1.m_elementId = "XTORM_MAIN::" + elementId + "::IMAGE";
//        String localfile = "C:\\test\\0406_2down.txt";
//        int ret = uePage1.getContent(localfile);
//
//        if (ret != 0)
//            System.out.println("Error, download normal, " + uePage1.getLastError());
//        else
//            System.out.println("Success, download normal, " + uePage1.m_elementId);
//    }

    public void multipartDownload(asysConnectData con, String _elementId) throws IOException {
        asysUsrElement uePage1 = new asysUsrElement(con);
        String elementid = _elementId;
        uePage1.m_elementId = "XTORM_MAIN::" + elementid + "::IMAGE";

        int _ret = uePage1.retrieveProps("XTORM_MAIN::"+elementid+"::IMAGE", true, true);

//        if (_ret != 0) { System.out.println("Error : " + uePage1.getLastError());
//        } else { extention = uePage1.m_descr;}

        System.out.println("extention= " + uePage1.m_descr);

        String localfile = "C:\\XTORMTEST\\" +elementid +"."+ uePage1.m_descr;     // 이 경로, 이름으로 다운됨.
        int ret = uePage1.getContent(localfile);

        if (ret != 0) {
            System.out.println("Error, failed to download, " + uePage1.getLastError());
        } else {
            System.out.println("Success, download normal, " + uePage1.m_elementId);
        }
    }

//    public void delete(asysConnectData con) {
//        asysUsrElement uePage1 = new asysUsrElement(con);
//        String elementId = "2023040609300100";
//        uePage1.m_elementId = "XTORM_MAIN::" + elementId + "::IMAGE";
//        int ret = uePage1.delete();
//
//        if (ret != 0) {
//            System.out.println("Error, failed to delete, " + uePage1.getLastError());
//        } else {
//            System.out.println("Success, delete is done, " + uePage1.m_elementId);
//        }
//    }

    public void multipartDelete(asysConnectData con, String _elementId) throws IOException {
        asysUsrElement uePage1 = new asysUsrElement(con);
        String elementid = _elementId;
        uePage1.m_elementId = "XTORM_MAIN::" + elementid + "::IMAGE";
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


//    public void retrieve(asysConnectData con){
//        asysUsrElement elem = new asysUsrElement(con);
//        String elementid = "2023041313495000";
//        int ret = elem.retrieveProps("XTORM_MAIN::"+elementid+"::IMAGE", true, true);
//        //int ret = elem.retrieveProps("", false, false);
//        // Check for errors - last message always in API object
//        if (ret != 0)
//            System.out.println("Error : " + elem.getLastError());
//        else {
//            System.out.println("Success : " + elem.m_elementId);
//            System.out.println("  descr : " + elem.m_descr);
//            System.out.println(" sclass : " + elem.m_userSClass);
//            System.out.println(" eclass : " + elem.m_eClassId);
//
//            System.out.println(" size   : " + elem.m_contentSize);
//            System.out.println(" date   : " + elem.m_contentDate);
//
//            elem.retrieveCClassId();
//            System.out.println(" cclass : " + elem.m_cClassId);
//        }
//    }



}
