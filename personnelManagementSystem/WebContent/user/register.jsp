<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<base href="<%=basePath %>">
<link rel="stylesheet" type="text/css" href="user/css/log_in.css" />
<script type="text/javascript" src="user/js/verify.js"></script>
<script type="text/javascript">
	function verifyInfo() {
		//用户名
		if(!verifyUserName(document.form1.name.value)) {
			alert("请按要求填写用户名");
			return false;
		}
		//密码
		if(!verifyPwd(document.form1.pwd.value)) {
			alert("请按照要求填写密码");
			return false;
		}
		//两次密码相同
		if(!verifyConfirmPwd(document.form1.pwd.value, document.form1.confirmpwd.value)) {
			alert("请保证两次输入的密码一致");
			return false;
		}
	}
	</script>
</head>
<body>
 <div class="choose">
        <div class="sign">
            <form action="${pageContext.request.contextPath}/PlayerServlet?method=register" name="form1" method="post" onsubmit="return verifyInfo()">
            
                <h2>注册</h2>
                <input class="sign-text" type="text" name="name" placeholder="用户名"/>
                <input class="sign-text" type="password" name="pwd"  placeholder="密码" >
                <input class="sign-text" type="password" name="confirmpwd" placeholder="再次输入密码"> 
                <p><input class="sign-btn" type="submit" value="注册"></p>
                <p>
                    <a class="a" href="user/login.jsp" style="color:white">返回登录</a>
                </p>
            </form>
        </div>
    </div>

</body>
</html>