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
	</header>
	<div class="container">
		<div class="sub_menu">
			<div class = "subject_h1" >
				<h1>조 회 </h1>
			</div>
			<div class = "subject_h5">
				<h5>홈 > 앨범게시판 > 조회하기</h5>
			</div>
			
		</div>
		
		<form action="/" method="post" id="readForm">
			<input type="hidden" id="ano" name="ano" value="${read.ano}" />				
		</form>
		
			<div class="input_group_a">
				
				<div class="input-group">
					<span class="input-group-text">사 진</span>
					<img id="image" src="" width="700" alt="로컬에 있는 이미지가 보여지는 영역">
				</div>
				
		
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">내 용</span> 
					<input type="text" class="form-control" name="acontent" value="${read.acontent}" readonly="readonly"/>
				</div>
				<span>파일 목록</span>
				<div class="form-group" style="border: 1px solid #dbdbdb;">
					<c:forEach var="file" items="${file}">
						<a href="#" onclick="fn_fileDown('${file.FILE_NO}'); return false;">${file.ORG_FILE_NAME}</a>(${file.FILE_SIZE}kb)<br>
					</c:forEach>
				</div>
				
			<div class="btn_group">
					<button type="button" class="btn btn-primary" id="btn_update">수 정</button>
					<button type="button" class="btn btn-primary" id="btn_delete">삭 제</button>
					<button type="button" class="btn btn-danger" id="btn_list">목 록</button>
				</div>
			</div>
			
	</div>

	<div class="bottom">
	</div>

	<script>
		$(document).ready(function(){
			
			const readForm = $("#readForm");
			
			// 목록 버튼 누르면 목록으로 가기
			$("#btn_list").on("click",function(){
				location.href="/controller/albumboard/list"
			})
			
			// 수정 버튼을 누르면 writeView로 이동
			$("#btn_update").on("click",function(){
				
				readForm.attr("action", "/controller/albumboard/updateView");
				readForm.attr("method", "get");
				readForm.submit();
			})
			
			
			// 삭제 버튼을 누르면 게시글 삭제
			$("#btn_delete").on("click",function(){
				
				//삭제 버튼 누르면 confirm으로 한번 더 확인
				const deleteChk = confirm("삭제 하시겠습니까?");
				
				if(deleteChk == true){
					
				readForm.attr("action", "/controller/albumboard/delete");
				readForm.attr("method","post");
				readForm.submit();
				}
			})
			
			//사진 조회
		
			var fileContent = "${fileImg}"
			document.getElementById("image").src = "data:image/png;base64," + fileContent; 
			
		})

				    
			    
	
	</script>

</body>
</html>