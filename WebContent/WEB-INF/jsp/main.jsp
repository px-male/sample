<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, java.util.List, model.Mutter"%>
<%
User user = (User)session.getAttribute("user");
List<Mutter> list = (List<Mutter>) application.getAttribute("tsubuList");
String error = (String)request.getAttribute("error");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<p>ようこそ<%= user.getName() %>さん。</p>
<a href="/example/Logout">ログアウト</a>
<br>
<form action="/example/Main" method="post">
<input type="text" name="mutter"><br>
<input type=submit value="つぶやく">
</form>
<br>
<% 
if (error != null && !error.isEmpty()) {
%>
<p><%=error %></p>
<% 
}
%>


<%
String name;
String mutters;
for (Mutter mutter: list) { 
	name = mutter.getName();
	mutters = mutter.getContent();
%>
<p><%= name %>：<%= mutters %> </p>
<%
}
%>
</body>
</html>