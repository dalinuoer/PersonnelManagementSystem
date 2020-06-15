<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>工会人员管理系统</title>
    <link rel="stylesheet" type="text/css" href="./login.css" />
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
        <div class="right">
            <div class="body-part">
                <div class="update">
                    <form action="${pageContext.request.contextPath}/AdminServlet?method=update" name="form1" method="post" onsubmit="return verifyLogin()">
                        <h2>信息更新</h2>
                        <input class="input1" type="text" name="id" placeholder="输入账号" />
                        <input class="input1" type="text" name="labourid" placeholder="输入公会号" />
                        <input class="input1" type="password" name="pwd" placeholder="输入新的密码" />
                        <input class="sign-btn" type="submit" value="更新">
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
                <a href="/personnelManagementSystem/about.jsp" style="color: white; text-decoration: none">信息反馈</a>
            </li>
        </ul>
    </div>

</body>
</html>