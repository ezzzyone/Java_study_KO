<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%-- Required meta tags --%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%-- Bootstrap CSS --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  </head>
<body>
	<h1>Member List Page</h1>
	
	<section class="container text-center con-lg-7">
		<div class="row align-items-center">
			<div class="col">
				회원아이디
			</div>
			<div class="col">
				이름
			</div>
			<div class="col">
				이메일
			</div>
			<div class="col">
				전화번호
			</div>
		</div>
		<div class="row align-items-center">
			<c:forEach items="${requestScope.list}" var="dto">
				<div class="col">
					${dto.userName}
				</div>
				<div class="col">
					${dto.name}
				</div>
				<div class="col">
					${dto.email}
				</div>
				<div class="col">
					${dto.phone}
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>