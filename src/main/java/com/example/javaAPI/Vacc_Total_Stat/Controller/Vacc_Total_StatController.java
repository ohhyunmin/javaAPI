package com.example.javaAPI.Vacc_Total_Stat.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.javaAPI.Vacc_Total_Stat.Service.Vacc_Total_StatService;

@RestController
@RequestMapping("/vacc_Total_Stat")
public class Vacc_Total_StatController {
	
	
	@Autowired
	private Vacc_Total_StatService vacc_Total_StatService;
	
	@GetMapping(value="/list")
	public String vacc_Total_Stat_list_API(HttpServletRequest reqeust, HttpServletResponse response, Model model) throws Exception {
		System.out.println("-----------------------vacc_Total_Stat_list_API");
		
		String data = vacc_Total_StatService.Vacc_Total_Stat_list(reqeust, response, model);
        return data;
    }
}