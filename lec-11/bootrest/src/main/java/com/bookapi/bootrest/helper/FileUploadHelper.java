package com.bookapi.bootrest.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    public final String Upload_DIR="C:\\Users\\Pankaj Tile\\OneDrive\\Desktop\\java springboot\\lec-11\\bootrest\\src\\main\\resources\\static\\img";
    public boolean uploadFile(MultipartFile multipartFile){
        boolean f=false;
        try {

            //first method
            // InputStream is=multipartFile.getInputStream();
            // byte data[]=new byte[is.available()];
            // is.read(data);
            // FileOutputStream fos=new FileOutputStream(Upload_DIR+File.separator+Upload_DIR);
            // fos.write(data);
            // fos.flush();
            // fos.close();

            //second method
            Files.copy(multipartFile.getInputStream(),Paths.get(Upload_DIR+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
            f=true;
            
        } catch (Exception e) {
           
            // TODO: handle exception
            e.printStackTrace();
        }
        return f;
    }
}
