<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>机器人</title>
<%@ include file="../common/common.jsp"%>
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
					当前位置： <a href="/robot">设备管理</a> &gt;&gt; 数据查询
				</div>
				<div class="divQuery pull-right">
					<a href="/bind/equipment">新增设备</a>
				</div>

				<table class="table table-hover table-gray">
					<tbody>
						<tr>
							<th>电压</th>
							<th>电流</th>
							<th>工作模式</th>
							<th>机器人位置X(mm)</th>
							<th>机器人位置Y(mm)</th>
							<th>报警状态</th>
							<th>时间</th>
						</tr>
						<c:if test="${not empty robotOnlineData}">
							<c:forEach items="${robotOnlineData }" var="item">
								<tr>
									<td>${item.voltage }</td>
									<td>${item.current }</td>
									<td>${item.mode }</td>
									<td>${item.postionX }</td>
									<td>${item.postionY }</td>
									<td>${item.alarmStatus }</td>
				               		<td>${item.formattedCollectTime }</td>
				               	</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
				<%@include file="../page/pager.jsp"%>
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