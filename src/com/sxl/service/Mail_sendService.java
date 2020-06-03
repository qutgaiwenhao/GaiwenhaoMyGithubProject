package com.sxl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.dao.Mail_sendDao;
import com.sxl.model.Mail_send;
import com.sxl.util.PageTool;

@Service("Mail_sendService")
public class Mail_sendService extends BaseService{
	
	@Autowired
	public Mail_sendDao mail_sendDao;
	
	/**
	 * 分页查询
	 * @param request
	 * @param mail_send
	 * @return
	 */
	public List<Mail_send> getMail_sendList(HttpServletRequest request,Mail_send mail_send){
		Integer page_num=5;
		String page_nums = request.getParameter("page_num");
		if(page_nums!=null&&!"".equals(page_nums)){
			page_num =Integer.parseInt(page_nums);
		}
		int pageIndex = request.getParameter("offset")==null?1:Integer.parseInt(request.getParameter("offset"));
		int size =mail_sendDao.countAll(mail_send);
		int begin = page_num*(pageIndex-1);
		PageTool page = new PageTool(pageIndex, page_num,size);
		page.setHref(geturl(request));
		request.setAttribute("page", page);
		mail_send.setBegin(begin);
		mail_send.setPage_num(page_num);
		List<Mail_send> list = mail_sendDao.queryForList(mail_send);
		return list;
	}
	
	/**
	 * 删除一条记录
	 * @param request
	 * @param id
	 * @return
	 */
	public int deleteOne(HttpServletRequest request,Long id){
		return mail_sendDao.delete(id);
	}
	
	/**
	 * 根据id获取记录
	 * @param request
	 * @param id
	 * @return
	 */
	public Mail_send getMail_send(HttpServletRequest request,Long id){
		return mail_sendDao.getById(id);
	}
	
	/**
	 * 新增一条记录
	 * @param request
	 * @param book
	 * @return
	 */
	public int save(HttpServletRequest request,Mail_send mail_send){
		return mail_sendDao.insert(mail_send);
	}
	
	/**
	 * 更新记录
	 * @param request
	 * @param mail_send
	 * @return
	 */
	public int update(HttpServletRequest request,Mail_send mail_send){
		return mail_sendDao.update(mail_send);
	}
}
