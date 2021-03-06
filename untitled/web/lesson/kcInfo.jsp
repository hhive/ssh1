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
    </style>
</head>
<body>
<table>
    <tr align="center" bgcolor="#f2f2f2">
        <th>课程号</th><th>课程名</th><th>开课学期</th><th>学时</th><th>学分</th><th>专业</th><th>任课老师</th><th>周次</th><th>上次时间</th><th>地点</th><th>操作</th><th>操作</th>
    </tr>
    <s:iterator value="#request.list" id="kc">
        <tr>
            <td><s:property value="#kc.kch"/></td>
            <td><s:property value="#kc.kcm"/></td>
            <td>第<s:property value="#kc.kxxq"/>学期</td>
            <td><s:property value="#kc.xs"/></td>
            <td><s:property value="#kc.xf"/></td>
            <td><s:property value="#kc.zyb.zym"/></td>
            <td><s:property value="#kc.dlb.name"/></td>
            <td><s:property value="#kc.weekBegin"/>~<s:property value="#kc.weekEnd"/>周</td>
            <td>星期<s:property value="#kc.weekDay"/>&nbsp;第<s:property value="#kc.lesson"/>节</td>
            <td><s:property value="#kc.destination"/></td>
            <td>
                <a href="deleteKc.action?kc.kch=<s:property value="#kc.kch"/>" onClick="if(!confirm('确定删除该课程信息吗？'))return false;else return true;">删除</a>
            </td>
            <td>
                <a href="findOneKc.action?kc.kch=<s:property value="#kc.kch"/>"&message="">修改</a>
            </td>
        </tr>
    </s:iterator>
    <tr>
        <td colspan="12" style="font-size: 20px;font-weight: 300">
            <s:set name="page" value="#request.page"/>
            <s:if test="#page.totalPage">
                总页数：<s:property value="#page.totalPage"/>&nbsp;
            </s:if>
            <s:if test="#page.hasFirst">
                <s:a href="kcInfo.action?pageNow=1">首页</s:a>&nbsp;
            </s:if>
            <s:if test="#page.hasPre">
                <a href="kcInfo.action?pageNow=<s:property value="#page.pageNow-1"/>">上一页</a>&nbsp;
            </s:if>
            <s:if test="#page.hasNext">
                <a href="kcInfo.action?pageNow=<s:property value="#page.pageNow+1"/>">下一页</a>&nbsp;
            </s:if>
            <s:if test="#page.hasLast">
                <a href="kcInfo.action?pageNow=<s:property value="#page.totalPage"/>">尾页</a>
            </s:if>
        </td>
    </tr>
</table>
</body>
</html>
