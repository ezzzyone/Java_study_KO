<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> 이거지우기!!!!!!!! --%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Main Page  
</h1>
<ol>
	<li>first</li>
	<li>seconds</li>
</ol>
<div><ul><a href="./bankbook/list.iu">상품리스트</a></ul>
	
	<ul><a href="./member/login.ko">멤버로그인</a></ul>
</div>

	<c:if test="${empty sessionScope.member}">
		<h2>어서오세요~</h2>	
		<button type="button" onclick="location.href='./member/login.ko'">로그인</button>
		<button type="button" onclick="location.href='./member/join.ko'">회원가입</button>
	</c:if>
	
	<c:if test="${not empty sessionScope.member}">
		<h2>${sessionScope.member.userName}님 환영합니다!</h2>
		<button type="button" onclick="location.href='./member/logout.ko'">로그아웃</button>
	</c:if>
	
	<button type="button" onclick="location.href='./bankbook/list.iu'">통장리스트</button>
</body>
</html>
