<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Main Page  
</h1>
	<button type="button" onclick="location.href='./member/login.iu'">로그인</button>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
