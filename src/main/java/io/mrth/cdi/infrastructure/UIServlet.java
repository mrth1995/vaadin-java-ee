package io.mrth.cdi.infrastructure;

import com.vaadin.cdi.CdiVaadinServlet;
import com.vaadin.flow.server.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/", asyncSupported = true)
public class UIServlet extends CdiVaadinServlet implements SessionInitListener, SessionDestroyListener {
	private static final Logger LOG = LoggerFactory.getLogger(UIServlet.class);

	@Override
	protected void servletInitialized() throws ServletException {
		super.servletInitialized();
		getService().addSessionInitListener(this);
		getService().addSessionDestroyListener(this);
	}

	@Override
	public void sessionDestroy(SessionDestroyEvent sessionDestroyEvent) {
		LOG.debug("sessionDestroy {}", sessionDestroyEvent.getSession().getSession().getId());
	}

	@Override
	public void sessionInit(SessionInitEvent sessionInitEvent) throws ServiceException {
		LOG.debug("sessionDestroy {}", sessionInitEvent.getSession().getSession().getId());
	}
}
