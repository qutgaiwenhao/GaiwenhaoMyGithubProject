<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script>
var ctx='${ctx}';
</script>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <link rel="stylesheet" href="${ctx }/resource/mine/11/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx }/resource/mine/11/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctx }/resource/mine/11/css/fontastic.css">
    <link rel="stylesheet" href="${ctx }/resource/mine/11/css/style.default.css" id="theme-stylesheet">
    <link rel="stylesheet" href="${ctx }/resource/mine/11/css/custom.css">
    <script type="text/javascript" src="${ctx }/resource/check.js"></script>
    <link rel="shortcut icon" href="img/favicon.ico">
  </head>
  <body>
    <div class="page login-page">
      <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
          <div class="row">
            <div class="col-lg-6">
              <div class="info d-flex align-items-center">
                <div class="content">
                  <div class="logo">
                    <h1>网页邮箱系统</h1>
                  </div>
                  <p>采用网易126邮箱</p>
                </div>
              </div>
            </div>
            <div class="col-lg-6 bg-white" >
              <div class="form d-flex align-items-center">
                <div class="content">
                  <form action="" method="post" id="login_form">
                    <div class="form-group">
                      <input  type="text" id="login_username" name="username"  class="input-material">
                      <label for="login-username" class="label-material">账号</label>
                    </div>
                    <div class="form-group">
                      <input name="password" id="login_password" type="password"   class="input-material">
                      <label for="login-password" class="label-material">密码</label>
                    </div>
                    <%--
                    <div class="form-group">
                      <input name="yzm" id="login_yzm" type="text"   class="input-material">
                      <img src="${ctx }/public/image/validateImg.html" id="tuxingyanzhengma" onClick="reloadcode();" style="border:1px solid red;cursor: pointer;">
                      <label for="login-password" class="label-material">验证码</label>
                    </div> --%>
                    <div class="form-group">
                    	  角色：<select class="input-material" name="type" id="type">
			            	<option value="用户">用户</option>
			            	<option value="超级管理员">超级管理员</option>
			           </select>
                    </div>
                    <a id="login"  onclick="loginCheck();" href="#" class="btn btn-primary">登录</a><br>
                    <%--<a href="#" class="forgot-pass">忘记密码？</a> <br>--%>
                  <a href="javascript:showRegistercustomer();" class="signup">用户注册</a>
                  </form>
                  <form action="" method="post" id="registerFormcustomer" style="display: none;">
                    <div class="form-group">
                      <input  type="text" id="customer_username" name="username"  class="input-material">
                      <label for="login-username" class="label-material">账号</label>
                    </div>
                    <div class="form-group">
                      <input id="customer_password" name="password" type="password"   class="input-material">
                      <label for="login-password" class="label-material">密码</label>
                    </div>
                    <div class="form-group">
                      <input  type="text" id="customer_customerName" name="customerName"  class="input-material">
                      <label for="login-username" class="label-material">姓名</label>
                    </div>
                    <div class="form-group">
                     	 性别：<select class="username" id="customer_sex" name="sex">
								<option value="男">男</option>
								<option value="女">女</option>
					</select>
                    </div>
                    <div class="form-group">
                      <input  type="text" id="customer_age" name="age"  class="input-material">
                      <label for="login-username" class="label-material">年龄</label>
                    </div>
                    <div class="form-group">
                      <input  type="text" id="customer_phone" name="phone"  class="input-material">
                      <label for="login-username" class="label-material">电话</label>
                    </div>
                    <div class="form-group">
                      <input  type="text" id="customer_sfz" name="sfz"  class="input-material">
                      <label for="login-username" class="label-material">身份证</label>
                    </div>
                    <div class="form-group">
                      <input  type="text" id="customer_address" name="address"  class="input-material">
                      <label for="login-username" class="label-material">地址</label>
                    </div>
                   
                    
                    <a id="login"  onclick="registerSavecustomer();" href="#" class="btn btn-primary">注册</a>
                    <br>
                    <%--<a href="#" class="forgot-pass">忘记密码？</a> <br>--%>
                  <small>我有账号，我要 </small><a href="javascript:showLogin();" class="signup">登录</a>
                  </form>
                  
                  
                  
                  
                  
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <%--
      <div class="copyrights text-center">
        <p>Design by <a href="#" class="external">Bootstrapious</a>
        </p>
      </div> --%>
    </div>
    <script src="${ctx }/resource/mine/11/vendor/jquery/jquery.min.js"></script>
    <script src="${ctx }/resource/mine/11/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="${ctx }/resource/mine/11/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="${ctx }/resource/mine/11/vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="${ctx }/resource/mine/11/vendor/chart.js/Chart.min.js"></script>
    <script src="${ctx }/resource/mine/11/vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="${ctx }/resource/mine/11/js/front.js"></script>
    <script type="text/javascript">
    function reloadcode(){
	    document.getElementById("tuxingyanzhengma").src="${ctx }/public/image/validateImg.html?id="+new Date().getTime();
	}
    
    
    function showRegistercustomer(){
		$("#login_form").hide();
		$("#registerFormcustomer").show();
	}
	function showLogin(){
		$("#login_form").show();
		$("#registerFormcustomer").hide();
	}	
	function loginCheck(){
		var username = $("#login_username").val();
		var password = $("#login_password").val();
		var type = $("#type").val();
		if(username==''||password==''){
			alert('用户名和密码必须填写');
			return false;
		}
		<%--
		var login_yzm = $("#login_yzm").val();
		if(login_yzm==''){
			alert('验证码不能为空');
			return false;
		}
		 --%>
		var aa="";
		var bb="";
		if(type=='用户'){
			aa="${ctx}/customerLogin/save.html";
			bb="${ctx}/customer/index.html";
		}else{
			aa="${ctx}/adminLogin/save.html";
			bb="${ctx}/admin/index.html";
		}
		$.ajax({
		      type: "POST",
		      async:false,  // 设置同步方式
		      cache:false,
		      url: aa,
				data:$("#login_form").serializeArray(),
				success:function(result){
				result = eval("("+result+")");
				if(result.status=='true'||result.status==true){
					if(result.msg=='1'){
						alert('登录成功');
						window.location.href=bb;
					}else if(result.msg=='0'){
						alert('密码或用户名错误');
					}else if(result.msg=='5'){
						alert('验证码错误，请重新输入');
						reloadcode();
						$("#login_yzm").val("");
					}
				}
		      }
			});
	}
	function registerSavecustomer(){
		var username = $("#customer_username").val();
		var password = $("#customer_password").val();
		if(username==''||password==''){
			alert('用户名和密码必须填写');
			return false;
		}
		
		var phone = $("#customer_phone").val();
 		if(!_isMobile(phone)){
			alert('电话手机号码格式不正确');
			return false;
		}
		var sfz = $("#customer_sfz").val();
 		if(!_isIdCardNo(sfz)){
			alert('身份证身份证格式不正确');
			return false;
		}
		
		
		
		$.ajax({
		      type: "POST",
		      async:false,  // 设置同步方式
		      cache:false,
		      url: "${ctx}/customerLogin/registerSave.html",
				data:$("#registerFormcustomer").serializeArray(),
				success:function(result){
				result = eval("("+result+")");
				if(result.status=='true'||result.status==true){
						alert('注册成功');
						window.location.href="${ctx}/customer/index.html";
				}else{
					alert(result.msg);
				}
		      }
			});
	}
    
    
    </script>
  </body>
</html>