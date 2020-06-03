<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script>
var ctx='${ctx}';
var ctx_fck='${ctx}';
</script>
<%@taglib uri="http://displaytag.sf.net/el" prefix="display"%>
<%@taglib prefix="ckeditor" uri="http://ckeditor.com"%>
<style type="text/css">
@import url("${ctx}/resource/admin/displaytag/displaytag.css");
@import url("${ctx}/resource/admin/displaytag/alternative.css");
</style>
<script src="${ctx}/resource/admin/js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="${ctx}/resource/admin/js/common.js" type="text/javascript"></script>
<link rel="StyleSheet" href="${ctx}/resource/admin/css/mobile_main.css" type="text/css" />
<script type="text/javascript" src="${ctx}/resource/admin/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="${ctx }/resource/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx }/resource/check.js"></script>
<script type="text/javascript" src="${ctx }/resource/jquery.jqprint-0.3.js"></script>
<script type="text/javascript" src="${ctx }/resource/highcharts.js"></script>
<script src="${ctx }/resource/jquery.qrcode.min.js"></script>
<link rel="StyleSheet" href="${ctx}/resource/mine/11/mine.css" type="text/css" />

<script type="text/javascript">
function  printdiv(){
        $("#ddd").jqprint();
}
function saveAnd(){
if(window.opener.parent.parent != window.opener.parent){
		try{
			if(window.opener.location.href.indexOf('d-16544-p') == -1) {
				window.opener.parent.document.forms[0].submit();
					
			} else {
				window.opener.location.reload();
			}
    	} catch(e){
    		window.opener.document.forms[0].submit();
    	}
	} else {
		try {
			window.opener.document.forms[0].submit();
		} catch(e){
			window.opener.location.reload();
		}			
	}
	window.close();
}
</script>
