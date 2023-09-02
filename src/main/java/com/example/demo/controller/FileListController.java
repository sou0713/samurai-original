package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.FileEntity;
import com.example.demo.user.service.FileService;

@Controller
@RequestMapping("user")
public class FileListController {
	
	private final FileService fileService;

    @Autowired
    public FileListController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/list")
    public String getAllFiles(Model model) {
        List<FileEntity> files = fileService.getAllFiles();
        model.addAttribute("files", files);
        return "user/fileList"; // ファイル情報を表示するビュー名
    }

}
