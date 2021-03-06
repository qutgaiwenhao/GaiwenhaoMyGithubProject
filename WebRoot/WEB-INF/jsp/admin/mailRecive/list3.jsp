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
			requestURI="list3.html" class="list"
			id="row" cellspacing="0" cellpadding="0" pagesize="5">
			<display:column style="width:60px;" media="html" title="编号">
				<c:out value="${row_rowNum}"/>
			</display:column>
			<display:column style="width:60px;" media="html" title="<input onclick='chooseAll(this);'  type='checkbox'/>全选">
				<input type="checkbox" value="${row.id }" name="ppp"/>
			</display:column>
			<display:column title="查看" style="width:40px;">
				<img src="${ctx}/resource/admin/images/edit.gif"
					onclick="return shows('${row.id}');" style="cursor:hand;"/>
			</display:column>
			<display:column title="发件人" property="v1"/>
			<display:column title="标题" property="v2"/>
			<display:column title="发送时间" property="v4"/>
			<display:column title="附件地址">
				<a href='${ctx }/upload/${row.v5}'>${row.v5 }</a>
			</display:column>
			<display:column title="彻底删除" style="width:40px;">
				<img src="${ctx}/resource/admin/images/delete.png"
					onclick="return deleteOne('${row.id}');" style="cursor:hand;"/>
			</display:column>
		</display:table>
		<br>
		<input type="button" value="彻底批量删除" onclick="doBatch();"/>
	</body>
	<script type="text/javascript">
	function deleteOne(id){
		if(!confirm("确定要删除吗?")){
			return false;
		}
		var params={id:id};
		$.post("editDelete2.html",params,function(
				result){
			result=eval("("+result+")");
			if(result.status=="true"||result.status==true){
				alert('成功');
			window.parent.form1.submit();
			}
		});
	}
	
	function shows(id){
			MyWindow.OpenCenterWindow('shows.html?id='+id,'modshowsify',800,800);
	}
	
	function modifyOne(id){
			MyWindow.OpenCenterWindow('edit.html?id='+id,'modify',800,800);
	}
	
	function chooseAll(src){
		if($(src).attr("checked")=='checked'){
			$("[name='ppp']").attr("checked",'checked');//全选
		}else{
			$("[name='ppp']").removeAttr("checked");//取消全选
		}
	}
	
	function doBatch(){
		if(!confirm("确定要批量删除吗?")){
			return false;
		}
		if($("input[name='ppp']:checked").length>0){
			var allpp = $("input[name='ppp']:checked");
			var ids="";
			for(var i=0;i<allpp.length;i++){
				
				if(i==0){
					ids+=$(allpp[i]).val();
				}else{
					ids+=","+$(allpp[i]).val();
				}
			}
			$.post("batchDelete2.html",{ids:ids},function(result){
				result=eval("("+result+")");
				if(result.status=="true"||result.status==true){
					alert('成功');
					window.parent.form1.submit();
				}
			});
			
		}else{
			alert('请选择要删除的信息');
			return false;
		}
	}
</script>
</html>
