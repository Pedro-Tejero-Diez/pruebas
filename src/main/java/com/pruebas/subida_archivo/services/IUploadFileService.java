package com.pruebas.subida_archivo.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface IUploadFileService {
    String uploadFile (MultipartFile file) throws Exception;

}