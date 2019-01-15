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
<h3>修改课程信息</h3>
<hr width="700" align="left">
<s:form action="updateKc" method="post" enctype="multipart/form-data" theme="simple">
<table border="1" cellpadding="8">
    <tr>
        <td>
            课程号
        </td>
        <td>
            <input name="kc.kch" value="<s:property value="kc.kch"/>"/>
        </td>
    </tr>
    <tr>
        <td>课程名</td>
        <td>
            <input name="kc.kcm" value="<s:property value="kc.kcm"/>"/>
        </td>
    </tr>
    <tr>
        <td>开课学期</td>
        <td>
            <s:select name="kc.kxxq" value="kc.kxxq" list="#{1:1,2:2,3:3,4:4,5:5,6:6,7:7,8:8}" />
        </td>
    </tr>
    <tr>
        <td>学时</td>
        <td>
            <input name="kc.xs" value="<s:property value="kc.xs"/>"/>
        </td>
    </tr>
    <tr>
        <td>学分</td>
        <td>
            <input name="kc.xf" value="<s:property value="kc.xf"/>"/>
        </td>
    </tr>
    <tr>
        <td width="80">专业：</td>
        <td>
            <select name="xs.zyb.id">
                <s:iterator value="zys" id="zy">
                    <option value="<s:property value="#zy.id"/>">
                        <s:property value="#zy.zym"/>
                    </option>
                </s:iterator>
            </select>
        </td>
    </tr>
    <tr>
        <td>
            开课周次
        </td>
        <td>
            <s:select name="kc.weekBegin" value="kc.weekBegin" list="#{1:1,2:2,3:3,4:4,5:5,6:6,7:7,8:8,9:9,10:10,11:11,12:12,13:13,14:14,15:15,16:16,17:17}" />
        </td> <!--开课周次应小于结课周次-->
    </tr>
    <tr>
        <td>
            结课周次
        </td>
        <td>
            <s:select name="kc.weekEnd" value="kc.weekEnd" list="#{2:2,3:3,4:4,5:5,6:6,7:7,8:8,9:9,10:10,11:11,12:12,13:13,14:14,15:15,16:16,17:17,18:18}" />
        </td>
    </tr>
    <tr>
        <td>
            周几
        </td>
        <td>
            <s:select name="kc.weekDay" value="kc.weekDay" list="#{1:1,2:2,3:3,4:4,5:5,6:6,7:7}" />
        </td>
    </tr>
    <tr>
        <td>
            节次
        </td>
        <td>
            <s:select name="kc.lesson" value="kc.lesson" list="#{1:1,2:2,3:3,4:4,5:5}" />
        </td>
    </tr>
    <tr>
        <td>地点</td>
        <td>
            <input name="kc.destination" value="<s:property value="kc.destination"/>"/>
        </td>
    </tr>
</table>
    <input type="submit" value="修改" class="kk"/>
    <input type="button" value="返回" onClick="javaScript:history.back()" class="kk"/>
</s:form>
    <br><s:property value="message"/>
</body>
</html>
