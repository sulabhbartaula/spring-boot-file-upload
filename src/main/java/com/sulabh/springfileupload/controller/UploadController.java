package com.sulabh.springfileupload.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UploadController {

    Map<String, Object> result = new HashMap<>();

    @RequestMapping("/uploadFile")
    public Map<String,Object> upload(@RequestParam("attach")MultipartFile file) throws IOException{

        //information of file
        System.out.println("File name = "+file.getOriginalFilename());
        System.out.println("File type = "+file.getContentType());

        //saving to disk
        String filePath = "B:/";
        file.transferTo(new File(filePath + file.getOriginalFilename()));
        result.put("Success",true);
        return result;
    }
}
