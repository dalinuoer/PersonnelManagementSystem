<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>工会人员管理系统</title>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
    
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