<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
User user = (User)session.getAttribute("user");
%>
<br>
下記のユーザを登録します。<br>
<p>
ログイン名:<%=user.getId() %><br>
名前：<%=user.getName() %><br>
</p>
<a href="/example/RegisterUser">戻る</a>
<a href="/example/RegisterUser?action=done">登録</a>

</body>
</html>