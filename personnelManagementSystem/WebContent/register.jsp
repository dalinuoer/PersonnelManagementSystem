<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>工会人员管理系统</title>
    <link rel="stylesheet" type="text/css" href="./log_in.css" />
    <style>
        ul {
            list-style-type: none;
        }
    </style>
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
	}
</script>
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
                <a class="a" href="./log_in.jsp">登录</a>
                <span>/</span>
                <a class="a" href="./register.jsp">注册</a>
            </div>
            <div class="body-part">
                <div class="sign">
                    <form action="${pageContext.request.contextPath}/PlayerServlet?method=register" name="form1" method="post" onsubmit="return verifyLogin()">
                        <h2>注册</h2>
                        <input class="input1" type="text" name="name" placeholder="输入用户名" />
                        <input class="input1" type="password" name="pwd" placeholder="输入密码">
                        <input class="sign-btn" type="submit" value="注册">
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