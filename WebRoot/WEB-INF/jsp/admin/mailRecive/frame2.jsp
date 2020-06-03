<%@ page language="java" pageEncoding= "UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/taglibs.jsp"%>
<link rel="StyleSheet" href="${ctx }/resource/admin/css/mobile_main.css" type="text/css" />
<html>
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
        
        function hideLoading()
        {
            document.getElementById("over").style.display = "none";
            document.getElementById("layout").style.display = "none";
        }
    </script>
	<body class= "mobile">
<div id="over" class="over"></div>
    <div id="layout" class="layout"><img src="${ctx }/resource/o_31.gif" /></div>
		<form id= "form1" name="form1" method="post" action= "list2.html"
			target= "query">
			<input type="hidden" value="${param.flag }" name="flag"/>
			<table class= "mobile">
				<tr class= "pageheader" height="6%">
					<td colspan= "2">
						垃圾箱
					</td>
				</tr>
				<tr class= "pagesearch" height="5%">
					<td style= "text-align: left;">
						&nbsp;&nbsp;
						标题：
						<input type= "text" name= "keyword" style= "width:100px;">
						&nbsp;&nbsp;
						<input type= "button" class= "btn" value= "查 询 " onClick= "sch();" />
					</td>
				</tr>
			</table>
			<iframe id= "query" name= "query" frameborder= "0" height= "88%"
				width= "100%" scrolling= "yes"></iframe>
		</form>
		<script>
		sch();
		function sch() {
			form1.action= "list2.html";
			form1.submit();
		}
		function keylog() {
			if(window.event.keyCode == 13){
				sch();
			}
		}

		function add(){
		showLoading();
			$.post("getMessage.html", {id:1}, function(result) {
				result = eval("(" + result + ")");
				if (result.status == "true" || result.status == true) {
					form1.action= "list.html";
					form1.submit();
					hideLoading();
				} else {
				}
			});
		}
   </script>
	</body>
</html>
