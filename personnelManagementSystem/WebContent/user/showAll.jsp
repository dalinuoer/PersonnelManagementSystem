<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> show all group info</title>
    <link rel="stylesheet" type="text/css" href="user/css/apply_1.css" />
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
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
                        <table class="table" border="1" style="text-align:center">
                            <thead>
                                <tr>
                                    <td>团体名称</td>
                                    <td>团体人数</td>
                                    <td>公会名称</td>
                                    <td>团体介绍</td>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${page.list}" var="groupInfo">
                                    <tr>
                                        <td>${groupInfo.name}</td>
                                        <td>${groupInfo.number}</td>
                                        <td>${groupInfo.labourname}</td>
                                        <td>${groupInfo.description}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div>
                        <div style="text-align:center">
                            <%--当前页码为1 --%>
                            <c:if test="${requestScope.page.pageNo == 1}">
                                首页&nbsp;&nbsp;前一页
                            </c:if>

                            <%--当前页码大于1 --%>
                            <c:if test="${requestScope.page.pageNo >1}">
                                <a class="a" href="GroupServlet?method=findGroupByPage">首页</a>&nbsp;
                                <a class="a" href="GroupServlet?method=findGroupByPage&pageNo=${requestScope.page.pageNo - 1}">上一页</a>
                            </c:if>

                            <a href="GroupServlet?method=findGroupByPage&pageNo=${requestScope.page.pageNo}">【${requestScope.page.pageNo}】</a>

                            <%-- 当前页码小于总页码 --%>
                            <c:if test="${requestScope.page.pageNo < requestScope.page.totalNo}">
                                <a class="a" href="GroupServlet?method=findGroupByPage&pageNo=${requestScope.page.pageNo + 1}">下一页</a>&nbsp;
                                <a class="a" href="GroupServlet?method=findGroupByPage&pageNo=${requestScope.page.totalNo}">末页</a>
                            </c:if>

                            <%-- 当前页码等于总页码 --%>
                            <c:if test="${requestScope.page.pageNo == requestScope.page.totalNo}">
                                下一页&nbsp;&nbsp;末页
                            </c:if>
                        </div>
                        <div style="text-align:center">
                            一共有 ${requestScope.page.countNo} 条记录&nbsp;&copy;&nbsp;
                            一共有 ${requestScope.page.totalNo} 页&nbsp;
                        </div>
                    </div>
                    <div style="text-align:center">
                        跳转到第 <input type="text" value="${requestScope.page.pageNo}" id="goPageNo" /> 页&nbsp;
                        <input class="button" type="button" id="goBtn" value="跳转" />
                    </div>
                    <script type="text/javascript">
                        window.onload = function () {
                            var goBtn = document.getElementById("goBtn");
                            goBtn.onclick = function () {
                                var goPageNo = document.getElementById("goPageNo").value;
                                goPageNo = parseInt(goPageNo);
                                if (isNaN(goPageNo)) {
                                    alert('页码不是数值！');
                                    document.getElementById("goPageNo").value = 1;
                                    return;
                                }
                                window.location.href = "GroupServlet?method=findGroupByPage&pageNo=" + goPageNo;
                            };
                        };
                    </script>

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
</html>>