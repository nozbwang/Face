<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>基本参数</title>
	<%@ include file="../common/common.jsp"%>
</head>

<body>

<%@include file="../common/topLink.jsp" %>

<%@include file="../common/leftLink.jsp" %>

<div id="right_form">
<table id="fixed_table" cellspacing="5">
	<tr class="center">
		<td colspan="2">
		<h2>参数列表</h2>
		</td>
	</tr>
	<tr>
		<td colspan="2"><a href="/bp/add">添加参数</a></td>
	</tr>
	<c:forEach items="${command}" var="item">
		<tr>
			<td><c:out value="${item.type}" /></td>
			<td><c:out value="${item.nameCn}" /></td>
			<td><c:out value="${item.nameEn}" /></td>
			<td><c:out value="${item.value}" /></td>
		</tr>
	</c:forEach>
</table>
</div>

<%@ include file="../common/bottom.jsp"%>
</body>
</html>