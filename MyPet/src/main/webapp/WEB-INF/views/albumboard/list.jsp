<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
  <head>


    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>album</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/album/">

	<link href="${path}/resources/css/albumboard/list.css"rel="stylesheet" >

<!-- jquery CDN -->	
<script src="https://code.jquery.com/jquery-3.6.0.slim.min.js" integrity="sha256-u7e5khyithlIdTpu22PHhENmPcRdFiHRjhAuHcs05RI=" crossorigin="anonymous"></script>		
<!-- 절대경로 -->
<link href="${path}/resources/css/freeboard/list.css"rel="stylesheet" >


    <!-- Bootstrap core CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  </head>
  <body>
	
<header>
 <jsp:include page="../top_bottom/header.jsp"></jsp:include>

</header>



  <div class="album py-5 bg-light">
    <div class="container">
    		<div class="sub_menu">
			<div class = "subject_h1" >
				<h1>앨 범</h1>
			</div>
			<div class = "subject_h5">
				<h5>홈 > 앨범게시판 > 목록</h5>
			</div>
	</div>
    

      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
     
     <c:forEach items="${list}" var="list">
        <div class="col">
          <div class="card shadow-sm">
          	
     
          <img src="https://cdn.pixabay.com/photo/2018/05/17/06/22/dog-3407906__480.jpg"/>
          	          
            <div class="card-body">
            
              <a href="/controller/albumboard/readView?ano=${list.ano}">
             	 <p class="card-text"><c:out value="${list.acontent}"/></p>
              </a>	
            
              <div class="d-flex justify-content-between align-items-center">
                <small class="text-muted"><fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd" /></small>
              </div>
            
            </div>
          </div>
        </div>
     </c:forEach>
    
      </div>
    </div>
    	<div class="btn_group" id="write_btn">
			<button type="button" class="btn btn-primary" id="btn_write">작 성</button>
		</div>
    
  </div>
      
      <footer>
      
      </footer>
      <script>
	
	$(document).ready(function(){
	
		// 글쓰기 버튼 누르면 글쓰기 화면으로 이동
		$("#btn_write").on("click",function(){
			location.href="/controller/albumboard/writeView";
		})
	})
	</script>
      
      
  </body>
</html>