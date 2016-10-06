<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>添加足迹</title>
	<%@ include file="../common/common.jsp"%>
	<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
</head>

<body>
	<%@include file="../common/topLink.jsp" %>
	<%@include file="../common/leftLink.jsp" %>

	<div id="right_form">
		<form name="submitForm" action="/foot/insertFoot" method="post" enctype="multipart/form-data">
			<table cellspacing="25">
				<tr class="center">
					<td colspan="2">
						<h2>添加足迹</h2>
					</td>
				<tr>
                    <td>目的地：</td>
                    <td style="width:100px"><input type="text" id="footTitle" name="footTitle" ></td>
                </tr>
				<tr>
					<td>人：</td>
                    <td style="width:100px">
	                    <label><input name="footer" type="checkbox" value="王智博" />智博王 </label> 
						<label><input name="footer" type="checkbox" value="李美林" />美林李 </label> 
					</td>
				</tr>
				<tr>
					<td><label for="addTime">到达时间：</label></td>
					<td>
                  		<input id="addTime" type="date"  name="addTime" value="<%=new Date().toLocaleString() %>"/>
                    </td>
				</tr>
				<tr>
					<td>描述：</td>
					<td style="width: 100px">
						<textarea rows="5" cols="50"id="bookDetail" name="footDetail" maxlength="1000"></textarea>
					</td>
				</tr>
				<input type="hidden" name="belongType" value="2"/>
				<tr>
					<td>
						<label id="localPictureFlag"><input type="radio" name="pictureType"  value="1" checked/>上传图片：</label></br>
						<label id="remotePictureFlag"><input type="radio" name="pictureType"  value="2"/>图片链接：</label>
					</td>
                    <td style="width:100px" id="localPicture"><input id="localPictureE" type="file" id="fileName" name="fileName" ></td>
                    <td style="width:100px; display:none;" id="remotePicture"><input id="remotePictureE" type="text" id="link" name="pictureLink" maxlength="500"></td>
                </tr>
				<tr>
					<td colspan="2" class="right">
						<input type="button" id="submitButton" value="添加足迹">
						<input type="hidden" id="submitFlag" value="">
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<%@ include file="../common/bottom.jsp"%>
	</body>
<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
<script src="<%=request.getContextPath() %>/js/base.js"></script>
<script src="<%=request.getContextPath() %>/js/form.js"></script>
<script src="<%=request.getContextPath() %>/js/registerValidate.js"></script>
</html>