<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<div id="header">
	<div id="smallLogo"></div>
	<ul id="menu">
		<li  <c:if test="${pageType == 'index'}"> class="active" </c:if>><a href="/">首页</a></li>
		<li <c:if test="${pageType == 'example'}"> class="active" </c:if>><a href="#">案例</a></li>
		<li <c:if test="${pageType == 'platform'}"> class="active" </c:if>><a href="/robot">云服务平台</a></li>	
		<li <c:if test="${pageType == 'user'}"> class="active" </c:if>>	
		 <c:if test="${user != null && user.isLogon()}">
			<a href="/user/login">${user.userName}</a>
			<ul style="display:none">
				<li><a href="/user/loginOut">登出</a></li>
			</ul>
		</c:if>
		<c:if test="${user == null || !user.isLogon()}">
			<a href="/user/login">登录</a>
		</c:if>	
		</li>
		<li <c:if test="${pageType == 'contactUs'}"> class="active" </c:if>><a href="#">联系我们</a></li>
	</ul>
</div>
