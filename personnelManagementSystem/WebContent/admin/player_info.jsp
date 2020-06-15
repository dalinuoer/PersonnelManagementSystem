<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>玩家信息</title>
    <link rel="stylesheet" type="text/css" href="/personnelManagementSystem/admin/message.css" />
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
                <div class="title">玩家信息</div>
            </div>
            <div class="body-part">
				<table border="1">
	    			<tr>
	        			<td>玩家号</td>
	        			<td>${searchedPlayer.id}</td>
	    			</tr>
	    			<tr>
	        			<td>名称</td>
	        			<td>${searchedPlayer.name}</td>
	    			</tr>
	    			<tr>
	        			<td>密码</td>
	        			<td>${searchedPlayer.pwd}</td>
	    			</tr>
	    			<tr>
	        			<td>团体号</td>
	        			<td>${searchedPlayer.groupid}</td>
	    			</tr>
	    			<tr>
	        			<td>修改日期</td>
	        			<td>${searchedPlayer.date}</td>
	    			</tr>
				</table>
				<input type="button" name="back" value ="返回" onclick="window.location.href='/personnelManagementSystem/admin/index.jsp'"/>
            </div>
        </div>
    </div>

    <div class="footer">
        <span>关于我们</span>
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