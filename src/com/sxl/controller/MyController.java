package com.sxl.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.sxl.dao.MyBatiesPublic;
import com.sxl.util.JacksonJsonUtil;
import com.sxl.util.DBHelper;
import com.sxl.util.PageTool;

public class MyController  {
	@Autowired
	public DBHelper db;
	@Autowired
	public MyBatiesPublic db2;
	
	public Map getAdmin(HttpServletRequest request){
		Map customerBean = (Map)request.getSession().getAttribute("adminBean");
		return customerBean;
	}
	
	public Map getCustomer(HttpServletRequest request){
		Map customerBean = (Map)request.getSession().getAttribute("customerBean");
		return customerBean;
	}
	public ResponseEntity<String> renderMsg(Boolean status, String msg) {
		if (StringUtils.isEmpty(msg)) {
			msg = "";
		}
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"status\":\"" + status + "\",\"msg\":\"" + msg + "\"");
		sb.append("}");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				sb.toString(), initHttpHeaders(), HttpStatus.OK);
		return responseEntity;
	}
	
	
	public ResponseEntity<String> renderData(Boolean status, String msg,
			Object obj) {
		if (StringUtils.isEmpty(msg)) {
			msg = "";
		}
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"status\":\"" + status + "\",\"msg\":\"" + msg + "\",");
		sb.append("\"data\":" + JacksonJsonUtil.toJson(obj) + "");
		sb.append("}");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				sb.toString(), initHttpHeaders(), HttpStatus.OK);
		return responseEntity;
	}
	
	public ResponseEntity<String> renderDataEasyUi(HttpServletRequest request,Object obj) {
		StringBuffer sb = new StringBuffer();
		PageTool page = (PageTool)request.getAttribute("page");
		sb.append("{");
		sb.append("\"total\":\"" + page.getSize() + "\",");
		sb.append("\"rows\":" + JacksonJsonUtil.toJson(obj) + "");
		sb.append("}");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				sb.toString(), initHttpHeaders(), HttpStatus.OK);
		return responseEntity;
	}
	public ResponseEntity<String> renderComboBoxAjax(Object obj) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				JacksonJsonUtil.toJson(obj), initHttpHeaders(), HttpStatus.OK);
		return responseEntity;
	}
	public void writeToExcel(HSSFWorkbook wb, String fileName,HttpServletResponse response)
			throws IOException {
		fileName = (fileName == null || fileName.equals("")) ? "result"
				: fileName;
		fileName = java.net.URLEncoder.encode(fileName, "UTF-8").replace('+',
				' ');
		response.reset();
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ fileName + ".xls");
		wb.write(response.getOutputStream());
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
	
	
	/////////////////////////////////////
	public static final Long EXPIRES_IN = 1000 * 3600 * 24 * 1L;// 1天

	/**
	 * 返回服务器地址 like http://192.168.1.1:8441/UUBean/
	 */
	public String getHostUrl(HttpServletRequest request) {
		String hostName = request.getServerName();
		Integer hostPort = request.getServerPort();
		String path = request.getContextPath();

		if (hostPort == 80) {
			return "http://" + hostName + path + "/";
		} else {
			return "http://" + hostName + ":" + hostPort + path + "/";
		}
	}

	/***
	 * 获取当前的website路径 String
	 */
	public static String getWebSite(HttpServletRequest request) {
		String returnUrl = request.getScheme() + "://"
				+ request.getServerName();

		if (request.getServerPort() != 80) {
			returnUrl += ":" + request.getServerPort();
		}

		returnUrl += request.getContextPath();

		return returnUrl;
	}



	/**
	 * 初始化HTTP头.
	 * 
	 * @return HttpHeaders
	 */
	public HttpHeaders initHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = new MediaType("text", "html",
				Charset.forName("utf-8"));
		headers.setContentType(mediaType);
		return headers;
	}




	/***
	 * 获取IP（如果是多级代理，则得到的是一串IP值）
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		if (ip != null && ip.length() > 0) {
			String[] ips = ip.split(",");
			for (int i = 0; i < ips.length; i++) {
				if (!"unknown".equalsIgnoreCase(ips[i])) {
					ip = ips[i];
					break;
				}
			}
		}
		return ip;
	}
}
