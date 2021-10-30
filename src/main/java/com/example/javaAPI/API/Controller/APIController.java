package com.example.javaAPI.API.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class APIController {
	
	@GetMapping(value="/")
	public String index() {
		return "Home/index";
	}
	
	public String CallAPI(String pUrl, String accept, String pContentType, String authorization ) {
		System.out.println("-----------------------CallAPI");
		
		String inputLine = null;
		StringBuffer out = new StringBuffer();
		HttpURLConnection conn = null;
		
		try {
			URL url = new URL(pUrl);
			
			BufferedReader in;
			
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("accept", accept);
			conn.setRequestProperty("content-Type", pContentType);
			conn.setRequestMethod("GET");
	        conn.setRequestProperty("Authorization", authorization);
	        
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

    		while ((inputLine = in.readLine()) != null) {
    			out.append(inputLine);
            }
            
            conn.disconnect();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		return out.toString();
	}
}