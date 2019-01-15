<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head></head>
<body bgcolor="#D9DFAA">
	<h3>请填写学生信息</h3>
	<hr width="700" align="left">
	<s:form action="addUser" method="post" enctype="multipart/form-data">
		<table border="0" cellspacing="0" cellpadding="1">
			<tr>
				<td>
					工号：<input name="dl.id"  value=""/>
				</td>
			</tr>
			<tr>
				<td>
					密码：<input name="dl.password"  value=""/>
				</td>
			</tr>
			<tr>
				<td>
					姓名：<input name="dl.name"  value=""/>
				</td>
			</tr>
			<tr>
				<td>
					年龄：<input name="dl.age" value=""/>
				</td>
			</tr>
			<tr>
				<td>
					<s:radio name="dl.sex" value="1" list="#{1:'男',0:'女'}" label="性别"/>
				</td>
			</tr>
			<tr>
				<td>
					角色：<select name="dl.role">
						<option value="sa">sa</option>
						<option value="teacher">teacher</option>
					</select>
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
