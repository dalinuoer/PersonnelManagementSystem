<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="./message.css" />
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
                <div class="title">我的信息</div>
            </div>

            <div class="body-part">

                <form class="form" action="self_information.jsp" method="post" >
                    <p>姓名<input class="sign-text" type="text" name="user"></p>
                    <p>编号<input class="sign-text" type="text" name="ID"></p>
                    <p class="sign-cek">
                        性别
                        <input type="checkbox" name="sex" value="1">男
                        <input type="checkbox" name="sex" value="2">女
                    </p>
                    <p>密码<input class="sign-text" type="text" name="secret"></p>
                    <p>电话<input class="sign-text" type="text" name="telephone"></p>
                    <p>邮箱<input class="sign-text" type="text" name="email"></p>
                    <p>籍贯<input class="sign-text" type="text" name="address"></p>
                    <p>备注<input class="sign-text" type="text" name="text"></p>
                    <p><input class="sign-btn" type="submit" value="提交"></p>
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