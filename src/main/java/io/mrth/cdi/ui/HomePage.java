package io.mrth.cdi.ui;

import com.vaadin.cdi.annotation.RouteScoped;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import io.mrth.cdi.model.UserInfo;

import javax.annotation.PostConstruct;

@RouteScoped
@Route(value = "", layout = BasicTemplate.class)
public class HomePage extends Div {

	@PostConstruct
	public void init() {
		setTitle("Welcome");
		UserInfo userInfo = UI.getCurrent().getSession().getAttribute(UserInfo.class);
		Text text = new Text("Welcome" + userInfo.getUsername());
	}
}
