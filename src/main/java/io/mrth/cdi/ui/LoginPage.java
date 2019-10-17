package io.mrth.cdi.ui;

import com.vaadin.cdi.annotation.RouteScoped;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.router.Route;
import io.mrth.cdi.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@RouteScoped
@Route(value = "auth/login", layout = BasicTemplate.class)
public class LoginPage extends Div {
	private static final Logger LOG = LoggerFactory.getLogger(LoginPage.class);

	@Inject
	private UserAuthService authService;

	public LoginPage() {
		setTitle("Login");
	}

	@PostConstruct
	public void init() {
		LoginForm loginForm = new LoginForm();
		loginForm.addLoginListener(loginEvent -> {
			boolean isAuthenticated = authService.authenticate(loginEvent.getUsername(), loginEvent.getPassword());
			if (isAuthenticated) {
				UserInfo userInfo = new UserInfo(loginEvent.getUsername());
				UI.getCurrent().getSession().setAttribute(UserInfo.class, userInfo);
				navigateToHome();
			} else {
				loginForm.setError(true);
			}
		});
	}

	private void navigateToHome() {
		UI.getCurrent().navigate(HomePage.class);
	}
}
