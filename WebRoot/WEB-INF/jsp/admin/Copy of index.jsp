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
                <li class="nav-item dropdown" title="系统通知"> <a id="notifications" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link"><i class="fa fa-bell-o"></i><span class="badge bg-red badge-corner">${tongzhiSize }</span></a>
                  <ul aria-labelledby="notifications" class="dropdown-menu">
                    <li>
                    	<c:forEach items="${tongzhiList }" var="lists">
	                    <a rel="nofollow" href="#" class="dropdown-item"> 
	                        <div class="notification">
	                          <div class="notification-content" style="width: 200px;overflow: hidden;"><i class="fa fa-envelope bg-green"></i>${lists.title }</div>
	                          <div class="notification-time"><small><fmt:formatDate value="${lists.insertDate}" type="date" pattern="yyyy-MM-dd HH:mm"/></small></div>
	                        </div>
	                    </a>
	                    </c:forEach>
                    </li>
                    <li><a rel="nofollow" href="${ctx }/admin/tongzhi/frame.html" target="mainiframe" class="dropdown-item all-notifications text-center"> <strong>查看全部</strong></a></li>
                  </ul>
                </li>
                <li class="nav-item dropdown" title="个人消息"> <a id="messages" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link"><i class="fa fa-envelope-o"></i><span class="badge bg-orange badge-corner">${messageSize }</span></a>
                  <ul aria-labelledby="notifications" class="dropdown-menu">
                    <li>
                    	<c:forEach items="${messageList }" var="lists">
	                    <a rel="nofollow" href="#" class="dropdown-item"> 
	                        <div class="notification">
	                          <div class="notification-content" style="width: 200px;overflow: hidden;"><i class="fa fa-envelope bg-green"></i>${lists.title }</div>
	                          <div class="notification-time"><small><fmt:formatDate value="${lists.insertDate}" type="date" pattern="yyyy-MM-dd HH:mm"/></small></div>
	                        </div>
	                    </a>
	                    </c:forEach>
                    </li>
                    <li><a rel="nofollow" target="mainiframe" href="${ctx }/admin/message/frame.html?flag=1" class="dropdown-item all-notifications text-center"> <strong>查看全部    </strong></a></li>
                  </ul>
                </li>
                --%>
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
            <div class="avatar"><img src="${ctx }/${customerBean.headPic}" alt="..." class="img-fluid rounded-circle"></div> --%>
            <div class="title">
              <h1 class="h4">账号：(${adminBean.username })</h1>
              <%--<p>姓名：</p> --%>
            </div>
          </div>
          <span class="heading">菜单</span>
          <ul class="list-unstyled" >
               <li class="xiaoguo active"><a href="#exampledropdownDropdown" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>个人中心</a>
                 <ul id="exampledropdownDropdown" class="collapse list-unstyled ">
                   <li class="colorchange"><a href="${ctx}/admin/password.html"  target="mainiframe">修改密码</a></li>
                 </ul>
               </li>
               
               <li class="xiaoguo"><a href="#exampledropdownDropdown0" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>管理</a>
	               <ul id="exampledropdownDropdown0" class="collapse list-unstyled ">
	                   <li class="colorchange"><a href="${ctx}/admin/delete/frame.html?flag=1"  target="mainiframe">管理</a></li>
	               </ul>
               </li>
               <li class="xiaoguo"><a href="#exampledropdownDropdown1" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>广告或敏感词汇管理</a>
	               <ul id="exampledropdownDropdown1" class="collapse list-unstyled ">
	                   <li class="colorchange"><a href="${ctx}/admin/ggc/frame.html?flag=1"  target="mainiframe">广告或敏感词汇管理</a></li>
	               </ul>
               </li>
               <li class="xiaoguo"><a href="#exampledropdownDropdown2" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>黑名单管理</a>
	               <ul id="exampledropdownDropdown2" class="collapse list-unstyled ">
	                   <li class="colorchange"><a href="${ctx}/admin/hmd/frame.html?flag=1"  target="mainiframe">黑名单管理</a></li>
	               </ul>
               </li>
               <li class="xiaoguo"><a href="#exampledropdownDropdown3" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>邮件接收管理</a>
	               <ul id="exampledropdownDropdown3" class="collapse list-unstyled ">
	                   <li class="colorchange"><a href="${ctx}/admin/mail_recive/frame.html?flag=1"  target="mainiframe">邮件接收管理</a></li>
	               </ul>
               </li>
               <li class="xiaoguo"><a href="#exampledropdownDropdown4" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>邮件发送管理</a>
	               <ul id="exampledropdownDropdown4" class="collapse list-unstyled ">
	                   <li class="colorchange"><a href="${ctx}/admin/mail_send/frame.html?flag=1"  target="mainiframe">邮件发送管理</a></li>
	               </ul>
               </li>
               <li class="xiaoguo"><a href="#exampledropdownDropdown5" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>通讯录管理</a>
	               <ul id="exampledropdownDropdown5" class="collapse list-unstyled ">
	                   <li class="colorchange"><a href="${ctx}/admin/txl/frame.html?flag=1"  target="mainiframe">通讯录管理</a></li>
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
          <iframe name="mainiframe"  scrolling= "no"  frameborder= "0"  style="width: 100%;" height="2000" src="${ctx }/admin/main.html"></iframe>
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
