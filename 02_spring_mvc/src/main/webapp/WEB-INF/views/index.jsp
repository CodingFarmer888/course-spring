<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello Mvc</title>
</head>
<body>
Hello Mvc~<br/>


<a href="hello">RequestMapping to hello</a><br>

<a href="h1">RequestMapping to h1</a><br>

<a href="h2">RequestMapping to h2</a><br>

<form action="hello" method="POST">
<input type="submit" value="用POST方法呼叫hello"/>
</form>

<a href="requestGet">Get Method</a><br>

<form action="requestGet" method="POST">
<input type="submit" value="用POST方法呼叫requestGet"/>
</form>

<a href="getMapping">Get Mapping</a>


<form action="postMapping" method="POST">
<input type="submit" value="用POST方法呼叫postMapping"/>
</form>


<hr>

<a href="toLoginPage">往登入頁</a>


</body>
</html>