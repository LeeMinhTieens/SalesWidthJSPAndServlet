package com.leminhtien.utils;

import java.io.IOException;

import org.apache.catalina.connector.ClientAbortException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.json.JSONObject;

import com.leminhtien.controller.admin.constrants.LoginGoogleConstrants;
import com.leminhtien.model.UserModel;

//import java.io.IOException;
//
//import javax.security.auth.message.callback.PrivateKeyCallback.Request;
//
//import org.apache.http.client.ClientProtocolException;
//import com.leminhtien.controller.admin.constrants.LoginGoogleConstrants;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.net.URI;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.nio.charset.StandardCharsets;
//
//import javax.net.ssl.HttpsURLConnection;
//
//import org.apache.catalina.connector.ClientAbortException;
//import org.json.JSONObject;
//
//import com.leminhtien.controller.admin.constrants.LoginGoogleConstrants;
//import com.leminhtien.model.UserModel;

public class LoginGoogleUtil {

	/**
	 * method send request to google and process then return token(not library)
	 * 
	 * @param code
	 * @return
	 * @throws ClientAbortException
	 * @throws IOException
	 */
//	public static String getToken(final String code) throws ClientAbortException, IOException {
//		// cần encode để mã hóa đúng đường dẫn, tránh gây ra lỗi sai đường dẫn
//		// client_id định danh ứng dụng đăng ký trên google
//		String urlParameter = "client_id=" + URLEncoder.encode(LoginGoogleConstrants.GOOGLE_CLIENT_ID, "UTF-8")
//		// khóa bí mật của ứng dụng
//				+ "&client_secret=" + URLEncoder.encode(LoginGoogleConstrants.GOOGLE_CLIENT_SECRERT, "UTF-8")
//				// client_redirect URI mà google sẽ chuyển hướng quay lại khi xác thực thành
//				// công(nơi gửi respone)
//				+ "&redirect_uri=" + URLEncoder.encode(LoginGoogleConstrants.GOOGLE_SEND_REDIRACT, "UTF-8")
//				// code : mã xác thực google trả về từ Google OAuth2
//				+ "&code=" + URLEncoder.encode(code, "UTF-8")
//				// loại phương thức cấp quyền được yêu cầu, lấy token là authorization_code
//				+ "&grant_type=" + URLEncoder.encode(LoginGoogleConstrants.GOOGLE_GRANT_TYPE, "UTF-8");
//		;
//
//		// chuyển đổi chuỗi tham số thành mảng byte
//		byte[] postData = urlParameter.getBytes(StandardCharsets.UTF_8);
//
//		// tạo url đại diện cho đường dẫn
//
//		URL url = new URL(LoginGoogleConstrants.GOOGLE_LINK_GET_TOKEN);
//		// tạo kết nối
//		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
//		// cho phép ghi dữ liệu vào yêu cầu
//		con.setDoOutput(true);
//		// set method handle
//		con.setRequestMethod("POST");
//		// set content-type,length
//		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//		con.setRequestProperty("Content-Length", Integer.toString(postData.length));
//
//		// ghi dữ liệu vào yêu cầu(sử dụng try-with-resource để giải phóng dữ liệu khi
//		// kết thúc)
//		try (OutputStream out = con.getOutputStream()) {
//			out.write(postData);
//		}
//
//		// đọc phải hổi của yêu cầu
//		String response = null;
//		try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
//			String line;
//			StringBuffer content = new StringBuffer();
//			while ((line = in.readLine()) != null) {
//				content.append(line);
//			}
//			response = content.toString();
//		}
//
//		JSONObject object = new JSONObject(response);
//		String accesToken = object.getString("access_token");
//
//		return accesToken;
//	}
//
//	public static UserModel getUserInfor(final String accsessToken) throws IOException, InterruptedException {
//		// đường dẫn gửi yêu cầu
//		String link = LoginGoogleConstrants.GOOGLE_LINK_GET_USER_INFO + accsessToken;
//		// tạo đôi tượng client
//		HttpClient client = HttpClient.newHttpClient();
//		HttpRequest request = HttpRequest.newBuilder()// tạo ra đối tượng requestBuilder để xây dựng request
//				.uri(URI.create(link))// thiết lập uri cho yêu cầu
//				.build();// trả về đối tượng httpRequest
//		// gửi phản hồi và trả về dưới dạng chuỗi
//		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//		// lấy response trả về nằm ở phần thân phản hồi
//		String responseBody = response.body();
//
//		JSONObject object = new JSONObject(responseBody);
//		UserModel user = new UserModel();
//		user.setSocial_id(object.getString("id"));
//		user.setEmail(object.getString("emial"));
//		user.setName(object.getString("name"));
//		return user;
//
//	}
//	
//	
//	

	public static String getToken(final String code) throws ClientProtocolException, IOException {

//		Request request = Request.Post(LoginGoogleConstrants.GOOGLE_LINK_GET_TOKEN);	
//		Form form = Form.form();//tạo ra một form
//		//thêm các name và value vào form
//		form.add("client_id",LoginGoogleConstrants.GOOGLE_CLIENT_ID)//thêm các thuộc tính vào form bao gồm name và value
//		.add("client_secret",LoginGoogleConstrants.GOOGLE_CLIENT_ID)
//		.add("redirect_uri",LoginGoogleConstrants.GOOGLE_SEND_REDIRACT)
//		.add("grant_type",LoginGoogleConstrants.GOOGLE_GRANT_TYPE);		
//		request.bodyForm(form.build());//thêm form vào body request		
//		Response respone = request.execute();//gửi request và nhận lại respone		
//		Content content = respone.returnContent();//lấy ra nội dung response
//		String response = content.asString();//chuyển nội dung thành chuỗi

		String response = Request.Post(LoginGoogleConstrants.GOOGLE_LINK_GET_TOKEN).bodyForm(Form.form()// thiết lập nội
																										// dung yêu cầu
																										// là một biểu
																										// mẫu
				.add("client_id", LoginGoogleConstrants.GOOGLE_CLIENT_ID)// thêm các thuộc tính vào form bao gồm name và
																			// value
				.add("client_secret", LoginGoogleConstrants.GOOGLE_CLIENT_SECRERT)
				.add("redirect_uri", LoginGoogleConstrants.GOOGLE_SEND_REDIRACT).add("code", code)
				.add("grant_type", LoginGoogleConstrants.GOOGLE_GRANT_TYPE).build())// xây dựng form và trả về một
																					// UrlEncodedFormEntity chứa các
																					// tham số
				.execute()// gửi yêu cầu đến máy chủ và trả về một đối tượng respone
				.returnContent()// lấy nội dung của phản hồi dưới dạng một Content
				.asString();// chuyển đổi Content sang String

		JSONObject jsonResponse = new JSONObject(response);
		String accessToken = jsonResponse.getString("access_token");
		return accessToken;
	}

	public static UserModel getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
		String link = LoginGoogleConstrants.GOOGLE_LINK_GET_USER_INFO + accessToken;
		String response = Request.Get(link).execute().returnContent().asString();
		JSONObject jsonRespone = new JSONObject(response);
		UserModel user = new UserModel();
		user.setSocial_id(jsonRespone.getString("id"));
		user.setName(jsonRespone.getString("given_name"));
		user.setEmail(jsonRespone.getString("email"));
		user.setFullname(jsonRespone.getString("name"));
		return user;
	}

}