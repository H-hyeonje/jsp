﻿<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="dto.Book"%>
<%@ page import="dao.BookRepository" %>
<%@ page errorPage="exceptionNoBookId.jsp" %>
<!-- 직접 객체 생성하여 접근하지 않음  
<jsp:useBean id="bookDAO" class="dao.BookRepository" scope="session" />
 -->
<html>
<head>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href=".\\resources\\css\\bootstrap.min.css" />
<title>도서 정보</title>
</head>
<body>
<div class="container py-4">
   <%@ include file="menu.jsp"%>	

   <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold">도서정보</h1>
        <p class="col-md-8 fs-4">BookInfo</p>      
      </div>
    </div>
	
	<%--
		String id = request.getParameter("id");
		Book book = bookDAO.getBookById(id);
	--%>
	<%
	    Book book = (Book)request.getAttribute("book");

	%>
			<script type="text/javascript">
				function addTocart() {
					if(confirm("도서를 장바구니에 추가 하시겠습니까?")){
						document.addForm.submit();
					}else{
						document.addForm.reset();
					}
				}
			
			</script>

	
	 <div class="row align-items-md-stretch">	
	 	<div class="col-md-5">
	 		<img src="${pageContext.request.contextPath}/resources/images/<%= book.getFileName() %>" style="width :70%" />
	 	</div> 	
			<div class="col-md-6">
				<h3><b><%=book.getName()%></b></h3>
				<p><%=book.getDescription()%>
				<p><b>도서코드 : </b><span class="badge text-bg-danger"> <%=book.getBookId()%></span>							
				<p><b>저자</b> : <%=book.getAuthor()%>	
				<p><b>출판사</b> : <%=book.getPublisher()%>	
				<p><b>출판일</b> : <%=book.getReleaseDate()%>					
				<p><b>분류</b> : <%=book.getCategory()%>
				<p><b>재고수</b> : <%=book.getUnitsInStock()%>
				<h4><%=book.getUnitprice()%>원</h4>
				<p><form name="addForm" action="addCart?id=<%=book.getBookId()%>" method="post">
						<a href="#" class="btn btn-info" onclick="addTocart()">도서 주문 &raquo;</a>
						<a href="addCart" class="btn btn-warning">장바구니 &raquo;</a>
						<a href="Books" class="btn btn-secondary"> 도서목록 &raquo;</a>				
					</form>
					
			</div>
			
			
	
		</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
