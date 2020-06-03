<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/taglibs.jsp"%>
<%@taglib uri="http://displaytag.sf.net/el" prefix="display"%>
<style type="text/css">
@import url("${ctx}/resource/admin/displaytag/zdisplaytag.css");
@import url("${ctx}/resource/admin/displaytag/alternative.css");
</style>
<html>
	<body>
		<display:table name="list"
			requestURI="selectTxt.html" class="list"
			id="row" cellspacing="0" cellpadding="0" pagesize="5">
			<display:column style="width:60px;" media="html" title="编号">
				<c:out value="${row_rowNum}"/>
			</display:column>
			<display:column style="width:60px;" media="html" title="<input onclick='chooseAll(this);'  type='checkbox'/>全选">
				<input type="checkbox" value="${row.email }" name="ppp"/>
			</display:column>
			<display:column title="姓名" property="username"/>
			<display:column title="邮件地址" property="email"/>
		</display:table>
		<br>
		<input type="button" value="确定" onclick="doBatch();"/>
	</body>
	<script type="text/javascript">
	
	function chooseAll(src){
		if($(src).attr("checked")=='checked'){
			$("[name='ppp']").attr("checked",'checked');//全选
		}else{
			$("[name='ppp']").removeAttr("checked");//取消全选
		}
	}
	
	function doBatch(){
		if($("input[name='ppp']:checked").length>0){
			var allpp = $("input[name='ppp']:checked");
			var ids="";
			for(var i=0;i<allpp.length;i++){
				
				if(i==0){
					ids+=$(allpp[i]).val();
				}else{
					ids+=";"+$(allpp[i]).val();
				}
			}
			window.opener.form1.v1.value=ids;
			window.close();
		}else{
			alert('请选择信息');
			return false;
		}
	}
</script>
</html>
