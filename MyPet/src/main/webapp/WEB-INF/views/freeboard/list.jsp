<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- jquery CDN -->	
<script src="https://code.jquery.com/jquery-3.6.0.slim.min.js" integrity="sha256-u7e5khyithlIdTpu22PHhENmPcRdFiHRjhAuHcs05RI=" crossorigin="anonymous"></script>		

<!-- 절대경로 -->
<link href="${path}/resources/css/freeboard/list.css"rel="stylesheet" >

<!-- 부트스트랩 CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<title>MyPet</title>
</head>
<body>
	<header>
	</header>
	<div class="container">
		<div class="sub_menu">
			<div class = "subject_h1" >
				<h1>목록 </h1>
			</div>
			<div class = "subject_h5">
				<h5>홈 > 자유게시판 > 목록</h5>
			</div>
			
		</div>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">이름</th>
					<th scope="col">날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="list">
					<tr>
						<th scope="row"><c:out value="${list.fno}" /></th>
						<td><a href="/controller/freeboard/readView?fno=${list.fno}"><c:out value="${list.ftitle}" /></a></td>
						<td><c:out value="${list.fwriter}" /></td>
						<td><fmt:formatDate value="${list.regdate}"
								pattern="yyyy-MM-dd" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="btn_group">
			<button type="button" class="btn btn-primary" id="btn_write">작 성</button>
		</div>

	</div>

	<div class="bottom">
	</div>

	<script>
	
		
	$(document).ready(function(){
	
		// 글쓰기 버튼 누르면 글쓰기 화면으로 이동
		$("#btn_write").on("click",function(){
			location.href="/controller/freeboard/writeView";
		})
		
		
		
		
	})
	</script>

</body>
</html>