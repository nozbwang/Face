<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="refresh" content="5">
	<title>机器人</title>
	<%@ include file="../common/common.jsp"%>
</head>

<body>

<%@include file="../common/topLink.jsp" %>

<%@include file="../common/leftLink.jsp" %>

<div id="right_form">
 	<c:if test="${empty robotOnlineData}">
		<div class="verticalCenter" style="margin-top: 250px;">
 		暂无实时数据上报！
 		</div>
 	</c:if>
	<c:if test="${not empty robotOnlineData}">
		<table class="right"  border="1px" width="800px" border-spacing="0">
               <tr class="center">
                   <td colspan="7">
                       <h2>机器人实时数据</h2>
                   </td>
              </tr>
               <tr>
                   <td>电压</td>
                   <td>电流</td>
                   <td>工作模式</td>
                   <td>机器人位置X(mm)</td>
                   <td>机器人位置Y(mm)</td>
                   <td>报警状态</td>
                   <td>时间</td>
               </tr>
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
           </table>
	</c:if>
            
</div>

<%@ include file="../common/bottom.jsp"%>
</body>
</html>