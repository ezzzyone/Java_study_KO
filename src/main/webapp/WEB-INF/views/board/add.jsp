<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add</title>

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
	<h1>${board} Add</h1>
	<br>
	<form action="./add" method="post">
		작성자를 입력하세요
		<br>
		<input type="text" name="writer">
		<br>
		글 제목을 입력하세요
		<br>
		<input type="text" name="title">
		<br>
		글 내용을 입력하세요
		<br>
	<!-- 	<input type="text" name="contents" id="contents"> -->
		
		<textarea class="form-control" name="contents" id="contents" rows="3">${boardDTO.contents}</textarea>
		<br>
		
		<input type="submit" value="답글달기완료"><input type="reset" value="초기화">
		<!-- 위에 말고 밑에는 가능 <butoon type="submit">Add</button> -->
		
	</form>
	
	<%-- without bootstrap 주석 가능 --%>
<%-- <%-- bootstrap --%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script> --%>

<script type="text/javascript">
$("#contents1").summernote();
</script>

</body>
</html>