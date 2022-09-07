<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.ko.home.BankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- 요청이 발생하면 생성, 응답이 나가면 소멸 : Requst --> 
<%-- BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("detail"); --%>
<!DOCTYPE html>
<html>
<head>
<link rel="short icon" href="#">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>통장 상세정보</h1>

	<table border="1">
		<thead>
			<tr>
				<th>BookNum</th>
				<th>BookName</th>
				<th>BookRate</th>
				<th>BookSale</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${requestScope.detail.getBookNum()}</td><!-- 속성명 잘 보기! -->
				<td>${requestScope.detail.bookName}</td>
				<td>${detail.bookRate}</td>
				<td>${detail.bookSale}</td>
			</tr>
		</tbody>
	</table>
	
	<c:if test="${empty sessionScope.member}">
	<a href="../member/login">로그인</a>
	<a href="../member/join">회원가입하기</a>
	</c:if>
	
	<c:if test="${not empty sessionScope.member}">
	<a href="./update?bookNum=${detail.bookNum}">통장수정</a>
	<a href="./delete?bookNum=${detail.bookNum}">통장삭제</a>
	<a href="../bankAccount/add?bookNum=${detail.bookNum}">통장가입하기</a>
	</c:if>
	
	<a href="./list">통장리스트</a>

	<!--comment insert 영역시작-->
	<div class="row">
		<div class="mb-3">
			<label for="writer" class="form-label">Username</label>
			<input type="text" class="form-control" id="writer" placeholder="enter your username">
		  </div>
		  <div class="mb-3">
			<label for="contents" class="form-label">contents</label>
			<textarea class="form-control" id="contents" row="3"></textarea>
		  </div>
		  <div class="mb-3">
			<button type="button" id="commentAdd" data-book-num="${detail.bookNum}">button</button>
		  </div>

		  	<!--comment list 영역시작-->

			<div>

				<table id="commentList">

				</table>

				

			</div>

			<button id="more" class="btn btn-danger">더보기</button>



	</div>
</body>
<script src="/resources/js/bankbookComment.js"></script>
</html>