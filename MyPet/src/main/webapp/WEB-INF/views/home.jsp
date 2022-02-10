<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>My Pet</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sign-in/">
    <!-- jquery CDN -->	
	<script src="https://code.jquery.com/jquery-3.6.0.slim.min.js" integrity="sha256-u7e5khyithlIdTpu22PHhENmPcRdFiHRjhAuHcs05RI=" crossorigin="anonymous"></script>		
    
	<!-- 절대경로 -->
	<link href="${path}/resources/css/home/index.css"rel="stylesheet" >

	<!-- 부트스트랩 CDN -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
 
  <body class="text-center">
    
<main class="form-signin">
  <form name='homeForm' method="post" action="/controller/member/login">
    <img class="mb-4" src="${path}/resources/images/home/logo.png" alt="" width="230" height="170">
    <c:if test="${member == null}">
    <div class="form-floating">
      <input type="text" class="form-control" name="userId" id="userId" placeholder="name@example.com" required>
      <label for="floatingInput">아이디를 입력해주세요.</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" name="userPass" id="userPass" placeholder="Password" required>
      <label for="floatingPassword">비밀번호를 입력해주세요</label>
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
    <button class="w-100 btn btn-lg btn-danger" type="button" id="register_btn">회원가입</button>
    </c:if>
    
    	<c:if test="${member != null}">
        		<p>${member.userId}님 안녕하세요.</p>
      		<a href="/controller/member/logout">
        		<button type="button" class="btn btn-outline-primary me-2">Login Out</button>
       		</a>
       	</c:if>
    
    <p class="mt-5 mb-3 text-muted">&copy; 2011-2022</p>
    
  </form>
</main>
  </body>
  
  <script>
	$(document).ready(function(){
		
		
		$("#register_btn").on("click", function(){
			location.href="/controller/member/register";
		})
		
		
	})
</script>
  
</html>
