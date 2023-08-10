package com.leminhtien.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leminhtien.model.UserModel;
import com.leminhtien.service.IUserService;
import com.leminhtien.utils.LoginGoogleUtil;
import com.leminhtien.utils.SessionUtil;

@WebServlet(urlPatterns = { "/login-google" })
public class LoginGoogle extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Inject
	private IUserService userService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		if (code == null || code.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
			
		} else {
			String accessToken = LoginGoogleUtil.getToken(code);
			UserModel userResponse = LoginGoogleUtil.getUserInfo(accessToken);
			UserModel user = userService.fineBySocialId(userResponse.getSocial_id());
			if(user != null) {
				System.out.println("login");
				SessionUtil.getInstance().putValue(request, "USERMODEL", user);
				if(user.getCode().equals("ADMIN")) {
					response.sendRedirect(request.getContextPath() + "/admin-home");
				}else if(user.getCode().equals("USER")) {
					response.sendRedirect(request.getContextPath()+ "/trang-chu");
				}
			}else {
				System.out.println("register");
				System.out.println(userResponse.toString());
				UserModel userModel = userService.save(userResponse);
				SessionUtil.getInstance().putValue(request, "USERMODEL", userModel);
				if(userModel.getCode().equals("ADMIN")) {
					response.sendRedirect(request.getContextPath() + "/admin-home");
				}else if(userModel.getCode().equals("USER")) {
					response.sendRedirect(request.getContextPath()+ "/trang-chu");
				}
			}

		}

	}

}