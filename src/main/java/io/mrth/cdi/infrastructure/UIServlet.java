package io.mrth.cdi.infrastructure;

import com.vaadin.cdi.CdiVaadinServlet;
import com.vaadin.flow.server.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/*", name = "ui-servlet", asyncSupported = true)
public class UIServlet extends CdiVaadinServlet implements SessionDestroyListener, SessionInitListener {
	private static final Logger LOG = LoggerFactory.getLogger(UIServlet.class);

	@Override
	protected void servletInitialized() throws ServletException {
		super.servletInitialized();
		getService().addSessionDestroyListener(this);
		getService().addSessionInitListener(this);
	}

	@Override
	public void sessionDestroy(SessionDestroyEvent sessionDestroyEvent) {
		LOG.info("sessionDestroy {}", sessionDestroyEvent.getSession().getSession().getId());
	}

	@Override
	public void sessionInit(SessionInitEvent sessionInitEvent) throws ServiceException {
		LOG.info("sessionInit {}", sessionInitEvent.getSession().getSession().getId());
	}
}
