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
<body>
	<h3>请录入学生成绩</h3>
	<hr>
	<s:form action="addorupdateXscj" method="post">
		<table width="400">
			<tr>
				<td width="100">
					学生：
				</td>
				<td>
					<select name="cj.id.xh">
						<s:iterator id="xs" value="#request.list1">
							<option value="<s:property value="#xs.xh"/>">
								<s:property value="#xs.xm"/>
							</option>
						</s:iterator>
					</select>
				</td>
			</tr>
			<tr>
				<td width="100">
					课程：
				</td>
				<td>
					<select name="cj.id.kch">
						<s:iterator id="kc" value="#request.list2">
							<option value="<s:property value="#kc.kch"/>">
								<s:property value="#kc.kcm"/>
							</option>
						</s:iterator>
					</select>
				</td>
			</tr>
			<tr>
				<s:textfield label="成绩" name="cj.cj" size="15" />
			</tr>
		</table>
		<input type="submit" value="确定"/>
	</s:form>
	<br><s:property value="message"/>
</body>
</html>
