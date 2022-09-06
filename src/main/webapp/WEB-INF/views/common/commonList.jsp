<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <table class="table table-dark table-striped">

        <c:forEach items="${commentList}" var="dto">
            <tr>

                <td>${dto.contents}</td>
                <td>${dto.writer}</td>
                <td>${dto.regdate}</td>
            </tr>

        </c:forEach>

    </table>