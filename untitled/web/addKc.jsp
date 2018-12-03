<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head></head>
<body bgcolor="#D9DFAA">
<h3>请填写课程信息</h3>
<hr width="700" align="left">
<s:form action="addKc" method="post" enctype="multipart/form-data">
<table border="0" cellspacing="0" cellpadding="1">
    <tr>
        <td>
            <s:textfield name="kc.kch" label="课程号" value=""/>
        </td>
    </tr>
    <tr>
        <td>
            <s:textfield name="kc.kcm" label="课程名" value=""/>
        </td>
    </tr>
    <tr>
        <td>
            <s:select name="kc.kxxq" value="1" list="#{1:1,2:2,3:3,4:4,5:5,6:6,7:7,8:8}" label="开课周次"/>
        </td>
    </tr>
    <tr>
        <td>
        <s:textfield name="kc.xs" label="学时" value=""/>
        </td>
    </tr>
    <tr>
        <td>
            <s:textfield name="kc.xf" label="学分" value=""/>
        </td>
    </tr>
    <tr>
        <td>
            <s:select name="kc.zyb.id"  list="list" listKey="id" listValue="zym" headerKey="0" headerValue="--请选择专业--" label="专业"/>
        </td>
    </tr>
    <tr>
        <td>
            <s:select name="kc.weekBegin" value="1" list="#{1:1,2:2,3:3,4:4,5:5,6:6,7:7,8:8,9:9,10:10,11:11,12:12,13:13,14:14,15:15,16:16,17:17}" label="开课周次"/>
        </td> <!--开课周次应小于结课周次-->
        <td>
            <s:select name="kc.weekEnd" value="1" list="#{2:2,3:3,4:4,5:5,6:6,7:7,8:8,9:9,10:10,11:11,12:12,13:13,14:14,15:15,16:16,17:17,18:18}" label="结课周次"/>
        </td>
    </tr>
    <tr>
        <td>
            <s:select name="kc.weekDay" value="1" list="#{1:1,2:2,3:3,4:4,5:5,6:6,7:7}" label="周几"/>
        </td>
    </tr>
    <tr>
        <td>
            <s:select name="kc.lesson" value="1" list="#{1:1,2:2,3:3,4:4,5:5}" label="节次"/>
        </td>
    </tr>
    <tr>
        <td>
            <s:textfield name="kc.destination" label="地点" value=""/>
        </td>
    </tr>
</table>
<p>
    <input type="submit" value="添加"/>
    <input type="reset" value="重置"/>
    </s:form>
<br>
<s:property value="message"/>
</body>
</html>
