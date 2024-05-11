<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1A2B</title>
</head>
<body>
<h1>1A2B 猜數字！</h1>

<a href="newGame">新遊戲</a>

<form action="guess" method="GET">
	猜數字：<input type="text" name="guessNum" />
	<button type="submit">猜答案</button>
</form>

<ul>
    <c:forEach var="num" items="${gameHistory}">
        <li>${num}</li>
    </c:forEach>
</ul>

</body>
</html>