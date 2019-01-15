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
					工号：<input type="text" name="dl.id"  value=""/>
				</td>
			</tr>
			<tr>
				<td>
					密码：<input type="password" name="dl.password"  value=""/>
				</td>
			</tr>
			<tr>
				<td>
					姓名：<input type="text"  name="dl.name"  value=""/>
				</td>
			</tr>
			<tr>
				<td>
					年龄：<input type="text"  name="dl.age" value=""/>
				</td>
			</tr>
			<tr>
				<td>
					性别：<input type="radio" value="1" list="#{1:'男',0:'女'}">
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
