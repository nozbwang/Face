<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<title>注册心声</title>
	<%@ include file="common/common.jsp"%>
</head>

<body>
	<%@include file="common/header.jsp" %>
	<%@include file="common/leftLink.jsp" %>
		
       <div id="right_form">
        <form name="registerForm" action="upload/onlineData?voltage=1&current=2&mode=4&postionX=8.92&postionY=1.23&alarmStatus=12&collectTime=20170215222010" method="POST">
            <table cellspacing="25" >
                <tr class="center">
                    <td colspan="2">
                        <h2>测试实时数据</h2>
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
        <form name="registerForm" action="upload/motion?power=12&heartRateWired=123&heartRateWireless=1232&speed=123&energy=123&status=123&collectTime=20170215222010" method="POST">
            <table cellspacing="25" >
                <tr class="center">
                    <td colspan="2">
                        <h2>测试运动检测设备</h2>
                    </td>
                <tr>
                    <td>运动检测设备编号：</td>
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
        <form name="registerForm" action="upload/sensor?temperature=37&humidity=30.8&collectTime=20170215222010" method="POST">
            <table cellspacing="25" >
                <tr class="center">
                    <td colspan="2">
                        <h2>测试温度传感器</h2>
                    </td>
                <tr>
                    <td>传感器编号：</td>
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
	
	<%@ include file="common/footer.jsp"%>
	<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
	<script src="<%=request.getContextPath() %>/js/base.js"></script>
	<script src="<%=request.getContextPath() %>/js/form.js"></script>
	<script src="<%=request.getContextPath() %>/js/registerValidate.js"></script>
	</body>
</html>