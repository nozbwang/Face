<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>沟通</title>
	<%@ include file="common.jsp"%>
</head>

<body>
	<%@include file="topLink_visitor.jsp" %>
<div id="left_img">
		<img src="images/windowtree.jpg" alt="by bobomeilin" />
	</div>
		
       <div id="right_form">
        <form name="voiceForm" action="/user/sendMail" method="post">
            <table cellspacing="25" >
                <tr class="center">
                    <td colspan="2">
                        <h2>邮件你我</h2>
                    </td>
                <tr>
                    <td>邮件内容：</td>
                    <td style="width:100px">
                    <textarea rows="5" cols="50" id="content" name="content" ></textarea>
                   	</td>
                </tr>
                <tr>
                    <td>邮箱：</td>
                    <td style="width:100px">
                    	<input type="radio" name="to" value="498330153@qq.com" checked="checked" />melon 
						<input type="radio" name="to" value="melody1926@126.com" />zbwang 
                   	</td>
                </tr>
                <tr>
                    <td colspan="2" class="right"><input style="width:180px;height:30px;" type="submit" value="发送邮件" ></td>
                </tr>
            </table>
        </form>
    </div>
	
	<%@ include file="bottom.jsp"%>
	</body>
<script src="<%=request.getContextPath() %>/js/jquery-1.9.1.js"></script>
<script src="<%=request.getContextPath() %>/js/base.js"></script>
<script src="<%=request.getContextPath() %>/js/registerValidate.js"></script>
</html>