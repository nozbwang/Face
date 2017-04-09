<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>机器人</title>
<%@ include file="../common/common.jsp"%>
<link rel="stylesheet" href="../../css/main.css" type="text/css" />
<link rel="stylesheet" href="../../css/list.css" type="text/css" />
<link rel="stylesheet" href="../../css/jquery.datetimepicker.css" type="text/css" />
</head>

<body style="font-size: 1em;">

	<c:set var="pageType" value="platform" scope="page" />
	<c:set var="menuType" value="equipdatamenu" scope="page"/>
	<%@include file="../common/header.jsp"%>
	<div class="dark_space"></div>

	<div class="content">
		<%@include file="../common/leftGuide.jsp"%>
		
		<div class="container-right">

			<div class="divContent">
				<div class="divNav">
					当前位置： <a href="/robot">设备管理</a> &gt;&gt; 数据查询
				</div>
				<div class="divQuery pull-left" style="margin-left:200px;">
					<lable for="uuid">设备名称</lable>
					<select id="uuid" name="uuid" style="margin:0 10px; height:30px">
						<option value="">--请选择--</option>
						<c:if test="${not empty bindedRobots}">
							<c:forEach items="${bindedRobots }" var="bindedRobot">
								<option value="${bindedRobot.uuid }" <c:if test="${uuid ==  bindedRobot.uuid}"> selected</c:if>>
									${bindedRobot.uuid }
								</option>
							</c:forEach>
						</c:if>
					</select>
					<label for="meeting">采集开始时间：</label>
					<input id="datetimepicker1"  type="text"  name="startTime" value="${startTime }" style="margin:0 5px; height:25px"/>
					<label for="meeting">采集结束时间：</label>
					<input id="datetimepicker2"  type="text"  name="endTime" value="${endTime }" style="margin:0 5px; height:25px"/>
					<a id="search"href="javascript:void()" style="color: #fff;background-color: #e64545;border: solid 1px #e64545;">搜索</a>
				</div>
				<%@include file="robotData.jsp"%>
			</div>
		</div>
	</div>

	<%@ include file="../common/footer.jsp"%>
	<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
	<script src="<%=request.getContextPath()%>/js/leftNavigation.js"></script>
	<script src="<%=request.getContextPath()%>/js/searchForm.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.datetimepicker.js"></script>
</body>
<script>
	$('#datetimepicker1').datetimepicker();
	$('#datetimepicker2').datetimepicker();
	
	
	
</script>
</html>