<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<div id="topLink">
	<a href="/">首页</a>
	<span style="margin-left:30px"></span>
	<a href="${baseLink}">全部</a>
	<c:forEach items="${baseParameters}" var="baseParameter">
		<a href="${baseLink}/${baseParameter.nameEn}" />${baseParameter.nameCn}
  	</c:forEach>
  	<span style="margin-right:30px"></span>
    <c:if test="${user != null && user.userName != null}">
		<a href="/user/login">${user.userName}</a>
		<a href="/user/loginOut">登出</a>
	</c:if>
	<c:if test="${user.userName == null || user.userName == null}">
		<a href="/user/login">登录</a>
	</c:if>
</div>