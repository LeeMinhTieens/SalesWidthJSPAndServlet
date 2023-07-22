package com.leminhtien.fillter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leminhtien.model.UserModel;
import com.leminhtien.utils.SessionUtil;

public class AuthorizationFilter implements Filter{
	
	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}
	

	@Override
	public void doFilter(ServletRequest ServletRequest, ServletResponse ServletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) ServletRequest;
		HttpServletResponse response = (HttpServletResponse) ServletResponse;
		
		String uri = request.getRequestURI();
		uri = uri.substring(request.getContextPath().length());
		if(uri.startsWith("/admin")) {
			UserModel user =(UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
			if(user != null) {
				if(user.getCode().equals("ADMIN")) {
					chain.doFilter(ServletRequest, ServletResponse);
				}else if(user.getCode().equals("USER")) {
					//xử lý khi USER cố tình vào web admin
					response.sendRedirect(request.getContextPath()+"/dang-ky?action=register");
				}
			}else {
				response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login");
			}
		}else {
			chain.doFilter(ServletRequest, ServletResponse);
		}
		
		
		
		
		
	}

}
