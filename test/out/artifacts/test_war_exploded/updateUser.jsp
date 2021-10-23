<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
         <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@page import="cn.anxcyun.www.po.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Update Page</title>
</head>
<body align="center">
<h1>Users Info</h1>
<form action="updateUser" method="post" >
<table style="border:2px solid #FFF;border-color:#F0F0F0;background:#00F0F0;font-size:25px;color:#F0F0F0;width:700px;height:400px" align="center">
<tr style="border:2px solid #FFF" hidden>
	<th>username</th><td><input type="text" name="name" value="${user.u_name}"></td>
</tr>
<tr>
	<th>password</th><td><input type="text" name="password" value="${user.u_password}"></td>
</tr>
<tr>
	<th>class</th><td><input type="text" name="classes" value="${user.u_classes}"></td>
</tr>
<tr>
	<th>sex</th><td><input type="text" name="sex" value="${user.u_sex}"></td>
</tr>
<tr>
	<th>tel</th><td><input type="text" name="tel" value="${user.u_tel}"></td>
<tr>
<td colspan="2"><input type="submit" value="submit"></td>
</tr>               
</table>
</form>
</body>
</html>