<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>注册心声</title>
	<%@ include file="../common/common.jsp"%>
</head>

<body>
	<%@include file="../common/topLink.jsp" %>
	<%@include file="../common/leftLink.jsp" %>
		
       <div id="right_form">
        <form name="registerForm" action="/user/registerVoice" method="POST">
            <table cellspacing="25" >
                <tr class="center">
                    <td colspan="2">
                        <h2>注册</h2>
                    </td>
                <tr>
                    <td>用户名：</td>
                    <td style="width:100px"><input type="text" id="username" name="userName" maxlength="255"></td>
                 	<td id="usernameNotice"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                   	<td style="width:100px"><input type="password" id="password" name="password" maxlength="255"></td>
                   	<td id="passwordNotice"></td>
                </tr>
                <tr>
                    <td>重复密码：</td>
                    <td style="width:100px"><input type="password"  id="confirmPassword" name="confirmPassword" maxlength="255"></td>
                    <td id="confirmPasswordNotice"></td>
                </tr>
                <tr>
                    <td>邮箱：</td>
                    <td style="width:100px"><input type="text" id="email" name="email"></td>
                    <td id="mailboxNotice"></td>
                </tr>
                <tr>
                    <td colspan="2" class="right">
                    	<input class="submitButton"  type="submit" value="注册" >
                    </td>
                </tr>
            </table>
        </form>
    </div>
	
	<%@ include file="../common/bottom.jsp"%>
	</body>
</html>