<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<style type="text/css">
		h3 {
			font-size: 20px;
			font-weight: 300;
		}
		table {
			background-color: white;
			border-color: grey;
			border-collapse: collapse;
		}
		th, td {
			padding: 9px 15px;
			min-height: 20px;
			line-height: 20px;
			border: 1px solid #e2e2e2;
			font-size: 14px;
		}
		input[type=button] {
			font-size: 13px;
			text-align: center;
			display: block;
			width: 190px;
			height: 45px;
			margin: 10px 0px;
			color: white;
			background-color: #56baed;
			border: none;
			border-radius: 5px;
		}
	</style>
</head>
<body >
	<h3>该学生成绩如下：</h3>
	<hr width="700" align="left">
	<table border="1" cellspacing="1" cellpadding="8" width="700">
		<tr>
			<th>课程名</th><th>成绩</th><th>学分</th>
		</tr>
		<s:iterator value="#request.list" id="xscj">
		<tr>
			<td><s:property value="#xscj[2]"/></td>
			<td><s:property value="#xscj[3]"/></td>
			<td><s:property value="#xscj[4]"/></td>
		</tr>
		</s:iterator>
	</table>
	<input type="button" value="返回" onClick="javaScript:history.back()"/>
</body>
</html>
