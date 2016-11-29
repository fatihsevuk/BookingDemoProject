package com.fatih;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	
	//@Value("${app-mode}")
	private String appMode;
	
	//app- modu constructor parametresi olarak autowire d yapabilirzi
	@Autowired
	public ViewController(Environment environment) {
		appMode=environment.getProperty("app-mode");
	}
	
	
	@RequestMapping("/")
	public String index(Model model ){
		
		
		
		model.addAttribute("datetime" ,new Date());
		model.addAttribute("username","fatih");
		model.addAttribute("mode",appMode);
		
		return "index";
		
		
	}
	
	
	
}
