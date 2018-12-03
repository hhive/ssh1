<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head></head>
<body bgcolor="#D9DFAA">
<table border="1" cellpadding="10" width="1000">
    <tr align="center" bgcolor="silver">
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
            <td><s:property value="#session.dl.name"/></td>
            <td><s:property value="#kc.weekBegin"/>~<s:property value="#kc.weekEnd"/>周</td>
            <td>星期<s:property value="#kc.weekDay"/>&nbsp;第<s:property value="#kc.lesson"/>节</td>
            <td><s:property value="#kc.destination"/></td>
            <td>
                <a href="deleteKc.action?kc.kch=<s:property value="#kc.kch"/>" onClick="if(!confirm('确定删除该生信息吗？'))return false;else return true;">删除</a>
            </td>
            <td>
                <a href="findOneKc.action?kc.kch=<s:property value="#kc.kch"/>">修改</a>
            </td>
        </tr>
    </s:iterator>
    <tr>
        <s:set name="page" value="#request.page"/>
        <s:if test="#page.totalPage">
            总页数：<s:property value="#page.totalPage"/>&nbsp;
        </s:if>
        <s:if test="#page.hasFirst">
            <s:a href="xsInfo.action?pageNow=1">首页</s:a>&nbsp;
        </s:if>
        <s:if test="#page.hasPre">
            <a href="xsInfo.action?pageNow=<s:property value="#page.pageNow-1"/>">上一页</a>&nbsp;
        </s:if>
        <s:if test="#page.hasNext">
            <a href="xsInfo.action?pageNow=<s:property value="#page.pageNow+1"/>">下一页</a>&nbsp;
        </s:if>
        <s:if test="#page.hasLast">
            <a href="xsInfo.action?pageNow=<s:property value="#page.totalPage"/>">尾页</a>
        </s:if>
    </tr>
</table>
</body>
</html>
