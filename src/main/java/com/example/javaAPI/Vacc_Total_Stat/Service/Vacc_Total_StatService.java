package com.example.javaAPI.Vacc_Total_Stat.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface Vacc_Total_StatService {
	String Vacc_Total_Stat_list(HttpServletRequest reqeust, HttpServletResponse responsem, Model model) throws Exception;
}
