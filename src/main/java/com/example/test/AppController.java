package com.example.test;

import com.windfire.apis.asysConnectData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.*;

@Controller
public class AppController {


    AppService appService = new AppService();
    private asysConnectData con = null;

    public AppController() {
        _PropertiesConfig prop = null;
        try {
            prop = new _PropertiesConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        con = new asysConnectData(prop.hostname, prop.port, prop.desc, prop.username, prop.password);

    }


    @GetMapping("/xtorm")
    public String upload() {
        return "upload";
    }

    @GetMapping("/xtorm2")
    public String upload2() {
        return "upload2";
    }

    @PostMapping("/upload")
    public String uploadToXtorm(@RequestParam MultipartFile[] uploadfile) throws IOException {
        System.out.println("upload");
        System.out.println(uploadfile);

        for(MultipartFile file : uploadfile){
            if(!file.isEmpty()){
                appService.createStream(con, file.getInputStream());
            }
        }

        return "upload";
    }


//ajax version

    @PostMapping("/multipartUpload.do")
    public String multipartUpload(MultipartHttpServletRequest request) throws Exception {

        List<MultipartFile> fileList = request.getFiles("file");

        for(MultipartFile file : fileList){
            if(!file.isEmpty()){
                appService.createStream(con, file.getInputStream());
                System.out.println("ajax upload 성공");
            }
        }
        return "upload";
    }


    @PostMapping("/down")
    public String downloadToXtorm() {
        System.out.println("down");
        appService.download(con);

        return "upload";
    }


    @PostMapping("/multipartDownload.do")
    public String multipartDownload(MultipartHttpServletRequest request) throws Exception {

        List<MultipartFile> fileList = request.getFiles("file");
        System.out.println("ajax 다운 url");

        for(MultipartFile file : fileList){
            if(!file.isEmpty()){
               appService.downloadStream(con, file.getOriginalFilename());

            }
        }
        return "upload";
    }

    @PostMapping("/delete")
    public String deleteToXtorm() {
        System.out.println("delete");
        appService.delete(con);

        return "upload";
    }

    @PostMapping("/multipartDelete.do")
    public String multipartDelete(MultipartHttpServletRequest request) throws Exception {

        List<MultipartFile> fileList = request.getFiles("file");
        System.out.println("ajax 삭제 url");

        for(MultipartFile file : fileList){
            if(!file.isEmpty()){
                appService.deleteStream(con, file.getOriginalFilename());

            }
        }
        return "upload";
    }

    @PostMapping("/replace")
    public String replaceToXtorm() {
        System.out.println("replace");
        appService.replace(con);

        return "upload";
    }

}
