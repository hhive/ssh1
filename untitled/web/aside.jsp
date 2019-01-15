<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <style type="text/css">
        * {
            padding: 0px;
            margin: 0px;
        }
        aside {
            width: 130px;
        }
        aside ul {
            list-style-type: none;
            height: 680px;
            background-color: rgb(244, 244, 244);
        }
        aside ul li{
            border-bottom: 2px solid white;
            padding-left: 20px;
            line-height: 50px;
        }
        aside ul li a {
            text-decoration: none;
            font-family: 宋体;
            font-weight: bold;
            color: #222222;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <aside>
        <ul>
            <s:if test="#session.dl.role == 'teacher'">
                <li >
                    <a href="xsInfo.action" target="main">查询学生</a>
                <li >
                    <a href="addKcView.action?message=" target="main">课程录入</a>
                </li>
                </li>
            </s:if>
            <s:else>
                <li><a href="addXsView.action?message=" target="main">学生录入</a> </li>
                <li><a href="xsInfo.action" target="main">学生查询</a> </li>
                <li><a href="/teacher/addUserInfo.jsp?message=" target="main">教师录入</a></li>
                <li><a href="showUserList.action" target="main">教师查询</a> </li>
            </s:else>
            <li >
                <a href="kcInfo.action" target="main">查询课程</a>
            </li>
            <li >
                <a href="addXscjView.action?message=" target="main">成绩录入</a>
            </li>
            <li >
                <a href="xscjInfo.action" target="main">查询成绩</a>
            </li>
        </ul>
    </aside>
</body>
</html>