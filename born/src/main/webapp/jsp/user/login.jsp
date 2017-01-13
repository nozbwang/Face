<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<title>登录心声</title>
	<%@ include file="../common/common.jsp"%>
</head>

<body>

	<%@include file="../common/topLink.jsp" %>
	
	<%@include file="../common/leftLink.jsp" %>

    <div id="right_form">
        <form name="loginForm" action="/user/loginVoice" method="POST" onsubmit="return checkAll()">
            <table cellspacing="25" class="right" >
                <tr class="center">
                    <td colspan="2">
                        <h2>登录</h2>
                    </td>
               </tr>
                <tr>
                    <td>用户名：</td>
                    <td style="width:100px"><input type="text" id="userName" name="userName" maxlength="20"></td>
                    <td id="usernameNotice"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td style="width:100px"><input type="password" id="password" name="password" maxlength="20"></td>
                    <td id="passwordNotice"></td>
                </tr>
                <tr>
                    <td colspan="2">
                	    <input id="loginButton"  class="submitButton"  type="submit" value="登录">
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><a href="/user/register">新用户注册</a></td>
                </tr>
                <tr>
                    <td colspan="2"><a href="/user/find">找回密码</a></td>
                </tr>
            </table>
        </form>
    </div>
	
	<%@ include file="../common/bottom.jsp"%>
</body>

	<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
	<script src="<%=request.getContextPath() %>/js/base.js"></script>
	<script src="<%=request.getContextPath() %>/js/form.js"></script>
	<script src="<%=request.getContextPath() %>/js/loginValidate.js"></script>
</html>