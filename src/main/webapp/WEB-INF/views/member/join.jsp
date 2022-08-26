<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  </head>
<body>

	<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid con-lg-7">
		<div class="row">
			<h1>Join Page</h1>
			<%--enctype 넘기는 타입. 파일은 잘게 쪼개서 넘어가야함.--%>
			<form action="./join" method="POST" enctype="multipart/form-data">
			
			   <div class="mb-3">
    <label for="files" class="form-label">Photo</label>
    <input type="file" name="photo" class="form-control" id="files" aria-describedby="idHelp" value="jw1">
    <div id="idHelp" class="form-text">사진 주세요~</div>
  </div>
  
			 <div class="row mb-3">
			    <label for="inputUserName" class="col-sm-2 col-form-label">ID</label>
			    <div class="col-sm-10">
			      <input type="text" name="userName" class="form-control" id="inputUserName" placeholder="ID 입력">
			    </div>
			  </div>
			  <div class="row mb-3">
			    <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
			    <div class="col-sm-10">
			      <input type="password" name="passWord" class="form-control" id="inputPassword" placeholder="Password 입력">
			    </div>
			  </div>
			  <div class="row mb-3">
			    <label for="inputName" class="col-sm-2 col-form-label">Name</label>
			    <div class="col-sm-10">
			      <input type="text" name="name" class="form-control" id="inputName" placeholder="이름 입력">
			    </div>
			  </div>
			  
			  <div class="row mb-3">
			    <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
			    <div class="col-sm-10">
			      <input type="email" name="email" class="form-control" id="inputEmail" placeholder="Email 입력">
			    </div>
			  </div>
			  <div class="row mb-3">
			    <label for="inputPhone" class="col-sm-2 col-form-label">Phone</label>
			    <div class="col-sm-10">
			      <input type="text" name="phone" class="form-control" id="inputPhone" placeholder="전화번호 입력">
			    </div>
			  </div>
			  <div class="row justify-content-end">
			  	<div >
			  		<button type="submit" class="btn btn-primary mb-3">Sign in</button>
			  	</div>
			  </div>
			</form>
			
		</div>
	</section>
	
	<c:import url="../template/footer.jsp"></c:import>

</body>
</html>