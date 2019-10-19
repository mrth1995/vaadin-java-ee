package io.mrth.cdi.ui;

import com.vaadin.cdi.annotation.RouteScoped;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import io.mrth.cdi.model.UserInfo;

import javax.annotation.PostConstruct;

@RouteScoped
@Route(value = "", layout = MainTemplate.class)
public class HomePage extends VerticalLayout {

	@PostConstruct
	public void init() {
		Text text = new Text("Welcome");
		add(text);
	}
}
