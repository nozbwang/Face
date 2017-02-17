<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
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
        <form name="registerForm" action="/robot/bindRobot" method="POST">
            <table cellspacing="25" >
                <tr class="center">
                    <td colspan="2">
                        <h2>绑定机器人</h2>
                    </td>
                <tr>
                    <td>机器人编号：</td>
                    <td style="width:100px"><input type="text" id="uuid" name="uuid" maxlength="255" placeholder="请输入机器人编号"></td>
                </tr>
                <tr>
                    <td colspan="2" class="right">
                    	<input id="registerButton"  class="submitButton" type="submit" value="绑定">
                    	<input type="hidden" id="submitFlag" value="">
                    </td>
                </tr>
            </table>
        </form>
    </div>
	
	<%@ include file="../common/bottom.jsp"%>
	<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
	<script src="<%=request.getContextPath() %>/js/base.js"></script>
	<script src="<%=request.getContextPath() %>/js/form.js"></script>
	<script src="<%=request.getContextPath() %>/js/registerValidate.js"></script>
	</body>
</html>