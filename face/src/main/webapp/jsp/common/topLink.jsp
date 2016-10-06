<div id="topLink">
	<a href="/">首页</a>
	<a href="/book">读书</a>
	<a href="/foot">足迹</a>
    <c:if test="${user != null && user.userName != null}">
		<a href="/user/login">${user.userName}</a>
		<a href="/user/loginOut">登出</a>
	</c:if>
	<c:if test="${user.userName == null || user.userName == null}">
		<a href="/user/login">登录</a>
	</c:if>
</div>