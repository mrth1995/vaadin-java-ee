package io.mrth.cdi.ui;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.VaadinSession;
import io.mrth.cdi.model.UserInfo;

@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
public class MainTemplate extends Div implements RouterLayout, BeforeEnterObserver {

	@Override
	public void showRouterLayoutContent(HasElement content) {
		getElement().appendChild(content.getElement());
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
