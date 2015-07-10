window.com_aspicon_webnotifications_WebNotification = function(){
	this.requestPermission = function(){
		Notify.requestPermission();
	}

	this.show = function(title,message) {
		var notification = new Notify(title, {
		    body: message,
		    notifyShow:notifyShow(title),
		    notifyClick:notifyClick,
		    notifyClose:notifyClose
		});

		notification.show();
	}
}