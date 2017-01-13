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
	$.ajax( {    
	    url:'/user/checkUsername', 
	    data:{
	        username: $("#username").val()
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





function submitForm()
{
	if (userExist) 
	{
		id("userNameNotice").innerHTML = "<font color='red'>该用户名已被使用！</font>";
	} 
	else if(validateUserName() && validatePassword() && validateConfirmPassword() && validateMailBox())
	{
		document.registerForm.submit();
	}
}

function validateUserName()
{
	var length = id("username").value.length;
	if (length < 3 || length > 20) 
	{
		id("userNameNotice").innerHTML = "<font color='red'>用户名长度为3-20个字符</font>";
		return false;
	}
	id("userNameNotice").innerHTML = "";
	return true;
}

function validatePassword()
{
	var length = id("password").value.length;
	if (length < 3 || length > 20) 
	{
		id("passwordNotice").innerHTML = "<font color='red'>密码长度为3-20个字符</font>";
		return false;
	}
	id("passwordNotice").innerHTML = "";
	return true;
}

function validateConfirmPassword()
{
	password = id("password").value;
	confirmPassword = id("confirmPassword").value;
	if (password != confirmPassword) 
	{
		id("confirmPasswordNotice").innerHTML = "<font color='red'>两次密码输入不一致</font>";
		return false;
	}
	id("confirmPasswordNotice").innerHTML = "";
	return true;
}

function validateMailBox()
{
	mailBox = id("mailbox").value;
	var mailPattern = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if(!mailPattern.test(mailBox))
	{
		id("mailBoxNotice").innerHTML = "<font color='red'>请输入正确的邮箱地址</font>";
		return false;
	}
	id("mailBoxNotice").innerHTML = "";
	return true;
}

var xmlHttp;
var userExist = true;
function checkUserExist() 
{
	var length =  id("username").value.length;
	if (length < 3 || length > 20) 
	{
		id("userNameNotice").innerHTML = "<font color='red'>用户名长度为3-20个字符</font>";
		return;
	}
	id("userNameNotice").innerHTML = "<font>用户名检测中...</font>";
	var userName = id("username").value;
	if (window.ActiveXObject) 
	{
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	} 
	else if (window.XMLHttpRequest) 
	{
		xmlHttp = new XMLHttpRequest();
	}
	var uri = "/user/registerValidate?username=" + userName;
	xmlHttp.open("post", uri, true);
	
	xmlHttp.onreadystatechange = function() 
	{
		if (xmlHttp.readyState == 4) 
		{
			if (xmlHttp.status == 200) 
			{
				var flag = xmlHttp.responseText;
				if (flag == "EXIST") 
				{
					id("userNameNotice").innerHTML = "<font color='red'>该用户名已被使用！</font>";
					userExist = true;
				} 
				else 
				{
					id("userNameNotice").innerHTML = "<font color='green'>恭喜您，该用户名可用!</font>";
					userExist = false;
				}
			}
		}
	};
	xmlHttp.send(null);
}