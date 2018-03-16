<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.SiteEV" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

SiteEV siteEv = (SiteEV)application.getAttribute("site");

%>
<h1>湊くんのページへようこそ</h1>
<a href="/example/MinatoIndex?action=like">よいね</a>：<%=siteEv.getLike() %>人<br>
<a href="/example/MinatoIndex?action=dislike">よくないね</a>：<%=siteEv.getdisLike() %>人<br>
</body>
</html>