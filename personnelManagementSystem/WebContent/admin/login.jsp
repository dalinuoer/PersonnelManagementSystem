<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="./login.css" />
    <style>
        ul {
            list-style-type: none;
        }
    </style>
	<script type="text/javascript">
		//验证用户名和密码是否为空
		function verifyLogin() {
			if(!verifyNotNull(document.form1.labourid.value)) {
				alert("公会号不能为空！");
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
	<!-- 存在错误信息弹窗提示 并且用户名回显 -->
	<c:if test="${not empty labourid}">
		<script type="text/javascript">
			alert("公会号或密码错误");
		</script>
	</c:if>

    <div style="height:auto; width:auto;">
        <header class="header">工会人员管理系统</header>
    </div>

    <div class="centerContext">
        <div class="right">
            <div class="body-part">
                <div class="sign">
                    <form  name="form1" action="${pageContext.request.contextPath}/AdminServlet?method=login" method="post" onsubmit="return verifyLogin()">
                        <h2>登录</h2>
                        <input class="input2" type="text" name="labourid" value="${labourid}" placeholder="请输入工会号" />
                        <input class="input2" type="password" name="pwd" placeholder="请输入密码">
                        <input class="sign-btn" type="submit" value="登录">
                    </form>
                </div>
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