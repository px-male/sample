<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User user = (User)session.getAttribute("user");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(user != null) {
%>
<p> ログインに成功しました。	</p>
<p> ようこそ<%=user.getName() %>さん。</p>
<a href="/example/Main">つぶやき投稿・閲覧へ</a>
<% } else { %>
<p> ログインに失敗しました。 </p>
<a href="/example/index.jsp">TOPへ</a>

<% } %>

</body>
</html>