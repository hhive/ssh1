<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
    <style type="text/css">
        * {
            margin: 0px;
            padding: 0px;
        }
        nav {
            width: 1130px;
            line-height: 60px;
            background-color: #0f8dc7;
            color: white;
            overflow: hidden;
            vertical-align: center;
            font-size: 25px;
            font-family: 隶书;
            margin-bottom: 10px;
        }
        nav .left {
            float: left;
            margin-left: 18px;
        }
        nav .right {
            float: right;
            margin-right: 150px;
        }
        a {color: black}
    </style>
</head>
<body>
    <nav>
        <div class="left">教务管理系统</div>
        <div class="right">
            欢迎你，<s:property value="#session.dl.name"/>
        </div>
    </nav>
</body>
</html>


