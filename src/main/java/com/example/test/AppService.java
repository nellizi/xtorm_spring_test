package com.example.test;

import com.windfire.apis.asys.asysUsrElement;
import com.windfire.apis.asysConnectData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class AppService {
    @Autowired
    AppRepository appRepository;
//    public void create(asysConnectData con, String filePath) {
//        asysUsrElement uePage1 = new asysUsrElement(con);
//        uePage1.m_localFile = filePath;
//        uePage1.m_descr = "filePath";
//        uePage1.m_cClassId = "BASIC"; //xtorm 관리파일의 라이프사이클 정의 ID
//        uePage1.m_userSClass = "SUPER";
//        uePage1.m_eClassId = "IMAGE";
//        String gateway = "XTORM_MAIN";
//
//        int ret = uePage1.create(gateway);
//
//        if (ret != 0) {
//            System.out.println("Error, create normal, " + uePage1.getLastError());
//        } else {
//            System.out.println("Success, create normal, " + uePage1.m_elementId);
//        }
//    }

    public void multipartUpload(asysConnectData con, InputStream _inputStream, String extension) throws  IOException {

        asysUsrElement uePage1 = new asysUsrElement(con);
        uePage1.m_descr = extension;
        uePage1.m_cClassId = "BASIC";
        uePage1.m_userSClass = "SUPER";
        uePage1.m_eClassId = "IMAGE";
        String gateway = "XTORM_MAIN";
        String path = _inputStream.toString();

//        InputStream inputStream = _inputStream;
        try {
            int ret = uePage1.create(gateway, _inputStream, "", "");
            if (ret != 0)
                System.out.println("Error, create stream, " + uePage1.getLastError());
            else {
                System.out.println("Success, create stream, " + uePage1.m_elementId);
                String[] arr = uePage1.m_elementId.split("::");

             createEntity(arr[1]);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            _inputStream.close();
        }
    }

    private void createEntity(String elementId) {
        BizEntity bizEntity = new BizEntity();
        bizEntity.setElementId(elementId);

        System.out.println("createEntity: "+elementId);

        String id = appRepository.findByElementId(elementId);
        System.out.println("=========id : "+id +"==========");

    }

    public void multipartDownload(asysConnectData con, String _elementId) throws IOException {
        System.out.println("download in service");

        asysUsrElement uePage1 = new asysUsrElement(con);
        String elementid = _elementId;
        uePage1.m_elementId = "XTORM_MAIN::" + elementid + "::IMAGE";

        // uePage1.m_descr 불러오기 위함
        int _ret = uePage1.retrieveProps("XTORM_MAIN::"+elementid+"::IMAGE", true, true);

//        if (_ret != 0) { System.out.println("Error : " + uePage1.getLastError());
//        } else { extention = uePage1.m_descr;}

//        System.out.println("extention= " + uePage1.m_descr);

        String localfile = "C:\\XTORMTEST\\" +elementid +"."+ uePage1.m_descr;     // 이 경로, 이름으로 다운됨.
        int ret = uePage1.getContent(localfile);

        if (ret != 0) {
            System.out.println("Error, failed to download, " + uePage1.getLastError());
        } else {
            System.out.println("Success, download normal, " + uePage1.m_elementId);
        }
    }

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

}
