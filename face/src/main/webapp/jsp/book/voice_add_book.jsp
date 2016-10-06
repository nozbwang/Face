<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>添加书评</title>
	<%@ include file="../common/common.jsp"%>
	<link rel="stylesheet" href="/css/book.css" type="text/css"  />
</head>

<body>
	<%@include file="../common/topLink.jsp" %>

	<div id="left_img_book">	
	<c:choose>
		<c:when test="${command.faceVoiceAttach.isCompressed eq '0' }">
				<img src="/attach?attachId=${command.faceVoiceAttach.attachmentId}" title="${command.bookTitle }">
		</c:when>
		<c:otherwise>
				</br></br>书名：${command.bookTitle }
		</c:otherwise>
	</c:choose>
	<c:if test="${not empty command.author}">
		</br></br>作者：${command.author }
	</c:if>
	<c:if test="${not empty command.bookDetail}">
		</br></br>简介：${command.bookDetail }
	</c:if>
</div>

	<div id="right_form">
		<form name="submitForm" action="/face/insertVoice" method="post" enctype="multipart/form-data">
			<table cellspacing="25">
				<tr class="center">
					<td colspan="2">
						<h2>${command.bookTitle }</h2>
					</td>
				<tr>
					<td>书评：</td>
					<td style="width: 100px">
						<textarea rows="5" cols="50" id="voice" name="voice" maxlength="4000"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="right">
						<input type="button"  id="submitButton"  value="添加">
						<input  type="hidden" id="submitFlag" value="">
						<input  type="hidden" name="belongType" value="1">
						<input  type="hidden" name="belongId" value="${command.bookId}">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div class="clearFloat"></div>
	<%@ include file="../common/bottom.jsp"%>
	</body>
<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
<script src="<%=request.getContextPath() %>/js/base.js"></script>
<script src="<%=request.getContextPath() %>/js/form.js"></script>
<script src="<%=request.getContextPath() %>/js/registerValidate.js"></script>
</html>