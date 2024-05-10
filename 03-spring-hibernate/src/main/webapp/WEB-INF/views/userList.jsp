<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>使用者列表</h1>
    <table border="1">
        <tr>
            <th>帳號</th>
            <th>密碼</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.username}</td>
                <td>${user.password}</td>
            </tr>
        </c:forEach>
    </table>
    
    <hr/>
    <form action="deleteUser">
        刪除使用者： <input type="text" name="username"/>
        <input type="submit" value="刪除"/>
    </form>
    
    <hr/>
    	<h3>修改使用者密碼</h3>
        <form action="updateUser">
        帳號： <input type="text" name="username"/>
        新密碼： <input type="text" name="password"/>
        <input type="submit" value="更新"/>
    </form>

    
</body>
</html>