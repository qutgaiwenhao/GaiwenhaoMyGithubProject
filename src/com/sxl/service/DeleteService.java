package com.sxl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.dao.DeleteDao;
import com.sxl.model.Delete;
import com.sxl.util.PageTool;

@Service("DeleteService")
public class DeleteService extends BaseService{
	
	@Autowired
	public DeleteDao deleteDao;
	
	/**
	 * 分页查询
	 * @param request
	 * @param delete
	 * @return
	 */
	public List<Delete> getDeleteList(HttpServletRequest request,Delete delete){
		Integer page_num=5;
		String page_nums = request.getParameter("page_num");
		if(page_nums!=null&&!"".equals(page_nums)){
			page_num =Integer.parseInt(page_nums);
		}
		int pageIndex = request.getParameter("offset")==null?1:Integer.parseInt(request.getParameter("offset"));
		int size =deleteDao.countAll(delete);
		int begin = page_num*(pageIndex-1);
		PageTool page = new PageTool(pageIndex, page_num,size);
		page.setHref(geturl(request));
		request.setAttribute("page", page);
		delete.setBegin(begin);
		delete.setPage_num(page_num);
		List<Delete> list = deleteDao.queryForList(delete);
		return list;
	}
	
	/**
	 * 删除一条记录
	 * @param request
	 * @param id
	 * @return
	 */
	public int deleteOne(HttpServletRequest request,Long id){
		return deleteDao.delete(id);
	}
	
	/**
	 * 根据id获取记录
	 * @param request
	 * @param id
	 * @return
	 */
	public Delete getDelete(HttpServletRequest request,Long id){
		return deleteDao.getById(id);
	}
	
	/**
	 * 新增一条记录
	 * @param request
	 * @param book
	 * @return
	 */
	public int save(HttpServletRequest request,Delete delete){
		return deleteDao.insert(delete);
	}
	
	/**
	 * 更新记录
	 * @param request
	 * @param delete
	 * @return
	 */
	public int update(HttpServletRequest request,Delete delete){
		return deleteDao.update(delete);
	}
}
