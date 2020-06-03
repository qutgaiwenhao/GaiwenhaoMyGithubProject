<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/taglibs.jsp"%>
<script type="text/javascript" src="${ctx}/js/easy_validator.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.bgiframe.min.js"></script>
<script type="text/javascript"
	src="${ctx }/resource/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="${ctx}/resource/admin/js/ajaxfileupload.js"></script>
<link href="${ctx}/css/validate.css" rel="stylesheet" type="text/css" />
<html>
<head>
<title>信息内容功能</title>
</head>
<body>
	<form id="form1" name="form1" action="" method="post">
		<input type="hidden" value="${map.id }" name="id" id="id" />
		<center>
			<table class="mobile" style="width: 95%;">
				<tr class="pageheader">
					<td colspan="2"><strong>信息处理</strong></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">收件人： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2"><input type="text" value="${map.v1 }"
						name="v1" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">标题： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2"><input type="text" value="${map.v2 }"
						name="v2" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">内容： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2"><input type="text" value="${map.v3 }"
						name="v3" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">发送时间： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2"><input type="text" value="${map.v4 }"
						name="v4" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">附件名称： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2"><input type="text" value="${map.v5 }"
						name="v5" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">附件地址： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2"><input type="text" value="${map.v6 }"
						name="v6" /></td>
				</tr>
				<%--<input name="newDate" id="newDate" value="${map.newDate }" type="text" onClick="WdatePicker()"/> --%>
				<%--
				<tr height="25">
					<td class="outDetail" style="width: 30%">图片： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2"><input id="f_file" name="cmfile"
						onchange="triggerUpload(this);" title="选择图片" type="file">
						<input class="text" type="hidden" name="img" value="${map.img }">
						<img id="imgUrlShow" style="width: 100px;" src="${ctx}/${map.img }" />
					</td>
				</tr>
				--%>
				<%--
				<tr height="25">
					<td class="outDetail" style="width: 30%">是否特价： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2"><select name="isSale">
							<option value="0" ${bean.isSale==0?'selected':'' }>否</option>
							<option value="1" ${bean.isSale==1?'selected':'' }>是</option>
					</select>
				</tr>
				 --%>
				<%--
				<tr height="25">
					<td class="outDetail" style="width: 30%">图书分类的外键： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2"><select name="typeId">
							<c:forEach items="${typeList }" var="typeLists">
								<option value="${typeLists.id }" ${bean.typeId==typeLists.id?'selected':'' }>${typeLists.typeName
									}</option>
							</c:forEach>
					</select>
				</tr>
				 --%>
			</table>
		</center>
		<p align="center">
			<br> <input type="button" class="btn" value="保  存"
				onclick="save(this);" /> <input type="button" class="btn"
				value="关  闭" onclick="window.close();" />
		</p>
	</form>
</body>
<script type="text/javascript">
	function save(src) {
		$.post("editSave.html", $("#form1").serializeArray(), function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('成功');
				saveAnd();
			} else {
				alert('保存失败，请重试');
			}
		});
	}
	function triggerUpload(src) {
		$.ajaxFileUpload({
			url : '${ctx}/file/upload.json',
			secureuri : false,
			fileElementId : 'f_file',
			dataType : 'json',
			data : {
				fileloc : 'upload/',
				dir : 'temp'
			},
			success : function(data, status) {
				$("input[name='img']").val(data.data.filepath);
				$("#imgUrlShow").attr("src",
						"${ctx}/" + data.data.filepath + "");
			},
			error : function(data, status, e) {
				alert('文件上传失败');
			}
		});
	}
</script>
</html>
