<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head></head>
<body bgcolor="#D9DFAA">
	<s:set name="dl" value="#request.UserInfo"></s:set>
	<s:form action="updateUser" method="post" enctype="multipart/form-data">
		<table border="0" cellspacing="0" cellpadding="1">
			<tr>
				<td>
					工号：<input type="text" name="dl.id"  value="<s:property value="#dl.id"/>"/>
				</td>
			</tr>
			<tr>
				<td>
					密码：<input type="password" name="dl.password"  value="<s:property value="#dl.password"/>"/>
				</td>
			</tr>
			<tr>
				<td>
					姓名：<input type="text" name="dl.name"  value="<s:property value="#dl.name"/>"/>
				</td>
			</tr>
			<tr>
				<td>
					年龄：<input type="text" name="dl.age" value="<s:property value="#dl.age"/>"/>
				</td>
			</tr>
			<tr>
				<td>
					性别：<input type="radio" name="dl.sex" value="1" list="#{1:'男',0:'女'}"/>
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
		<input type="submit" value="修改"/>
		<!-- 返回上一界面 -->
		<input type="button" value="返回" onclick="javascript:history.back();"/>
	</s:form>
	<!-- 这里用 JavaScript 来实现根据该学生的专业 ID 来显示专业名 -->
	<script type="text/javascript">
		document.getElementById("dl.zyb.id").value= <s:property value="#dl.zyb.id"/>
	</script>
</body>
</html>
