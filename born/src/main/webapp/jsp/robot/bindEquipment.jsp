<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>绑定机器人</title>
<%@ include file="../common/common.jsp"%>
<link rel="stylesheet" href="../../css/index.css" type="text/css" />
<link rel="stylesheet" href="../../css/main.css" type="text/css" />
<link rel="stylesheet" href="../../css/list.css" type="text/css" />
</head>

<body style="font-size: 1em;">

	<c:set var="pageType" value="platform" scope="page" />
	<c:set var="menuType" value="equipmenu" scope="page"/>
	<%@include file="../common/header.jsp"%>
	<div class="dark_space"></div>

	<div class="content">
		<%@include file="../common/leftGuide.jsp"%>
		
		<div class="container-right">

			<div class="divContent">
				<div class="divNav">
					当前位置： <a href="/robot">设备管理</a> &gt;&gt;  添加设备
				</div>

				<div class="divQuery pull-right">
					<a href="/robot">返回</a>
				</div>

				<div class="grayfont">
					<div class="divTitle">
						<p>添加设备</p>
					</div>
					<hr>
					<form id="submitForm" name="submitForm" action="/bind" class="form-horizontal">
						<div class="control-group ">
							<label class="control-label" for="GatewayType"> 设备类型： </label>
							<div class="controls">
							<select name="robotType" class="height:10px;">
								<option value="1" selected>机器人</option>
<!-- 								<option value="2">运动检测设备</option> -->
<!-- 								<option value="3">温度传感器</option> -->
							 </select>
							</div>
						</div>
						<div class="control-group ">
							<label class="control-label" for="GatewayType"> 设备编号：</label>
							<div class="controls">
								<input type="text" id="uuid" name="uuid" maxlength="255" placeholder="请输入设备编号">
								<div id="uuidNotice"></div>
							</div>
						</div>
						<div class="control-group ">
							<div class="controls" style="align:right">
								<input id="bindQuipmentButton"  class="btn btn-main"  type="submit" value="绑定">
                    			<input type="hidden" id="submitFlag" value="">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="../common/footer.jsp"%>
	<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
	<script src="<%=request.getContextPath() %>/js/base.js"></script>
	<script src="<%=request.getContextPath() %>/js/form.js"></script>
	<script src="<%=request.getContextPath() %>/js/loginValidate.js"></script>
	<script src="<%=request.getContextPath() %>/js/leftNavigation.js"></script>
	<script src="<%=request.getContextPath() %>/js/equipmentValidate.js"></script>
</body>

</html>