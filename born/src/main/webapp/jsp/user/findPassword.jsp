<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<title>找回密码</title>
	<%@ include file="../common/common.jsp"%>
	<link rel="stylesheet" href="/css/index.css" type="text/css"  />
	<link rel="stylesheet" href="/css/main.css" type="text/css"  />
</head>

<body  style="background:url(../images/windowback.jpg);">
	<c:set var="pageType" value="user" scope="page"/>
	<%@include file="../common/header.jsp" %>
		
   	<div class="centerContent">
        <form class="form"  action="/user/findPassword" method="post">
            <table cellspacing="25" >
                <tr class="center">
                    <td colspan="2">
                        <span class="bold">找回密码</span> 
                    </td>
               </tr>
                <tr>
                    <td>用户名：</td>
                    <td style="width:100px"><input type="text" id="userName" name="userName" placeholder="请输入您的用户名"></td>
                    <td id="warning"></td>
                </tr>
                <tr>
                    <td colspan="2" class="right">
               			<input type="submit"  id="submitButton"  class="submitButton"  value="提交">
						<input  type="hidden" id="submitFlag" value="">
                    </td>
                </tr>
            </table>
        </form>
    </div>

	<%@ include file="../common/footer.jsp"%>
</body>
</html>