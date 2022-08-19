<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> 이거지우기!!!!!!!! --%>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Main Page  
</h1>
<P>  The time on the server is ${serverTime}. </P>

	<c:if test="${empty sessionScope.member}">
		<h2>어서오세요~</h2>	
		<button type="button" onclick="location.href='./member/login.iu'">로그인</button>
		<button type="button" onclick="location.href='./member/join.iu'">회원가입</button>
	</c:if>
	
	<c:if test="${not empty sessionScope.member}">
		<h2>${sessionScope.member.userName}님 환영합니다!</h2>
		<button type="button" onclick="location.href='./member/logout.iu'">로그아웃</button>
		<button type="button" onclick="location.href='./member/mypage.iu'">마이페이지</button>
	</c:if>
	
	<button type="button" onclick="location.href='./member/list.iu'">아이디검색</button>
	<button type="button" onclick="location.href='./bankbook/list.iu'">통장리스트</button>
</body>
</html>
