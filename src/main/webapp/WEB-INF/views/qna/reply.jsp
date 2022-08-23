<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>QNA 답글 작성 페이지</h1>
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
		<input type="text" name="contents">
		<br>
		
		<input type="submit" value="답글달기완료"><input type="reset" value="초기화">
		<!-- 위에 말고 밑에는 가능 <butoon type="submit">Add</button> -->
		
	</form>

</body>
</html>