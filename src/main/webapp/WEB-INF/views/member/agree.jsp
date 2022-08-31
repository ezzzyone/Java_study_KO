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
<h1>Agree Page</h1>


  <div>

 전체동의<input type="checkbox" id="all">
  약관(필수)<input type="checkbox" class="cb req" >
  약관(필수)<input type="checkbox" class="cb req" >
  약관(선택)<input type="checkbox" class="cb" >

</div>

<form id="frm" action="./join">
  <button type="button" id="join">회원가입</button>

</form>
</div>
</section>
</body>
  <script src="/resources/js/member.js"></script>
  <script>
    check();
  </script>
    <c:import url="../template/footer.jsp"></c:import>
</html>
