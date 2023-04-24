package com.example.test;

import com.windfire.apis.asysConnectData;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Controller
@Aspect
public class AppController {

    @Autowired
    AppService appService = new AppService();
    private asysConnectData con = null;

    public void setCon(asysConnectData con){
        System.out.println("setCon: "+con);
        this.con = con;
        System.out.println("setCon_this.con: "+this.con);
    }

//    public AppController() {
//        _PropertiesConfig prop = null;
//        try {
//            prop = new _PropertiesConfig();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        this.con = new asysConnectData(prop.hostname, prop.port, prop.desc, prop.username, prop.password);
//    }

    @GetMapping("/xtorm")
    public String upload() {
        return "upload";
    }

    //ajax version
    @GetMapping("/xtorm2")
    public String upload2() {
        return "upload2";
    }

    // @Before("")
//    public void createConnection() {
//        System.out.println("before work");
//
//        _PropertiesConfig prop = null;
//        try {
//            prop = new _PropertiesConfig();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        this.con = new asysConnectData(prop.hostname, prop.port, prop.desc, prop.username, prop.password);
//    }

    // @After("")
//    public void disconnect(asysConnectData con) {
//        System.out.println("after work");
//
//        if (con != null) {
//            con.close();
//            this.con = null;
//        }
//    }

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


    //MultipartFile test code

//    @PostMapping("/uploadtest")
//    public String saveFile(HttpServletRequest request) throws Exception {
//
//        if (productDomain == null) {
//            throw new Exception("전달받은 폼 데이터가 없음");
//        }
//
//        log.info("mutipartList = {}", productDomain.getItemImgList());
//
//        for (MultipartFile file : productDomain.getItemImgList()) {
//            log.info("file name = {}", file.getOriginalFilename());
//        }
//        return "upload-form";
//    }

    @PostMapping("/multipartUpload.do")
    public String multipartUpload(MultipartHttpServletRequest request) throws Exception {
        System.out.println("con in upload: "+ con);
//        createConnection();

        List<MultipartFile> fileList = request.getFiles("file");
//        HashMap<String,String> msg = new HashMap<String,String>();
        ModelAndView modelAndView = new ModelAndView();

        for (MultipartFile file : fileList) {
            if (!file.isEmpty()) {
//                System.out.println("originalFilename = "+file.getOriginalFilename());
                String[] arr = file.getOriginalFilename().split("\\.");
                appService.multipartUpload(con, file.getInputStream(), arr[1]);
                // con = appService.discon(con);
               // modelAndView.add
            } else {
                String failMsg = "선택 파일 없음";
            }
        }
//        disconnect(con);
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