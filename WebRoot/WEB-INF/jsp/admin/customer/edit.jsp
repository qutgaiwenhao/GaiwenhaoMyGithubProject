<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/taglibs.jsp"%>
<html>
	<head>
		<title>信息内容功能</title>
	</head>
	<body>
		<form id="form1" name="form1" action=""
			method="post">
<input type="hidden" value="${param.flag }" name="flag"/>
			<input type="hidden" value="${map.id }" name="id" id="id" />
			<center>
				<table class="mobile" style="width: 95%;">
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						账号：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input type="text" id="username" value="${map.username }" name="username" style="width: 100%"/>
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						密码：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input type="text" id="password" value="${map.password }" name="password" style="width: 100%"/>
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						姓名：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input type="text" id="customerName" value="${map.customerName }" name="customerName" style="width: 100%"/>
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						性别：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<select id="sex" name="sex">
								<option value="男" ${map.sex=='男'?'selected':'' }>男</option>
								<option value="女" ${map.sex=='女'?'selected':'' }>女</option>
					</select>
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						年龄：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input type="text" id="age" value="${map.age }" name="age" style="width: 100%"/>
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						电话：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input type="text" id="phone" value="${map.phone }" name="phone" style="width: 100%"/>
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						头像：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input id="f_fileImg0" name="cmfile"
						onchange="triggerUploadImg0(this);" title="选择图片" type="file">
						<input class="text" type="hidden" name="headPic" id="bbbbbImg0" value="${map.headPic }">
						<c:if test="${map.headPic!=null }">
						<img style='width:100px;' src="${ctx }/${map.headPic}" id="aaaaaImg0"/>
						</c:if>
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						身份证：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input type="text" id="sfz" value="${map.sfz }" name="sfz" style="width: 100%"/>
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						地址：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input type="text" id="address" value="${map.address }" name="address" style="width: 100%"/>
					</td>
				</tr>
				
		<c:if test="${1==1 }"></c:if>
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
					<td class="outDetail2">
					<select name="isSale">
							<option value="是" ${map.isSale=='是'?'selected':'' }>是</option>
							<option value="否" ${map.isSale=='否'?'selected':'' }>否</option>
					</select>
				</tr>
				 --%>
				<%--
				<tr height="25">					<td class="outDetail" style="width: 30%">图书分类的外键： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2">					
<select name="typeId">
							<c:forEach items="${typeList }" var="lists">
								<option value="${lists.id }" ${map.typeId==lists.id?'selected':'' }>${lists.typeName
									}</option>
							</c:forEach>
					</select>
				</tr>
				 --%>
				</table>
			</center>
			<p align="center">
				<br>
<c:if test="${param.method!='show' }">					<input type="button" class="btn" value="保  存" onclick="save(this);" /></c:if>
				<input type="button" class="btn" value="关  闭"
					onclick="window.close();" />
			</p>
		</form>
	</body>
	<script type="text/javascript">
	function save(src) {
		var username = $("#username").val();
		if($.trim(username)==''){
			alert('账号不能为空');
			return false;
		}
		var password = $("#password").val();
		if($.trim(password)==''){
			alert('密码不能为空');
			return false;
		}
		var customerName = $("#customerName").val();
		if($.trim(customerName)==''){
			alert('姓名不能为空');
			return false;
		}
		<%--
		var phone = $("#phone").val();
 		if(!_isMobile(phone)){
			alert('电话手机号码格式不正确');
			return false;
		}
		var sfz = $("#sfz").val();
 		if(!_isIdCardNo(sfz)){
			alert('身份证身份证格式不正确');
			return false;
		} --%>
		$.post("editSave.html",$("#form1").serializeArray(),
		       function(result){
		        	result = eval("("+result+")");
		    		if(result.status == "true" || result.status == true){
		    			alert('成功');
		    			saveAnd();
		    		}else{
		    			alert('保存失败，请重试');
		    		}
		        }
			);
	}
	function triggerUploadImg0(src) {
		$.ajaxFileUpload({
			url : '${ctx}/file/upload.json',
			secureuri : false,
			fileElementId : 'f_fileImg0',
			dataType : 'json',
			data : {
				fileloc : 'upload/',
				dir : 'temp'
			},
			success : function(data, status) {
				$("#bbbbbImg0").val(data.data.filepath);
				$("#aaaaaImg0").remove();
				$("#bbbbbImg0").after("<img  id='aaaaaImg0' style='width:100px;' src='${ctx}/"+data.data.filepath+"' />");
			},
			error : function(data, status, e) {alert('文件上传失败');}
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
			error : function(data, status, e) {alert('文件上传失败');}
		});
	}
</script>
</html>
