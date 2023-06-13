package com.gdxt.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * @Author WangXin
 * @Date 2023/6/13 15:52
 */
public class FileUtil {
    private String fileSavePath = "D:/task/upload/";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");

     public ArrayList uploadContract(MultipartFile[] uploadFiles, HttpServletRequest req) throws Exception{
         ArrayList<String> contractList=new ArrayList();
         String filePath = "";
        for(MultipartFile uploadFile:uploadFiles){
            String format = sdf.format(new Date());
            File folder = new File(fileSavePath + format);
            if (!folder.isDirectory()) {
                folder.mkdirs();
                String oldName = uploadFile.getOriginalFilename();
                String newName = UUID.randomUUID().toString() +
                        oldName.substring(oldName.lastIndexOf("."), oldName.length());
                try {
                    uploadFile.transferTo(new File(folder, newName));
                    filePath = req.getScheme() + "://" + req.getServerName() + ":" +
                            req.getServerPort() + "/uploadFile/" + format + newName;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String oldName = uploadFile.getOriginalFilename();
            String newName = UUID.randomUUID().toString() +
                    oldName.substring(oldName.lastIndexOf("."), oldName.length());
            try {
                uploadFile.transferTo(new File(folder, newName));
                filePath = req.getScheme() + "://" + req.getServerName() + ":" +
                        req.getServerPort() + "/uploadFile/" + format + newName;
            } catch (IOException e) {
                e.printStackTrace();
            }

            contractList.add(filePath);
        }
        return contractList;
    }
}
