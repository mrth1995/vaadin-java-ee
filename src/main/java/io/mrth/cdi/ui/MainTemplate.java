package io.mrth.cdi.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.VaadinSession;
import io.mrth.cdi.model.UserInfo;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
public class MainTemplate extends AppLayout implements RouterLayout, BeforeEnterObserver {

	private Div container;
	private Tabs menu;

	@PostConstruct
	public void init() {
		container = new Div();
		menu = createMenu();
		addToNavbar(true, menu);
		setContent(container);
	}

	private Tabs createMenu() {
		Tabs navBar = new Tabs(populateMenu());
		navBar.setOrientation(Tabs.Orientation.HORIZONTAL);
		navBar.setWidthFull();
		navBar.setFlexGrowForEnclosedTabs(1);
		return navBar;
	}

	private Tab[] populateMenu() {
		List<Tab> tabs = new ArrayList<>();
		tabs.add(createTab(HomePage.class, VaadinIcon.HOME));
		tabs.add(createTab(NotificationPage.class, VaadinIcon.BELL));
		tabs.add(createTab(TenantPage.class, VaadinIcon.SHOP));
		tabs.add(createTab(SettingPage.class, VaadinIcon.COGS));
		return tabs.toArray(new Tab[tabs.size()]);
	}

	private Tab createTab(Class<? extends Component> targetClass, VaadinIcon icon) {
		Tab tab = new Tab();
		RouterLink link = new RouterLink(null, targetClass);
		link.add(icon.create());
		tab.add(link);
		return tab;
	}

	@Override
	public void showRouterLayoutContent(HasElement content) {
		container.getElement().appendChild(content.getElement());
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
