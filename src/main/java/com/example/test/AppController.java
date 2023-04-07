package com.example.test;

import com.windfire.apis.asysConnectData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class AppController {

    AppService appService = new AppService();
    private asysConnectData con = null;

    public AppController() {
        con = new asysConnectData("127.0.0.1", 2102, "desc", "SUPER", "SUPER");
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
            }
        }
        return "upload";
    }


    @PostMapping("/down")
    public String downloadToXtorm() {
        System.out.println("upload");
        appService.download(con);

        return "upload";
    }

    @PostMapping("/delete")
    public String deleteToXtorm() {
        System.out.println("upload");
        appService.delete(con);

        return "upload";
    }

    @PostMapping("/replace")
    public String replaceToXtorm() {
        System.out.println("upload");
        appService.replace(con);

        return "upload";
    }

}
