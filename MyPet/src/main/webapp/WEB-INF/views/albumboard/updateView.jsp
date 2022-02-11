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
 <link href="${path}/resources/css/freeboard/writeView.css"rel="stylesheet" >
<!-- 부트스트랩 CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<title>MyPet</title>
</head>
<body>
	<header>
	 <jsp:include page="../top_bottom/header.jsp"></jsp:include>
	</header>
	<div class="container">
		<div class="sub_menu">
			<div class = "subject_h1" >
				<h1>조 회 </h1>
			</div>
			<div class = "subject_h5">
				<h5>홈 > 앨범게시판 > 수정하기</h5>
			</div>
			
		</div>
		
		<form action="/controller/albumboard/update" method="post" >
			<div class="input_group_a">
				<input type="hidden" id="ano" name="ano" value="${update.ano}" />		
			
				<div class="input-group">
					<span class="input-group-text">사 진</span>
					<img id="image" src="" width="700" alt="로컬에 있는 이미지가 보여지는 영역">
				</div>
				
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">내 용</span> 
					<input type="text" class="form-control" name="acontent" value='<c:out value="${update.acontent}"></c:out>'/>
				</div>

				<div class="btn_group">
					<button type="submit" class="btn btn-primary" id="btn_write">수 정</button>
					<button type="button" class="btn btn-danger" id="btn_list">취 소</button>
				</div>
			</div>
		</form>
	</div>

	<div class="bottom">
	</div>

	<script>
		$(document).ready(function(){
			// 목록 버튼 누르면 목록으로 가기
			$("#btn_list").on("click",function(){
				location.href="/controller/albumboard/list"
			})
			
			
			//사진 조회
			var fileContent = "${fileImg}"
			document.getElementById("image").src = "data:image/png;base64," + fileContent;  
			
		})
	
	</script>

</body>
</html>