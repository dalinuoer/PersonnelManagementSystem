<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<base href="<%=basePath %>">
<link rel="stylesheet" type="text/css" href="user/css/log_in.css" />
<script type="text/javascript" src="user/js/verify.js"></script>
<script type="text/javascript">
	//验证用户名和密码是否为空
	function verifyLogin() {
		if(!verifyNotNull(document.form1.name.value)) {
			alert("用户名不能为空！");
			return false;
		}
		if(!verifyNotNull(document.form1.pwd.value)) {
			alert("密码不能为空！");
			return false;
		}
	}
</script>
</head>
<body>
<c:if test="${not empty name}">
		<script type="text/javascript">
			alert("用户名或密码错误");
		</script>
	</c:if>
	
<div class="choose">
        <div class="sign">
            <form action="${pageContext.request.contextPath}/PlayerServlet?method=login" name="form1" method="post" onsubmit ="return verifyLogin()">
                <h2>登录</h2>
                <input class="sign-text" type="text" name="name" value="${name}"placeholder="请输入用户名" />
                <input class="sign-text" type="password" name="pwd" placeholder="请输入密码">
                <input class="sign-btn" type="submit"  value="登  录" />
                <p><a class="a" href="user/register.jsp" style="color:white">注册新用户</a></p>
            </form>
        </div>
    </div>
</body>
</html>