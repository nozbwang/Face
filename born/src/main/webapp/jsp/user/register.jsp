<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<title>注册</title>
	<%@ include file="../common/common.jsp"%>
	<link rel="stylesheet" href="/css/index.css" type="text/css"  />
	<link rel="stylesheet" href="/css/main.css" type="text/css"  />
</head>

<body  style="background:url(../images/windowback.jpg);">
	<c:set var="pageType" value="user" scope="page"/>
	<%@include file="../common/header.jsp" %>
		
   	<div class="centerContent">
        <form class="form" name="registerForm" action="/user/registerVoice" method="POST">
            <table cellspacing="25" >
                <tr class="center">
                    <td colspan="2">
                		<span class="bold">注册</span> 
                    </td>
                <tr>
                    <td>用户名：</td>
                    <td style="width:100px"><input type="text" id="username" name="userName" maxlength="255" placeholder="请输入英文和数字的组合"></td>
                 	<td id="usernameNotice"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                   	<td style="width:100px"><input type="password" id="password" name="password" maxlength="255" placeholder="请输入英文和数字的组合"></td>
                   	<td id="passwordNotice"></td>
                </tr>
                <tr>
                    <td>重复密码：</td>
                    <td style="width:100px"><input type="password"  id="confirmPassword" name="confirmPassword" maxlength="255"></td>
                    <td id="confirmPasswordNotice"></td>
                </tr>
                <tr>
                    <td>邮箱：</td>
                    <td style="width:100px"><input type="text" id="mailbox" name="email" placeholder="常用邮箱，可用于找回密码"></td>
                    <td id="mailboxNotice"></td>
                </tr>
                <tr>
                    <td colspan="2" class="right">
                    	<input id="registerButton"  class="submitButton" type="submit" value="注册">
                    	<input type="hidden" id="submitFlag" value="">
                    </td>
                </tr>
                 <tr>
                    <td colspan="2" class="right"><a href="/user/login">用户登录</a></td>
                </tr>
            </table>
        </form>
    </div>
	
	<%@ include file="../common/footer.jsp"%>
	<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
	<script src="<%=request.getContextPath() %>/js/base.js"></script>
	<script src="<%=request.getContextPath() %>/js/form.js"></script>
	<script src="<%=request.getContextPath() %>/js/registerValidate.js"></script>
	</body>
</html>