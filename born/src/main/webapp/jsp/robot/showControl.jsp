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
 	<c:if test="${empty robotControls}">
		<div class="verticalCenter" style="margin-top: 250px;">
 		暂无机器人控制数据上报！
 		</div>
 	</c:if>
	<c:if test="${not empty robotControls}">
		<table class="right"  border="1px" width="400px" border-spacing="0">
               <tr class="center">
                   <td colspan="2">
                       <h2>机器人控制历史</h2>
                   </td>
              </tr>
               <tr>
                   <td>时间</td>
                   <td>操作</td>
               </tr>
               <c:forEach items="${robotControls }" var="item">
               	<tr>
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

<%@ include file="../common/bottom.jsp"%>
</body>
</html>