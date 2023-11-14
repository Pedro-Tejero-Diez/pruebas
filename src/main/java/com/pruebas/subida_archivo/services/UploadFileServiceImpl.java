package com.pruebas.subida_archivo.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadFileServiceImpl implements IUploadFileService {


    @Override
    public String uploadFile(MultipartFile file) throws Exception {
        try {
            String fileName = UUID.randomUUID().toString();
            byte[] bytes = file.getBytes();
            String fileOriginalName = file.getOriginalFilename();

            long fileSize = file.getSize();
            long maxFileSize = 5 * 1024 * 1024;

            if (fileSize > maxFileSize) {
                return "Max File Size less than 5MB";
            }
            if (!fileOriginalName.endsWith(".jpg") && !fileOriginalName.endsWith(".png")) {
                return "only jpg and png files allowed";
            }
            String fileExtension = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
            String newFileName = fileName + fileExtension;

            File folder = new File("/src/main/resources/pictures/");
            if (!folder.exists()) {
                folder.mkdirs();
            }
            Path path = Paths.get("/src/main/resources/pictures/" + newFileName);
            Files.write(path, bytes);
            return "File Uploaded Succesfully";
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}