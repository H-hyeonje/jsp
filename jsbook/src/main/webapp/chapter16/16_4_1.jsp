<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="chapter16.dto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<% 	
		
		ArrayList<dto> arr=(ArrayList<dto>)request.getAttribute("arr");
		for(int i=0;i<arr.size();i++){		
			%>	
		<tr>
			<td><%= %></td>
			<td><%= %></td>
			<td><%= %></td>
		</tr>	
   <%
		}
	%>
	</table>
</body>
</html>