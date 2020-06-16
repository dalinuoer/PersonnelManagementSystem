<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="po.Player"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<link rel="stylesheet" type="text/css" href="user/css/apply_1.css" />
<title>show personal information </title>
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
                    <div>
                        <p>我的信息</p>
                        <%
                        //检测用户是否已经登陆
                        Object player = session.getAttribute("player");
                        if(player == null){
                        response.sendRedirect("/user/login.jsp");
                        }
                        %>
                        <p>名称：${sessionScope.player.name} </p>
                    </div>
                    <div>
                        <c:choose>
                            <c:when test="${sessionScope.player.groupid == 0}">
                                <p>您当前没加入任何团体</p>
                            </c:when>
                            <c:otherwise>
                                <a href="GroupServlet?method=findGroupById&groupid=${sessionScope.player.groupid }">点击查看所在组 </a>
                                <c:if test="${not empty requestScope.group}">

                                       当前所在组 &nbsp;
                                    ${requestScope.group.name}
                                <div>
                                    <div class="show">
                                        组人数&nbsp;   ${requestScope.number}
                                    </div>
                                    <div class="show">
                                        组信息&nbsp;${requestScope.group.description}
                                    </div>
                                </div>
                                </c:if>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div>
                        <a class="a" href="user/changePwd.jsp">修改密码</a>
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