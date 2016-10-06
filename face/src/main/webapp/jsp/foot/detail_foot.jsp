<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>心声</title>
	<%@ include file="../common/common.jsp"%>
		<link rel="stylesheet" href="/css/book.css" type="text/css"  />
</head>

<body style="
	background:#f7f7f7 url(../images/pinstripe.gif) repeat top left;
	color:#000;
	font-family: Georgia, "Times New Roman",sans-serif;
	font-size:12px;
	"
>

<%@include file="../common/topLink.jsp" %>

<div id="left_img_book">	
	<c:choose>
		<c:when test="${foot.faceVoiceAttach.isCompressed eq '0' }">
				<img src="/attach?attachId=${foot.faceVoiceAttach.attachmentId}" title="${foot.footTitle }">
		</c:when>
		<c:otherwise>
				</br></br>足迹：${foot.footTitle }
		</c:otherwise>
	</c:choose>
	<c:if test="${not empty foot.footer}">
		</br></br>足者：${foot.footer }
	</c:if>
	<c:if test="${not empty foot.footDetail}">
		</br></br>简介：${foot.footDetail }
	</c:if>
	<c:if test="${not empty foot.footDetail}">
		</br></br>时间：${foot.formattedAddTime }
	</c:if>
</div>

<div id="right_form">
<table id="fixed_table" cellspacing="5">
	<tr class="center">
		<td colspan="2">
		<h2>${foot.footTitle }</h2>
		</td>
	</tr>
	<tr>
		<td colspan="2"><a href="/foot/insertFootVoice?footId=${foot.footId}">添加脚印</a></td>
	</tr>
	<c:forEach items="${voices}" var="item">
		<tr>
			<td><c:out value="${item.formattedAddTime}" /></td>
			<td><pre><c:out value="${item.voice}" /></pre>
			<c:forEach items="${item.faceVoiceAttachs}" var="attachItem">
				<c:if test="${attachItem.isCompressed eq '0' }">
					<a href="/bigAttach?attachId=${attachItem.attachmentId}"><img src="/attach?attachId=${attachItem.attachmentId}"></a>
				</c:if>
				<c:if test="${attachItem.isCompressed eq '1' }">
				    loading picture...
				</c:if>
			</c:forEach>
			</td>
		</tr>
	</c:forEach>
</table>
</div>
<div class="clearFloat"></div>

<%@ include file="../common/bottom.jsp"%>
</body>
</html>