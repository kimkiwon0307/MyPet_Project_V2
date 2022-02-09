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
				<h5>홈 > 자유게시판 > 조회하기</h5>
			</div>
			
		</div>
		
		<form action="/" method="post" id="readForm">
			<input type="hidden" id="fno" name="fno" value="${read.fno}" />				
		</form>
		
			<div class="input_group_a">
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">이 름</span> 
					<input type="text" class="form-control" placeholder="Username"
					 name="fwriter" value="${read.fwriter}" readonly="readonly"/>
				</div>
			
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">제 목</span> 
					<input type="text" class="form-control" placeholder="제목을 작성하세요." 
					name="ftitle" aria-label="Username" aria-describedby="basic-addon1"
					value="${read.ftitle}" readonly="readonly">
				</div>
			
			
				<div class="input-group">
					<span class="input-group-text">내 용</span>
  					<textarea class="form-control" aria-label="With textarea" name="fcontent" readonly="readonly"><c:out value="${read.fcontent}" /></textarea>
				</div>



			<div class="btn_group">
					<button type="button" class="btn btn-primary" id="btn_update">수 정</button>
					<button type="button" class="btn btn-primary" id="btn_delete">삭 제</button>
					<button type="button" class="btn btn-danger" id="btn_list">목 록</button>
				</div>
			</div>
			
			<!-- 댓글 -->
<div id="reply">
  <ol class="replyList">
    <c:forEach items="${replyList}" var="replyList">
      <li>
        <p>
        작성자 : ${replyList.writer}<br />
        작성 날짜 :  <fmt:formatDate value="${replyList.regdate}" pattern="yyyy-MM-dd" />
        </p>

        <p>${replyList.content}</p>
       <div>
  		<button type="button" class="replyUpdateBtn" data-rno="${replyList.rno}">수정</button>
 		<button type="button" class="replyDeleteBtn" data-rno="${replyList.rno}">삭제</button>
	   </div>
        
      </li>
    </c:forEach>   
  </ol>
</div>

<form name="replyForm" method="post">
  <input type="hidden" id="fno" name="fno" value="${read.fno}" />
  <input type="hidden" id="page" name="page" value="${scri.page}"> 
  <input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
  <input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
  <input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 

  <div>
    <label for="writer">댓글 작성자</label><input type="text" id="writer" name="writer" />
    <br/>
    <label for="content">댓글 내용</label><input type="text" id="content" name="content" />
  </div>
  <div>
 	 <button type="button" class="replyWriteBtn">작성</button>
  </div>
</form>
			
	</div>

	<div class="bottom">
	</div>

	<script>
		$(document).ready(function(){
			
			const readForm = $("#readForm");
			
			
			
			// 목록 버튼 누르면 목록으로 가기
			$("#btn_list").on("click",function(){
				location.href="/controller/freeboard/list"
			})
			
			
			// 수정 버튼을 누르면 writeView로 이동
			$("#btn_update").on("click",function(){
				
				readForm.attr("action", "/controller/freeboard/updateView");
				readForm.attr("method", "get");
				readForm.submit();
				
			})
			
			// 삭제 버튼을 누르면 게시글 삭제
			$("#btn_delete").on("click",function(){
				
				//삭제 버튼 누르면 confirm으로 한번 더 확인
				const deleteChk = confirm("삭제 하시겠습니까?");
				
				if(deleteChk == true){
					
				readForm.attr("action", "/controller/freeboard/delete");
				readForm.attr("method","post");
				readForm.submit();
				}
				
			})
			
			$(".replyWriteBtn").on("click", function(){
				  var formObj = $("form[name='replyForm']");
				  formObj.attr("action", "/controller/freeboard/replyWrite");
				  formObj.submit();
				});
			
			
			//댓글 수정 View
			$(".replyUpdateBtn").on("click", function(){
				location.href = "/controller/freeboard/replyUpdateView?fno=${read.fno}"
								+ "&page=${scri.page}"
								+ "&perPageNum=${scri.perPageNum}"
								+ "&searchType=${scri.searchType}"
								+ "&keyword=${scri.keyword}"
								+ "&rno="+$(this).attr("data-rno");
			});
					
		//댓글 삭제 View
			$(".replyDeleteBtn").on("click", function(){
				location.href = "/controller/freeboard/replyDeleteView?fno=${read.fno}"
					+ "&page=${scri.page}"
					+ "&perPageNum=${scri.perPageNum}"
					+ "&searchType=${scri.searchType}"
					+ "&keyword=${scri.keyword}"
					+ "&rno="+$(this).attr("data-rno");
			});
			
		})
	
	</script>

</body>
</html>