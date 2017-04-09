$("#uuid").blur(function(){
	$("#uuidNotice").text("");
	$("#uuidNotice").removeClass();
	
	var uuid=$("#uuid").val().trim();
	if(uuid.length==0)
	{
		$("#uuidNotice").text("设备编号不能为空.");
		return;
	}
	if(!isStringAndDigit(uuid))
	{
		$("#uuidNotice").text("设备编号只能为数字和字母的组合.");
    	$("#uuidNotice").css("color","red");
    	return;
	}
	checkuuid(uuid);
});

function checkuuid(uuid)
{
	$.ajax( {    
	    url:'/checkUuid', 
	    data:{
	    	uuid:uuid
	    },    
	    type:'post',    
	    cache:false,    
	    dataType:'json',    
	    success:function(data) {    
	        if(data.binded){    
	        	$("#uuidNotice").text("该设备已经被绑定.");
	        	$("#uuidNotice").css("color","red");
	        	return false;
	        }else{    
	        	$("#uuidNotice").addClass("ok");
	        }    
	     },    
	     error : function() {    
	          alert("异常！");    
	     }    
	});
}

$("#bindQuipmentButton").bind("click", function(){
	$("#uuidNotice").text("");
	var uuid=$("#uuid").val().trim();
	if(uuid.length==0)
	{
		$("#uuidNotice").text("设备号不能为空");
		$("#uuidNotice").css("color","red");
		return false;
	}
	var uuidExists=false;
	var submitFlag = $("#submitFlag").val();
	if (submitFlag == '1') {
		return false;
	}
	else{
		$("#submitFlag").val("1");
	}
	$.ajax( {    
	    url:'/checkUuid', 
	    data:{
	    	uuid:uuid
	    },     	
	    type:'post',    
	    cache:false,    
	    dataType:'json',    
	    async:false,
	    success:function(data) {    
	        if(data.binded){    
	        	$("#uuidNotice").text("该设备已经被绑定.");
	        	$("#uuidNotice").css("color","red");
	        	uuidExists = true;
	        }else{   
	        	uuidExists = false;
	        }    
	     },    
	});
	if (uuidExists) {
		$("#submitFlag").val("");
		return false;
	}
	document.submitForm.submit();
	});

