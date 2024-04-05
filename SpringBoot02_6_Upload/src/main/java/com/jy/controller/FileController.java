package com.jy.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("file")
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @Value("${file.upload.dir}")
    private String realPath ;

    @RequestMapping("upload1")
    public String uploadJar(MultipartFile file, HttpServletRequest request) throws IOException {
        String originalFilename = file.getOriginalFilename();
        log.info("文件:{},{},{}", file.getOriginalFilename(), file.getSize(), file.getContentType());


        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ext;

        file.transferTo(new File(realPath, newFileName));

        return "redirect:/upload.jsp";
    }

    @RequestMapping("upload")
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
        String originalFilename = file.getOriginalFilename();
        log.info("文件:{},{},{}", file.getOriginalFilename(), file.getSize(), file.getContentType());
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        log.info("绝对路径:{}", realPath);

        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ext;

        file.transferTo(new File(realPath, newFileName));


        return "redirect:/upload.jsp";
    }
}
