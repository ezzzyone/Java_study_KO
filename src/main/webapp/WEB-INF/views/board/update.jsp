<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} Update Page</h1>

	<form action="./update" method="post">
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
		<input type="submit" value="수정" >
		<!-- 이걸 많이 씀!! <button type="submit">수정</button> -->
	</form>
</body>
</html>