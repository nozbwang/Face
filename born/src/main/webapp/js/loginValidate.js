$("#loginButton").bind("click",function()
{
	var username=$("#userName").val().trim();
	if(username.length==0)
	{
		$("#usernameNotice").text("用户名不能为空.");
		$("#usernameNotice").css("color","red");
		return false;
	}
	if(!isStringAndDigit(username))
	{
		$("#usernameNotice").text("用户名只能为数字和字母的组合.");
    	$("#usernameNotice").css("color","red");
    	return false;
	}
	var password=$("#password").val().trim();
	if(password.length==0)
	{
		$("#passwordNotice").text("密码不能为空.");
		$("#passwordNotice").css("color","red");
		return false;
	}
	if(!isStringAndDigit(password))
	{
		$("#passwordNotice").text("密码只能为数字和字母的组合.");
		$("#passwordNotice").css("color","red");
		return false;
	}
	return true;
});

$("#userName").blur(function(){
	$("#usernameNotice").text("");
	$("#passwordNotice").text("");
	$("#usernameNotice").removeClass();
	
	var username=$("#userName").val().trim();
	if(username.length==0)
	{
		return;
	}
	if(!isStringAndDigit(username))
	{
		$("#usernameNotice").text("用户名只能为数字和字母的组合.");
    	$("#usernameNotice").css("color","red");
    	return;
	}
});
