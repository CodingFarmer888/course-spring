<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使用者列表</title>
</head>
<body>

<ul>
<c:forEach var="user" items="${users}">
	<li>${user.email}</li>
</c:forEach>
</ul>
</body>
</html>