package com.sxl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.dao.HmdDao;
import com.sxl.model.Hmd;
import com.sxl.util.PageTool;

@Service("HmdService")
public class HmdService extends BaseService{
	
	@Autowired
	public HmdDao hmdDao;
	
	/**
	 * 分页查询
	 * @param request
	 * @param hmd
	 * @return
	 */
	public List<Hmd> getHmdList(HttpServletRequest request,Hmd hmd){
		Integer page_num=5;
		String page_nums = request.getParameter("page_num");
		if(page_nums!=null&&!"".equals(page_nums)){
			page_num =Integer.parseInt(page_nums);
		}
		int pageIndex = request.getParameter("offset")==null?1:Integer.parseInt(request.getParameter("offset"));
		int size =hmdDao.countAll(hmd);
		int begin = page_num*(pageIndex-1);
		PageTool page = new PageTool(pageIndex, page_num,size);
		page.setHref(geturl(request));
		request.setAttribute("page", page);
		hmd.setBegin(begin);
		hmd.setPage_num(page_num);
		List<Hmd> list = hmdDao.queryForList(hmd);
		return list;
	}
	
	/**
	 * 删除一条记录
	 * @param request
	 * @param id
	 * @return
	 */
	public int deleteOne(HttpServletRequest request,Long id){
		return hmdDao.delete(id);
	}
	
	/**
	 * 根据id获取记录
	 * @param request
	 * @param id
	 * @return
	 */
	public Hmd getHmd(HttpServletRequest request,Long id){
		return hmdDao.getById(id);
	}
	
	/**
	 * 新增一条记录
	 * @param request
	 * @param book
	 * @return
	 */
	public int save(HttpServletRequest request,Hmd hmd){
		return hmdDao.insert(hmd);
	}
	
	/**
	 * 更新记录
	 * @param request
	 * @param hmd
	 * @return
	 */
	public int update(HttpServletRequest request,Hmd hmd){
		return hmdDao.update(hmd);
	}
}
