
package com.sxl.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;

@Controller("txlController")
@RequestMapping(value = "/admin/txl")
public class TxlController extends MyController {
	

	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request)throws Exception {
		return "/admin/txl/frame";
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request,String keyword)throws Exception {
		String sql="select * from t_txl where 1=1 and customerId= "+getCustomer(request).get("id");
		if(keyword!=null&&!"".equals(keyword)){
			sql+=" and username like '%"+keyword+"%'";
		}
		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/txl/list";
	}
	
	@RequestMapping(value = "/editSave")
	public ResponseEntity<String> editSave(Model model,HttpServletRequest request,Long id
		,String username,String email) throws Exception{
		int result = 0;
		if(id!=null){
			String sql="update t_txl set username=?,email=? where id=?";
			result = db.update(sql, new Object[]{username,email,id});
		}else{
			String sql="insert into t_txl(username,email,customerId) values(?,?,?)";
			result = db.update(sql, new Object[]{username,email,getCustomer(request).get("id")});
		}
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
	@RequestMapping(value = "/editDelete")
	public ResponseEntity<String> editDelete(Model model,HttpServletRequest request,Long id) throws Exception {
		
		String sql="delete from t_txl where id=?";
		int result = db.update(sql, new Object[]{id});
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
		
	}
	
	@RequestMapping(value = "/edit")
	public String edit(Model model, HttpServletRequest request,Long id)throws Exception {
		if(id!=null){
			//修改
			String sql="select * from t_txl where id=?";
			Map map = db.queryForMap(sql,new Object[]{id});
			model.addAttribute("map", map);
		}
		return "/admin/txl/edit";
	}
}
