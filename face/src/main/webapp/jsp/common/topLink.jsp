<div id="topLink">
	<a href="/">首页</a>
	<a href="/book">读书</a>
	<a href="/foot">足迹</a>
	<a href="/treehole">树洞</a>
	<a href="/home">家</a>
	<c:if test="${user.userId == 2}">
		<a href="/bp">基础参数</a>
	</c:if>
    <c:if test="${user != null && user.userName != null}">
		<a href="/user/login">${user.userName}</a>
		<a href="/user/loginOut">登出</a>
	</c:if>
	<c:if test="${user.userName == null || user.userName == null}">
		<a href="/user/login">登录</a>
	</c:if>
</div>