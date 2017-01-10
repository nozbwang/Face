$("#submitButton").bind("click", function(){
	var submitFlag = $("#submitFlag").val();
	if (submitFlag == '') {
		$("#submitFlag").val("1");
		document.submitForm.submit();
	}
	return true;
})

function deleteConfirm() {
	var confirmed = window.confirm("亲，不要删除我啊！");
	if (confirmed) {
		return true;
	}
	return false;
}

$("#remotePictureFlag").bind("click",function(){
	$("#localPicture").hide();
	$("#remotePicture").show();
	$("#localPictureE").val("");
})
	
$("#localPictureFlag").bind("click",function(){
	$("#localPicture").show();
	$("#remotePicture").hide();
	$("#remotePictureE").val("");
})

function addImage(){ 
    $("#imageDiv")
    	.append('<div></br><input type="file" id="file" name="file" /><a href="#" name="rmlink"><img src="/images/icon/del.png"/></a></div>');
    // 为新元素节点添加事件侦听器
    bindListener();
}
// 用来绑定事件(使用unbind避免重复绑定)
function bindListener(){
    $("a[name=rmlink]").unbind().click(function(){
        $(this).parent().remove(); 
    })
}