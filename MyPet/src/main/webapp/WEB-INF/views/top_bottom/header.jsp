<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 절대경로 -->
<link href="${path}/resources/css/top_bottom/header.css"rel="stylesheet" >

<title>Insert title here</title>

</head>
<body>

  <div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
      <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
        <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
        </svg>
      </a>

      <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
        <li><a id="a_header" href="/controller" class="nav-link px-2 link-secondary">Home |</a></li>
        <li><a id="a_header" href="/controller/albumboard/list" class="nav-link px-2 link-dark">Album |</a></li>
        <li><a id="a_header" href="/controller/freeboard/list" class="nav-link px-2 link-dark">FreeBoard</a></li>
      </ul>

      <div class="col-md-3 text-end">
      	<c:if test="${member != null}">
        		<p>${member.userId}님 안녕하세요.</p>
      			<button type="button" class="btn btn-outline-primary me-2" id="user_info">회원정보</button>
      		<a href="/controller/member/logout">
        		<button type="button" class="btn btn-outline-primary me-2">Login Out</button>
       		</a>
       	</c:if>
      </div>
    </header>
  </div>
</body>
	<script>
		$(document).ready(function(){
			
			$("#user_info").on("click",function(){
				
				location.href="/controller/member/memberUpdateView";
			})
			
		})
	
	</script>


</html>