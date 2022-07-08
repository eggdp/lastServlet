<%@page import="dto.Menu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@ include file="header.jsp" %>

<center><h3>메뉴 보기</h3></center><br>

<%
	//SeeServlet에서 셋팅한 데이터 여기서 가지고 오기
	List<Menu> list = (List<Menu>)request.getAttribute("menuList"); // (List<Menu>) 강제 형변환
	for(Menu m : list){
		out.println("메뉴는 "+ m.getMenu()+" 가격은 "+ m.getPrice()+"원입니다.<br>");
		
	}
%>

</body>
</html>
