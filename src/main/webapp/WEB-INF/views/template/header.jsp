<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
            <a class="navbar-brand" href="#">Bank</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                
                <!-- if else문과 같음 -->
                <c:choose>
                	<!-- if -->
                	<c:when test="${empty sessionScope.member}">
		                <li class="nav-item">
		                    <a class="nav-link active" href="/member/login.ko">로그인</a>
		                </li>
		                <li class="nav-item">
		                    <a class="nav-link" href="/member/join.ko">회원가입</a>
		                </li>
                	</c:when>
                	<!-- else -->
                	<c:otherwise>
		                <li class="nav-item">
		                    <a class="nav-link active" href="/member/mypage.ko">로그아웃</a>
		                </li>
		                <li class="nav-item">
		                    <a class="nav-link" href="/member/logout.ko">마이페이지</a>
		                </li>
                	</c:otherwise>
                </c:choose>
                <li class="nav-item">
                    <a class="nav-link" href="/board/list.iu">공지사항</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/bankbook/list.iu">상품리스트</a>
                </li>
                
                </li>
                </ul>
            </div>
            </div>
        </nav>
    </header>