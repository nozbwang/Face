$("#search").bind("click", function(){
	var uuid=$("#uuid").val();
	var startTime=$("[name='startTime']").val();
	var endTime=$("[name='endTime']").val();
	window.location.href="/detail/search?uuid="+uuid+"&startTime="+startTime+"&endTime="+endTime;
	});

