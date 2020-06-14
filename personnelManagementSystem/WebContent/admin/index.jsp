<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="${pageContext.request.contextPath}/admin/">
    <title>工会人员管理系统</title>
    <link  rel="stylesheet" type="text/css" href="./typesetting.css"/>
        <style>
        ul {
            list-style-type: none;
        }
    </style>
</head>
<body>
    <div style="height:auto; width:auto;">
        <header class="header">工会人员管理系统</header>
    </div>

    <div class="centerContext">
    	<div class="left">
            <div>
                <span style="color:darkgrey">
                    系统菜单
                </span>
            </div>
           <div>
                <span>
                    <a class="a" href="./home-page.jsp">首页</a>
                </span>
            </div>
            <div>
                <span>
                    <a class="a" href="./log_in.jsp">登录</a>
                </span>
            </div>
            <div>
                <span>
                    <a class="a" href="./joined.jsp">浏览</a>
                </span>
            </div>
            <div>
                <span>
                    <a class="a" href="./application_group.jsp">申请</a>
                </span>
            </div>
            <div>
                <span>
                    <a class="a" href="./review_no.jsp">审核</a>
                </span>
            </div>
            <div>
                <span>
                    <a class="a" href="./self_information.jsp">个人信息</a>
                </span>
            </div>
            <div>
                <span>
                    <a class="a" href="./about_us.jsp">关于我们</a>
                </span>
            </div>
        </div>
        <div class="right">
            <div class="choose-part">
                <div class="title">首页</div>
            </div>

            <div class="body-part">
                <div id="search">
                    <input type="text" id="input" />
                    <input type="button" id="go" value="搜　 索" />
                </div>
            </div>
        </div>

    </div>

    <div class="footer">
        <span id="we">关于我们</span>
        <ul>
            <li>QQ:1234567890</li>
            <li>联系电话：1234567890</li>
            <li>
                <a href="./about_us.jsp" style="color: white; text-decoration: none">信息反馈</a>
            </li>
        </ul>
    </div>
   
</body>
</html>