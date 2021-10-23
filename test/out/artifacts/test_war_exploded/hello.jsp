<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@page import="cn.anxcyun.www.po.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body align="center">
<h1>hello World!</h1>
<select id="select">
<option value="0">fuzzy query</option>
<option value="1">precise query</option>
</select>&nbsp;&nbsp;
<select id="select1">
<option value="u_username">username</option>
<option value="u_password">password</option>
<option value="u_class">class</option>
<option value="u_sex">sex</option>
<option value="u_tel">tel</option>
</select>&nbsp;&nbsp;
<input type="text" id="select2" >&nbsp;&nbsp;
<input type="button" value="check" onclick="check()" />&nbsp;&nbsp;
<input type="button" value="add" onclick="add()">
<input type="button" value="reset" onclick="reset()">
</br>

<table style="border:2px solid #FFF;border-color:#F0F0F0;background:#00F0F0;font-size:25px;color:#F0F0F0;width:700px;" align="center">
<tr style="border:2px solid #FFF">
	<th>username</th><th>password</th><th>class</th><th>sex</th><th>tel</th><th>operation</th>
</tr>
<c:forEach var="user" items="${list}">
<tr>
         <td>${user.u_name}</td><td>${user.u_password}</td><td>${user.u_classes}</td><td>${user.u_sex}</td><td>${user.u_tel}</td>
         <td><input type="button" value="update"  onclick="updateUser('${user.u_name}')" /><input type="button" onclick="deleteUser('${user.u_name}')" value="delete"></td>
</tr>
</c:forEach>            
</table>
<script>
function reset(){
    window.location.href="resetUser";
}
function updateUser(u_name){
	window.location.href="update?name="+u_name;
}
function deleteUser(u_name){
	window.location.href="deleteUser?name="+u_name;
}
function check(){
	var select = document.getElementById("select");//查询方式
	var select1 = document.getElementById("select1");//查询列名称
	var textvalue = document.getElementById("select2").value;//查找的内容
	
	var index = select.selectedIndex;
	var selectvalue = select.options[index].value;
	
	var index1 = select1.selectedIndex;
	var selectvalue1 = select1.options[index1].value;
	
	/*selectvalue =0模糊查询  =1精准查询  */
	if(selectvalue=="0"){
		textvalue=" "+" where "+selectvalue1+" LIKE '%"+textvalue+"%'";
		//window.location.href="select?name="+u_name;
	}else{
		textvalue=" "+" where "+selectvalue1+"= '"+textvalue+"'";
	}
	//alert("select * from user"+textvalue);
	
	window.location.href=encodeURI("select?sql="+textvalue);
}
function add(){window.location.href='addUser.jsp';}
/* select * from user where u_username LIKE '%1%';
select * from user where u_username=2;  
select?sql=%20%20where%20u_sex%20LIKE%20%27%1%%27
select?sql=%20%20where%20u_sex=1*/

</script>
</body>
</html>