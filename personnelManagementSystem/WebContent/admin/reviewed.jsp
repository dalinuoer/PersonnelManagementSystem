<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>工会人员管理系统</title>
    <link rel="stylesheet" type="text/css" href="./table.css" />
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
                <a class="a" href="./review_no.jsp">未审核</a>
                <span>/</span>
                <a class="a" href="./reviewed.jsp">已审核</a>
            </div>

            <div class="body-part">

                <div>
                    <div>
                        <table class="table" border="1" >
                            <thead>
                                <tr>

                                    <th>
                                        <div>序号</div>
                                    </th>
                                    <th>
                                        <div>团体编号</div>
                                    </th>
                                    <th>
                                        <div>团体名称</div>
                                    </th>
                                    <th>
                                        <div>团体描述</div>
                                    </th>
                                    <th>
                                        <div>团体人数</div>
                                    </th>
                                    <th>
                                        <div>操作</div>
                                    </th>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td class="num">1</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><div align="center"><input class="sign-btn" type="submit" value="删除" /></div></td>
                                </tr>
                                <tr>
                                    <td class="num">2</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><div align="center"><input class="sign-btn" type="submit" value="删除" /></div></td>
                                </tr>
                                <tr>
                                    <td class="num">3</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><div align="center"><input class="sign-btn" type="submit" value="删除" /></div></td>
                                </tr>
                                <tr>
                                    <td class="num">4</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><div align="center"><input class="sign-btn" type="submit" value="删除" /></div></td>
                                </tr>
                                <tr>
                                    <td class="num">5</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><div align="center"><input class="sign-btn" type="submit" value="删除" /></div></td>
                                </tr>
                                <tr>
                                    <td class="num">6</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><div align="center"><input class="sign-btn" type="submit" value="删除" /></div></td>
                                </tr>
                                <tr>
                                    <td class="num">7</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><div align="center"><input class="sign-btn" type="submit" value="删除" /></div></td>
                                </tr>
                                <tr>
                                    <td class="num">8</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><div align="center"><input class="sign-btn" type="submit" value="删除" /></div></td>
                                </tr>
                                <tr>
                                    <td class="num">9</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><div align="center"><input class="sign-btn" type="submit" value="删除" /></div></td>
                                </tr>
                                <tr>
                                    <td class="num">10</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><div align="center"><input class="sign-btn" type="submit" value="删除" /></div></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div style="padding:4px">
                        <input class="sign-btn" type="submit" value="上一页" />
                        <input class="sign-btn" type="submit" value="下一页" />

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