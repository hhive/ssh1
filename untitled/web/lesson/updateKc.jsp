<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head></head>
<body bgcolor="#D9DFAA">
<h3>修改课程信息</h3>
<hr width="700" align="left">
<s:form action="updateKc" method="post" enctype="multipart/form-data">
<table border="1" cellpadding="8">
    <tr>
        <td>
            课程号:<input name="kc.kch" value="<s:property value="kc.kch"/>"/>
        </td>
    </tr>
    <tr>
        <td>
            课程名：<input name="kc.kcm" label="课程名" value="<s:property value="kc.kcm"/>"/>
        </td>
    </tr>
    <tr>
        <td>
            <s:select name="kc.kxxq" value="kc.kxxq" list="#{1:1,2:2,3:3,4:4,5:5,6:6,7:7,8:8}" label="开课学期"/>
        </td>
    </tr>
    <tr>
        <td>
            学时：<input name="kc.xs" label="学时" value="<s:property value="kc.xs"/>"/>
        </td>
    </tr>
    <tr>
        <td>
            学分：<input name="kc.xf" label="学分" value="<s:property value="kc.xf"/>"/>
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
        <td>
            <s:select name="kc.weekBegin" value="kc.weekBegin" list="#{1:1,2:2,3:3,4:4,5:5,6:6,7:7,8:8,9:9,10:10,11:11,12:12,13:13,14:14,15:15,16:16,17:17}" label="开课周次"/>
        </td> <!--开课周次应小于结课周次-->
    </tr>
    <tr>
        <td>
            <s:select name="kc.weekEnd" value="kc.weekEnd" list="#{2:2,3:3,4:4,5:5,6:6,7:7,8:8,9:9,10:10,11:11,12:12,13:13,14:14,15:15,16:16,17:17,18:18}" label="结课周次"/>
        </td>
    </tr>
    <tr>
        <td>
            <s:select name="kc.weekDay" value="kc.weekDay" list="#{1:1,2:2,3:3,4:4,5:5,6:6,7:7}" label="周几"/>
        </td>
    </tr>
    <tr>
        <td>
            <s:select name="kc.lesson" value="kc.lesson" list="#{1:1,2:2,3:3,4:4,5:5}" label="节次"/>
        </td>
    </tr>
    <tr>
        <td>
            地点：<input name="kc.destination" value="<s:property value="kc.destination"/>"/>
        </td>
    </tr>
</table>
<p>
    <input type="submit" value="修改"/>
    <input type="reset" value="重置"/>
    </s:form>
    <br>
    <s:property value="message"/>
<br>
    <input type="button" value="返回" onClick="javaScript:history.back()"/>
</body>
</html>
