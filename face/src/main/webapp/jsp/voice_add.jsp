<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>添加心声</title>
	<%@ include file="common.jsp"%>
</head>

<body>
	<%@include file="topLink_visitor.jsp" %>
	<div id="left_img">
		<img src="images/windowtree.jpg" alt="by bobomeilin" />
	</div>

	<div id="right_form">
		<form name="voiceForm" action="/face/insertVoice" method="post" enctype="multipart/form-data">
			<table cellspacing="25">
				<tr class="center">
					<td colspan="2">
						<h2>自己的声音</h2>
					</td>
				<tr>
					<td>声音：</td>
					<td style="width: 100px"><textarea rows="5" cols="50"
							id="voice" name="voice" maxlength="200"></textarea></td>
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
                    <td>音乐链接：</td>
                    <td style="width:100px"><input type="text" id="link" name="musicLink" maxlength="500"></td>
                </tr>
				<tr>
					<td colspan="2" class="right"><input
						style="width: 180px; height: 30px;" type="submit" value="发声"></td>
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