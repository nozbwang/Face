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
				<div class="divQuery pull-right">
					<a href="/robot">返回</a>
				</div>
				<%@include file="robotData.jsp"%>
			</div>
		</div>
	</div>

	<%@ include file="../common/footer.jsp"%>
	<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
		<script src="<%=request.getContextPath() %>/js/leftNavigation.js"></script>
</body>
</html>