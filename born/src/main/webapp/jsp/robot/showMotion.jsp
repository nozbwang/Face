<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<title>机器人</title>
	<%@ include file="../common/common.jsp"%>
</head>

<body>

<%@include file="../common/topLink.jsp" %>

<%@include file="../common/leftLink.jsp" %>

<div id="right_form">
 	<c:if test="${empty robotMotion}">
		<div class="verticalCenter" style="margin-top: 250px;">
 		暂无机器人运动检测数据上报！
 		</div>
 	</c:if>
	<c:if test="${not empty robotMotion}">
		<table class="right"  border="1px" width="800px" border-spacing="0">
               <tr class="center">
                   <td colspan="7">
                       <h2>机器人运动检测数据</h2>
                   </td>
              </tr>
               <tr>
                   <td>消耗功率(W)</td>
                   <td>有线心率</td>
                   <td>无线心率</td>
                   <td>运动速度(m/s)</td>
                   <td>消耗能量(J)</td>
                   <td>状态</td>
                   <td>时间</td>
               </tr>
               <c:forEach items="${robotMotion }" var="item">
               	<tr>
					<td>${item.power }</td>
					<td>${item.heartRateWired }</td>
					<td>${item.heartRateWireless }</td>
					<td>${item.speed }</td>
					<td>${item.energy }</td>
					<td>${item.status }</td>
               		<td>${item.formattedCollectTime }</td>
               	</tr>
               </c:forEach>
           </table>
	</c:if>
            
</div>

<%@ include file="../common/bottom.jsp"%>
</body>
</html>