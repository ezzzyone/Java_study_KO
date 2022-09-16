<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- JQuery --%>
     <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
     
   <%-- Required meta tags --%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%-- <%-- Bootstrap CSS --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> --%>
     
     <%-- SummerNote --%>
     <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

</head>
<body>
	<section class="container-fluid col-lg-4">
	<h1>${board} Update Page</h1>

	<form action="./update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" readonly="readonly" value="${boardDTO.num}">
		<div>
		<input type="hidden" name="writer" readonly="readonly" value="${boardDTO.writer}">
		</div>
		<div>
			제목 : <input type="text" name="title" value="${boardDTO.title}">
		</div>
		<div>
			내용 : <input type="text" name="contents" value="${boardDTO.contents}">
		</div>
		<br>
		<br>
		<span>${boardDTO.boardFileDTO}</span>
		<c:forEach items="${boardDTO.boardFileDTO}" var="fileDTO">
             <div class="mb-3">
                  <span class="form-control">${fileDTO.oriName}</span>
                  <button type="button" class="fileDelete" data-file-num="${fileDTO.fileNum}">삭제</button>
               </div>
         </c:forEach>

		 <div id="addfiles">

			<button type="button" id="fileAdd">파일추가</button>
		
		  </div>
         
         <div class="mb-3">
            <button class="btn btn-success">WRITE</button>
         </div>

		<!-- 이걸 많이 씀!! <button type="submit">수정</button> -->
	</form>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script>
	setCount(${boradDTO.boardFileDTO.size()});
</script>
</body>
<script src="/resources/js/add.js"></script>
</html>