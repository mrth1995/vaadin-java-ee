package io.mrth.cdi.ui;

import com.vaadin.cdi.annotation.RouteScoped;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterListener;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import io.mrth.cdi.model.UserInfo;

import javax.annotation.PostConstruct;

@RouteScoped
@Route(value = "")
public class HomePage extends VerticalLayout implements BeforeEnterListener {

	@PostConstruct
	public void init() {
		UserInfo userInfo = UI.getCurrent().getSession().getAttribute(UserInfo.class);
		Text text = new Text("Welcome" + userInfo.getUsername());
	}

	@Override
	public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
		UserInfo userInfo = beforeEnterEvent.getUI().getSession().getAttribute(UserInfo.class);
		if (userInfo == null) {
			beforeEnterEvent.rerouteTo(LoginPage.class);
		}
	}
}
