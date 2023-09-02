package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.FileEntity;

@Mapper
public interface FileMapper {
	
	@Insert("INSERT INTO files (file_name, file_type, data) VALUES (#{fileName}, #{fileType}, #{data})")
    void insertFile(FileEntity fileEntity);

	List<FileEntity> getAllFiles();

	

}
