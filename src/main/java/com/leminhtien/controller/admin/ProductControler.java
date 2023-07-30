package com.leminhtien.controller.admin;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.leminhtien.model.ProductModel;
import com.leminhtien.model.SizeModel;
import com.leminhtien.model.TypeModel;
import com.leminhtien.model.UserModel;
import com.leminhtien.paging.Paging;
import com.leminhtien.paging.Sort;
import com.leminhtien.service.IProductService;
import com.leminhtien.service.ISizeService;
import com.leminhtien.service.ITypeService;
import com.leminhtien.utils.HttpUtil;
import com.leminhtien.utils.SessionUtil;
@WebServlet(urlPatterns = { "/admin/product" })
public class ProductControler extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	@Inject
	private IProductService productService;
	
	@Inject
	private ITypeService typeService;
	
	@Inject
	private ISizeService sizeService;
	
	ResourceBundle myAlert = ResourceBundle.getBundle("myAlert");
	ResourceBundle productAlert = ResourceBundle.getBundle("newproduct");

	/**
	 * thao tác với database 
	 * thêm là Post 
	 * cập nhật là Put 
	 * lấy lên là Get xóa là
	 * Delete
	 */

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		if (type.equals("list")) {
			Paging pagable = null;
			String sortName = request.getParameter("sortName");
			String sortBy = request.getParameter("sortBy");
			if(sortName != null && !sortName.equals("") &&sortBy != null && !sortBy.equals("")) {
				Sort sort = new Sort(sortName,sortBy);
				pagable = new Paging(sort);
			}else {
				pagable = new Paging();
			}
			String page = request.getParameter("page");
			if(page!= null) {
				pagable.setPage(Integer.parseInt(page));
			}
			pagable.setTotalItem(productService.countItem());
			String limit = request.getParameter("limit");
			if(limit!= null && !limit.equals("")) {
				pagable.setLimit(Integer.parseInt(limit));
			}
			List<ProductModel> productModel = productService.fineAll(pagable);
			request.setAttribute("Page",pagable);
			request.setAttribute("PRODUCT", productModel);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/list/product.jsp");
			rd.forward(request, response);
		} else if (type.equals("edit")) {
			List<SizeModel> listSize = sizeService.fineAll();
			List<TypeModel> listType = typeService.fineAll();
			request.setAttribute("SIZE", listSize);
			request.setAttribute("TYPE", listType);
			Integer id = Integer.parseInt(request.getParameter("id"));
			ProductModel product = productService.fineById(id);
			request.setAttribute("PRODUCT", product);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/list/newproduct.jsp");
			rd.forward(request, response);
			
		}else if(type.equals("add")) {
			List<SizeModel> listSize = sizeService.fineAll();
			List<TypeModel> listType = typeService.fineAll();
			request.setAttribute("SIZE", listSize);
			request.setAttribute("TYPE", listType);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/list/newproduct.jsp");
			rd.forward(request, response);
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ProductModel product = HttpUtil.readReson(request.getReader()).toModel(ProductModel.class);
		UserModel user = (UserModel)SessionUtil.getInstance().getValue(request, "USERMODEL");
		product.setCreateBy(user.getName());
		System.out.println(product.toString());
		String alert="";
		String message="";
		JSONObject jsonrespone = new JSONObject();
		try {
			Integer id = productService.save(product);
			if(id!=null) {
				 alert = myAlert.getString("success");
				 message = productAlert.getString("successAdd");
			}else {
				 alert = myAlert.getString("danger");
				 message = productAlert.getString("ErrorAdd");
			}
			
		} catch (Exception e) {
			 alert = myAlert.getString("danger");
			 message = productAlert.getString("ErrorAdd");
		}	
		jsonrespone.put("message", message);
		jsonrespone.put("alert", alert);
		response.getWriter().print(jsonrespone.toString());
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ProductModel product = HttpUtil.readReson(request.getReader()).toModel(ProductModel.class);
		UserModel user = (UserModel)SessionUtil.getInstance().getValue(request, "USERMODEL");
		product.setModifyBy(user.getName());
		System.out.println(product.toString());
		String alert="";
		String message="";
		JSONObject jsonrespone = new JSONObject();
		try {
			Integer id = productService.update(product);
			if(id!=null) {
				 alert = myAlert.getString("success");
				 message = productAlert.getString("seccessEdit");
			}else {
				 alert = myAlert.getString("danger");
				 message = productAlert.getString("ErrorEdit");
			}
			
		} catch (Exception e) {
			 alert = myAlert.getString("danger");
			 message = productAlert.getString("ErrorEdit");
		}	
		jsonrespone.put("message", message);
		jsonrespone.put("alert", alert);
		response.getWriter().print(jsonrespone.toString());
		
	}
	
	
}
