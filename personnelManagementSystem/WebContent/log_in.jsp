<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="./log_in.css" />
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
                    <form  action="log_in.jsp" method="post">
                        <h2>登录</h2>
                        <input class="sign-text" type="text" placeholder="请输入账号" />
                        <input class="sign-text" type="password" placeholder="请输入密码">
                        <input class="sign-btn" type="submit" value="登录">
                        <p>
                            <label class="sign-cek">
                                <input type="checkbox" name="sex" value="1">记住密码
                            </label>
                        </p>
                        <span><a class="a" href="./register.jsp" style="color:white">注册新用户</a></span>
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