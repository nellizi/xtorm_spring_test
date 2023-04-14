package com.example.test;

import com.windfire.apis.asysConnectData;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    //ajax version
    @GetMapping("/xtorm2")
    public String upload2() {
        return "upload2";
    }

//    @PostMapping("/upload")
//    public String uploadToXtorm(@RequestParam MultipartFile[] uploadfile) throws IOException {
//        System.out.println("upload");
//        System.out.println(uploadfile);
//
//        for(MultipartFile file : uploadfile){
//            if(!file.isEmpty()){
//                String extension = "";
//                appService.retrieve(con);
//            }
//        }
//        return "upload2";
//    }


    @PostMapping("/multipartUpload.do")
    public String multipartUpload(MultipartHttpServletRequest request, Model model) throws Exception {

        List<MultipartFile> fileList = request.getFiles("file");

        JSONObject resMap = new JSONObject();

        for(MultipartFile file : fileList){
            if(!file.isEmpty()){
                System.out.println("originalFilename = "+file.getOriginalFilename());
                String[] arr =  file.getOriginalFilename().split("\\.");

                appService.multipartUpload(con, file.getInputStream(),arr[1]);
//              model.addAttribute("msg",successMsg);
//              System.out.println("ajax upload 성공");
            }else{
                String failMsg = "선택 파일 없음";
                model.addAttribute("msg",failMsg);
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
    public String multipartDownload(MultipartHttpServletRequest request, Model model) throws Exception {

        List<MultipartFile> fileList = request.getFiles("file");
        for(MultipartFile file : fileList){
            if(!file.isEmpty()){
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

        for(MultipartFile file : fileList){
            if(!file.isEmpty()){
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
