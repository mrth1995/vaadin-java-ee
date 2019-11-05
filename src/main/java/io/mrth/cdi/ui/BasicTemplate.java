package io.mrth.cdi.ui;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.VaadinSession;
import io.mrth.cdi.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
public class BasicTemplate extends Div implements RouterLayout {
	private static final Logger LOG = LoggerFactory.getLogger(BasicTemplate.class);

	public BasicTemplate() {
	}

	@Override
	public void showRouterLayoutContent(HasElement content) {
		getElement().appendChild(content.getElement());
	}
}
