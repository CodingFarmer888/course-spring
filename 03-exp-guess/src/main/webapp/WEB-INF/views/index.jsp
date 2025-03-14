<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${title}</h1>

<form action="newGame">
	<button type="submit">新遊戲</button>
</form>


<form action="guess" method="GET">
	猜數字：<input type="text" name="guessNum" />
	<button type="submit">猜答案</button>
</form>

<ul>
<c:forEach var="resultBean" items="${historyList}">
	<li>${resultBean.guessNum} ${resultBean.resultDisplay}</li>
</c:forEach>
</ul>
</body>
</html>