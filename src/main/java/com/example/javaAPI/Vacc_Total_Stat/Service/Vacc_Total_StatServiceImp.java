package com.example.javaAPI.Vacc_Total_Stat.Service;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.javaAPI.API.Controller.APIController;

@Service
public class Vacc_Total_StatServiceImp implements Vacc_Total_StatService{

private APIController API;
	
	@Autowired
	public void setAPI(APIController api) {
		this.API = api;
	}
	
	@Override
	public String Vacc_Total_Stat_list(HttpServletRequest reqeust, HttpServletResponse responsem, Model model)
			throws Exception {
		SimpleDateFormat condFormat = new SimpleDateFormat ( "2021-10-28 00:00:00");
		Calendar time = Calendar.getInstance();
		
		String baseData = URLEncoder.encode("cond[baseDate::EQ]", "UTF-8") + "=" + URLEncoder.encode(condFormat.format(time.getTime()), "UTF-8").replace("+", "%20");
		
		String url = "https://api.odcloud.kr/api/15077756/v1/vaccine-stat?namespace=15077756/v1vaccine-stat?"
				+ "page=1"
				+"&perPage=18"
				+"&" + baseData
				+"&serviceKey=NHbnXqF6KKTp609Q27Ie3PD2T1KOL%2BDZMO1GoAYbZkdrMwRD0TMFdZq3WJctLlRuZZh8faZXqrlYDPG8os%2Biug%3D%3D";
		
		String accept = "application/json";
		String contentType = "application/json";
		String authorization = "NHbnXqF6KKTp609Q27Ie3PD2T1KOL+DZMO1GoAYbZkdrMwRD0TMFdZq3WJctLlRuZZh8faZXqrlYDPG8os+iug==";
		String data = API.CallAPI(url, accept, contentType, authorization);
		System.out.println(data);
		return data;
	}
}
