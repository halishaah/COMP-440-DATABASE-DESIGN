<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Addtion</title>
</head>
<body align="center">
<h1>Add user page</h1>
<form action="addUser" method="post">
<table style="margin:0 auto;width:500px;height:300px;font-size:15">
	<tr>
		<td>username:</td><td><input type="text" name="username"></td>
	</tr>
	<tr>
		<td>password:</td><td><input type="text" name="password"></td>
	</tr>
	<tr>
		<td>firstName:</td><td><input type="text" name="class"></td>
	</tr>
	<tr>
		<td>lastName:</td><td><input type="text" name="sex"></td>
	</tr>
	<tr>
		<td>email</td><td><input type="text" name="tel"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="submit">&nbsp;&nbsp;
		<input type="reset" value="reset">
		<br>
		</td>
	</tr>

</table>
</form>
</body>
</html>