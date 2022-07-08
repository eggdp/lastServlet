<%@page import="dto.TbUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	//세션 정보 받아오기
 	TbUser dto=(TbUser)session.getAttribute("user");
 	//세션에 정보가 있으면 메뉴 넣기가 보여야 되고 로그인 > 로그아웃
 	//세션에 정보가 없으면 메뉴 넣기는 안보이고 로그인 바뀜
 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>머먹지</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="/">
    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJrNqV6364uIVvqjVI6qn3AEevxwcZWJzXdA&usqp=CAU" alt="logo" style="width:50px;">
  </a>
  
  <!-- Links -->
  <ul class="navbar-nav">
  <%if(dto!=null){ %>
	  <li class="nav-item">
      <a class="nav-link" href="/insert.menu">메뉴 넣기</a>
    </li>
	<%} %> 

    
    <li class="nav-item">
      <a class="nav-link" href="/see.menu">메뉴 보기</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/best.menu">메뉴 추천</a>
    </li>
    <%  if(dto==null){%>
        <li class="nav-item">
      <a class="nav-link" href="/login.menu">로그인</a>
    	</li>
    	<li class="nav-item">
      <a class="nav-link" href="/join.menu">회원 가입</a>
    	</li>
    <% }else{%>
    <li class="nav-item">
      <a class="nav-link" href="/logout.menu">로그아웃</a>
    	</li>
    <%  } %> 

  </ul>
  </nav>

</body>
</html>