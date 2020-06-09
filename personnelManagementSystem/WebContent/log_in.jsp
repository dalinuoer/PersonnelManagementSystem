<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="./log_in.css" />
    <style>
        ul {
            list-style-type: none;
        }
    </style>
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
	<!-- 存在错误信息弹窗提示 并且用户名回显 -->
	<c:if test="${not empty name}">
		<script type="text/javascript">
			alert("用户名或密码错误");
		</script>
	</c:if>

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
        </div> -->
        <div class="right">
            

            <div class="choose-part">
                <a class="a" href="./log_in.jsp">登录</a>
                <span>/</span>
                <a class="a" href="./register.jsp">注册</a>
            </div>
            <div class="body-part">
                <div class="sign">
                    <form  name="form1" action="${pageContext.request.contextPath}/PlayerServlet?method=login" method="post" onsubmit="return verifyLogin()">
                        <h2>登录</h2>
                        <input class="input2" type="text" name="name" value="${name}" placeholder="请输入用户名" />
                        <input class="input2" type="password" name="pwd" placeholder="请输入密码">
                        <input class="sign-btn" type="submit" value="登录">
                        <p>
                            <label class="sign-cek">
                                <input type="checkbox" name="sex" value="1">记住密码
                            </label>
                        </p>
                        <span><a class="a" href="register.jsp" style="color:white">注册新用户</a></span>
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
                <a href="./about_us.jsp" style="color: white; text-decoration: none">信息反馈</a>
            </li>
        </ul>
    </div>

</body>
</html>