package com.sxl.controller.admin;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;


/**
 * 后台主页
 * @author pc
 * @date2015-11-30
 */
@Controller("adminController")
@RequestMapping(value = "/admin")
public class AdminController extends MyController {
	

	@RequestMapping(value = "/index")
	public String index(Model model, HttpServletRequest request)throws Exception {
		return "/admin/index";
	}
	
	@RequestMapping(value = "/main")
	public String main(Model model, HttpServletRequest request)throws Exception {
		return "/admin/main";
	}
	
	@RequestMapping(value = "/send")
	public String send(Model model, HttpServletRequest request)throws Exception {
		return "/admin/send";
	}
	
	@RequestMapping(value = "/selectTxt")
	public String selectTxt(Model model, HttpServletRequest request)throws Exception {
		String sql="select * from t_txl order by id desc";
		model.addAttribute("list", db.queryForList(sql));
		return "/admin/selectTxl";
	}
	
	
	@RequestMapping(value = "/sendSave")
	public ResponseEntity<String> sendSave(Model model,HttpServletRequest request,
			String v1,String v2,String v3,String v5,String v6,String status) throws Exception{
		String host="smtp.126.com";
		String pop3="pop.126.com";
		Map admin = getCustomer(request);
		
		System.out.println("v1===="+admin.get("v1").toString());
		System.out.println("v2===="+admin.get("v2").toString());
		
		
		if("1".equals(status)){
			String[] v1s = v1.split(";");
			String sql="insert into t_mail_send(v1,v2,v3,v4,v5,v6,status,customerId) values(?,?,?,now(),?,?,1,?)";
			for (int i = 0; i < v1s.length; i++) {
				if(v6!=null&&!"".equals(v6)){
					System.out.println("--------附件发送----------");
					JavaMailWithAttachment se = new JavaMailWithAttachment(true);
			        File affix = new File(request.getServletContext().getRealPath("/")+v6);
			        //upload/20160413/146050644353076.docx
			        se.doSendHtmlEmail(v2, v3, v1s[i], affix,host,admin.get("v1").toString(),admin.get("v2").toString(),v5,admin.get("id").toString());
				}else{
					System.out.println("---------普通邮件-------------");
					JavaMail se = new JavaMail(true);
			        se.doSendHtmlEmail(v2, v3, v1s[i],host,admin.get("v1").toString(),admin.get("v2").toString(),admin.get("id").toString());
					
				}
				System.out.println("***************************"+getCustomer(request).get("id"));
		        db.update(sql, new Object[]{v1s[i],v2,v3,v5,v6,getCustomer(request).get("id")});
			}
		}else{
			
			System.out.println("***************************"+getCustomer(request).get("id"));
			
			
			String sql="insert into t_mail_send(v1,v2,v3,v4,v5,v6,status,customerId) values(?,?,?,now(),?,?,0,?)";
			 db.update(sql, new Object[]{v1,v2,v3,v5,v6,getCustomer(request).get("id")});
		}
		return renderData(true,"操作成功",null);
	}
	
	
	@RequestMapping(value = "/sendSave2")
	public ResponseEntity<String> sendSave2(Model model,HttpServletRequest request,
			Long id) throws Exception{
		String host="smtp.126.com";
		String pop3="pop.126.com";
		Map admin = getCustomer(request);
		
		Map map = db.queryForMap("select * from t_mail_send where id="+id);
		String v1 = map.get("v1")==null?"": map.get("v1").toString();
		String v2 = map.get("v2")==null?"": map.get("v2").toString();
		String v3 = map.get("v3")==null?"": map.get("v3").toString();
		String v4 = map.get("v4")==null?"": map.get("v4").toString();
		String v5 = map.get("v5")==null?"": map.get("v5").toString();
		String v6 = map.get("v6")==null?"": map.get("v6").toString();
		
		String[] v1s = v1.split(";");
		String sql="insert into t_mail_send(v1,v2,v3,v4,v5,v6,status,customerId) values(?,?,?,now(),?,?,1,"+getCustomer(request).get("id")+")";
		for (int i = 0; i < v1s.length; i++) {
			if(v6!=null&&!"".equals(v6)){
				System.out.println("--------附件发送----------");
				JavaMailWithAttachment se = new JavaMailWithAttachment(true);
		        File affix = new File(request.getServletContext().getRealPath("/")+v6);
		        //upload/20160413/146050644353076.docx
		        se.doSendHtmlEmail(v2, v3, v1s[i], affix,host,admin.get("v1").toString(),admin.get("v2").toString(),v5,getCustomer(request).get("id").toString());
			}else{
				System.out.println("---------普通邮件-------------");
				JavaMail se = new JavaMail(false);
		        se.doSendHtmlEmail(v2, v3, v1s[i],host,admin.get("v1").toString(),admin.get("v2").toString(),getCustomer(request).get("id").toString());
				
			}
			db.update("delete from t_mail_send where id=?",new Object[]{id});
	        db.update(sql, new Object[]{v1s[i],v2,v3,v5,v6});
		}
		return renderData(true,"操作成功",null);
	}
}
