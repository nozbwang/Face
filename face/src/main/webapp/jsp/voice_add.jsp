<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>添加心声</title>
	<%@ include file="common/common.jsp"%>
</head>

<body>
	<%@include file="common/topLink.jsp" %>
	<%@include file="common/leftLink.jsp" %>

	<div id="right_form">
		<form name="submitForm" action="/face/insertVoice" method="post" enctype="multipart/form-data">
			<table cellspacing="25">
				<tr class="center">
					<td colspan="2">
						<h2>自己的声音</h2>
					</td>
				</tr>
				<tr>
					<td>声音：</td>
					<td style="width: 100px"><textarea rows="5" cols="50"
							id="voice" name="voice" maxlength="4000"></textarea></td>
				</tr>
                <tr>
                    <td>上传图片：</td>
                    <td style="width:100px">
                    	<input type="file" id="file" name="file" />
                    	<div id="imageDiv"></div>
                    	<a href="javascript:addImage()" id="addImg">继续上传</a>
                    </td>
                </tr>
                <tr>
                    <td>图片链接：</td>
                    <td style="width:100px"><input type="text" id="link" name="pictureLink" maxlength="500"></td>
                </tr>
                <tr>
                    <td>音乐链接：</td>
                    <td style="width:100px"><input type="text" id="link" name="musicLink" maxlength="500"></td>
                </tr>
				<tr>
					<td colspan="2" class="right">
						<input type="button"  id="submitButton"  value="发声">
						<input  type="hidden" id="submitFlag" value="">
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<%@ include file="common/bottom.jsp"%>
	</body>
<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
<script src="<%=request.getContextPath() %>/js/base.js"></script>
<script src="<%=request.getContextPath() %>/js/form.js"></script>
<script src="<%=request.getContextPath() %>/js/registerValidate.js"></script>
</html>