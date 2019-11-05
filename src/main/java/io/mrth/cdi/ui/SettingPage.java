package io.mrth.cdi.ui;

import com.vaadin.cdi.annotation.RouteScoped;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import javax.annotation.PostConstruct;

@RouteScoped
@Route(value = "setting", layout = MainTemplate.class)
public class SettingPage extends VerticalLayout {

	@PostConstruct
	public void init() {
		Div accountInfo = new Div();
		H3 name = new H3("Siska Seliani");
		Label email = new Label("siskaseliani@gmail.com");
		Label phone = new Label("087825169069");
		accountInfo.add(name, email, phone);

		Div support = new Div();
		Button helpBtn = new Button("Bantuan");
		helpBtn.setMaxWidth("100%");
		helpBtn.setIcon(new Icon(VaadinIcon.QUESTION_CIRCLE));

		Button tncBtn = new Button("Ketentuan dan Layanan");
		tncBtn.setMaxWidth("100%");
		tncBtn.setIcon(new Icon(VaadinIcon.NEWSPAPER));

		Button rateBtn = new Button("Beri Kami Nilai");
		rateBtn.setMaxWidth("100%");
		rateBtn.setIcon(new Icon(VaadinIcon.STAR));

		support.add(helpBtn, tncBtn, rateBtn);

		addAndExpand(accountInfo, support);
	}
}
