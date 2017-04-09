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
	<c:set var="menuType" value="equipmenu" scope="page"/>
	<%@include file="../common/header.jsp"%>
	<div class="dark_space"></div>

	<div class="content">
		<%@include file="../common/leftGuide.jsp"%>
		
		<div class="container-right">

			<div class="divContent">
				<div class="divNav">
					当前位置： <a href="/robot">设备管理</a> &gt;&gt;  设备列表
				</div>
				<div class="divQuery pull-right">
					<a href="/bind/equipment">新增设备</a>
				</div>

				<table class="table table-hover table-gray">
					<tbody>
						<tr>
							<th>设备绑定时间</th>
							<th>设备类型</th>
							<th>设备编号</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
						<c:if test="${not empty bindedRobots}">
							<c:forEach items="${bindedRobots }" var="bindedRobot">
								<tr>
									<td>${bindedRobot.formattedAddTime }</td>
									<td>
										<c:if test="${bindedRobot.robotType == '1' }">机器人</c:if>
										<c:if test="${bindedRobot.robotType == '2' }">运动检测设备</c:if>
										<c:if test="${bindedRobot.robotType == '3' }">温度传感器</c:if>
									</td>
									<td>${bindedRobot.uuid }</td>
									<td>
										<c:if test="${bindedRobot.workStatus == '1' }">启动</c:if>
										<c:if test="${bindedRobot.workStatus == '2' }">关闭</c:if>
									</td>
									<td>
										<a href="/delete?uuid=${bindedRobot.uuid }" onclick="if(confirm('确认要删除设备 ${bindedRobot.uuid } 么?')==false)return false;" >删除</a> |
										<c:if test="${bindedRobot.robotType == '1' }"><a href="detail/search?uuid=${bindedRobot.uuid }"></c:if>
										<c:if test="${bindedRobot.robotType == '2' }"><a href="/detail/motionEquipment?uuid=${bindedRobot.uuid }"></c:if>
										<c:if test="${bindedRobot.robotType == '3' }"><a href="/detail/temperature?uuid=${bindedRobot.uuid }"></c:if>
										查看详情</a>
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<%@ include file="../common/footer.jsp"%>
	<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
	<script src="<%=request.getContextPath()%>/js/leftNavigation.js"></script>
</body>
</html>