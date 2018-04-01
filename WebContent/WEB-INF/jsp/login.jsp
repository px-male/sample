<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>ログイン</p>
<form action="/example/LoginServlet" method="post">
ユーザID ：<input type="text" name="userId"><br>
パスワード：<input type="password" name="passWord"><br>
         <input type="submit" value="ログイン">
</form>

</body>
</html>