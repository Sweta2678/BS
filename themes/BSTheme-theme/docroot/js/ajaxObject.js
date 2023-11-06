function com_ihg_merlin_ajaxObject(url)
{
	var that=this;
	this.url=url;
	this.callback=function(){};
	this.inProcess=false;
	
	this.sendRequest = function(requestData)
	{
		//alert("requestData: " + requestData);
		if(this.inProcess==true)
		{
			return false;
		}
		this.inProcess=true;
		var AJAX=null;
		if(window.XMLHttpRequest)
		{
			//Mozilla/Safari
			AJAX=new XMLHttpRequest();
		}
		else if(typeof ActiveXObject!="undefined")
		{
			AJAX=new ActiveXObject("Microsoft.XMLHTTP");
		}
		if(AJAX==null)
		{
			return false;
		}
		AJAX.onreadystatechange = function()
		{
			if(AJAX.readyState==4 || AJAX.readyState=="complete")
			{
				//alert("this.callback: " + that.callback);
				//if(AJAX.getResponseHeader("Content-type")!="application/json")
				//{
					//that.callback(undefined);
				//}
				//else
				//{
					that.callback(AJAX.responseText);
				//}
				that.inProcess=false;
			}
		};
		AJAX.open("POST",this.url,true);
		AJAX.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		AJAX.send(requestData);
		return true;
	}
}