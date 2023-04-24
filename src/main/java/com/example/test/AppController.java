package com.example.test;

import com.windfire.apis.asysConnectData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

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

    //ajax version
    @GetMapping("/xtorm2")
    public String upload2() {
        return "upload2";
    }

    @PostMapping("/multipartUpload.do")
    public String postMultipartUpload(MultipartHttpServletRequest request) throws Exception {

        List<MultipartFile> fileList = request.getFiles("file");
//        HashMap<String,String> msg = new HashMap<String,String>();
        ModelAndView modelAndView = new ModelAndView();

        for (MultipartFile file : fileList) {
            if (!file.isEmpty()) {
                String[] arr = file.getOriginalFilename().split("\\.");
                appService.multipartUpload(con, file.getInputStream(), arr[1]);
               // modelAndView.add
            } else {
                String failMsg = "선택 파일 없음";
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

    //ajax version
    @PostMapping("/multipartDownload.do")
    public String postMultipartDownload(MultipartHttpServletRequest request, Model model) throws Exception {

        List<MultipartFile> fileList = request.getFiles("file");
        for (MultipartFile file : fileList) {
            if (!file.isEmpty()) {
                appService.multipartDownload(con, file.getOriginalFilename());
            }
        }
//        model.addAttribute("msg", msg);
        return "upload2";
    }

    @PostMapping("/delete")
    public String deleteToXtorm() {
        System.out.println("delete");
        appService.delete(con);

        return "upload";
    }

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