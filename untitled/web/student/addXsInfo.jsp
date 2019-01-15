<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head></head>
<body bgcolor="#D9DFAA">
	<h3>请填写学生信息</h3>
	<hr width="700" align="left">
	<s:form action="addXs" method="post" enctype="multipart/form-data">
		<table border="0" cellspacing="0" cellpadding="1">
			<tr>
				<td>
					<s:textfield name="xs.xh" label="学号" value=""/>
				</td>
			</tr>
			<tr>
				<td>
					<s:textfield name="xs.xm" label="姓名" value=""/>
				</td>
			</tr>
			<tr>
				<td>
					<s:radio name="xs.xb" value="1" list="#{1:'男',0:'女'}" label="性别"/>
				</td>
			</tr>
			<tr>
				<s:select name="xs.zyb.id"  list="list" listKey="id" listValue="zym" headerKey="0" headerValue="--请选择专业--" label="专业"/>
			</tr>
			<tr>
				<td>出生日期：</td>
				<td><input type="date" name="xs.cssj"></td>
				<%--<s:textfield name="xs.cssj" label="出生时间" value=""/>--%>
			</tr>
			<tr>
				<td>
					<s:textfield name="xs.zxf" label="总学分" value=""/>
				</td>
			</tr>
			<tr>
				<td>
					<s:textfield name="xs.bz" label="备注" value=""/>
				</td>
			</tr>
			<tr>
				<td>
					<s:file name="zpFile" label="照片" value=""/>
				</td>
			</tr>
		</table>
		<p>
		<input type="submit" value="添加"/>
		<input type="reset" value="重置"/>
	</s:form>
			<input type="button" value="返回" onClick="javaScript:history.back()"/>
</body>
</html>
