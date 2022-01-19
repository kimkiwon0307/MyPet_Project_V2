<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

 <link href="${path}/resources/css/freeboard.css"rel="stylesheet" >
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
				<h1>글쓰기 </h1>
			</div>
			<div class = "subject_h5">
				<h5>홈 > 자유게시판 > 글쓰기</h5>
			</div>
			
		</div>
		
		<form action="/controller/freeboard/write" method="post" >
				
			<div class="input_group_a">
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">이 름</span> 
					<input type="text" class="form-control" placeholder="Username" name="fwriter"/>
				</div>
			
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">제 목</span> 
					<input type="text" class="form-control" placeholder="제목을 작성하세요." 
					name="ftitle" aria-label="Username" aria-describedby="basic-addon1">
				</div>
			
			
				<div class="input-group">
					<span class="input-group-text">내 용</span>
  					<textarea class="form-control" aria-label="With textarea" name="fcontent"></textarea>
				</div>
				
				<div class="btn_group">
					<button type="submit" class="btn btn-primary">작 성</button>
					<button type="button" class="btn btn-danger">목 록</button>
				</div>
			</div>
		</form>
			
	</div>

	<div class="bottom">
	</div>

</body>
</html>