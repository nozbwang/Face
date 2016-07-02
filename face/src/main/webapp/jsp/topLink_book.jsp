<div id="topLink">
	<a href="/">首页</a>
	<span style="margin-left:30px"></span>
	<a href="/book">全部</a>
	<a href="/book/read/literature" />文学
  	<a href="/book/read/popular"/>流行
  	<a href="/book/read/culture"/>文化
  	<a href="/book/read/life"/>生活
  	<a href="/book/read/manage"/>经管
  	<a href="/book/read/science"/>科技
  	<span style="margin-right:30px"></span>
	
    <c:if test="${user != null && user.userName != null}">
		<a href="/user/login">${user.userName}</a>
		<a href="/user/loginOut">登出</a>
	</c:if>
	<c:if test="${user.userName == null || user.userName == null}">
		<a href="/user/login">登录</a>
	</c:if>
</div>