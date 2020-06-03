<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
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
    <title>主页</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <link rel="stylesheet" href="${ctx }/resource/mine/11/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx }/resource/mine/11/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctx }/resource/mine/11/css/fontastic.css">
    <link rel="stylesheet" href="${ctx }/resource/mine/11/css/style.default.css" id="theme-stylesheet">
    <link rel="stylesheet" href="${ctx }/resource/mine/11/css/custom.css">
    <link rel="shortcut icon" href="${ctx }/resource/mine/11/img/favicon.ico">
    <style type="text/css">
    html,body{
	    margin: 0;
	    padding: 0;
	    border: 0;
	    overflow: hidden;
	    height: 100%;
	}
    </style>
  </head>
  <body>
    <div class="page">
      <!-- Main Navbar-->
      <header class="header">
        <nav class="navbar">
          <!-- Search Box-->
          <div class="search-box">
            <button class="dismiss"><i class="icon-close"></i></button>
            <form id="searchForm" action="#" role="search">
              <input type="search" placeholder="What are you looking for..." class="form-control">
            </form>
          </div>
          <div class="container-fluid">
            <div class="navbar-holder d-flex align-items-center justify-content-between">
              <!-- Navbar Header-->
              <div class="navbar-header">
                <a href="index.html" class="navbar-brand d-none d-sm-inline-block">
                  <div class="brand-text d-none d-lg-inline-block"><strong>网页邮箱系统</strong></div>
                  <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>网页邮箱系统</strong></div></a>
                <a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
              </div>
              <!-- Navbar Menu -->
              <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
              	<%--
                <!-- Search-->
                <li class="nav-item d-flex align-items-center"><a id="search" href="#"><i class="icon-search"></i></a></li> --%>
                <!-- Notifications-->
                <%--
                <li class="nav-item dropdown" title="系统通知"> <a id="notifications" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link"><i class="fa fa-bell-o"></i><span class="badge bg-red badge-corner">12</span></a>
                  <ul aria-labelledby="notifications" class="dropdown-menu">
                    <li><a rel="nofollow" href="#" class="dropdown-item"> 
                        <div class="notification">
                          <div class="notification-content" style="width: 200px;overflow: hidden;"><i class="fa fa-envelope bg-green"></i>sdfasd啥的发生的发生大法师阿是的发送到发生的发的放 </div>
                          <div class="notification-time"><small>2019-11-11 12:12:12</small></div>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item all-notifications text-center"> <strong>查看全部                                          </strong></a></li>
                  </ul>
                </li>
                <li class="nav-item dropdown" title="个人消息"> <a id="messages" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link"><i class="fa fa-envelope-o"></i><span class="badge bg-orange badge-corner">10</span></a>
                  <ul aria-labelledby="notifications" class="dropdown-menu">
                    <li><a rel="nofollow" href="#" class="dropdown-item d-flex"> 
                        <div class="msg-body" style="width: 200px;overflow: hidden;">
                          <h3 class="h5">小明</h3><span>asdfasdfa打算发多少发送的发大所发生的发</span>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item all-notifications text-center"> <strong>查看全部    </strong></a></li>
                  </ul>
                </li> --%>
                <!-- Languages dropdown    -->
                <%--
                <li class="nav-item dropdown"><a id="languages" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link language dropdown-toggle"><img src="${ctx }/resource/mine/11/img/flags/16/GB.png" alt="English"><span class="d-none d-sm-inline-block">English</span></a>
                  <ul aria-labelledby="languages" class="dropdown-menu">
                    <li><a rel="nofollow" href="#" class="dropdown-item"> <img src="${ctx }/resource/mine/11/img/flags/16/DE.png" alt="English" class="mr-2">German</a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item"> <img src="${ctx }/resource/mine/11/img/flags/16/FR.png" alt="English" class="mr-2">French                                         </a></li>
                  </ul>
                </li> --%>
                <li class="nav-item"><a href="${ctx }/adminLogin/out.html" class="nav-link logout"> <span class="d-none d-sm-inline">注销</span><i class="fa fa-sign-out"></i></a></li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
      <div class="page-content d-flex align-items-stretch"> 
        <nav class="side-navbar">
        <%-- --%>
          <div class="sidebar-header d-flex align-items-center">
          	<%--
            <div class="avatar"><img src="${ctx }/resource/mine/11/img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div> --%>
            <div class="title">
              <h1 class="h4">超级管理员</h1>
              <p>角色：超级管理员</p>
            </div>
          </div>
          <span class="heading">菜单</span>
          <ul class="list-unstyled" >
               <li class="xiaoguo active"><a href="#exampledropdownDropdown" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>个人中心</a>
                 <ul id="exampledropdownDropdown" class="collapse list-unstyled ">
                   <li class="colorchange"><a href="${ctx}/admin/password.html"  target="mainiframe">修改密码</a></li>
                 </ul>
               </li>
               
               <li class="xiaoguo"><a href="#exampledropdownDropdown2" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>人员管理</a>
	               <ul id="exampledropdownDropdown2" class="collapse list-unstyled ">
	                   <li class="colorchange"><a href="${ctx }/admin/customer/frame.html?flag=1"  target="mainiframe">用户管理</a></li>
	               </ul>
               </li>
               <%--
               <li class="colorchange xiaoguo"><a href="${ctx}/admin/student/frame.html?flag=1" target="mainiframe"><i class="icon-interface-windows"></i>个人中心</a></li>
               <li class="xiaoguo active"><a href="#exampledropdownDropdown" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>消息通知</a>
                 <ul id="exampledropdownDropdown" class="collapse list-unstyled ">
                   <li class="colorchange"><a href="#" target="mainiframe">菜单一</a></li>
                   <li class="colorchange"><a href="#" target="mainiframe">菜单二</a></li>
                   <li class="colorchange"><a href="#" target="mainiframe">菜单三</a></li>
                 </ul>
               </li> --%>
          </ul>
         <%-- <span class="heading">Extras</span>
          <ul class="list-unstyled">
            <li> <a href="#" target="mainiframe"> <i class="icon-flask"></i>Demo </a></li>
            <li> <a href="#" target="mainiframe"> <i class="icon-screen"></i>Demo </a></li>
            <li> <a href="#" target="mainiframe"> <i class="icon-mail"></i>Demo </a></li>
            <li> <a href="#" target="mainiframe"> <i class="icon-picture"></i>Demo </a></li>
          </ul> --%>
        </nav>
        <div class="content-inner">
          <iframe name="mainiframe"  scrolling= "no"  frameborder= "0"  style="width: 100%;" height="2000" src="main.html"></iframe>
        </div>
      </div>
    </div>
    <script src="${ctx }/resource/mine/11/vendor/jquery/jquery.min.js"></script>
    <script src="${ctx }/resource/mine/11/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="${ctx }/resource/mine/11/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="${ctx }/resource/mine/11/vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="${ctx }/resource/mine/11/vendor/chart.js/Chart.min.js"></script>
    <script src="${ctx }/resource/mine/11/vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="${ctx }/resource/mine/11/js/charts-home.js"></script>
    <!-- Main File-->
    <script src="${ctx }/resource/mine/11/js/front.js"></script>
    <script type="text/javascript">
    	$(".colorchange").click(function(){
    		if($(this).hasClass("xiaoguo")){
    			$(".xiaoguo").removeClass("active");
    			$(this).addClass("active");
    			
    		}else{
    			$(".xiaoguo").removeClass("active");
    			$(this).parent().parent().addClass("active");
    		}
    	});
    </script>
  </body>
</html>