package com.aspicon.webnotifications;

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.AbstractJavaScriptExtension;
import com.vaadin.ui.UI;

@JavaScript({"notify.js","webnotification-connector.js"})
public class WebNotification extends AbstractJavaScriptExtension {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5456268564354547296L;

	public WebNotification(UI ui) {
		extend(ui);
	}
	
	public void requestPermission()
	{
		callFunction("requestPermission");
	}

	public void show(String title, String message)
	{
		callFunction("show",title, message);
	}
}
