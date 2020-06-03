
package com.sxl.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;
import com.sxl.util.POP3ReceiveMailTest;

@Controller("mailReciveController")
@RequestMapping(value = "/admin/mailRecive")
public class MailReciveController extends MyController {
	

	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request)throws Exception {
		return "/admin/mailRecive/frame";
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request,String keyword,String flag)throws Exception {
		String sql="select * from t_mail_recive a where isd=1 and customerId= "+getCustomer(request).get("id")+" ";
		String ppp = request.getParameter("ppp");
		if(keyword!=null&&!"".equals(keyword)){
			sql+=" and v2 like '%"+keyword+"%'";
		}
		
		if("1".equals(ppp)){
			sql+=" and date_format(REPLACE(REPLACE(left(v4,10),'年','-'),'月','-'),'%Y-%m-%d') = date_format(now(), '%Y-%m-%d') " ;
		}
		if("2".equals(ppp)){
			sql+=" and DATEDIFF(date_format(now(), '%Y-%m-%d'),date_format(REPLACE(REPLACE(left(v4,10),'年','-'),'月','-'),'%Y-%m-%d')  )>7 " ;
		}
		if("3".equals(ppp)){
			sql+=" and DATEDIFF(date_format(now(), '%Y-%m-%d'),date_format(REPLACE(REPLACE(left(v4,10),'年','-'),'月','-'),'%Y-%m-%d'))> 30" ;
		}
		if("4".equals(ppp)){
			sql+=" and DATEDIFF(date_format(now(), '%Y-%m-%d'),date_format(REPLACE(REPLACE(left(v4,10),'年','-'),'月','-'),'%Y-%m-%d'))>365 " ;
		}
		//date_format(insertDate, '%Y-%m-%d %H:%i:%s')
		
		
		sql+=" and not exists(select 1 from t_delete b where a.v2=b.title and a.emailId=b.emailId) ";
		if("1".equals(flag)){
			//黑名单的
			sql+=" and (exists(select 1 from t_hmd c where a.v1  like CONCAT ('%',c.email,'%') ) or " +
					"exists(select 1 from t_ggc d where a.v2  like CONCAT ('%',d.username,'%')  or a.v3 like CONCAT ('%',d.username,'%')))";
		}else{
			sql+=" and (not exists(select 1 from t_hmd c where a.v1 like CONCAT ('%',c.email,'%') ) and  " +
					" not exists(select 1 from t_ggc d where a.v2 like CONCAT ('%',d.username,'%') and a.v3 like CONCAT ('%',d.username,'%')))";
		}
		sql+=" order by id desc";
		System.out.println("====================="+sql);
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/mailRecive/list";
	}
	
	
	@RequestMapping(value = "/frame2")
	public String frame2(Model model, HttpServletRequest request)throws Exception {
		return "/admin/mailRecive/frame2";
	}
	
	@RequestMapping(value = "/frame3")
	public String frame3(Model model, HttpServletRequest request)throws Exception {
		return "/admin/mailRecive/frame3";
	}
	
	@RequestMapping(value = "/list2")
	public String list2(Model model, HttpServletRequest request,String keyword,String flag)throws Exception {
		String sql="select * from t_mail_recive a where isd=0 and customerId= "+getCustomer(request).get("id")+" ";
		if(keyword!=null&&!"".equals(keyword)){
			sql+=" and v2 like '%"+keyword+"%'";
		}
		sql+=" and not exists(select 1 from t_delete b where a.v2=b.title and a.emailId=b.emailId) ";
		if("1".equals(flag)){
			//黑名单的
			sql+=" and (exists(select 1 from t_hmd c where a.v1  like CONCAT ('%',c.email,'%') ) or " +
					"exists(select 1 from t_ggc d where a.v2  like CONCAT ('%',d.username,'%')  or a.v3 like CONCAT ('%',d.username,'%')))";
		}else{
			sql+=" and (not exists(select 1 from t_hmd c where a.v1 like CONCAT ('%',c.email,'%') ) and  " +
					" not exists(select 1 from t_ggc d where a.v2 like CONCAT ('%',d.username,'%') and a.v3 like CONCAT ('%',d.username,'%')))";
		}
		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/mailRecive/list2";
	}
	
	@RequestMapping(value = "/list3")
	public String list3(Model model, HttpServletRequest request,String keyword,String flag)throws Exception {
		String sql="select * from t_mail_recive a where sc=1 and customerId= "+getCustomer(request).get("id")+" ";
		if(keyword!=null&&!"".equals(keyword)){
			sql+=" and v2 like '%"+keyword+"%'";
		}
		sql+=" and not exists(select 1 from t_delete b where a.v2=b.title and a.emailId=b.emailId) ";
//		if("1".equals(flag)){
//			//黑名单的
//			sql+=" and (exists(select 1 from t_hmd c where a.v1  like CONCAT ('%',c.email,'%') ) or " +
//					"exists(select 1 from t_ggc d where a.v2  like CONCAT ('%',d.username,'%')  or a.v3 like CONCAT ('%',d.username,'%')))";
//		}else{
//			sql+=" and (not exists(select 1 from t_hmd c where a.v1 like CONCAT ('%',c.email,'%') ) and  " +
//					" not exists(select 1 from t_ggc d where a.v2 like CONCAT ('%',d.username,'%') and a.v3 like CONCAT ('%',d.username,'%')))";
//		}
		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/mailRecive/list3";
	}
	
	@RequestMapping(value = "/editSave")
	public ResponseEntity<String> editSave(Model model,HttpServletRequest request,Long id
		,String v1,String v2,String v3,String v4,String v5,String v6) throws Exception{
		int result = 0;
		if(id!=null){
			String sql="update t_mail_recive set v1=?,v2=?,v3=?,v4=?,v5=?,v6=? where id=?";
			result = db.update(sql, new Object[]{v1,v2,v3,v4,v5,v6,id});
		}else{
			String sql="insert into t_mail_recive(v1,v2,v3,v4,v5,v6) values(?,?,?,?,?,?)";
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
		
		String sql="update t_mail_recive set isd=0  where id=?";
		int result = db.update(sql, new Object[]{id});
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
	@RequestMapping(value = "/bj")
	public ResponseEntity<String> bj(Model model,HttpServletRequest request,Long id) throws Exception {
		
		String sql="update t_mail_recive set sc=1 where id=?";
		int result = db.update(sql, new Object[]{id});
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
	@RequestMapping(value = "/editDelete2")
	public ResponseEntity<String> editDelete2(Model model,HttpServletRequest request,Long id) throws Exception {
		
		String sql="insert into t_delete(title,emailId) select v2,emailId from t_mail_recive  where id in ("+id+")";
		db.update(sql);
		sql="delete from t_mail_recive where id=?";
		int result = db.update(sql, new Object[]{id});
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
	
	@RequestMapping(value = "/getMessage")
	public ResponseEntity<String> getMessage(Model model,HttpServletRequest request,Long id) throws Exception {
		Map admin = getCustomer(request);
		String host="smtp.126.com";
		String pop3="pop.126.com";
		String sql="delete from t_mail_recive where id=1";
		db.update(sql);
		List<Map> list = POP3ReceiveMailTest.receive(pop3, admin.get("v1").toString(), admin.get("v2").toString(),request.getServletContext().getRealPath("/")+"upload/");
		sql="insert into t_mail_recive(v1,v2,v3,v4,v5,v6,status,emailId,isd,customerId) values(?,?,?,?,?,?,1,?,1,'"+getCustomer(request).get("id")+"')";
		System.out.println("-----list.size()----------"+list.size());
		if(list!=null){
			for (int i = 0; i < list.size(); i++) {
				try{
					Map map = list.get(i);
					System.out.println("map============================"+map);
//					map.get("from").toString();
//					map.get("title").toString();
//					map.get("content").toString();
//					map.get("sendTime").toString();
//					map.get("v5").toString();
//					map.get("v6").toString();
//					map.get("id").toString();
					int a  =db.queryForInt("select count(1) from t_mail_recive where emailId='"+map.get("id").toString()+"' and customerId="+getCustomer(request).get("id")+"");
					if(a>0){
					}else{
						db.update(sql, new Object[]{map.get("from").toString(),map.get("title").toString(),map.get("content").toString(),map.get("sendTime").toString(),map.get("v5").toString(),map.get("v6").toString(),map.get("id").toString()});
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		}
		return renderData(true,"操作成功",null);
	}
	
	@RequestMapping(value = "/batchDelete")
	public ResponseEntity<String> batchDelete(Model model,HttpServletRequest request,String ids) throws Exception {
		System.out.println(ids);
		String sql="update t_mail_recive set isd=0  where id in ("+ids+")";
		db.update(sql);
		return renderData(true,"操作成功",null);
		
	}
	
	@RequestMapping(value = "/batchDelete2")
	public ResponseEntity<String> batchDelete2(Model model,HttpServletRequest request,String ids) throws Exception {
		System.out.println(ids);
		String sql="insert into t_delete(title,emailId) select v2,emailId from t_mail_recive  where id in ("+ids+")";
		db.update(sql);
		return renderData(true,"操作成功",null);
		
	}
	
	
	@RequestMapping(value = "/edit")
	public String edit(Model model, HttpServletRequest request,Long id)throws Exception {
		if(id!=null){
			//修改
			String sql="select * from t_mail_recive where id=?";
			Map map = db.queryForMap(sql,new Object[]{id});
			model.addAttribute("map", map);
		}
		return "/admin/mailRecive/edit";
	}
	
	@RequestMapping(value = "/shows")
	public String shows(Model model, HttpServletRequest request,Long id)throws Exception {
		if(id!=null){
			//修改
			String sql="select * from t_mail_recive where id=?";
			Map map = db.queryForMap(sql,new Object[]{id});
			model.addAttribute("map", map);
		}
		return "/admin/mailRecive/shows";
	}
}
