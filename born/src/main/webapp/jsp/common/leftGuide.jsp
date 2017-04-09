<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<div class="container-left">
			<div class="divMenu" style="">
				<div class="headMenuItem" data-id="16">
					<span> 设备管理 </span> <img src="../images/ico_arrow.png">
				</div>
				<div data-parent-id="16" style="">
					<div class="menuItem <c:if test="${menuType==null || menuType == 'equipmenu' }"> menuItemActive</c:if> ">
						<a href="/robot">设备列表</a>
					</div>
					<div class="menuItem <c:if test="${menuType == 'equipdatamenu' }"> menuItemActive</c:if> ">
						<a href="/detail/search">数据查询</a>
					</div>
				</div>
				<div class="headMenuItem" data-id="33">
					<span> 个人中心 </span> <img src="../images/ico_arrow.png">
				</div>
				<div data-parent-id="33" style="display: none;">
					<div class="menuItem">
						<a href="#">修改密码</a>
					</div>
					<div class="menuItem">
						<a href="#">我的资料</a>
					</div>
					<div class="menuItem">
						<a href="#">日志信息</a>
					</div>
				</div>
			</div>
		</div>