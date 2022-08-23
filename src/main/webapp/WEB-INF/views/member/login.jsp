<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
  </head>
<body>

    <c:import url="../template/header.jsp"></c:import>
    
		
	
<section class="container-fluid col-lg-4">
<div class="row">
<h1>Login Page</h1>
<form action="./login" method="post">
  <div class="mb-3">
    <label for="exampleInputID" class="form-label">ID</label>
    <input type="text" name="userName" class="form-control" id="userName" aria-describedby="idHelp">
    <div id="idHelp" class="form-text">아이디를 입력하세요~</div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" name="passWord" class="form-control" id="exampleInputPassword1">
  </div>
  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>
  <button type="submit" class="btn btn-primary" >Submit</button>
</form>
</div>
</section>

    <c:import url="../template/footer.jsp"></c:import>
</html>
