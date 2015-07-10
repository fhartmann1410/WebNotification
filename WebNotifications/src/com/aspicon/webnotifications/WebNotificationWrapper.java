package com.aspicon.webnotifications;

import com.vaadin.ui.JavaScript;
import com.vaadin.ui.JavaScriptFunction;
import com.vaadin.ui.UI;

import elemental.json.JsonArray;


public abstract class WebNotificationWrapper {

	private WebNotification notification;

	public WebNotificationWrapper(UI ui) 
	{
		JavaScript.getCurrent().addFunction("notifyShow", new JavaScriptFunction() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = -2056167702634871096L;

			@Override
			public void call(JsonArray arguments) {
				notifyShow(arguments.getString(0));
				
			}
		});
		
		JavaScript.getCurrent().addFunction("notifyClick", new JavaScriptFunction() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = -8886288852304884089L;

			@Override
			public void call(JsonArray arguments) {
				notifyClick();
			}
		});
		
		JavaScript.getCurrent().addFunction("notifyClose", new JavaScriptFunction() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 7399112380054521242L;

		@Override
		public void call(JsonArray arguments) {
			notifyClose();
		}
	});

//		JavaScript.getCurrent().addFunction("notifyError", new JavaScriptFunction() {
//			
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = -8886288852304884089L;
//
//			@Override
//			public void call(JsonArray arguments) {
//				notifyError(arguments.getString(0));
//			}
//		});
//
//		JavaScript.getCurrent().addFunction("permissionGranted", new JavaScriptFunction() {
//		
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = -8886288852304884089L;
//		
//			@Override
//			public void call(JsonArray arguments) {
//				permissionGranted();
//			}
//		});
//	
//	
//		JavaScript.getCurrent().addFunction("permissionDenied", new JavaScriptFunction() {
//			
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = -8886288852304884089L;
//		
//			@Override
//			public void call(JsonArray arguments) {
//				permissionDenied();
//			}
//		});

		notification = new WebNotification(ui);
	}

	public void requestPermission()
	{
		notification.requestPermission();
	}
	
	public void show(String id, String title, String message)
	{
		notification.show(title, message);
	}
	
	public abstract void notifyClick();
	
	public abstract void notifyClose();
	
	public abstract void notifyShow(String title);
	
//	public abstract void notifyError(String title);
//	
//	public abstract void permissionGranted();
//	
//	public abstract void permissionDenied();
	
//	@com.vaadin.annotations.JavaScript({"notify.js","webnotification-connector.js"})
//	private class WebNotification extends AbstractJavaScriptExtension {
//
//		
//		private static final long serialVersionUID = 5456268564354547296L;
//
//		public WebNotification(UI ui) {
//			extend(ui);
//		}
//		
//		public void requestPermission()
//		{
//			callFunction("requestPermission");
//		}
//
//		public void show(String title, String message)
//		{
//			callFunction("show", title, message);
//		}
//	}
}
