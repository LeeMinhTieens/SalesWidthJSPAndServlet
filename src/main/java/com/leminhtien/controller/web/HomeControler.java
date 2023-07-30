package com.leminhtien.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.leminhtien.model.UserModel;
import com.leminhtien.service.IUserService;
import com.leminhtien.utils.HttpUtil;
import com.leminhtien.utils.SessionUtil;

@WebServlet(urlPatterns = {"/trang-chu","/dang-nhap","/thoat"})
public class HomeControler extends HttpServlet{
	ResourceBundle myAlert = ResourceBundle.getBundle("myAlert");
	ResourceBundle registerAlert = ResourceBundle.getBundle("register");

	private static final long serialVersionUID = 1L;
	@Inject
	IUserService userService;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		respone.setContentType("application/json");		
		respone.setContentType("application/json");
		respone.setCharacterEncoding("UTF-8");
		String action=request.getParameter("action");
		if(action != null) {
			if(action.equals("login")) {
				RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
				rd.forward(request, respone);
			}else if(action.equals("register")) {
				RequestDispatcher rd = request.getRequestDispatcher("/views/register.jsp");
				rd.forward(request, respone);
			}else if(action.equals("logout")) {
				SessionUtil.getInstance().removeValue(request, "USERMODEL");
				respone.sendRedirect(request.getContextPath()+"/dang-nhap?action=login");
			}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, respone);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");		
		response.setCharacterEncoding("UTF-8");
		String action=request.getParameter("action");
		 if(action!=null && action.equals("loging")) {	
				UserModel user = HttpUtil.readReson(request.getReader()).toModel(UserModel.class);
				user = userService.fineByUserNameAndPassWord(user.getName(), user.getPassword());
				if(user!=null) {
					SessionUtil.getInstance().putValue(request, "USERMODEL", user);
					JSONObject jsonResponse = new JSONObject();
					if(user.getCode().equals("ADMIN")) {
						jsonResponse.put("urlResponse", request.getContextPath()+"/admin-home");
					}else if(user.getCode().equals("USER")){
						jsonResponse.put("urlResponse", request.getContextPath()+"/trang-chu");
					}
					PrintWriter out = response.getWriter();
					out.print(jsonResponse.toString());
				}else {
					JSONObject jsonResponse = new JSONObject();
					String alert = myAlert.getString("danger");
					String message = registerAlert.getString("loginError");
					jsonResponse.put("alert",alert);
					jsonResponse.put("message",message);
					PrintWriter out = response.getWriter();
					out.print(jsonResponse.toString());
				}
			
			}
		

	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
		
		super.doDelete(request, respone);
	}

}
