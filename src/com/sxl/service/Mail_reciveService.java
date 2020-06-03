package com.sxl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.dao.Mail_reciveDao;
import com.sxl.model.Mail_recive;
import com.sxl.util.PageTool;

@Service("Mail_reciveService")
public class Mail_reciveService extends BaseService{
	
	@Autowired
	public Mail_reciveDao mail_reciveDao;
	
	/**
	 * 分页查询
	 * @param request
	 * @param mail_recive
	 * @return
	 */
	public List<Mail_recive> getMail_reciveList(HttpServletRequest request,Mail_recive mail_recive){
		Integer page_num=5;
		String page_nums = request.getParameter("page_num");
		if(page_nums!=null&&!"".equals(page_nums)){
			page_num =Integer.parseInt(page_nums);
		}
		int pageIndex = request.getParameter("offset")==null?1:Integer.parseInt(request.getParameter("offset"));
		int size =mail_reciveDao.countAll(mail_recive);
		int begin = page_num*(pageIndex-1);
		PageTool page = new PageTool(pageIndex, page_num,size);
		page.setHref(geturl(request));
		request.setAttribute("page", page);
		mail_recive.setBegin(begin);
		mail_recive.setPage_num(page_num);
		List<Mail_recive> list = mail_reciveDao.queryForList(mail_recive);
		return list;
	}
	
	/**
	 * 删除一条记录
	 * @param request
	 * @param id
	 * @return
	 */
	public int deleteOne(HttpServletRequest request,Long id){
		return mail_reciveDao.delete(id);
	}
	
	/**
	 * 根据id获取记录
	 * @param request
	 * @param id
	 * @return
	 */
	public Mail_recive getMail_recive(HttpServletRequest request,Long id){
		return mail_reciveDao.getById(id);
	}
	
	/**
	 * 新增一条记录
	 * @param request
	 * @param book
	 * @return
	 */
	public int save(HttpServletRequest request,Mail_recive mail_recive){
		return mail_reciveDao.insert(mail_recive);
	}
	
	/**
	 * 更新记录
	 * @param request
	 * @param mail_recive
	 * @return
	 */
	public int update(HttpServletRequest request,Mail_recive mail_recive){
		return mail_reciveDao.update(mail_recive);
	}
}
