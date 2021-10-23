<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome to sign up</title>
</head>
<script>
//function addCheck(){
//var password=document.getElementById("class").value;
//var pwdagain=document.getElementById("pwdagain").value;

//if (password != pwdagain) {
//        alert("Input password unmatched");
//         return false;         
//}
//}
function check(){
	var password1 = document.getElementById('pwd1').value;
	var password2 = document.getElementById('pwd2').value;
	if(password1 !== password2){
		alert("two passwords are inconsistent");
		return false;
	} else {
		var form = document.forms[0];
		form.action = "register";
		form.method = "post";
		form.submit();
	}
}
</script>

<body align="center">
<h1>Sign up Page</h1>
<form action="register" method="post">
<table style="margin:0 auto;width:500px;height:300px;font-size:15">
	<tr>
		<td>username:</td><td><input type="text" name="username"></td>
	</tr>
	<tr>
		<td>password:</td><td><input type="text" name="password" id="pwd1"></td>
	</tr>
	<tr>
		<td>firstName:</td><td><input type="text" name="class"></td>
	</tr>
	<tr>
		<td>lastName:</td><td><input type="text" name="sex"></td>
	</tr>
	<tr>
		<td>email:</td><td><input type="text" name="tel"></td>
	</tr>
		<tr>
		<td>pwdagain</td><td><input type="text" name="pwdagain" id="pwd2"></td>
	</tr>
	<tr>
		<td colspan="2">
<%--			<input type="submit" value="submit" onclick="check()">&nbsp;&nbsp;--%>
			<input type="button" value="submit" onclick="check()">&nbsp;
			<input type="reset" value="reset">

			<br>
		</td>
	</tr>

</table>
</form>
</body>
</html>