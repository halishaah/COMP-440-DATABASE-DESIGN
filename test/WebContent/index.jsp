<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
</head>
<body align="center">
<h1>Login Page</h1>
<form action="login" method="post">
<table style="margin:0 auto;width:500px;height:300px;font-size:15">
	<tr>
		<td>username:</td><td><input type="text" name="username"></td>
	</tr>
	
	<tr>
		<td>password:</td><td><input type="text" name="password"></td>
	</tr>
	
	<tr>
		<td colspan="2"><input type="submit" value="submit">&nbsp;&nbsp;
		<input type="button" onclick="func()" value="sign up">
		<br>
		</td>
	</tr>
</table>
</form>
<script>

function func(){window.location.href='register.jsp';}

window.onload=function(){
	var flag = <%=(String) request.getAttribute("flag") %>;
	if(flag =="0"){
		alert("Wrong account or password");
		flag="1";
	}
}
</script>
</body>
</html>