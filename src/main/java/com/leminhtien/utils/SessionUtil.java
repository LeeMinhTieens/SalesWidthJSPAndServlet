package com.leminhtien.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
	public static SessionUtil sessionUtil = null;
	
	public static SessionUtil getInstance() {
		if((sessionUtil != null)) {
			return sessionUtil;
		}else {
			return new SessionUtil();
		}
	}
	
	public void putValue(HttpServletRequest request, String key, Object value) {
		request.getSession().setAttribute(key, value);
	}
	
	public Object getValue(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);
	}
	
	public void removeValue(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);
	}
	

}
