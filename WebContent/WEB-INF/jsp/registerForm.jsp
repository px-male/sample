<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ登録</title>
</head>
<body>
<form action="/example/RegisterUser" method=post>
ログインID：<input type=text name="loginId"><br>
パスワード：<input type=text name="password"><br>
名前：<input type=text name="name"><br>
<input type=submit value="確認">
</form>
</body>
</html>