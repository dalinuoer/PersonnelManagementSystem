<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>工会人员管理系统</title>
    <link rel="stylesheet" type="text/css" href="./typesetting.css"/>
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
        <div class="right">
            <div class="choose-part">
                <div class="title">首页</div>
            </div>

            <div class="body-part">
                <div id="search">
                	<input type="button" name="adminLogin" value ="管理员登录" onclick="window.location.href='admin/login.jsp'"/>
                	<input type="button" name="playerLogin" value ="玩家登录" onclick="window.location.href='user/login.jsp'"/>
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
                <a href="./about.jsp" style="color: white; text-decoration: none">信息反馈</a>
            </li>
        </ul>
    </div>
   
</body>
</html>