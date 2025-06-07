package com.bookapi.bootrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bookapi.bootrest.helper.FileUploadHelper;

@RestController
public class FileUploadController {

    @Autowired
        private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        
        try {
            
      
        System.out.println(file.getOriginalFilename());
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain file");
        }
        if(!file.getContentType().equals("image/jpeg")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain jpeg file");
        }
        boolean f=fileUploadHelper.uploadFile(file);
        if(f){
            return ResponseEntity.ok("file uploaded successfully");
        }


    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
    }
}
