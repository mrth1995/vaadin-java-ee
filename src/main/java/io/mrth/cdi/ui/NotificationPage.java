package io.mrth.cdi.ui;

import com.vaadin.cdi.annotation.RouteScoped;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;

import javax.annotation.PostConstruct;

@RouteScoped
@Route(value = "notification", layout = MainTemplate.class)
public class NotificationPage extends Div {

	@PostConstruct
	public void init() {
		Label label = new Label("notification");
		add(label);
	}
}
