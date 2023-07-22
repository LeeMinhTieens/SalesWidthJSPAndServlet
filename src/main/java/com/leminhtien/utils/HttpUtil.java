package com.leminhtien.utils;

import java.io.BufferedReader;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	private String value;
	
	public HttpUtil(String value) {
		this.value = value;
	}
	
	public <T> T toModel(Class<T> clas) {
		try {
			return new ObjectMapper().readValue(value,clas);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static HttpUtil readReson(BufferedReader br) {
		StringBuilder sb = new StringBuilder();
		try {
			String line;
			while((line=br.readLine())!=null) {
				sb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new HttpUtil(sb.toString());
	}

}
