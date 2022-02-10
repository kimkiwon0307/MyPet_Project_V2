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
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<!-- 절대경로 -->
 <link href="${path}/resources/css/member/register.css"rel="stylesheet" >
<!-- 부트스트랩 CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<title>MyPet</title>
</head>

	<body>
	<header>
	</header>
 <div class="album py-5 bg-light">
	<div class="container">
			<div class="sub_menu">
			<div class = "subject_h1" >
				<h1>회원탈퇴 </h1>
			</div>
			<div class = "subject_h5">
				<h5>회원정보 > 회원탈퇴</h5>
			</div>
			
		</div>
			<form action="/controller/member/memberDelete" method="post" id="delForm">
				<div class="form-group has-feedback">
					<label class="control-label" for="userId">아이디</label>
					<input class="form-control" type="text" id="userId" name="userId" value="${member.userId}" readonly="readonly"/>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userPass">패스워드</label>
					<input class="form-control" type="password" id="userPass" name="userPass" required="required"/>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userName">성명</label>
					<input class="form-control" type="text" id="userName" name="userName" value="${member.userName}" readonly="readonly"/>
				</div>
				<div class="form-group has-feedback" style="float: right; margin-top: 10px;">
					<button class="btn btn-success" type="button" id="delete_btn">회원탈퇴</button>
					<button class="cencle btn btn-danger" type="button">취소</button>
				</div>
			</form>
			<div>
				<c:if test="${msg == false}">
					비밀번호가 맞지 않습니다.
				</c:if>
			</div>
		</div>
	</div>
		
	</body>
	<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cencle").on("click", function(){
				
				location.href = "/controller/member/memberUpdateView";
						    
			})
		
			$("#delete_btn").on("click",function(){
		
			
			$.ajax({
				url : "/controller/member/passChk",
				type : "POST",
				dataType : "json",
				data : $("#delForm").serializeArray(),
				success: function(data){
					
					if(data==0){
						alert("패스워드가 틀렸습니다.");
						return;
					}else{
						if(confirm("회원탈퇴하시겠습니까?")){
							$("#delForm").submit();
						}
						
					}
				}
			})
			
		});
		
	})
			
	</script>
</html>