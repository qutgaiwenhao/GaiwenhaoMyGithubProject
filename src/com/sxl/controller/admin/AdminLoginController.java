package com.sxl.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;
import com.sxl.util.CheckLogin;
import com.sxl.util.StringHelper;


@Controller("adminLoginController")
@RequestMapping(value = "/adminLogin")
public class AdminLoginController extends MyController {
	

	@RequestMapping(value = "/login")
	public String index(Model model, HttpServletRequest request)throws Exception {
		return "/admin/login";
	}
	
//	@RequestMapping(value = "/save")
//	public ResponseEntity<String> loginSave(Model model,HttpServletRequest request,String username,String password,String mailType) throws Exception {
//		String host="smtp.126.com";
//		String pop3="pop.126.com";
//		boolean out = CheckLogin.check(host, username, password);
//		if(out){
//			Map map = new HashMap();
//			map.put("username", username);
//			map.put("password", password);
//			map.put("host", host);
//			map.put("pop3", pop3);
//			request.getSession().setAttribute("adminBean", map);
//			
//			
//			return renderData(true,"1",null);
//		}else{
//			return renderData(true,"0",null);
//		}
//		
//	}
	
	@RequestMapping(value = "/save")
	public ResponseEntity<String> loginSave(Model model,HttpServletRequest request,String username,String password) throws Exception {
//		String yzm = request.getParameter("yzm");
//		String txyzm = (String) request.getSession().getAttribute(RandomValidateCode.RANDOMCODEKEY);
//		if(!yzm.toUpperCase().equals(txyzm.toUpperCase())){
//			return renderData(true,"5",null);
//		}
		
		String sql="select * from t_admin where username=?";
		List<Map> list = db.queryForList(sql, new Object[]{username});
		String result="1";
		if(list!=null&&list.size()>0){
			Map map = list.get(0);
			if(StringHelper.get(map, "password").equals(password)){
				request.getSession().setMaxInactiveInterval(60*60*24);
				request.getSession().setAttribute("adminBean", map);
				result="1";
			}else{
				result="0";
			}
		}else{
			result="0";
		}
		return renderData(true,result,null);
	}
	
	@RequestMapping(value = "/out")
	public String out(Model model, HttpServletRequest request)throws Exception {
		request.getSession().removeAttribute("adminBean");
		return "redirect:/adminLogin/login.html";
	}
	
}
