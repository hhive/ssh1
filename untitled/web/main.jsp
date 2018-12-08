<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>学生成绩管理系统</title>
</head>
<body bgcolor="#D9DFAA">
	<s:property value="#session.dl.name"/>，您好，欢迎光临教师教务系统<a href="logout.action">【注销】</a><br><br>
	学生信息管理<br>
	<ol type="1" start="1">
       <%--<s:property value="#session.dl.role"/>--%>
        <s:if test="#session.dl.role == 'teacher'">
            <li><a href="xsInfo.action">学生信息查询</a> </li>
        </s:if>
        <s:else>
            <li><a href="addXsView.action">学生信息录入</a> </li>
            <li><a href="xsInfo.action">学生信息查询</a> </li>
        </s:else>
	</ol>
	课程信息管理<br>
	<ol type="1" start="1">
		<li><a href="addKcView.action?message=<s:property value=""/>">课程信息录入</a> </li>
		<li><a href="kcInfo.action">课程信息查询</a> </li>
	</ol>
	成绩信息管理<br>
	<ol type="1" start="1">
		<li><a href="addXscjView.action">成绩信息录入</a> </li>
		<li><a href="xscjInfo.action">学生成绩查询</a> </li>
	</ol>

</body>
</html>


