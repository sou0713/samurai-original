package com.example.demo.model;

import lombok.Data;

@Data
public class FileEntity {
	
	private Long id;
    private String fileName;
    private String fileType;
    private byte[] data;

}
