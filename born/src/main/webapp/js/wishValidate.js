function id(x) 
{
  if (typeof x == "string") 
  {
	  return document.getElementById(x);
  }
  return x;
 }

function submitForm()
{
	if(validateWishName() && validateWishReason() && validateEndTime() && validateWishCount()
		&& validateWishFinishNumber() && validateWishActivity())
	{
		document.wishForm.submit();
	}
}

function noticeWishName()
{
	id("wishNameNotice").innerHTML = "<font color='black'>愿望名不能超过50个字哦</font>";
}

function validateWishName()
{
	var length = id("wishName").value.length;
	if(length == 0)
	{
		id("wishNameNotice").innerHTML = "<font color='red'>愿望名不能为空哦！</font>";
		return false;
	}
	if (length > 50) 
	{
		id("wishNameNotice").innerHTML = "<font color='red'>愿望名太长没法显示了哦</font>";
		return false;
	}
	id("wishNameNotice").innerHTML = "";
	return true;
}

function noticeWishReason()
{
	id("wishReasonNotice").innerHTML = "<font color='black'>建议用一句简短的语句来描述哦,方便进行愿望的显示哦。</font>";
}

function validateWishReason()
{
	var length = id("wishReason").value.length;
	if (length  > 4000) 
	{
		id("wishReasonNotice").innerHTML = "<font color='red'>愿望理由太充分了,咱捡主要的写呗/font>";
		return false;
	}
	id("wishReasonNotice").innerHTML = "";
	return true;
}

function validateEndTime()
{
	var length = id("wishEndTime").value.length;
	if (length == 0) 
	{
		id("wishEndTimeNotice").innerHTML = "<font color='red'>完成时间不能为空哦</font>";
		return false;
	}
	id("wishEndTimeNotice").innerHTML = "";
	return true;
}

function noticeWishCount()
{
	id("wishCountNotice").innerHTML = "<font color='black'>要量化自己的愿望哦,比如打算看完多少页书，或者立志吃10个苦瓜...</font>";
}


function validateWishCount()
{
	var wishCount = id("wishCount").value;
	var numberFormat = /^[1-9][0-9]*$/;
	if (!numberFormat.test(wishCount))
	{
		id("wishCountNotice").innerHTML = "<font color='red'>完成数量要是个具体的数字哦</font>";
		return false;
	}
	id("wishCountNotice").innerHTML = "";
	return true;
}

function noticeWishFinishNumber()
{
	id("wishFinishNumberNotice").innerHTML = "<font color='black'>已完成的数量,比如看完了多少页书，或者刚吃完了1个苦瓜...</font>";
}


function validateWishFinishNumber()
{
	var wishCount = id("wishCount").value;
	var wishFinishNumber = id("wishFinishNumber").value;
	var numberFormat = /^[0-9]+$/;
	if (!numberFormat.test(wishCount)) 
	{
		id("wishFinishNumberNotice").innerHTML = "<font color='red'>已完成数量要是个具体的数字哦</font>";
		return false;
	}
	if(parseInt(wishFinishNumber)>parseInt(wishCount))
	{
		id("wishFinishNumberNotice").innerHTML = "<font color='red'>已完成数量不能大于总数哦</font>";
		return false;
	}
	id("wishFinishNumberNotice").innerHTML = "";
	return true;
}

function noticeWishActivity()
{
	id("wishActivityNotice").innerHTML = "<font color='black'>建议用一句简短的语句来描述哦,方便进行愿望的显示哦。</font>";
}

function validateWishActivity()
{
	var length = id("wishActivity").value.length;
	if (length  > 4000) 
	{
		id("wishActivityNotice").innerHTML = "<font color='red'>愿望实现太充分了,咱捡主要的写呗/font>";
		return false;
	}
	id("wishActivityNotice").innerHTML = "";
	return true;
}