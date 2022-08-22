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

<c:import url="../template/header.jsp"></c:import>

	<h1>Member List Page</h1>

	<table class="table table-striped" border="1">
		<thead>
			<tr>
				<th>UserName</th><th>Name</th><th>Email</th><th>Phone</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list}" var="dto">			
				<tr>
	
				 <td>${dto.userName}</td>
  				<td>${dto.name}</td>
  				<td>${dto.email}</td>
 				 <td>${dto.phone}</td>
 			
				
				</tr>
			</c:forEach>
		</tbody>
	</table>
		 
</body>
<c:import url="../template/footer.jsp"></c:import>
</html>
