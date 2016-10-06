<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>读书</title>
	<%@ include file="../common/common.jsp"%>
	<link rel="stylesheet" href="/css/book.css" type="text/css"  />
</head>

<body>
<%@include file="topLink_book.jsp" %>

<div id="left_img_book">
	<img src="/images/handwrite.jpg" alt="by bobomeilin" />
</div>

<div id="right_form_book">
<table id="fixed_table" cellspacing="5">
	<tr class="center">
		<td colspan="2">
		<h2>爱书</h2>
		</td>
	</tr>
	<tr>
		<td colspan="2"><a href="/book/insert">添加爱书</a></td>
	</tr>
</table>
	<ul>
	<c:forEach items="${command}" var="item">
		<a href="/book/detail?bookId=${item.bookId}">
			<li>
			<c:choose>
				<c:when test="${item.faceVoiceAttach!=null && item.faceVoiceAttach.isCompressed eq '0' }">
					<img src="/attach?attachId=${item.faceVoiceAttach.attachmentId}" title="${item.bookTitle }">
				</c:when>
				<c:otherwise>
					${item.bookTitle }
				</c:otherwise>
			</c:choose>
			</li>
		</a>
	</c:forEach>
	</ul>
</div>

<div class="clearFloat"></div>

<%@ include file="../common/bottom.jsp"%>
</body>
</html>