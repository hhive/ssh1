<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<style type="text/css">
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
	</style>
</head>

<body>
	<table width="700">
		<tr align="center" bgcolor="#f2f2f2">
			<th>工号</th><th>姓名</th><th>性别</th><th>年龄</th><th>操作</th><th>操作</th>
		</tr>
		<s:iterator value="#request.list" id="dl">
		<tr>
			<td><s:property value="#dl.id"/></td>
			<td><s:property value="#dl.name"/></td>
			<td>
				<s:if test='#dl.sex=="1"'>男</s:if>
				<s:else>女</s:else>
			</td>
			<td><s:property value="#dl.age"/></td>
			<td>
				<a href="deleteUser.action?dl.id=<s:property value="#dl.id"/>" onClick="if(!confirm('确定删除吗？'))return false;else return true;">删除</a>
			</td>
			<td>
				<a href="updateUserView.action?dl.id=<s:property value="#dl.id"/>">修改</a>
			</td>
		</tr>
		</s:iterator>
		<tr>
			<s:set name="page" value="#request.page"></s:set>
			<s:if test="#page.totalPage">
				总页数：<s:property value="#page.totalPage"/>&nbsp;
			</s:if>
			<s:if test="#page.hasFirst">
				<s:a href="showUserList.action?pageNow=1">首页</s:a>&nbsp;
			</s:if>
			<s:if test="#page.hasPre">
				<a href="showUserList.action?pageNow=<s:property value="#page.pageNow-1"/>">上一页</a>&nbsp;
			</s:if>
			<s:if test="#page.hasNext">
				<a href="showUserList.action?pageNow=<s:property value="#page.pageNow+1"/>">下一页</a>&nbsp;
			</s:if>
			<s:if test="#page.hasLast">
				<a href="showUserList.action?pageNow=<s:property value="#page.totalPage"/>">尾页</a>
			</s:if>
		</tr>
	</table>
</body>
</html>
