<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
  </head>
<body>
	<section class="container-fluid con-lg-7">
		<div class="row">
			<h1>아이디 검색</h1>
			<form action="./search.iu" method="post">
								  <div class="mb-3">
				  <label for="exampleInputEmail1" class="form-label">아이디 입력하세요</label>
				  <input type="text" name="userName" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
				  <%-- <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div> --%>
				  </div>
				  <div class="mb-3">
				    <label for="exampleInputPassword1" class="form-label">비밀번호를 입력하세요</label>
				    <input type="text" name="passWord" class="form-control" id="exampleInputPassword1">
				  </div>
				  <div class="mb-3 form-check">
				    <input type="checkbox" class="form-check-input" id="exampleCheck1">
				    <label class="form-check-label" for="exampleCheck1">Check me out</label>
				  </div>
				  <button type="submit" class="btn btn-primary">아이디검색중</button>
			</form>
		</div>
	</section>
	
</body>
</html>