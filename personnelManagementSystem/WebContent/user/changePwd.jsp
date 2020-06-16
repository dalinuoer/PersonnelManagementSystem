<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改密码</title>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
    <script type="text/javascript" src="user/js/verify.js"></script>
    <script type="text/javascript">
        function verifyInfo() {
            //用户名
            if (!verifyUserName(document.form1.name.value)) {
                alert("请按要求填写用户名");
                return false;
            }
            //密码
            if (!verifyPwd(document.form1.pwd.value)) {
                alert("请按照要求填写密码");
                return false;
            }
            //两次密码相同
            if (!verifyConfirmPwd(document.form1.pwd.value, document.form1.confirmpwd.value)) {
                alert("请保证两次输入的密码一致");
                return false;
            }
        }
    </script>
    <link rel="stylesheet" type="text/css" href="user/css/apply_1.css" />
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
                    <a class="a" href="user/main.jsp">首页</a>
                </span>
            </div>
            <div>
                <span>
                    <a class="a" href="GroupServlet?method=findGroupByPage">浏览信息</a>
                </span>
            </div>
            <div>
                <span>
                    <a class="a" href="ApplyServlet?method=findApplyByPlayerId">查看申请</a>
                </span>
            </div>
            <div>
                <span>
                    <a class="a" href="user/personal.jsp">个人信息</a>
                </span>
            </div>
        </div>
        <div class="right">
            <div class="choose-part">
                <div class="title">
                    <form action="" method="post">
                        <span>welcome!</span>
                        <a href="PlayerServlet?method=logout"><input class="logout" type="button" value="注销" /></a>
                    </form>
                </div>

                <div class="body-part">
                    <div class="pos">
                        <form action="PlayerServlet?method=updateByPlayer" name="form1" method="post" onsubmit="return verifyInfo()">
                            <input type="hidden" name="id" value="${sessionScope.player.id }" />
                            <p>
                                enter name!&nbsp;
                                <input type="text" name="name" value="${sessionScope.player.name}" />
                            </p>
                            <p>
                                新密码&nbsp;
                                <input type="password" name="pwd" />
                            </p>

                            <p>
                                再次输入密码&nbsp;
                                <input type="password" name="confirmpwd">
                            </p>
                            <input type="submit" value="提交" />
                        </form>
                    </div>
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