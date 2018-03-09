<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Health" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
Health health = (Health) request.getAttribute("health");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>スッキリ健康診断の結果</h1>
<br>
<p>身長：<%= health.getHeight() %> cm</p>
<p>体重：<%= health.getWeight() %> kg</p>
<p>BIM:<%= health.getBmi() %> </p>
<p>体型:<%= health.getBodytype() %></p>

<a href="/example/HealthCheck"> 戻る </a>
</body>
</html>