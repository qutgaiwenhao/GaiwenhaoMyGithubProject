
package com.sxl.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;

@Controller("ggcController")
@RequestMapping(value = "/admin/ggc")
public class GgcController extends MyController {
	

	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request)throws Exception {
		return "/admin/ggc/frame";
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request,String keyword)throws Exception {
		String sql="select * from t_ggc where 1=1 and customerId= "+getCustomer(request).get("id");
		if(keyword!=null&&!"".equals(keyword)){
			sql+=" and usename like '%"+keyword+"%'";
		}
		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/ggc/list";
	}
	
	@RequestMapping(value = "/editSave")
	public ResponseEntity<String> editSave(Model model,HttpServletRequest request,Long id
		,String username) throws Exception{
		int result = 0;
		if(id!=null){
			String sql="update t_ggc set username=? where id=?";
			result = db.update(sql, new Object[]{username,id});
		}else{
			String sql="insert into t_ggc(username,customerId) values(?,?)";
			result = db.update(sql, new Object[]{username,getCustomer(request).get("id")});
		}
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
	@RequestMapping(value = "/editDelete")
	public ResponseEntity<String> editDelete(Model model,HttpServletRequest request,Long id) throws Exception {
		
		String sql="delete from t_ggc where id=?";
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
			String sql="select * from t_ggc where id=?";
			Map map = db.queryForMap(sql,new Object[]{id});
			model.addAttribute("map", map);
		}
		return "/admin/ggc/edit";
	}
}
