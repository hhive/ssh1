<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<title></title>
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
<body >
	<table>
		<tr bgcolor="#f2f2f2">
			<th>学号</th><th>姓名</th><th>课程名</th><th>成绩</th><th>学分</th><th>删除</th>
		</tr>
		<s:iterator value="#request.list" id="xscj">
		<tr>
			<td>
				<a href="findXscj.action?cj.id.xh=<s:property value="#xscj[0]"/>">
					<s:property value="#xscj[0]"/>
				</a>
			</td>
			<td><s:property value="#xscj[1]"/></td>
			<td><s:property value="#xscj[2]"/></td>
			<td><s:property value="#xscj[3]"/></td>
			<td><s:property value="#xscj[4]"/></td>
			<td>
				<a href="deleteOneXscj.action?cj.id.xh=<s:property value="#xscj[0]"/>&cj.id.kch=<s:property value="#xscj[5]"/>" onClick="if(!confirm('确定删除该信息吗？')) return false;else return true;">删除</a>
			</td>
		</tr>
		</s:iterator>
		<tr align="left">
			<td colspan="6" style="font-size: 20px;font-weight: 300">
				<s:set name="page" value="#request.page"></s:set>
				<s:if test="#page.totalPage">
					总页数：<s:property value="#page.totalPage"/>&nbsp;
				</s:if>
				<s:if test="#page.hasFirst">
					<s:a href="xscjInfo.action?pageNow=1">首页</s:a>&nbsp;
				</s:if>
				<s:if test="#page.hasPre">
					<a href="xscjInfo.action?pageNow=<s:property value="#page.pageNow-1"/>">上一页</a>&nbsp;
				</s:if>
				<s:if test="#page.hasNext">
					<a href="xscjInfo.action?pageNow=<s:property value="#page.pageNow+1"/>">下一页</a>&nbsp;
				</s:if>
				<s:if test="#page.hasLast">
					<a href="xscjInfo.action?pageNow=<s:property value="#page.totalPage"/>">尾页</a>
				</s:if>
			</td>
		</tr>
	</table>
</body>
</html>
