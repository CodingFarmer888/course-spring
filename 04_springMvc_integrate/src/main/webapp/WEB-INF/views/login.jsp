<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入頁</title>
</head>
<body>
登入頁
<form action="doLogin" method="POST">
	Email: <input type="text" name="email"/> <br>
	Password: <input type="password" name="password"/> <br>
	<input type="submit" />
</form>

<a href="register">註冊</a>
</body>
</html>