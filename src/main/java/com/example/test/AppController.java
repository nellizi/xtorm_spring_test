package com.example.test;

import com.windfire.apis.asysConnectData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.*;

@Controller
public class AppController {

    @Autowired
    AppService appService;
    private asysConnectData con = null;
    public void setCon(asysConnectData con){
        this.con = con;
    }

//    @GetMapping("/xtorm")
//    public String upload() {
//        return "upload";
//    }

    //ajax version
    @GetMapping("/xtorm2")
    public String upload2() {
        return "upload2";
    }

    @PostMapping("/multipartUpload.do")
    @ResponseBody
    public  HashMap<String,String> multipartUpload(MultipartHttpServletRequest request,@RequestParam("file") MultipartFile[] files ) throws Exception {

        List<MultipartFile> fileList = request.getFiles("file");
        HashMap<String,String> map = new HashMap<String,String>();

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                String[] arr = file.getOriginalFilename().split("\\.");
                appService.multipartUpload(con, file.getInputStream(), arr[1]);
                map.put("msg","성공");
            } else {
                System.out.println("선택 파일 없음");
                map.put("msg","선택 파일 없음");
            }
        }
         return map;
    }


//    @PostMapping("/down")
//    public String downloadToXtorm() {
//        System.out.println("down");
//        appService.download(con);
//
//        return "upload";
//    }

    //ajax version
    @PostMapping("/multipartDownload.do")
    public String multipartDownload(MultipartHttpServletRequest request, Model model) throws Exception {

        List<MultipartFile> fileList = request.getFiles("file");
        for (MultipartFile file : fileList) {
            if (!file.isEmpty()) {
                appService.multipartDownload(con, file.getOriginalFilename());
            }
        }
//        model.addAttribute("msg", msg);
        return "upload2";
    }

//    @PostMapping("/delete")
//    public String deleteToXtorm() {
//        System.out.println("delete");
//        appService.delete(con);
//
//        return "upload";
//    }

    //ajax version
    @PostMapping("/multipartDelete.do")
    public String multipartDelete(MultipartHttpServletRequest request) throws Exception {

        List<MultipartFile> fileList = request.getFiles("file");
        System.out.println("ajax 삭제 url");

        for (MultipartFile file : fileList) {
            if (!file.isEmpty()) {
                appService.multipartDelete(con, file.getOriginalFilename());
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