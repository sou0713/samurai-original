package com.example.demo.user.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.FileEntity;
import com.example.demo.repository.FileMapper;

@Service
public class FileService {
	
	private final FileMapper fileMapper;

    @Autowired
    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public void uploadFile(MultipartFile file) throws IOException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(file.getOriginalFilename());
        fileEntity.setFileType(file.getContentType());
        fileEntity.setData(file.getBytes());

        fileMapper.insertFile(fileEntity);
    }
    
    public List<FileEntity> getAllFiles() {
        return fileMapper.getAllFiles();
    }

}
