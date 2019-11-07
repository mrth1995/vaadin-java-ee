package io.mrth.cdi.ui.template;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.RouterLayout;

public class ViewFrame extends Composite<Div> implements HasStyle, HasDynamicTitle {

	private String pageTitle;

	public void add(Component... components) {
		getContent().add(components);
	}
	@Override
	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public void setHeightFull() {
		getContent().setHeightFull();
	}

	public void onPageLoad(RouterLayout layout) {

	}
}
