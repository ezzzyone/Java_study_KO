<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.ko.home.board.qna.QnaDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- 요청이 발생하면 생성, 응답이 나가면 소멸 : Requst --> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} 디테일</h1>

	<table border="1">
		<thead>
			<tr>
				<th>num</th>
				<th>title</th>
				<th>writer</th>
				<th>contents</th>
				<th>regdate</th>
				<th>hit</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${requestScope.detail.num}</td><!-- 속성명 잘 보기! -->
				<td>${requestScope.detail.title}</td>
				<td>${detail.writer}</td>
				<td>${detail.contents}</td>
				<td>${detail.regdate}</td>
				<td>${detail.hit}</td>
			</tr>
		</tbody>
	</table>
	
<%-- 	<c:if test="${empty sessionScope.member}">
	<a href="../member/login">로그인</a>
	<a href="../member/join">회원가입하기</a>
	</c:if>
	
	<c:if test="${not empty sessionScope.member}">
	<a href="./update?bookNum=${detail.bookNum}">통장수정</a>
	<a href="./delete?bookNum=${detail.bookNum}">통장삭제</a>
	<a href="../bankAccount/add?bookNum=${detail.bookNum}">통장가입하기</a>
	</c:if> --%>
	
	<a href="./list" class="btn btn-default" role="button">QNA리스트</a>
	<a href="./update?num=${boardDTO.num}" class="btn btn-default" role="button">질문수정</a>
	<a href="./delete?num=${boardDTO.num}" class="btn btn-default" role="button">삭제</a>
	<a href="./reply?num=${boardDTO.num}" class="btn btn-default" role="button">답글입력</a>
</body>
</html>