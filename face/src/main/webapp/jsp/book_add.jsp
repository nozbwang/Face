<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>添加书籍</title>
	<%@ include file="common.jsp"%>
</head>

<body>
	<%@include file="topLink_visitor.jsp" %>
	<div id="left_img">
		<img src="images/windowtree.jpg" alt="by bobomeilin" />
	</div>

	<div id="right_form">
		<form name="voiceForm" action="/book/insertBook" method="post" enctype="multipart/form-data">
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
						<textarea rows="5" cols="50"id=""bookDetail"" name="bookDetail" maxlength="200"></textarea>
					</td>
				</tr>
				<input type="hidden" name="belongType" value="1"/>
				<tr>
                    <td>上传图片：</td>
                    <td style="width:100px"><input type="file" id="fileName" name="fileName" ></td>
                </tr>
                <tr>
                    <td>图片链接：</td>
                    <td style="width:100px"><input type="text" id="link" name="pictureLink" maxlength="500"></td>
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
						<input style="width: 180px; height: 30px;" type="submit" value="添加爱书">
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<%@ include file="bottom.jsp"%>
	</body>
<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
<script src="<%=request.getContextPath() %>/js/base.js"></script>
<script src="<%=request.getContextPath() %>/js/registerValidate.js"></script>
</html>