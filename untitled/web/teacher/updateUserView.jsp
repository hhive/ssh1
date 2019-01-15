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
		.kk {
			font-size: 13px;
			text-align: center;
			display: inline-block;
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
	<s:set name="dl" value="#request.UserInfo"></s:set>
	<s:form action="updateUser" method="post" enctype="multipart/form-data" theme="simple">
		<table >
			<tr>
				<td>工号</td>
				<td>
					<input type="text" name="dl.id"  value="<s:property value="#dl.id"/>"/>
				</td>
			</tr>
			<tr>
				<td>密码</td>
				<td>
					<input type="password" name="dl.password"  value="<s:property value="#dl.password"/>"/>
				</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td>
					<input type="text" name="dl.name"  value="<s:property value="#dl.name"/>"/>
				</td>
			</tr>
			<tr>
				<td>年龄</td>
				<td>
					<input type="text" name="dl.age" value="<s:property value="#dl.age"/>"/>
				</td>
			</tr>
			<tr>
				<td>性别</td>
				<td width="80">
					<s:radio list="#{1:'男',0:'女'}" value="#dl.sex"	 name="dl.sex"/>
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
		<input type="submit" value="修改" class="kk"/>
		<!-- 返回上一界面 -->
		<input type="button" value="返回" onclick="javascript:history.back();" class="kk"/>
	</s:form>
	<!-- 这里用 JavaScript 来实现根据该学生的专业 ID 来显示专业名 -->
	<script type="text/javascript">
		document.getElementById("dl.zyb.id").value= <s:property value="#dl.zyb.id"/>
	</script>
</body>
</html>
