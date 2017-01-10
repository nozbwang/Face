function deleteFriend()
{
	var friendObject = document.getElementsByName("friendID");
	var friendNumber = friendObject.length;
	var deleteFriendIDGroup="";
	for (i=0; i<friendNumber; i++)
	{
	  if(friendObject[i].checked == true)
	  {
		  deleteFriendIDGroup += friendObject[i].value+",";
	  }
	}
	if(deleteFriendIDGroup.length == 0)
	{
		alert("请选择要删除掉的好友.");
		return;
	}
	deleteFriendIDGroup = deleteFriendIDGroup.substring(0, deleteFriendIDGroup.length-1);
	if(confirm("你确定要删除么？"))
	{
		location="deleteFriend?deleteFriendIDGroup=" + deleteFriendIDGroup;
	}
}

function selectAll()
{
	var friendObject = document.getElementsByName("friendID");
	if (document.getElementsByName("friendSelectControl")[0].checked) 
	{
		for ( var i = 0; i < friendObject.length; i++) 
		{
			friendObject[i].checked = true;
		}
	} 
	else 
	{
		for ( var j = 0; j < friendObject.length; j++) 
		{
			friendObject[j].checked = false;
		}
	}
}

function id(x) 
{
  if (typeof x == "string") 
  {
	  return document.getElementById(x);
  }
  return x;
 }

function checkFriendExist()
{
	var xmlHttp;
	var length =  id("userName").value.length;
	if (length < 3 || length > 20) 
	{
		id("userNameNotice").innerHTML = "<font color='red'>无此用户名</font>";
		return friendExist;
	}
	id("userNameNotice").innerHTML = "<font>用户名检测中...</font>";
	var userName = id("userName").value;
	if (window.ActiveXObject) 
	{
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	} 
	else if (window.XMLHttpRequest) 
	{
		xmlHttp = new XMLHttpRequest();
	}
	var uri = "fireFriendRequest?userName=" + userName;
	xmlHttp.open("post", uri, true);
	
	xmlHttp.onreadystatechange = function() 
	{
		if (xmlHttp.readyState == 4) 
		{
			if (xmlHttp.status == 200) 
			{
				var flag = xmlHttp.responseText;
				if (flag == "OK") 
				{
					id("userNameNotice").innerHTML = "<font color='green'>好友申请已发出，请耐心等待</font>";
				} 
				else 
				{
					id("userNameNotice").innerHTML = "<font color='red'>"+flag+"</font>";
				}
			}
		}
	};
	xmlHttp.send(null);
}