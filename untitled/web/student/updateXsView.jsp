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
<body>
	<s:set name="xs" value="#request.xsInfo"></s:set>
	<s:form action="updateXs" method="post" enctype="multipart/form-data">
		<table width="500">
			<tr>
				<td width="80">学号：</td>
				<td>
					<input type="text" name="xs.xh" value="<s:property value="#xs.xh"/>" readonly/>
				</td>
			</tr>
			<tr>
				<td width="80">姓名：</td>
				<td>
					<input type="text" name="xs.xm"	value="<s:property value="#xs.xm"/>"/>
				</td>
			</tr>
			<tr>
				<td width="80">
					<s:radio list="#{1:'男',0:'女'}" value="#xs.xb"	label="性别" name="xs.xb"/>
				</td>
			</tr>
			<tr>
				<td width="80">专业：</td>
				<td>
					<select name="xs.zyb.id">
						<s:iterator value="#request.zys" id="zy">
							<option value="<s:property value="#zy.id"/>">
								<s:property value="#zy.zym"/>
							</option>
						</s:iterator>
					</select>
				</td>
			</tr>
			<tr>
				<td width="80">出生时间：</td>
				<td>
					<input type="date" name="xs.cssj" value="<s:property value="#xs.cssj"/>"/>
				</td>
			</tr>
			<tr>
				<td width="80">总学分：</td>
				<td>
					<input type="text" name="xs.zxf" value="<s:property value="#xs.zxf"/>"/>
				</td>
			</tr>
			<tr>
				<td width="80">备注：</td>
				<td>
					<input type="text" name="xs.bz" value="<s:property value="#xs.bz"/>"/>
				</td>
			</tr>
			<tr>
				<td>照片</td>
				<td>
					<input type="file" name="zpFile"/>
				</td>
			</tr>
		</table>
		<input type="submit" value="修改" class="kk"/>
		<!-- 返回上一界面 -->
		<input type="button" value="返回" class="kk" onclick="javascript:history.back();"/>
	</s:form>
	<!-- 这里用 JavaScript 来实现根据该学生的专业 ID 来显示专业名 -->
	<script type="text/javascript">
		document.getElementById("xs.zyb.id").value= <s:property value="#xs.zyb.id"/>
	</script>
</body>
</html>
