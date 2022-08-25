<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
            <a class="navbar-brand" href="#">어서오세요 지원이나라 🐾🐈</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
               <%-- if else 처럼쓰임 --%>
                <c:choose>
                   <%-- if --%>
                   <c:when test="${empty sessionScope.member}">
                      <li class="nav-item">
                          <a class="nav-link" href="/member/login">로그인</a>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link" href="/member/join">회원가입</a>
                      </li>
                   </c:when>
                   
                   
                   
                   <%-- else --%>
                   <c:otherwise>
                      <li class="nav-item">
                          <a class="nav-link active" href="/member/mypage">마이페이지</a>
                      </li>
                   </c:otherwise>
                </c:choose>
                
                <li class="nav-item">
                    <a class="nav-link" href="/qna/list">QNA</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/notice/list">NOTICE</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/bankbook/list">상품리스트</a>
                </li>
				<li class="nav-item">
                    <a class="nav-link" href="/member/logout">로그아웃</a>
                      </li>
                </ul>
            </div>
            </div>
        </nav>
    </header>
    
<!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
