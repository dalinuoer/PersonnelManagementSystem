<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>工会人员管理系统</title>
    <link rel="stylesheet" type="text/css" href="./apply_1.css" />
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
            <div class="body-part">
                <form class="form" action="${pageContext.request.contextPath}/GroupServlet?method=create" method="post">
                    <p>
                        <label for="name">团体名称</label>
                        <input class="sign-text" type="text" name="name" placeholder="请输入团体名称"/>
                    </p>
                    <p>
                        <label for="email">所在公会号</label>
                        <input class="sign-text" type="text" name="labourid" placeholder="请输入所在公会号"/>
                    </p>
                    <p>
                        <label for="text">会长号</label>
                        <input class="sign-text" type="text" name="master" placeholder="请输入会长号"/>
                    </p>
                    <p>
                        <label for="web">团体描述</label>
                        <input class="sign-text" type="text" name="description" placeholder="请输入团体描述" style="height:100px"/>
                    </p>

                    <p class="submit">
                        <input class="sign-btn" type="submit" value="提交" />
                    </p>
                </form>
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