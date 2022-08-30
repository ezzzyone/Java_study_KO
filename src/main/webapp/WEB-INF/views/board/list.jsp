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
<section class="container-fluid col-lg-6">
<h1 class="align-center">${board} List Page</h1>
<div class="row">
	<!-- /book/list -->
	
	<!-- /book/detail   jsp:derail.jsp -->
	<!-- link 주소는 상대경로 작성 -->
	<!-- 이 페이지의 URL주소를 보고 경로를 결정 -->
	<!-- <a href="./detail">Detail</a> 이렇게 써도 됀다 -->
	
	
      <div>
         <form action="./list.ko" class="row row-cols-lg-auto g-3 align-items-center">
         
           <div class="col-12">
             <label class="visually-hidden" for="kind">kind</label>
             <select name="kind" class="form-select" id="kind">
               <option class="kinds" value="Contents">Contents</option>
               <option class="kinds" value="Title">Title</option>
               <option class="kinds" value="Writer">Writer</option>
             </select>
           </div>
         
           <div class="col-12">
             <label class="visually-hidden" for="search">검색어</label>
             <div class="input-group">
               <input type="text" name="search" value="${param.search}" class="form-control" id="search">
             </div>
           </div>
         
           <div class="col-12">
             <button type="submit" class="btn btn-default">검색</button>
           </div>
         </form>
      </div>
<p></p>
<table class="table">
	  <thead class="table-dark">
	    <tr>
	      <th scope="col">NUM</th>
	      <th scope="col">TITLE</th>
	      <th scope="col">WRITER</th>
	      <th scope="col">DATE</th>
	      <th scope="col">HIT</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach items="${list}" var="dto" >
			<tr>
				<td>${dto.num}</td>
				<!-- 파라미터 보낼때 띄어쓰기 하지말기 -->
				<td>
				<c:catch>
				<c:forEach begin="1" end="${dto.depth}" >--</c:forEach>
				</c:catch>
				<a href="./detail.iu?num=${dto.num}">${dto.title}</a>
				</td>
				<td>${dto.writer}</td>
				<td>${dto.regdate}</td>
				<td>${dto.hit}</td>	
			</tr>
		</c:forEach>
	  </tbody>
</table>

	<c:if test="${not empty sessionScope.member}">
		<a href="./add">게시글작성</a>
	</c:if>

	<nav aria-label="Page navigation example">
  <ul class="pagination">
  <c:if test="${pager.pre}">
    <li class="page-item">
      <a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </c:if>
    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
	 <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
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
      <a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    
  </ul>
</nav>
	
	
	</section>


	<script src="/resources/js/board.js"></script>

	<script>

	

		let k ='${param.kind}';
		const kinds = document.getElementsByClassName("kinds");

		for(let i=0;i<kinds.length;i++){
			if(kinds[i].value==k){
			kinds[i].selected=true;
			}
		}



		
	
		

	</script>

</body>

<c:import url="../template/footer.jsp"></c:import>
</html>