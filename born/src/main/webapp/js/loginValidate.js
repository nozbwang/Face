function checkAll()
{
	var username=$("#username").val().trim();
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
}

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
	    url:'/login/checkUsername', 
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
		
});
