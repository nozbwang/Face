<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>找回密码</title>
	<%@ include file="../common/common.jsp"%>
</head>

<body>

	<%@include file="../common/topLink.jsp" %>
	<%@include file="../common/leftLink.jsp" %>
	
	<div id="right_form">
        <form action="/user/findPassword" method="post">
            <table cellspacing="25" >
                <tr class="center">
                    <td colspan="2">
                        <h2>密码找回</h2>
                    </td>
               </tr>
                <tr>
                    <td>请输入您的用户名：</td>
                    <td style="width:100px"><input type="text" id="userName" name="userName"></td>
                    <td id="warning"></td>
                </tr>
                <tr>
                    <td colspan="2" class="right">
                    	<input  class="submitButton"  type="submit" value="提交">
                    </td>
                </tr>
            </table>
        </form>
    </div>

	<%@ include file="../common/bottom.jsp"%>
</body>
</html>