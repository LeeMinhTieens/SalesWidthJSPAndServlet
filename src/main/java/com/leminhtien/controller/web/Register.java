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

@WebServlet(urlPatterns = {"/dang-ky"})
public class Register extends HttpServlet{
	ResourceBundle myAlert = ResourceBundle.getBundle("myAlert");
	ResourceBundle registerAlert = ResourceBundle.getBundle("register");

	private static final long serialVersionUID = 1L;
	@Inject
	IUserService userService;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action != null) {
			if(action.equals("register")) {
				RequestDispatcher rd = request.getRequestDispatcher("/views/register.jsp");
				rd.forward(request, respone);
			}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, respone);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if(action!= null && action.equals("register")) {
			String alert = "";
			String message = "";
			UserModel user = HttpUtil.readReson(request.getReader()).toModel(UserModel.class);
			user = userService.save(user);
			if(user!= null) {
				alert = myAlert.getString("success");
				message=registerAlert.getString("registerSuccess");
			}else {
				alert = myAlert.getString("danger");
				message=registerAlert.getString("registerErorr");
			}
			
			JSONObject jsonResponse = new JSONObject();
			jsonResponse.put("message",message);
			jsonResponse.put("alert",alert);
			PrintWriter out = response.getWriter();
			out.print(jsonResponse.toString());
		}
	
	
	}
	

}
