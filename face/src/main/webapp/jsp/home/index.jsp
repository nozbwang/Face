<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>心声</title>
	<%@ include file="../common/common.jsp"%>
</head>

<body>

<%@include file="../common/topLink_base.jsp" %>

<%@include file="../common/leftLink.jsp" %>

<div id="right_form">
<table id="fixed_table" cellspacing="5">
	<tr class="center">
		<td colspan="2">
		<h2>一滴水的声音</h2>
		</td>
	</tr>
	<tr>
		<td colspan="2"><a href="/home/add">发出自己的声音</a></td>
	</tr>
	<c:forEach items="${command}" var="item">
		<tr>
			<td><c:out value="${item.formattedAddTime}" /></td>
			<td><pre><c:out value="${item.voice}" /></pre>
			<c:forEach items="${item.faceVoiceAttachs}" var="attachItem">
				<c:if test="${attachItem.isCompressed eq '0' }">
					<a href="/bigAttach?attachId=${attachItem.attachmentId}"><img src="/attach?attachId=${attachItem.attachmentId}"></a>
				</c:if>
				<c:if test="${attachItem.isCompressed eq '1' }">
				    </br>loading picture...
				</c:if>
			</c:forEach>
			<c:forEach items="${item.faceVoiceAttachLinks}" var="attachLinkItem">
				<c:if test="${attachLinkItem.is163Music() && not empty attachLinkItem.musicId}">
					<iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width=330 height=86 src="http://music.163.com/outchain/player?type=2&id=${attachLinkItem.musicId}&auto=0&height=66"></iframe>
				</c:if>
				<c:if test="${attachLinkItem.isXiamiMusic() && not empty attachLinkItem.musicId}">
					<embed src="http://www.xiami.com/widget/0_${attachLinkItem.musicId}/singlePlayer.swf" type="application/x-shockwave-flash" width="257" height="33" wmode="transparent"></embed>
				</c:if>
			</c:forEach>
			</td>
		</tr>
	</c:forEach>
</table>
</div>

<%@ include file="../common/bottom.jsp"%>
</body>
</html>