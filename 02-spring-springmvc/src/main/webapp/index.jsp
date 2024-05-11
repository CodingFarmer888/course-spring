<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="login">
		帳號：<input type="text" name="username" />
		<br/>
		密碼：<input type="text"name="password" />
		<br/>
		<button type="submit">送出</button>
	</form>
	
	<hr/>
	
	<a href="h1">發送 /h1 請求</a><br>

	<a href="h2">發送 /h2 請求</a><br>
	
	
	<hr/>
	
	<a href="user/Guybrush">發送 /user/{name}" 請求</a><br>
	
	<a href="user/regex/Guybrush">發送 /user/regex/{name:[a-zA-Z]+} 請求</a><br>
	

	
	
	<hr/>
	<p>前端後段參數傳遞</p>
	<p>HttpServletRequest</p>
	<form action="loginHttpServletRequest" method="GET">
		帳號：<input type="text" name="username" />
		<br/>
		密碼：<input type="text"name="password" />
		<br/>
		<button type="submit">送出</button>
	</form>
	
	<p>RequestParam</p>
	<form action="loginRequestParam" method="GET">
		帳號：<input type="text" name="username" />
		<br/>
		密碼：<input type="text"name="password" />
		<br/>
		<button type="submit">送出</button>
	</form>
	
	<p>Model</p>
	<form action="loginModel" method="GET">
		帳號：<input type="text" name="username" />
		<br/>
		密碼：<input type="text"name="password" />
		<br/>
		<button type="submit">送出</button>
	</form>

	<hr/>
	
	<p>ModelAttribute</p>
	<form action="loginModelAttribute" method="GET">
		帳號：<input type="text" name="username" />
		<br/>
		密碼：<input type="text"name="password" />
		<br/>
		<button type="submit">送出</button>
	</form>

	<hr/>
	
	<p>ModelAndView</p>
	<form action="loginModelAndView" method="GET">
		帳號：<input type="text" name="username" />
		<br/>
		密碼：<input type="text"name="password" />
		<br/>
		<button type="submit">送出</button>
	</form>

	<hr/>
	
	<form action="param/hobby" method="POST">
	<!-- <form action="param/class" method="POST"> -->
		暱稱: <input type="text" name="nickname"/> <br>
		手機: <input type="text" name="phone"/> <br>
		興趣：<br>
		<input type="checkbox" name="hobby" value="吃飯"/>吃飯
		<input type="checkbox" name="hobby" value="睡覺"/>睡覺
		<input type="checkbox" name="hobby" value="打東東"/>打東東
		<br>
		<input type="submit" />
	</form>
	
	<hr/>
	
	<a href="setSession">Set Sesstion</a>
	<br/>
	<a href="getSession">Get Sesstion</a>
	
</body>
</html>