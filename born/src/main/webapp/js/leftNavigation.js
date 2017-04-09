	$(document).ready(function() {
		$(".headMenuItem").click(function() {
			var id = $(this).attr("data-id");
			$("[data-parent-id='" + id + "']").toggle();
			refreshBodyHeight();
		});
		//选中
		$(".menuItemActive").parent().show();
		refreshBodyHeight();
	});
	/*刷新body的高度
	 */
	function refreshBodyHeight() {
		var windowHeight = document.documentElement.clientHeight;
		var bodyHeight = document.body.clientHeight;
		var menuHeigth = $(".divMenu").height();
		var mainHeight = $(".divMain").height();
		var headMenuCount = $(".headMenuItem").length;//菜单项头
		var menuCount = $(".menuItem:visible").length;//菜单项
		var changeMenuHeight = (headMenuCount + menuCount) * 50 + 100 + 20;//50表示菜单项的高度,110顶部高度，20底部高度
		if (bodyHeight < changeMenuHeight) {
			bodyHeight = changeMenuHeight;
		}
		var minMainHeight = (bodyHeight < windowHeight ? windowHeight - 110 - 20
				: bodyHeight - 110 - 20);//110顶部高度，20底部高度
		try {
			var addHeight = (window.AdditionalHeight || 0);
			minMainHeight = minMainHeight + addHeight;
		} catch (e) {
		}
		$(".divMain").css("height", minMainHeight);
		$(".divMenu").css("height", minMainHeight);
		$(".divContent").css("height", minMainHeight);
	}
