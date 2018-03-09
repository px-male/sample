<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.text.SimpleDateFormat, java.util.Date" %>

<% 
//運勢リスト
String[] luckArray = { "超すっきり", "すっきり", "最悪" };
int index = (int) (Math.random() * 3);
String luck = luckArray[index];

//実行日を取得
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
String today = sdf.format(date);
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><%= today %>の運勢は<%= luck %>です。</p>
</body>
</html>