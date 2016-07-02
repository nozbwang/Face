<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>读书</title>
	<%@ include file="common.jsp"%>
</head>

<body>

<%@include file="topLink_book.jsp" %>

<div id="left_img"><img src="images/windowtree.jpg" alt="by bobomeilin" /></div>

<div id="right_form">
<table id="fixed_table" cellspacing="5">
	<tr class="center">
		<td colspan="2">
		<h2>爱书</h2>
		</td>
	</tr>
	<tr>
		<td colspan="2"><a href="/book/insert">添加爱书</a></td>
	</tr>
	<tr>
	<c:forEach items="${command}" var="item" varStatus="status">
		<td>
			<c:forEach items="${item.faceVoiceAttachs}" var="attachItem" >
				<c:if test="${attachItem.isCompressed eq '0' }">
					<a><img src="/attach?attachId=${attachItem.attachmentId}" title="${item.bookTitle }"></a>
				</c:if>
			</c:forEach>
		</td>
	</c:forEach>
	</tr>
</table>
</div>

<%@ include file="bottom.jsp"%>
</body>
</html>