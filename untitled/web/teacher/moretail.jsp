<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head></head>
<body bgcolor="#D9DFAA">
	<h3>该学生信息如下：</h3>
	<s:set name="dl" value="#request.dl"></s:set>
	<s:form action="xsInfo" method="post">
		<table border="0" cellpadding="5">
			<tr>
				<td>工号：</td>
				<td width="100">
					<s:property value="#dl.id"/>
				</td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td width="100">
					<s:property value="#dl.name"/>
				</td>
			</tr>
			<tr>
				<td>性别：</td>
				<td width="100">
					<s:if test='#dl.sex=="1"'>男</s:if>
					<s:else>女</s:else>
				</td>
			</tr>

			<tr>
				<td>年龄</td>
				<td width="100">
					<s:property value="#dl.age"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<s:submit value="返回"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>
