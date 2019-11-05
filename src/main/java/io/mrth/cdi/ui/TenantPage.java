package io.mrth.cdi.ui;

import com.vaadin.cdi.annotation.RouteScoped;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;

import javax.annotation.PostConstruct;

@Route(value = "tenant", layout = MainTemplate.class)
@RouteScoped
public class TenantPage extends Div {

	@PostConstruct
	public void init() {
		Label title = new Label("tenant");
		add(title);
	}
}
