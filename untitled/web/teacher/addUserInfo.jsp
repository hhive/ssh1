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
		input[type=submit] {
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
<body>
	<h3>请填写教师信息</h3>
	<hr width="700" align="left">
	<s:form action="addUser" method="post" enctype="multipart/form-data" theme="simple">
		<table >
			<tr>
				<td>
					工号
				</td>
				<td>
					<input type="text" name="dl.id"  value=""/>
				</td>
			</tr>
			<tr>
				<td>
					密码
				</td>
				<td>
					<input type="password" name="dl.password"  value=""/>
				</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td>
					<input type="text"  name="dl.name"  value=""/>
				</td>
			</tr>
			<tr>
				<td>年龄</td>
				<td>
					<input type="text"  name="dl.age" value=""/>
				</td>
			</tr>
			<tr>
				<td>性别</td>
				<td width="80">
					<s:radio list="#{1:'男',0:'女'}" name="dl.sex"/>
				</td>
			</tr>
			<tr>
				<td>角色</td>
				<td>
					<select name="dl.role">
						<option value="sa">sa</option>
						<option value="teacher">teacher</option>
					</select>
				</td>
			</tr>
		</table>
		<p>
		<input type="submit" value="添加"/>
	</s:form>
			<br><s:property value="message"/>
</body>
</html>
