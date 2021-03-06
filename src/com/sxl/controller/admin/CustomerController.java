
package com.sxl.controller.admin;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;
import com.sxl.util.CheckLogin;

@Controller("customerController")
@RequestMapping(value = "/customer")
public class CustomerController extends MyController {
	

	@RequestMapping(value = "/index")
	public String frame(Model model, HttpServletRequest request)throws Exception {
		
//		//消息
//		List<Map> messageList = db.queryForList("select * from t_message where status='未读' and toId="+getCustomer(request).get("id"));
//		request.setAttribute("messageList", messageList);
//		request.setAttribute("messageSize", messageList.size());
//		//通知
//		List<Map> tongzhiList = db.queryForList("select * from t_tongzhi where status='未读' and customerId="+getCustomer(request).get("id"));
//		request.setAttribute("tongzhiList", tongzhiList);
//		request.setAttribute("tongzhiSize", tongzhiList.size());
//		
		
		return "/customer/index";
	}
	
	@RequestMapping(value = "/main")
	public String main(Model model, HttpServletRequest request)throws Exception {
		return "/customer/main";
	}
	
	
	@RequestMapping(value = "/password")
	public String password(Model model, HttpServletRequest request)throws Exception {
		return "/customer/password";
	}
	
	
	@RequestMapping(value = "/changePassword")
	public ResponseEntity<String> loginSave(Model model,HttpServletRequest request,String oldPassword,String newPassword) throws Exception {
		Map customer = getCustomer(request);
		if(oldPassword.equals(customer.get("password").toString())){
			String sql="update t_customer set password=? where id=?";
			db.update(sql, new Object[]{newPassword,customer.get("id")});
			return renderData(true,"1",null);
		}else{
			return renderData(false,"1",null);
		}
	}
	@RequestMapping(value = "/mine")
	public String mine(Model model, HttpServletRequest request)throws Exception {
Map customer =getCustomer(request);Map map = db.queryForMap("select * from t_customer where id=?",new Object[]{customer.get("id")});model.addAttribute("map", map);		return "/customer/mine";
	}
	
	
	class Authentication extends Authenticator{  
	      String username=null;  
	      String password=null;  

	      public Authentication(){  
	      }  
	      public Authentication(String username, String password) {  
	      this.username = username;  
	      this.password = password;  
	      }  
	      protected PasswordAuthentication getPasswordAuthentication(){
	      PasswordAuthentication pa = new PasswordAuthentication(username, password);
	      return pa;
	      }  
	    }
	@RequestMapping(value = "/mineSave")
	public ResponseEntity<String> mineSave(Model model,HttpServletRequest request,Long id
		,String username,String password,String customerName,String sex,String age,String phone,String headPic,String sfz,String address,String v1,String v2) throws Exception{
		String host="smtp.126.com";
		String pop3="pop.126.com";
		System.out.println("v1===="+v1);
		System.out.println("v2===="+v2);
		boolean out = CheckLogin.check(host, v1, v2);
		
		
		
		int result = 0;
			String sql="update t_customer set customerName=?,sex=?,age=?,phone=?,headPic=?,sfz=?,address=?,v1=?,v2=? where id=?";
			result = db.update(sql, new Object[]{customerName,sex,age,phone,headPic,sfz,address,v1,v2,id});
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	}
