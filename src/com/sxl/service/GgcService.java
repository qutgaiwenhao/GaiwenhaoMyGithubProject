package com.sxl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.dao.GgcDao;
import com.sxl.model.Ggc;
import com.sxl.util.PageTool;

@Service("GgcService")
public class GgcService extends BaseService{
	
	@Autowired
	public GgcDao ggcDao;
	
	/**
	 * 分页查询
	 * @param request
	 * @param ggc
	 * @return
	 */
	public List<Ggc> getGgcList(HttpServletRequest request,Ggc ggc){
		Integer page_num=5;
		String page_nums = request.getParameter("page_num");
		if(page_nums!=null&&!"".equals(page_nums)){
			page_num =Integer.parseInt(page_nums);
		}
		int pageIndex = request.getParameter("offset")==null?1:Integer.parseInt(request.getParameter("offset"));
		int size =ggcDao.countAll(ggc);
		int begin = page_num*(pageIndex-1);
		PageTool page = new PageTool(pageIndex, page_num,size);
		page.setHref(geturl(request));
		request.setAttribute("page", page);
		ggc.setBegin(begin);
		ggc.setPage_num(page_num);
		List<Ggc> list = ggcDao.queryForList(ggc);
		return list;
	}
	
	/**
	 * 删除一条记录
	 * @param request
	 * @param id
	 * @return
	 */
	public int deleteOne(HttpServletRequest request,Long id){
		return ggcDao.delete(id);
	}
	
	/**
	 * 根据id获取记录
	 * @param request
	 * @param id
	 * @return
	 */
	public Ggc getGgc(HttpServletRequest request,Long id){
		return ggcDao.getById(id);
	}
	
	/**
	 * 新增一条记录
	 * @param request
	 * @param book
	 * @return
	 */
	public int save(HttpServletRequest request,Ggc ggc){
		return ggcDao.insert(ggc);
	}
	
	/**
	 * 更新记录
	 * @param request
	 * @param ggc
	 * @return
	 */
	public int update(HttpServletRequest request,Ggc ggc){
		return ggcDao.update(ggc);
	}
}
