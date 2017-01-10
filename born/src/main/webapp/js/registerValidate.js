$("#username").blur(function(){
	$("#usernameNotice").text("");
	$("#passwordNotice").text("");
	$("#usernameNotice").removeClass();
	
	var username=$("#username").val().trim();
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
	checkUsername(username);
});

function checkUsername(username)
{
	$.ajax( {    
	    url:'/login/checkUsername', 
	    data:{
	        username:username
	    },    
	    type:'post',    
	    cache:false,    
	    dataType:'json',    
	    success:function(data) {    
	        if(data.nameExists){    
	        	$("#usernameNotice").text("用户名已经被注册.");
	        	$("#usernameNotice").css("color","red");
	        }else{    
	        	$("#usernameNotice").addClass("ok");
	        }    
	     },    
	     error : function() {    
	          alert("异常！");    
	     }    
	});
}

$("#password").blur(function(){
	$("#passwordNotice").text("");
	$("#passwordNotice").removeClass();
	var password = $("#password").val().trim();
	if(password.length==0)
	{
		return;
	}
	if(!isStringAndDigit(password))
	{
		$("#passwordNotice").text("密码只能为数字和字母的组合.");
    	$("#passwordNotice").css("color","red");
    	return;
	}
	var confirmPassword = $("#confirmPassword").val().trim();
	if(confirmPassword.length==0)
	{
		return;
	}
	if(confirmPassword != password)
	{
		$("#confirmPasswordNotice").text("两次密码输入不一致.");
    	$("#confirmPasswordNotice").css("color","red");
    	return;
	}
	else
	{
		$("#confirmPasswordNotice").text("");
		$("#confirmPasswordNotice").removeClass();
	}
});

$("#confirmPassword").blur(function(){
	$("#confirmPasswordNotice").text("");
	$("#confirmPasswordNotice").removeClass();
	var confirmPassword = $("#confirmPassword").val().trim();
	var password = $("#password").val().trim();
	if(confirmPassword.length==0)
	{
		return;
	}
	if(!isStringAndDigit(confirmPassword))
	{
		$("#confirmPasswordNotice").text("密码只能为数字和字母的组合.");
    	$("#confirmPasswordNotice").css("color","red");
    	return;
	}
	if(confirmPassword != password )
	{
		$("#confirmPasswordNotice").text("两次密码输入不一致.");
    	$("#confirmPasswordNotice").css("color","red");
    	return;
	}
});

$("#mailbox").blur(function(){
	$("#mailboxNotice").text("");
	$("#mailboxNotice").removeClass();
	var mailbBox = $("#mailbox").val().trim();
	if(mailbox.length==0)
	{
		return;
	}
	if(!isEmail(mailbox))
	{
		$("#mailboxNotice").text("请输入正确的邮箱");
		$("#mailboxNotice").css("color","red");
	}
});

function checkAll()
{
	$("#usernameNotice").text("");
	$("#passwordNotice").text("");
	$("#confirmPasswordNotice").text("");
	$("#mailboxNotice").text("");
	var username=$("#username").val().trim();
	var password = $("#password").val().trim();
	var confirmPassword = $("#confirmPassword").val().trim();
	var mailbox = $("#mailbox").val().trim();
	if(username.length==0)
	{
		$("#usernameNotice").text("用户名不能为空");
		$("#usernameNotice").css("color","red");
		return false;
	}
	if(password.length==0)
	{
		$("#passwordNotice").text("密码不能为空");
		$("#passwordNotice").css("color","red");
		return false;
	}
	if(confirmPassword.length==0)
	{
		$("#confirmPasswordNotice").text("密码不能为空");
		$("#confirmPasswordNotice").css("color","red");
		return false;
	}
	if(mailbox.length==0)
	{
		$("#mailboxNotice").text("邮箱不能为空");
		$("#mailboxNotice").css("color","red");
		return false;
	}
	if(confirmPassword != password )
	{
		$("#confirmPasswordNotice").text("两次密码输入不一致.");
    	$("#confirmPasswordNotice").css("color","red");
    	return false;
	}
	if(!isEmail(mailbox))
	{
		$("#mailboxNotice").text("请输入正确的邮箱");
		$("#mailboxNotice").css("color","red");
		return false;
	}
	return true;
}

	
	
	
	
