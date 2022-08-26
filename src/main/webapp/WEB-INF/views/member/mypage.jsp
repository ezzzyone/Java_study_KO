<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myPage</title>
</head>
<body>

<c:import url="../template/header.jsp"></c:import>

<section class="container-fluid col-lg-4 mt-5">
	<p>ID : ${requestScope.dto.userName}</p>
	<p>NAME : ${requestScope.dto.name}</p>
	<p>EMAIL : ${requestScope.dto.email}</p>
	<p>PHONE : ${requestScope.dto.phone}</p>
	
	<c:forEach items="${dto.bankAccountDTO}" var="dto">
	<p>통장번호: ${pageScope.dto.accountNum}</p>
	<p>통장이름: ${pageScope.dto.bankBookDTO.bookName}</p>
	<p>개설일자: ${pageScope.dto.accountDate}</p>
	</c:forEach>
</section>

<%-- 	<p>ID : ${requestScope.dto.userName}</p>
	<p>NAME : ${requestScope.dto.name}</p>
	<p>EMAIL : ${requestScope.dto.email}</p>
	<p>PHONE : ${requestScope.dto.phone}</p>
	
	<c:forEach items="${list}" var="dto">
	<p>${pageScope.dto.accountNum}</p>
	<p>${pageScope.dto.bankBookDTO.bookName}</p>
	<p>${pageScope.dto.accountDate}</p>
	</c:forEach> --%>

<%-- <p>${map}</p>

	<h1>MyPage</h1>
	<p>ID : ${map.dto.userName}</p>
	<p>NAME : ${map.dto.name}</p>
	<p>EMAIL : ${map.dto.email}</p>
	<p>PHONE : ${map.dto.phone}</p>
	
	<c:forEach items="${map.list}" var="dto">
	<p>${dto.accuontNum}</p>
	<p>${dto.bankbookDTO.bookName}</p>
	<p>${dto.accountDate}</p>
	</c:forEach> --%>
	
	<div class="row">
	<img src="../resources/upload/member/${dto.bankMemberFileDTO.fileName}">
	</div>
		 
</body>
<c:import url="../template/footer.jsp"></c:import>
</html>
