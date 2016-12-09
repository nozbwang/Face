<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>添加基础参数</title>
	<%@ include file="../common/common.jsp"%>
</head>

<body>
	<%@include file="../common/topLink.jsp" %>
	<%@include file="../common/leftLink.jsp" %>

	<div id="right_form">
		<form name="submitForm" action="/bp/insert" method="post">
			<table cellspacing="25">
				<tr class="center">
					<td colspan="2">
						<h2>参数</h2>
					</td>
				</tr>
                <tr>
                    <td>类型：</td>
                    <td style="width:100px"><input type="text" name="type" maxlength="50"></td>
                </tr>
                <tr>
                    <td>名称中文：</td>
                    <td style="width:100px"><input type="text" name="nameCn" maxlength="255"></td>
                </tr>
                <tr>
                    <td>名称英文：</td>
                    <td style="width:100px"><input type="text" name="nameEn" maxlength="255"></td>
                </tr>
                <tr>
                    <td>值：</td>
                    <td style="width:100px"><input type="text" name="value" maxlength="50" value="0"></td>
                </tr>
				<tr>
					<td colspan="2" class="right">
						<input type="button"  id="submitButton"  value="添加">
						<input  type="hidden" id="submitFlag" value="">
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