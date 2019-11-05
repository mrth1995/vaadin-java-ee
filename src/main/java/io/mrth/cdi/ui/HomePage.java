package io.mrth.cdi.ui;

import com.vaadin.cdi.annotation.RouteScoped;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import javax.annotation.PostConstruct;

@RouteScoped
@Route(value = "", layout = MainTemplate.class)
public class HomePage extends VerticalLayout {

	@PostConstruct
	public void init() {
		Label label = new Label("Home");
		add(label);
	}
}
