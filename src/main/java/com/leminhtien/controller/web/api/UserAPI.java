package com.leminhtien.controller.web.api;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leminhtien.model.UserModel;
import com.leminhtien.service.IUserService;
import com.leminhtien.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api/admin/user"})
public class UserAPI extends HttpServlet{

	private static final long serialVersionUID = 1L;
//	MyConnection connectionPoll = new MyConnection();
	
	@Inject
	private IUserService userService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/register.jsp");
		rd.forward(request, respone);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		respone.setContentType("application/json");		
		UserModel userModel = HttpUtil.readReson(request.getReader()).toModel(UserModel.class);
		UserModel user = userService.save(userModel);
		mapper.writeValue(respone.getOutputStream(), user);
		
	
	}

}
