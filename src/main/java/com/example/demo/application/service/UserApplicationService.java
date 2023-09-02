package com.example.demo.application.service;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {
	
	public Map<String,Integer> getGenderMap(Locale locale){
		Map<String,Integer> genderMap = new LinkedHashMap<>();
		genderMap.put("男性", 1);
		genderMap.put("女性", 2);
		return genderMap;
	}

}
