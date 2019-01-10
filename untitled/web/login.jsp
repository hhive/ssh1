<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>教师教务管理系统</title>
</head>
<body bgcolor="#D9DFAA">
<s:form action="login" method="post" theme="simple">
<table>
	<caption>用户登录</caption>
	<tr>
		<td>
			工号：<s:textfield name="dl.id" size="20"/>
		</td>
	</tr>
	<tr>
		<td>
			密码：<s:password name="dl.password" size="21"/>
		</td>
	</tr>
	<tr>
		<td align="right">
			<s:submit value="登录"/>
			<s:reset value="重置"/>
		</td>
	</tr>
</table>
</s:form>
</body>
</html>
