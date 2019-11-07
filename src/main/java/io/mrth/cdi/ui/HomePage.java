package io.mrth.cdi.ui;

import com.vaadin.cdi.annotation.RouteScoped;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;
import io.mrth.cdi.ui.template.ViewFrame;

import javax.annotation.PostConstruct;

@RouteScoped
@Route(value = "", layout = MainTemplate.class)
public class HomePage extends ViewFrame {

	@PostConstruct
	public void init() {
		setPageTitle("Home");
		Label label = new Label("Home");
		add(label);
	}
}
