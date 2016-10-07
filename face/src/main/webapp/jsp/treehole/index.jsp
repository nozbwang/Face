<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>树洞</title>
	<%@ include file="../common/common.jsp"%>
</head>

<body>

<%@include file="../common/topLink.jsp" %>
<%@include file="../common/leftLink.jsp" %>

<div id="right_form">
<table id="fixed_table_treehole" cellspacing="5">
	<tr class="center">
		<td colspan="3">
		<h2>秘密
			<img src="/images/icon/notice.png" title="秘密会在三天后会自动消失。">
		</h2>
		</td>
	</tr>
	<tr>
		<td colspan="3"><a href="/treehole/insert">发出自己的声音</a></td>
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

<%@ include file="bottom_treehole.jsp"%>
<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
<script src="<%=request.getContextPath() %>/js/base.js"></script>
<script src="<%=request.getContextPath() %>/js/form.js"></script>
</body>
</html>