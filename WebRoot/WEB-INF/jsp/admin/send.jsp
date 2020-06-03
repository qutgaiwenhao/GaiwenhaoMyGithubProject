<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<html>
<head>
<title></title>
<%@taglib prefix="ckeditor" uri="http://ckeditor.com"%>
<script type="text/javascript"
	src="${ctx}/resource/admin/js/ajaxfileupload.js"></script>
<style type="text/css">
body {
        width:auto; margin-top:12px; 
      font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
      font-size:19px; 
      color:#999999;
      line-height:25px;
      letter-spacing:1px
      }
</style>

    <style type="text/css">
        .current a {
            font-size: 20px;
        }

        .over {
            display: none;
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: #f5f5f5;
            opacity:0.5;
            z-index: 1000;
        }

        .layout {
            display: none;
            position: absolute;
            top: 40%;
            left: 40%;
            width: 20%;
            height: 20%;
            z-index: 1001;
            text-align:center;
        }
    </style>
    <script type="text/javascript">
        function showLoading()
        {
            document.getElementById("over").style.display = "block";
            document.getElementById("layout").style.display = "block";
        }
    </script>
</head>
<body>
<div id="over" class="over"></div>
    <div id="layout" class="layout"><img src="${ctx }/resource/o_31.gif" /></div>
	<p>邮件发送</p><br/>
	<form id="form1" name="form1">
	收件箱：<input type="text" style="width: 400px;" name="v1" id="v1"/><input type="button" value="选择通讯录" onclick="chooseTxl();"/><br/>
	标题：<input type="text" style="width: 200px;" name="v2" id="v2"/><br/>
	内容：<textarea rows="8" cols="100" name="v3" id="v3"></textarea><ckeditor:replace
							replace="v3" basePath="${ctx }/resource/plugin/ckeditor/" /><br/>
	附件：<input id="f_file" name="cmfile" onchange="triggerUpload(this);" title="选择文件" type="file">
						<input class="text" type="hidden" id="v5" name="v5">
						<input class="text" type="hidden" id="v6" name="v6">
	<br>
	是否存入草稿：<select name="status"> 
		<option value="1">发送</option>
		<option value="0">存入草稿</option>
	</select>
	<br>
	
	</form>
	<input type="button" value="发送" onclick="saveSend();"/>
</body>
<script type="text/javascript">
	function saveSend(){
		var v1 = $("#v1").val();
		if(v1==''){
			alert('邮箱不能为空');
		}
		var v2 = $("#v2").val();
		if(v2==''){
			alert('标题不能为空');
		}
		$("#v3").val(CKEDITOR.instances.v3.getData());
		showLoading();
		$.post("sendSave.html", $("#form1").serializeArray(), function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('发送成功');
				window.location.reload();
			} else {
				alert('发送失败，请重试');
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
				$("input[name='v6']").val(data.data.filepath);
				$("input[name='v5']").val(data.data.filename);
				$("#aaa").remove();
				$("#v6").after("<a id='aaa' href='${ctx}/"+data.data.filepath+"'>"+data.data.filename+"</a>");
				alert('上传成功');
			},
			error : function(data, status, e) {
				alert('文件上传失败');
			}
		});
	}
	
	function chooseTxl(){
		MyWindow.OpenCenterWindow('selectTxt.html','addOld',500,600);
	}
</script>
</html>