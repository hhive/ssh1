<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>教师教务管理系统</title>
    <style type="text/css">
        body {
            width: 1130px;
            margin: 0px auto;
        }
        .top {
            width: 1130px;
            height: 70px;
        }
        .aside {
            width: 130px;
            height: 680px;
            float: left;
        }
        .main {
            width: 1000px;
            height: 680px;
            float: right;
        }
        a {
            font-size: 13px;
            text-align: center;
            display: block;
            width: 70px;
            line-height: 45px;
            vertical-align: middle;
            color: white;
            /*background-color: #56baed;*/
            background-color: black;
            border: none;
            border-radius: 10px;
            position: absolute;
            top: 15px;
            left: 1260px;
            text-decoration: none;
        }

    </style>
</head>
<body>
    <iframe class="top" src="top.jsp" frameborder="0"></iframe>
    <iframe class="aside" src="aside.jsp" frameborder="0"></iframe>
    <iframe class="main" src="main.html" frameborder="0" name="main"></iframe>
    <a href="logout.action">注销</a>
<%--<s:property value="#session.dl.name"/>，您好，欢迎光临教师教务系统【<a href="logout.action">注销</a>】<br><br>--%>
<%--学生信息管理<br>--%>
<%--<ol type="1" start="1">--%>
    <%--&lt;%&ndash;<s:property value="#session.dl.role"/>&ndash;%&gt;--%>
    <%--<s:if test="#session.dl.role == 'teacher'">--%>
        <%--<li><a href="xsInfo.action">学生信息查询</a> </li>--%>
    <%--</s:if>--%>
    <%--<s:else>--%>
        <%--<li><a href="addXsView.action">学生信息录入</a> </li>--%>
        <%--<li><a href="xsInfo.action">学生信息查询</a> </li>--%>
    <%--</s:else>--%>
<%--</ol>--%>
<%--课程信息管理<br>--%>
<%--<ol type="1" start="1">--%>
    <%--<li><a href="addKcView.action?message=<s:property value=""/>">课程信息录入</a> </li>--%>
    <%--<li><a href="kcInfo.action">课程信息查询</a> </li>--%>
<%--</ol>--%>
<%--成绩信息管理<br>--%>
<%--<ol type="1" start="1">--%>
    <%--<li><a href="addXscjView.action">成绩信息录入</a> </li>--%>
    <%--<li><a href="xscjInfo.action">学生成绩查询</a> </li>--%>
<%--</ol>--%>
</body>
</html>


