
package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class CreateController {
	
	@Autowired
    protected ResourceLoader resourceLoader;
	
	
    public String viewInput(Model model) {
        
		PathMatchingResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
		try {
			Resource[] resource = resourceResolver.getResources("file:/Users/yamaguchisoichiro/Desktop/spring_pr/Original/src/main/resources/static/upload/*");
			List<String> nameList = new ArrayList<String>();
			for(int i = 0; i < resource.length; i++) {
				System.out.println(resource[i]);
				String name = resource[i].getFilename();
				System.out.println("name: " + name);

				File file = resource[i].getFile();
				System.out.println("file.exists(): " + file.exists());
				System.out.println("file.getAbsolutePath(): " + file.getAbsolutePath());
				
				nameList.add(new File("/upload/"+ name.toString()).toString());
			}
			model.addAttribute("nameList",nameList);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	
        
        return "user/create";
	}
}