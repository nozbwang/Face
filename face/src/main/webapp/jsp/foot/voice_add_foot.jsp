<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>添加脚印</title>
	<%@ include file="../common/common.jsp"%>
	<link rel="stylesheet" href="/css/book.css" type="text/css"  />
</head>

<body>
	<%@include file="../common/topLink.jsp" %>

	<div id="left_img_book">	
	<c:choose>
		<c:when test="${command.faceVoiceAttach.isCompressed eq '0' }">
				<img src="/attach?attachId=${command.faceVoiceAttach.attachmentId}" title="${command.footTitle }">
		</c:when>
		<c:otherwise>
				</br></br>足迹：${command.footTitle }
		</c:otherwise>
	</c:choose>
	<c:if test="${not empty command.footer}">
		</br></br>足者：${command.footer }
	</c:if>
	<c:if test="${not empty command.footDetail}">
		</br></br>简介：${command.footDetail }
	</c:if>
	<c:if test="${not empty command.footDetail}">
		</br></br>时间：${command.formattedAddTime }
	</c:if>
</div>

	<div id="right_form">
		<form name="submitForm" action="/face/insertVoice" method="post" enctype="multipart/form-data">
			<table cellspacing="25">
				<tr class="center">
					<td colspan="2">
						<h2>${command.footTitle }</h2>
					</td>
				<tr>
					<td>脚印：</td>
					<td style="width: 100px">
						<textarea rows="5" cols="50" id="voice" name="voice" maxlength="4000"></textarea>
					</td>
				</tr>
				<tr>
                    <td>上传图片：</td>
                    <td style="width:100px"><input type="file" id="fileName" name="fileName" ></td>
                </tr>
                <tr>
                    <td>图片链接：</td>
                    <td style="width:100px"><input type="text" id="link" name="pictureLink" maxlength="500"></td>
                </tr>
				<tr>
					<td colspan="2" class="right">
						<input type="button"  id="submitButton"  value="添加">
						<input  type="hidden" id="submitFlag" value="">
						<input  type="hidden" name="belongType" value="2">
						<input  type="hidden" name="belongId" value="${command.footId}">
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