package io.mrth.cdi.ui;

import com.vaadin.cdi.annotation.RouteScoped;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.AbstractLogin;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.Route;
import io.mrth.cdi.model.UserInfo;
import io.mrth.cdi.service.UserAuthService;
import io.mrth.cdi.ui.template.ViewFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@RouteScoped
@Route(value = "auth/login", layout = BasicTemplate.class)
public class LoginPage extends ViewFrame {
	private static final Logger LOG = LoggerFactory.getLogger(LoginPage.class);

	@Inject
	private UserAuthService authService;

	private LoginOverlay loginOverlay;
	private LoginI18n loginI18n;

	public LoginPage() {
		setPageTitle("Login");
	}

	@PostConstruct
	public void init() {
		loginI18n = LoginI18n.createDefault();
		loginI18n.getForm().setTitle("Login");
		loginI18n.getForm().setSubmit("Login");
		loginI18n.getErrorMessage().setMessage("Invalid username/password");
		loginI18n.getErrorMessage().setTitle("Login failed");
		loginI18n.setAdditionalInformation("Additional Info");
		loginOverlay = new LoginOverlay(loginI18n);
		loginOverlay.addLoginListener(this::login);

		Div title = new Div();
		title.getStyle().set("color", "#f0f0f0");
		title.getStyle().set("text-align", "center");
		title.getStyle().set("font-weight", "bold");
		title.getStyle().set("font-size", "18px");
		title.add("Kwon App");

		loginOverlay.setTitle(title);

		loginOverlay.setTitle("Overlay title");
		loginOverlay.setDescription("Ini desc");
		loginOverlay.setOpened(true);

	}

	private void login(AbstractLogin.LoginEvent loginEvent) {
		LOG.info("login");
		String username = loginEvent.getUsername();
		String password = loginEvent.getPassword();
		if (authService.authenticate(username, password)) {
			loginOverlay.setOpened(false);
			UserInfo userInfo = new UserInfo(username);
			UI ui = UI.getCurrent();
			ui.getSession().setAttribute(UserInfo.class, userInfo);
			ui.navigate(HomePage.class);
		} else {
			loginOverlay.setError(true);
		}
	}
}
