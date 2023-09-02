package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.user.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class UploadController {
	
	private final FileService fileService;

    @Autowired
    public UploadController(FileService fileService) {
        this.fileService = fileService;
    }
	
	@GetMapping("/upload")
	public String getUpload() {
		return "user/upload";
	}
	
//	@PostMapping("/file_upload")
//	  public String upload(@RequestParam MultipartFile file) throws IOException {
//	    Path dst = Path.of("/Users/yamaguchisoichiro/Desktop/spring_pr/Original/src/main/resources/static/upload", file.getOriginalFilename());
//	    Files.copy(file.getInputStream(), dst);
//	    return "user/result";
//	  }
	
	@PostMapping("/file_upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        fileService.uploadFile(file);
        return "user/result";
    }

}
