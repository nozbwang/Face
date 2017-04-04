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
					<form id="submitForm" action="/bind" class="form-horizontal">
						<div class="control-group ">
							<label class="control-label" for="GatewayType"> 网关类型： </label>
							<div class="controls">
							<select name="robotType" class="height:10px;">
								<option value="1">机器人</option>
								<option value="2">运动检测设备</option>
								<option value="3">温度传感器</option>
							 </select>
							</div>
						</div>
						<div class="control-group ">
							<label class="control-label" for="GatewayType"> 设备编号：</label>
							<div class="controls">
								<input type="text" id="uuid" name="uuid" maxlength="255" placeholder="请输入设备编号">
							</div>
						</div>
						<div class="control-group ">
							<div class="controls" style="align:right">
								<input id="submitButton"  class="btn btn-main"  type="submit" value="绑定">
                    			<input type="hidden" id="submitFlag" value="1">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="../common/footer.jsp"%>
	<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
</body>

<script type="text/javascript">
	$(document).ready(function() {
		$(".headMenuItem").click(function() {
			var id = $(this).attr("data-id");
			$("[data-parent-id='" + id + "']").toggle();
			refreshBodyHeight();
		});
		//选中
		$(".menuItemActive").parent().show();
		refreshBodyHeight();
		appendRequiredStar();
	});
	/*刷新body的高度
	 */
	function refreshBodyHeight() {
		var windowHeight = document.documentElement.clientHeight;
		var bodyHeight = document.body.clientHeight;
		var menuHeigth = $(".divMenu").height();
		var mainHeight = $(".divMain").height();
		var headMenuCount = $(".headMenuItem").length;//菜单项头
		var menuCount = $(".menuItem:visible").length;//菜单项
		var changeMenuHeight = (headMenuCount + menuCount) * 50 + 100 + 20;//50表示菜单项的高度,110顶部高度，20底部高度
		if (bodyHeight < changeMenuHeight) {
			bodyHeight = changeMenuHeight;
		}
		var minMainHeight = (bodyHeight < windowHeight ? windowHeight - 110 - 20
				: bodyHeight - 110 - 20);//110顶部高度，20底部高度
		try {
			var addHeight = (window.AdditionalHeight || 0);
			minMainHeight = minMainHeight + addHeight;
		} catch (e) {
		}
		$(".divMain").css("height", minMainHeight);
		$(".divMenu").css("height", minMainHeight);
		$(".divContent").css("height", minMainHeight);
	}
</script>
</html>