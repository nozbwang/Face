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
 	<c:if test="${empty robotTemperature}">
		<div class="verticalCenter" style="margin-top: 250px;">
 		暂无机器人温度数据上报！
 		</div>
 	</c:if>
	<c:if test="${not empty robotTemperature}">
		<table class="right"  border="1px" width="400px" border-spacing="0">
               <tr class="center">
                   <td colspan="2">
                       <h2>机器人温度</h2>
                   </td>
              </tr>
               <tr>
                   <td>温度</td>
                   <td>时间</td>
               </tr>
               <c:forEach items="${robotTemperature }" var="item">
               	<tr>
					<td>${item.temperature }</td>
               		<td>${item.formattedCollectTime }</td>
               	</tr>
               </c:forEach>
           </table>
	</c:if>
            
</div>

<%@ include file="../common/bottom.jsp"%>
</body>
</html>