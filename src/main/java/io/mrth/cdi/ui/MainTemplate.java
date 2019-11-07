package io.mrth.cdi.ui;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.VaadinSession;
import io.mrth.cdi.model.UserInfo;
import io.mrth.cdi.ui.template.ViewFrame;

import javax.annotation.PostConstruct;

@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
public class MainTemplate extends AppLayout implements RouterLayout, BeforeEnterObserver {

	private Div container;

	@PostConstruct
	public void init() {
		container = new Div();
		setContent(container);
	}

	@Override
	public void showRouterLayoutContent(HasElement content) {
		container.getElement().appendChild(content.getElement());
		if (content instanceof ViewFrame) {
			((ViewFrame) content).onPageLoad(this);
		}
	}

	@Override
	public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
		VaadinSession session = beforeEnterEvent.getUI().getSession();
		UserInfo userInfo = session.getAttribute(UserInfo.class);
		if (userInfo == null) {
			beforeEnterEvent.rerouteTo(LoginPage.class);
		}
	}
}
