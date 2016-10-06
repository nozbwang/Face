<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>足迹</title>
	<%@ include file="../common/common.jsp"%>
</head>

<body>

<%@include file="../common/topLink.jsp" %>

<%@include file="../common/leftLink.jsp" %>

<div id="right_form">
<table id="fixed_table" cellspacing="5">
	<tr class="center">
		<td colspan="2">
		<h2>足迹</h2>
		</td>
	</tr>
	<tr>
		<td colspan="2"><a href="/foot/insert">添加足迹</a></td>
	</tr>
	<c:forEach items="${command}" var="item" varStatus="status">
	<tr>
		<td>
			${item.formattedAddTime} ${item.footTitle}  ${item.footId} 
		</td>
		<td>
		<c:if test="${empty item.faceVoiceAttach}">
			${item.footTitle}
		</c:if>
		<c:if test="${item.faceVoiceAttach.isCompressed eq '0'}">
			<a href="/foot/detail?footId=${item.footId}"><img src="/attach?attachId=${item.faceVoiceAttach.attachmentId}" title="${item.footTitle}"></a>
		</c:if>
		<c:if test="${item.faceVoiceAttach.isCompressed eq '1' }">
			   ${item.footTitle}
		</c:if>
		</td>
	</tr>
	</c:forEach>
</table>
</div>

<%@ include file="../common/bottom.jsp"%>
</body>
</html>