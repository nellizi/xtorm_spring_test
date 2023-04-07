package com.example.test;

import com.windfire.apis.asysConnectData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        System.out.println("upload");

        return "upload";
    }


    @PostMapping("/upload")
    public String uploadToXtorm(@RequestParam MultipartFile[] uploadfile) throws IOException {
        System.out.println("upload");
        System.out.println(uploadfile);

        List<FileEntity> list = new ArrayList<>();
        for(MultipartFile file : uploadfile){
            if(!file.isEmpty()){

                System.out.println(file.getOriginalFilename());
              //appService.create(con, file.getOriginalFilename());
                appService.createStream(con, file.getInputStream());            }
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
