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

<%@include file="../common/topLink.jsp" %>

<%@include file="../common/leftLink.jsp" %>

<div id="right_form">
 	<c:if test="${empty bindedRobot}">
		<div class="verticalCenter" style="margin-top: 250px;">
 		尚未绑定机器人，请先<a href="/robot/bind" >绑定</a>!
 		</div>
 	</c:if>
	<c:if test="${not empty bindedRobot}">
		<a href="/robot/bind" >绑定机器人</a></br></br>
		<table class="right"  border="1px" width="800px" border-spacing="0">
               <tr class="center">
                   <td colspan="6">
                       <h2>我的机器人</h2>
                   </td>
              </tr>
               <tr>
                   <td>绑定时间</td>
                   <td>机器人编号</td>
                   <td>机器人状态</td>
                   <td>上报数据详情</td>
                   <td>机器人控制</td>
                   <td>机器人操作历史</td>
               </tr>
               <c:forEach items="${bindedRobot }" var="item">
               	<tr>
               		<td>${item.formattedAddTime }</td>
               		<td>${item.uuid }</td>
              		<td>
						<c:if test="${item.workStatus == '1' }">启动</c:if>
						<c:if test="${item.workStatus == '2' }">关闭</c:if>
					</td>
               		<td>	  <a target="_blank" href="/robot/showOnlineData?robotId=${item.robotId }">实时数据</a>
               		</td>
               		<td>
               			<a target="_blank" href="/robot/start?robotId=${item.robotId }">启动</a>
               			| <a target="_blank" href="/robot/stop?robotId=${item.robotId }">停止</a>
               		</td>
               		<td><a href="/robot/showControl?robotId=${item.robotId }">查看详情</a></td>
               	</tr>
               </c:forEach>
           </table>
	</c:if>
            
</div>

<%@ include file="../common/bottom.jsp"%>
</body>
</html>