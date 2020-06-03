
package com.sxl.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;

@Controller("mailSendController")
@RequestMapping(value = "/admin/mailSend")
public class MailSendController extends MyController {
	

	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request)throws Exception {
		return "/admin/mailSend/frame";
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request,String keyword,String status)throws Exception {
		String sql="select * from t_mail_send where 1=1 and customerId= "+getCustomer(request).get("id");
		if(keyword!=null&&!"".equals(keyword)){
			sql+=" and v2 like '%"+keyword+"%'";
		}
		if(status!=null&&!"".equals(status)){
			sql+=" and status like '%"+status+"%'";
		}
		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/mailSend/list";
	}
	
	@RequestMapping(value = "/editSave")
	public ResponseEntity<String> editSave(Model model,HttpServletRequest request,Long id
		,String v1,String v2,String v3,String v4,String v5,String v6) throws Exception{
		int result = 0;
		if(id!=null){
			String sql="update t_mail_send set v1=?,v2=?,v3=?,v4=?,v5=?,v6=? where id=?";
			result = db.update(sql, new Object[]{v1,v2,v3,v4,v5,v6,id});
		}else{
			String sql="insert into t_mail_send(v1,v2,v3,v4,v5,v6) values(?,?,?,?,?,?)";
			result = db.update(sql, new Object[]{v1,v2,v3,v4,v5,v6});
		}
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
	@RequestMapping(value = "/editDelete")
	public ResponseEntity<String> editDelete(Model model,HttpServletRequest request,Long id) throws Exception {
		
		String sql="delete from t_mail_send where id=?";
		int result = db.update(sql, new Object[]{id});
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
		
	}
	
	@RequestMapping(value = "/batchDelete")
	public ResponseEntity<String> batchDelete(Model model,HttpServletRequest request,String ids) throws Exception {
		
		String sql="delete from t_mail_send where id in ("+ids+")";
		db.update(sql);
		return renderData(true,"操作成功",null);
		
	}
	
	@RequestMapping(value = "/edit")
	public String edit(Model model, HttpServletRequest request,Long id)throws Exception {
		if(id!=null){
			//修改
			String sql="select * from t_mail_send where id=?";
			Map map = db.queryForMap(sql,new Object[]{id});
			model.addAttribute("map", map);
		}
		return "/admin/mailSend/edit";
	}
	
	@RequestMapping(value = "/shows")
	public String shows(Model model, HttpServletRequest request,Long id)throws Exception {
		if(id!=null){
			//修改
			String sql="select * from t_mail_send where id=?";
			Map map = db.queryForMap(sql,new Object[]{id});
			model.addAttribute("map", map);
		}
		return "/admin/mailSend/shows";
	}
}
