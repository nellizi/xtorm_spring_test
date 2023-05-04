package com.example.test;

import com.windfire.apis.asysConnectData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.*;

@Controller
public class AppController {

    @Autowired
    AppService appService;
    private asysConnectData con = null;

    public void setCon(asysConnectData con){
        this.con = con;
    }

    @GetMapping("/xtorm")
    public String upload() {
        return "upload";
    }

    @GetMapping("/xtorm2")
    public String upload2() {
        return "upload2";
    }

    @PostMapping("/multipartUpload.do")
    @ResponseBody
    public HashMap<String,String> multipartUpload(@RequestParam(value="file")  List<MultipartFile> files) throws Exception {

        HashMap<String,String> map = new HashMap<String,String>();

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                System.out.println("AppController");
                String[] arr = file.getOriginalFilename().split("\\.");
                appService.multipartUpload(con, file.getInputStream(), arr[1]);
                map.put("msg","업로드 완료");
            } else {
                map.put("msg","선택 파일 없음");
            }
        }
         return map;
    }

    @PostMapping("/multipartDownload.do")
    @ResponseBody
    public HashMap<String,String> multipartDownload(@RequestParam("file") MultipartFile[] files) throws Exception {

        HashMap<String,String> map = new HashMap<String,String>();
        System.out.println("download in controller");

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                appService.multipartDownload(con, file.getOriginalFilename());
            }else {
                map.put("msg","선택 파일 없음");
            }
        }
        return map;
    }

    @PostMapping("/multipartDelete.do")
    @ResponseBody
    public HashMap<String,String> multipartDelete(@RequestParam("file") MultipartFile[] files) throws Exception {

        HashMap<String,String> map = new HashMap<String,String>();

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                appService.multipartDelete(con, file.getOriginalFilename());
            }else {
                map.put("msg","선택 파일 없음");
            }
        }
        return map;
    }

    @PostMapping("/replace")
    public String replaceToXtorm() {
        System.out.println("replace");
        appService.replace(con);

        return "upload";
    }
}