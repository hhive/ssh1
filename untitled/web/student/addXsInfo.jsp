<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<title></title>
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
<body >
	<h3>请填写学生信息</h3>
	<hr width="700" align="left">
	<s:form action="addXs" method="post" enctype="multipart/form-data" theme="simple">
		<table >
			<tr>
				<td>
					学号
				</td>
				<td>
					<s:textfield name="xs.xh"  value=""/>
				</td>
			</tr>
			<tr>
				<td>
					姓名
				</td>
				<td>
					<s:textfield name="xs.xm" value=""/>
				</td>
			</tr>
			<tr>
				<td>
					性别
				</td>
				<td>
					<s:radio name="xs.xb" value="1" list="#{1:'男',0:'女'}" />
				</td>
			</tr>
			<tr>
				<td>
					专业
				</td>
				<td>
						<s:select name="xs.zyb.id"  list="list" listKey="id" listValue="zym" headerKey="0" headerValue="--请选择专业--" />
				</td>
			</tr>
			<tr>
				<td>出生日期：</td>
				<td><input type="date" name="xs.cssj"></td>
			</tr>
			<tr>
				<td>
					总学分
				</td>
				<td>
					<s:textfield name="xs.zxf"  value=""/>
				</td>
			</tr>
			<tr>
				<td>
					备注
				</td>
				<td>
					<s:textfield name="xs.bz"  value=""/>
				</td>
			</tr>
			<tr>
				<td>
					照片
				</td>
				<td>
					<s:file name="zpFile"  value=""/>
				</td>
			</tr>
		</table>
		<p>
		<input type="submit" value="添加"/>
	</s:form>
			<br><s:property value="message"/>
</body>
</html>
