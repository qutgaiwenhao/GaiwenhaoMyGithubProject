
package com.sxl.controller.admin;

import java.io.File;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;
import com.sxl.util.HssfHelper;
import com.sxl.util.ExcelUtils;

/**
*
* @author Administratorxxxx
* @date2020-04-14
*/
@Controller("deleteController")
@RequestMapping(value = "/admin/delete")
public class DeleteController extends MyController {
	

/**
* 查询frame
*/
	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request,String flag)throws Exception {
		return "/admin/delete/frame";
	}
	
/**
* 查询列表
*/
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request,String flag)throws Exception {
		//select date_format(insertDate, '%Y-%m-%d %H:%i:%s')
		//CONVERT(varchar, insertDate, 120 )
		//to_char(insertDate,'yyyy-mm-dd,hh24:mi:ss') 

		String sql="select a.* from t_delete a where 1=1 and customerId= "+getCustomer(request).get("id");


		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/delete/list";
	}
	
/**
* 编辑保存（包含修改和添加）
*/
	@RequestMapping(value = "/editSave")
	public ResponseEntity<String> editSave(Model model,HttpServletRequest request,Long id,String flag
		,String emailId,String title,String isd) throws Exception{
		int result = 0;
		if(id!=null){
			String sql="update t_delete set emailId=?,title=?,isd=? where id=?";
			result = db.update(sql, new Object[]{emailId,title,isd,id});
		}else{
			String sql="insert into t_delete(emailId,title,isd,customerId) values(?,?,?,?)";
			result = db.update(sql, new Object[]{emailId,title,isd,getCustomer(request).get("id")});
		}
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
/**
* 删除信息
*/
	@RequestMapping(value = "/editDelete")
	public ResponseEntity<String> editDelete(Model model,HttpServletRequest request,Long id,String flag) throws Exception {
		
		String sql="delete from t_delete where id=?";
		int result = db.update(sql, new Object[]{id});
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
		
	}
	
/**
* 跳转到编辑页面
*/
	@RequestMapping(value = "/edit")
	public String edit(Model model, HttpServletRequest request,Long id,String flag)throws Exception {
		if(id!=null){
			//修改
			String sql="select * from t_delete where id=?";
			Map map = db.queryForMap(sql,new Object[]{id});
			model.addAttribute("map", map);
		}String sql="";

		return "/admin/delete/edit";
	}
/**
* 跳转到查看页面
*/
	@RequestMapping(value = "/show")
	public String show(Model model, HttpServletRequest request,Long id,String flag)throws Exception {
		if(id!=null){
			//修改
			String sql="select * from t_delete where id=?";
			Map map = db.queryForMap(sql,new Object[]{id});
			model.addAttribute("map", map);
		}String sql="";

		return "/admin/delete/show";
	}
@RequestMapping(value = "/daochu")
	public void daochu(Model model, HttpServletResponse response,HttpServletRequest request,String flag)throws Exception {
		String sql="select a.* from t_delete a where 1=1 ";
			sql+=" order by id desc";
			List list = db.queryForList(sql);
			request.setAttribute("list", list);
			HssfHelper hssfHelper = new HssfHelper();
			writeToExcel(hssfHelper.export(list, new String[][] {
							{ "", "emailId" },{ "", "title" },{ "", "isd" } 
							}, "导出"),
					"下载", response);
	}
	
	
	@RequestMapping(value = "/imp")
	public String imp(Model model, HttpServletRequest request,Long id,String flag)throws Exception {

		return "/admin/delete/imp";
	}
	
	
	@RequestMapping(value = "/impSave")
	public ResponseEntity<String> impSave(Model model,HttpServletRequest request,Long id,String file) throws Exception {
		String[][] aa = ExcelUtils.importExcel(new File(request.getServletContext().getRealPath("/")+file), 0);
		String sql="insert into t_delete(emailId,title,isd) values(?,?,?)";
		for (int i = 1; i < aa.length; i++) {
			db.update(sql, new Object[]{aa[i][0],aa[i][1],aa[i][2]});
		}
		return renderData(true,"操作成功",null);
	
	}

}