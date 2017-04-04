<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<title>机器人</title>
	<meta http-equiv="refresh" content="5">
	<%@ include file="../common/common.jsp"%>
</head>

<body>

<%@include file="../common/header.jsp" %>

<%@include file="../common/leftLink.jsp" %>

<div id="right_form">
 	<c:if test="${empty robotControls}">
		<div class="verticalCenter" style="margin-top: 250px;">
 		暂无控制数据上报！
 		</div>
 	</c:if>
	<c:if test="${not empty robotControls}">
		<table class="right"  border="1px" width="400px" border-spacing="0">
               <tr class="center">
                   <td colspan="3">
                       <h2>
                   <c:if test="${bindedRobot.robotType == 1 }" >   机器人</c:if>
                   <c:if test="${bindedRobot.robotType == 2 }" >  运动检测设备</c:if>
                   <c:if test="${bindedRobot.robotType == 3 }" >   温度传感器</c:if>控制历史</h2>
                   </td>
              </tr>
               <tr>
               	   <td>编号</td>
                   <td>时间</td>
                   <td>操作</td>
               </tr>
               <c:forEach items="${robotControls }" var="item">
               	<tr>
               		<td>${bindedRobot.uuid}</td>
               		<td>${item.formattedAddTime }</td>
					<td>
						<c:if test="${item.action == '1' }">启动机器人</c:if>
						<c:if test="${item.action == '2' }">关闭机器人</c:if>
					</td>
               	</tr>
               </c:forEach>
           </table>
	</c:if>
            
</div>

<%@ include file="../common/footer.jsp"%>
</body>
</html>