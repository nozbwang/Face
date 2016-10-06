<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>添加书籍</title>
	<%@ include file="../common/common.jsp"%>
	<link rel="stylesheet" href="/css/book.css" type="text/css"  />
</head>

<body>
	<%@include file="../common/topLink.jsp" %>

	<div id="left_img_book">
		<img src="/images/handwrite.jpg" alt="by bobomeilin" />
	</div>
	
	<div id="right_form_book">
		<form name="submitForm" action="/book/insertBook" method="post" enctype="multipart/form-data">
			<table cellspacing="25">
				<tr class="center">
					<td colspan="2">
						<h2>添加爱书</h2>
					</td>
				<tr>
                    <td>书名：</td>
                    <td style="width:100px"><input type="text" id="bookTitle" name="bookTitle" ></td>
                </tr>
				<tr>
					<td>作者：</td>
                    <td style="width:100px"><input type="text" id="author" name="author" ></td>
				</tr>
				<tr>
					<td>简介：</td>
					<td style="width: 100px">
						<textarea rows="5" cols="50"id=""bookDetail"" name="bookDetail" maxlength="1000"></textarea>
					</td>
				</tr>
				<input type="hidden" name="belongType" value="1"/>
				<tr>
					<td>
						<label id="localPictureFlag"><input type="radio" name="pictureType"  value="1" checked/>上传图片：</label></br>
						<label id="remotePictureFlag"><input type="radio" name="pictureType"  value="2"/>图片链接：</label>
					</td>
                    <td style="width:100px" id="localPicture"><input id="localPictureE" type="file" id="fileName" name="fileName" ></td>
                    <td style="width:100px; display:none;" id="remotePicture"><input id="remotePictureE" type="text" id="link" name="pictureLink" maxlength="500"></td>
                </tr>
                <tr>
                    <td>图书种类：</td>
                    <td>
                   	<label><input type="radio" name="bookType" value="1" checked/>文学</label>
                   	<label><input type="radio" name="bookType" value="2"/>流行</label>
                   	<label><input type="radio" name="bookType" value="3"/>文化</label>
                   	<label><input type="radio" name="bookType" value="4"/>生活</label>
                   	<label><input type="radio" name="bookType" value="5"/>经管</label>
                   	<label><input type="radio" name="bookType" value="6"/>科技</label>
                   	</td>
                </tr>
				<tr>
					<td colspan="2" class="right">
						<input type="button" id="submitButton" value="添加爱书">
						<input type="hidden" id="submitFlag" value="">
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<%@ include file="../common/bottom.jsp"%>
</body>
<script>
	
</script>
<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
<script src="<%=request.getContextPath() %>/js/base.js"></script>
<script src="<%=request.getContextPath() %>/js/form.js"></script>
<script src="<%=request.getContextPath() %>/js/registerValidate.js"></script>
</html>