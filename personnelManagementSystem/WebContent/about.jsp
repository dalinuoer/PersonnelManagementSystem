<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>工会人员管理系统</title>
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
        <div class="right">
            <div class="choose-part">
                <div class="title">关于我们</div>
            </div>

            <div class="body-part">
                <form class="form" action="about_us.jsp" method="post">
                    <ul>
                        <li>QQ:1234567890</li>
                        <li>联系电话：1234567890</li>
                    </ul>
                    <p>
                        <label>信息反馈</label>
                        <input class="sign-text" type="text" name="text" placeholder="请输入反馈信息" style="height:100px" />
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
                <a href="./about.jsp" style="color: white; text-decoration: none">信息反馈</a>
            </li>
        </ul>
    </div>

</body>
</html>