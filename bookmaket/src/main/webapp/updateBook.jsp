<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="dto.dto" %>
<html>
<head>
<link rel ="stylesheet" href ="/bookmaket/resources/css/bootstrap.min.css" />

<title>도서 수정</title>
</head>
<body>
<div class="container py-4">
   <%@ include file="menu.jsp"%>	

   <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold">도서 수정</h1>
        <p class="col-md-8 fs-4">Book Updating</p>      
      </div>
    </div>
    
    <%
    	dto dto=(dto)request.getAttribute("dto");
    	String status=dto.getBookconditione();
		out.println(dto.getBookId());    
    %>
	
	 <div class="row align-items-md-stretch">	  	
		
		<div class="col-md-5">
				<img src="/bookmaket/resources/images/<%=dto.getBookId()%>.jpg" alt="image" style="width: 100%" />
			</div>
		<div class="col-md-7">	
		<form name="newBook" action="update" method="post" enctype ="multipart/form-data">
		
			
			<div class="mb-3 row">
				<label class="col-sm-2">도서코드</label>
				<div class="col-sm-5">
					<input type="text" name="bookid" id="bookid" class="form-control" value="<%=dto.getBookId()%>">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">도서명</label>
				<div class="col-sm-5">
					<input type="text" name="bookname" id="bookname" class="form-control" value="<%=dto.getBookname()%>">
				</div>
			</div>
				<div class="mb-3 row">
				<label class="col-sm-2">가격</label>
				<div class="col-sm-5">
					<input type="text" name="unitprice"  id="unitprice"class="form-control" value="<%=dto.getUnitprice()%>">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">저자</label>
				<div class="col-sm-5">
					<input type="text" name="author" class="form-control" value="<%=dto.getAuthor()%>">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">출판사</label>
				<div class="col-sm-5">
					<input type="text" name="publisher" class="form-control" value="<%=dto.getPublisher()%>">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">출판일</label>
				<div class="col-sm-5">
					<input type="text" name="releaseDate" class="form-control" value="<%=dto.getReleaseDate()%>">
				</div>
			</div>
	
			<div class="mb-3 row">
				<label class="col-sm-2">상세정보</label>
				<div class="col-sm-8">
					<textarea  name="bookdescription" id="bookdescription" cols="50" rows="2"
						class="form-control" placeholder="100자 이상 적어주세요"> <%=dto.getBookdescription()%></textarea>
				</div>
			</div>			
			<div class="mb-3 row">
				<label class="col-sm-2">분류</label>
				<div class="col-sm-5">
					<input type="text" name="category" class="form-control" value="<%=dto.getCategory()%>">
				</div>
			</div>
				<div class="mb-3 row">
				<label class="col-sm-2">재고수</label>
				<div class="col-sm-5">
					<input type="text" name="unitsInStock" id="unitsInStock"class="form-control" value="<%=dto.getUnitsInStock()%>">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">상태</label>
				<div class="col-sm-8">
					<input type="radio" name="bookcondition" value="new " <% if(status.equals("new")){out.println("checked");} %> >신규도서 
					<input type="radio" name="bookcondition" value="old" <% if(status.equals("old")){out.println("checked");} %>  > 중고도서 
					<input type="radio" name="bookcondition" value="eBook" <% if(status.equals("eBook")){out.println("checked");} %> > E-Book
				</div>				
			</div>		
			
			<div class="mb-3 row">
				<label class="col-sm-2">이미지</label>
				<div class="col-sm-8">
					<input type="file" name="fileName" class="form-control">
				</div>
			</div>
			
			<div class="mb-3 row">
				<div class="col-sm-offset-2 col-sm-10 ">
					<input type="submit" class="btn btn-primary" value="등록 " >
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</div>	

</body>
</html>
