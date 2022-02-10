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
					<h1>회원가입 </h1>
				</div>
			<div class = "subject_h5">
				<h5>홈 > 회원가입</h5>
			</div>
			
		</div>
	
		<form action="/controller/member/register" method="post" id="regForm">
			<div class="input_group_a">
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">아이디</span> 
					<input type="text" class="form-control" placeholder="아이디를 작성하세요." id="userId" name="userId" required/>
					<button class="idChk" type="button" id="idChk" value="N">중복확인</button>
				</div>
			
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">패스워드</span> 
					<input type="password" class="form-control" placeholder="제목을 작성하세요." 
					name="userPass" aria-label="Username" aria-describedby="basic-addon1" required>
				</div>
				
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">이 름</span> 
					<input type="text" class="form-control" placeholder="이름을 작성하세요." name="userName" required/>
				</div>

				<div class="form-group has-feedback" id="btn_set">
					<button class="btn btn-success" type="submit" id="submit">회원가입</button>
					<button class="cencle btn btn-danger" type="button">로그인</button>
				</div>
			</div>
	      </form>
		</div>
	</div>
	</body>
<script>
		$(document).ready(function(){
			// 취소
			$(".cencle").on("click", function(){
				location.href = "/controller";
			})
			
			$("#submit").on("click",function(){
				var idChkVal = $("#idChk").val();
		
				
				if(idChkVal == "N"){
					alert("중복확인 버튼을 눌러주세요.");
					return false;
				}else if(idChkVal == "Y"){
					
					$("#regForm").submit();
					
				}
				
			});
			
			$("#idChk").on("click",function(){
				$.ajax({
					url : "/controller/member/idChk",
					type : "post",
					dataType : "json",
					data : {"userId" : $("#userId").val()},
					success : function(data){
						if(data == 1){
							alert("중복된 아이디입니다.");
						}else if(data == 0){
							$("#idChk").attr("value", "Y");
							alert("사용가능한 아이디입니다.");
						}
					}
			})
		});
	})
</script>
</html>