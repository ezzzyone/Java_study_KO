<%@page import="java.util.ArrayList"%>
<%@page import="com.ko.home.board.qna.QnaDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:import url="../template/header.jsp"></c:import>
<section class="container-fluid col-lg-2">
	<h1>${board} 리스트</h1>
	<!-- /book/list -->
	
	<!-- /book/detail   jsp:derail.jsp -->
	<!-- link 주소는 상대경로 작성 -->
	<!-- 이 페이지의 URL주소를 보고 경로를 결정 -->
	<!-- <a href="./detail">Detail</a> 이렇게 써도 됀다 -->
	
	<table border="1" class="table table-striped">
		<thead>
			<tr>
				<th>게시글 제목</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach items="${requestScope.list}" var="dto">
					<tr>
					<!-- 파라미터 보낼때 띄어쓰기 하지말기 예를들어 detail?bookNum=... -->
						<td><a href="detail?num=${dto.num}">${dto.title}</a></td>
					</tr>
				</c:forEach>
		</tbody>
	</table>
	</section>
	<c:if test="${not empty sessionScope.member}">
		<a href="./add">게시글작성</a>
	</c:if>
	
	
	
	
	<nav aria-label="Page navigation example">
  <ul class="pagination">
  <c:if test="${pager.pre}">
    <li class="page-item">
      <a class="page-link" href="./list?page=${pager.startNum-1}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </c:if>
    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
	 <li class="page-item"><a class="page-link" href="./list?page=${i}">${i}</a></li>
	</c:forEach>
	
<%-- 	<c:choose>
	<c:when test="${pager.next}">
	<li class="page-item">
	</c:when>
	<c:otherwise>
	<li class="page-item disabled"> 
	</c:otherwise>
	</c:choose> --%>
	<li class="page-item ${pager.next?'':'disabled'}">
      <a class="page-link" href="./list?page=${pager.lastNum+1}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    
  </ul>
</nav>

	
</body>

<c:import url="../template/footer.jsp"></c:import>
</html>