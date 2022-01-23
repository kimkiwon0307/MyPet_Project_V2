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
				<h1>목 록 </h1>
			</div>
			<div class = "subject_h5">
				<h5>홈 > 자유게시판 > 목 록</h5>
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
						<td><fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	    <div id="sebupa">
		 <div class="search">
			<select name="searchType">
				<option value="n"
					<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
				<option value="t"
					<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
				<option value="c"
					<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
				<option value="w"
					<c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
				<option value="tc"
					<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
			</select> <input type="text" name="keyword" id="keywordInput"
				value="${scri.keyword}" />

			<button id="searchBtn" class="btn btn-primary" type="button">검색</button>
			<script>
				$(function() {
					$('#searchBtn').click(
							function() {
								self.location = "list"
										+ '${pm.makeQuery(1)}'
										+ "&searchType="
										+ $("select option:selected").val()
										+ "&keyword="
										+ encodeURIComponent($('#keywordInput').val());
							});
				});
			</script>
		</div>


		<!--  페이징 -->
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:if test="${pm.prev}">
					<li class="page-item">
						<a class="page-link" href="list${pm.makeQuery(pm.startPage - 1)}">이전</a>
					</li>
				</c:if>

				<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="idx">
					<li class="page-item">
						<a class="page-link" href="list${pm.makeQuery(idx)}">${idx}</a>
					</li>
				</c:forEach>

				<c:if test="${pm.next && pm.endPage > 0}">
					<li class="page-item">
						<a class="page-link" href="list${pm.makeQuery(pm.endPage + 1)}">다음</a>
					</li>
				</c:if>
			</ul>
		</nav>
	
		<div class="btn_group">
			<button type="button" class="btn btn-primary" id="btn_write">작 성</button>
		</div>

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