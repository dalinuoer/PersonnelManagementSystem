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
        <header class="header">工会人员管理系统 欢迎${admin.labourid}工会的管理员!</header>
    </div>
    

    <div class="centerContext">
    	<div class="left">
    		<div style="height:auto; width:auto;">
         		<a href="${pageContext.request.contextPath}/AdminServlet?method=logout" style="color: black; text-decoration: none">注销</a>
    		</div>
           	<div>
                <span style="color:darkgrey">系统菜单</span>
            </div>
           	<div>
                <span>
                    <a class="a" href="./index.jsp">首页</a>
                </span>
                <span>
                    <a class="a" href="./update.jsp">修改密码</a>
                </span>
                <span>
                    <a class="a" href="./update_player.jsp">修改玩家信息</a>
                </span>
                <span>
                    <a class="a" href="./search_player.jsp">查找玩家信息</a>
                </span>
                <span>
                    <a class="a" href="./search_group.jsp">查找团体信息</a>
                </span>
                <span>
                    <a class="a" href="./create_group.jsp">创建团体</a>
                </span>
                <span>
                    <a class="a" href="./delete_group.jsp">删除团体</a>
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