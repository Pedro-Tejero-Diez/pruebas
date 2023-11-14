package com.pruebas.subida_archivo.controllers;

import com.pruebas.subida_archivo.services.IUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    IUploadFileService uploadfileservice;

    @PostMapping("/picture")
    private ResponseEntity<String> uploadPicture (@RequestParam MultipartFile file) throws Exception {
           return new ResponseEntity<>(uploadfileservice.uploadFile(file), HttpStatus.OK);

    }
}
