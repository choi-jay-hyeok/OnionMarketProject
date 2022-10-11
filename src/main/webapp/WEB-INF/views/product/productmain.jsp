<%@ page import="javax.validation.constraints.NotEmpty" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("UTF-8");
//	String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>상품 리스트</title>
</head>
<body>

<h3>상품 리스트입니다</h3>
<div>
	<c:forEach var="dto" items="${dto}">
		제목: ${dto.subject}<br/>
		상품가격: ${dto.price}
		등록일: ${dto.uploadDate}<br/>
	</c:forEach>
</div>

<form action="/product/add">
	<input type="submit" value=" 상품 등록하기 " class="btn2"/>
</form>
<form action="/login">
	<input type="submit" value=" 로그인/로그아웃 "/>
</form>

</body>
</html>