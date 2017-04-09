<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

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
						<c:if test="${empty robotOnlineData}">
							<tr><td  colspan="7" align="center">暂无数据</td></tr>
						</c:if>
					</tbody>
				</table>
				<%@include file="../page/pager.jsp"%>
