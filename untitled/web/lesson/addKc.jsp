<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title></title>
    <style>
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
<h3>请填写课程信息</h3>
<hr width="700" align="left">
<s:form action="addKc" method="post" enctype="multipart/form-data" theme="simple">
<table border="0" cellspacing="0" cellpadding="1">
    <tr>
        <td>
            课程号
        </td>
        <td>
            <s:textfield name="kc.kch" value=""/>
        </td>
    </tr>
    <tr>
        <td>
            课程名
        </td>
        <td>
            <s:textfield name="kc.kcm" value=""/>
        </td>
    </tr>
    <tr>
        <td>
            开课学期
        </td>
        <td>
            <s:select name="kc.kxxq" value="1" list="#{1:1,2:2,3:3,4:4,5:5,6:6,7:7,8:8}" />
        </td>
    </tr>
    <tr>
        <td>
            学时
        </td>
        <td>
        <s:textfield name="kc.xs" value=""/>
        </td>
    </tr>
    <tr>
        <td>
            学分
        </td>
        <td>
            <s:textfield name="kc.xf" value=""/>
        </td>
    </tr>
    <tr>
        <td>
            专业
        </td>
        <td>
            <s:select name="kc.zyb.id"  list="list" listKey="id" listValue="zym" headerKey="0" headerValue="--请选择专业--" />
        </td>
    </tr>
    <tr>
        <td>
            开课周次
        </td>
        <td>
            <s:select name="kc.weekBegin" value="1" list="#{1:1,2:2,3:3,4:4,5:5,6:6,7:7,8:8,9:9,10:10,11:11,12:12,13:13,14:14,15:15,16:16,17:17}" />
        </td> <!--开课周次应小于结课周次-->
    </tr>
    <tr>
        <td>
            结课周次
        </td>
        <td>
            <s:select name="kc.weekEnd" value="1" list="#{2:2,3:3,4:4,5:5,6:6,7:7,8:8,9:9,10:10,11:11,12:12,13:13,14:14,15:15,16:16,17:17,18:18}" />
        </td>
    </tr>
    <tr>
        <td>
            周几
        </td>
        <td>
            <s:select name="kc.weekDay" value="1" list="#{1:1,2:2,3:3,4:4,5:5,6:6,7:7}" />
        </td>
    </tr>
    <tr>
        <td>
            节次
        </td>
        <td>
            <s:select name="kc.lesson" value="1" list="#{1:1,2:2,3:3,4:4,5:5}"/>
        </td>
    </tr>
    <tr>
        <td>
            地点
        </td>
        <td>
            <s:textfield name="kc.destination"  value=""/>
        </td>
    </tr>
</table>
<p>
    <input type="submit" value="添加"/>
    </s:form>
<br>
<s:property value="message"/>
</body>
</html>
