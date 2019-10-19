package io.mrth.cdi.infrastructure;

import com.vaadin.cdi.CdiVaadinServlet;
import com.vaadin.flow.server.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/*", name = "ui-servlet", asyncSupported = true)
public class UIServlet extends CdiVaadinServlet implements SessionDestroyListener, SessionInitListener {

	@Override
	protected void servletInitialized() throws ServletException {
		super.servletInitialized();
		getService().addSessionDestroyListener(this);
		getService().addSessionInitListener(this);
	}

	@Override
	public void sessionDestroy(SessionDestroyEvent sessionDestroyEvent) {

	}

	@Override
	public void sessionInit(SessionInitEvent sessionInitEvent) throws ServiceException {

	}
}
