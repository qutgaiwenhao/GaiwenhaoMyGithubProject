package com.sxl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.dao.TxlDao;
import com.sxl.model.Txl;
import com.sxl.util.PageTool;

@Service("TxlService")
public class TxlService extends BaseService{
	
	@Autowired
	public TxlDao txlDao;
	
	/**
	 * 分页查询
	 * @param request
	 * @param txl
	 * @return
	 */
	public List<Txl> getTxlList(HttpServletRequest request,Txl txl){
		Integer page_num=5;
		String page_nums = request.getParameter("page_num");
		if(page_nums!=null&&!"".equals(page_nums)){
			page_num =Integer.parseInt(page_nums);
		}
		int pageIndex = request.getParameter("offset")==null?1:Integer.parseInt(request.getParameter("offset"));
		int size =txlDao.countAll(txl);
		int begin = page_num*(pageIndex-1);
		PageTool page = new PageTool(pageIndex, page_num,size);
		page.setHref(geturl(request));
		request.setAttribute("page", page);
		txl.setBegin(begin);
		txl.setPage_num(page_num);
		List<Txl> list = txlDao.queryForList(txl);
		return list;
	}
	
	/**
	 * 删除一条记录
	 * @param request
	 * @param id
	 * @return
	 */
	public int deleteOne(HttpServletRequest request,Long id){
		return txlDao.delete(id);
	}
	
	/**
	 * 根据id获取记录
	 * @param request
	 * @param id
	 * @return
	 */
	public Txl getTxl(HttpServletRequest request,Long id){
		return txlDao.getById(id);
	}
	
	/**
	 * 新增一条记录
	 * @param request
	 * @param book
	 * @return
	 */
	public int save(HttpServletRequest request,Txl txl){
		return txlDao.insert(txl);
	}
	
	/**
	 * 更新记录
	 * @param request
	 * @param txl
	 * @return
	 */
	public int update(HttpServletRequest request,Txl txl){
		return txlDao.update(txl);
	}
}
