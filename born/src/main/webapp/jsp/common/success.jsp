<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<title>操作成功</title>
	<%@ include file="../common/common.jsp"%>
	<link rel="stylesheet" href="/css/index.css" type="text/css"  />
	<link rel="stylesheet" href="/css/main.css" type="text/css"  />
</head>

<body  style="background:url(../images/windowback.jpg);">
	<c:set var="pageType" value="user" scope="page"/>
	<%@include file="../common/header.jsp" %>
   	
   	<div class="centerContent">
		<span class="bold"><c:out value="${success}"/> </span>
	</div>

<%@ include file="../common/footer.jsp"%>
</body>

</html>