<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.dto"%>
<%@ page import="dao.repository" %>
<%@ page session="false" %>


<html>
<head>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/bookmaket/resources/css/bootstrap.min.css" />
<title>도서 목록</title>
</head>
<body>
<div class="container py-4">
   <%@ include file="menu.jsp"%>	

   <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold">도서목록</h1>
        <p class="col-md-8 fs-4">BookList</p>      
      </div>
    </div>

    <%
    	ArrayList<dto> arr = (ArrayList<dto>)request.getAttribute("arr");
		dto dto= new dto();
     %>
      
	 <div class="row align-items-md-stretch   text-center">	 	
	 <%
	if (arr != null && !arr.isEmpty()){ 
		for (int i = 0; i < arr.size(); i++) {
			dto= arr.get(i);
	  %>
     	<div class="col-md-4">
       		<div class="h-100 p-2">	
				<img src="/bookmaket/resources/images/<%=dto.getBookId()%>.jpg" style="width: 250px; height: 350px"/>
				<h5><b><%=dto.getBookname()%></b></h5>
				<p><%=dto.getAuthor()%>
				<br> <%=dto.getPublisher()%> | <%=dto.getReleaseDate()%>
				<p> <%=dto.getBookdescription()%>
				<p><%=dto.getUnitprice()%>원
				<p><a href="book?id=<%=dto.getBookId()%>" class="btn btn-secondary" role="button"> 상세 정보 &raquo;</a>
			</div>	
		</div>			
		<%
			}}
		%>
	
		</div>	
		<%@ include file="footer.jsp"%>   
  </div>
</body>
</html>