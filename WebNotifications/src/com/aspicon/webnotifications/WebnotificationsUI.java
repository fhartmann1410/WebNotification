package com.aspicon.webnotifications;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.JavaScriptFunction;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import elemental.json.JsonArray;

@SuppressWarnings("serial")
@Theme("webnotifications")
public class WebnotificationsUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = WebnotificationsUI.class)
	public static class Servlet extends VaadinServlet {
	}



	private WebNotificationWrapper notification;
	
	

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		notification = new WebNotificationWrapper(this) {
			
			@Override
			public void notifyShow(String title) {
				System.out.println("show: " + title);
			}
			
			@Override
			public void notifyClick() {
				System.out.println("click");
			}

			@Override
			public void notifyClose() {
				System.out.println("close");
			}
		};
		
		notification.requestPermission();

		Button button = new Button("Click Me");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
				notification.show("1","This is the titel", "This is the message");
			}
		});
		layout.addComponent(button);
	}

}