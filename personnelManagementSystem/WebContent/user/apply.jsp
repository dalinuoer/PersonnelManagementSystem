<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看申请</title>
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
                        <c:choose>
                            <c:when test="${not empty requestScope.apply}">
                                <p>申请内容&nbsp;&nbsp;${requestScope.apply.content}</p>
                                <p>申请日期&nbsp;&nbsp;${requestScope.apply.date}</p>
                                <p>审核状态&nbsp;&nbsp;</p>
                                <c:if test="${requestScope.apply.status==0 }"> 未审核</c:if>
                                <c:if test="${requestScope.apply.status==-1 }"> 未通过</c:if>
                                <c:if test="${requestScope.apply.status==1 }"> 已通过</c:if>
                                <a href="ApplyServlet?method=deleteApply&id=${requestScope.apply.id}">开始新的</a>
                            </c:when>

                            <c:otherwise>
                                <%--输入框提交呀 --%>
                                <form action="ApplyServlet?method=applyTo" method="post">
                                    <div id="tip" style=" color:#588905">你还能输入<em>90</em>个字</div>
                                    <textarea name="content" cols="50" rows="10" id="textArea"></textarea><br />
                  

                                    <label>
                                        <input type="submit" name="button" id="button" value="提交" />
                                    </label>
                                    <script type="text/javascript">
                                        document.getElementById("textArea").focus();
                                        var chackTextarea = function (obj, num, objTip) {
                                            obj.onfocus = function () {
                                                setInterval(function () {
                                                    if (obj.value.length >= 1) {
                                                        if (obj.value.length > num) {
                                                            objTip.innerHTML = "已超出<em>" + (obj.value.length - num) + "</em>个字!";
                                                            objTip.style.color = "#F00";
                                                            document.getElementById("button").disabled = "disabled";
                                                        } else {
                                                            objTip.innerHTML = "你还能输入<em>" + (num - obj.value.length) + "</em>个字!";
                                                            objTip.style.color = "#588905";
                                                            document.getElementById("button").disabled = "";
                                                        }
                                                    } else {
                                                        document.getElementById("button").disabled = "disabled";
                                                    }
                                                }, 100)
                                            }
                                        }
                                        chackTextarea(document.getElementById("textArea"), 90, document.getElementById("tip"));
                                    </script>
                                </form>
                            </c:otherwise>
                        </c:choose>

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