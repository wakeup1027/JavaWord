<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ path + "/";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>  
<meta charset="UTF-8" />  
<title>将数据导入word文档</title>  
<style type="text/css">  
    * { font-family: "微软雅黑"; }  
    .textField { border:none; border-bottom: 1px solid gray; text-align: center; }  
    #file { border:1px solid black; width: 80%; margin:0 auto; }  
    h1 input{ font-size:72px; }  
    td textarea { font-size: 14px; }  
    .key { width:125px; font-size:20px; }  
</style>  
</head>  
<body>  
    <form action="<%=basePath %>/servlet/myServlet" method="post">  
    <div id="file" align="center">  
        <h1><input type="text" name="title" class="textField" value="李向前简历"/></h1>  
        <hr/>  
        <table>  
            <tr>  
                <td class="key">姓名：</td>  
                <td><input type="text" name="name" class="textField"/></td>  
                <td class="key">性别：</td>  
                <td>  
                    <input type="radio" name="gender" value="男" checked/>男  
                    <input type="radio" name="gender" value="女" />女  
                </td>  
            </tr>  
            <tr>  
                <td class="key">联系电话：</td>  
                <td><input type="text" name="tel" class="textField"/></td>  
                <td class="key">家庭住址：</td>  
                <td><input type="text" name="address" class="textField"/></td>  
            </tr>  
            <tr>  
                <td colspan="4" class="key">个人简介：</td>  
            </tr>  
            <tr>  
                <td colspan="4">  
                    <textarea rows="10" cols="100" name="content"></textarea>  
                </td>  
            </tr>  
        </table>  
    </div>  
    <div align="center" style="margin-top:15px;">  
        <input type="submit" value="保存Word文档" />  
    </div>  
    </form>  
</body>  
</html>