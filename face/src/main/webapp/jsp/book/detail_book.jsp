<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>心声</title>
	<%@ include file="../common/common.jsp"%>
		<link rel="stylesheet" href="/css/book.css" type="text/css"  />
</head>

<body>

<%@include file="topLink_book.jsp" %>

<div id="left_img_book">	
	<c:choose>
		<c:when test="${book.faceVoiceAttach.isCompressed eq '0' }">
				<img src="/attach?attachId=${book.faceVoiceAttach.attachmentId}" title="${book.bookTitle }">
		</c:when>
		<c:otherwise>
				</br></br>书名：${book.bookTitle }
		</c:otherwise>
	</c:choose>
	<c:if test="${not empty book.author}">
		</br></br>作者：${book.author }
	</c:if>
	<c:if test="${not empty book.bookDetail}">
		</br></br>简介：${book.bookDetail }
	</c:if>
</div>

<div id="right_form_book">
<table id="fixed_table_book" cellspacing="5">
	<tr class="center">
		<td colspan="2">
		<h2>${book.bookTitle }</h2>
		</td>
	</tr>
	<tr>
		<td colspan="4"><a href="/book/insertBookVoice?bookId=${book.bookId}">添加书评</a></td>
	</tr>
	<c:forEach items="${voices}" var="item">
		<tr>
			<td><c:out value="${item.formattedAddTime}" /></td>
			<td colspan="2"><pre><c:out value="${item.voice}" /></pre></td>
			<td>
				<c:if test="${user != null && user.userName != null}">
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="/book/editBookVoice?bookId=${book.bookId}&voiceId=${item.voiceId}"><img src="/images/icon/edit.png"/></a>&nbsp;&nbsp;
				<a href="/face/deleteVoice?voiceId=${item.voiceId}&belongId=${book.bookId}&belongType=1" onClick="return deleteConfirm();"><img src="/images/icon/del.png"/></a>
				</c:if>
			</td>
		</tr>
	</c:forEach>
</table>
</div>
<div class="clearFloat"></div>

<%@ include file="../common/bottom.jsp"%>
</body>
<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
<script src="<%=request.getContextPath() %>/js/base.js"></script>
<script src="<%=request.getContextPath() %>/js/form.js"></script>
</html>