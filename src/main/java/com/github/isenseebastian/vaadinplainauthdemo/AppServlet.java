package com.github.isenseebastian.vaadinplainauthdemo;

import com.vaadin.flow.server.ServiceException;
import com.vaadin.flow.server.SessionDestroyEvent;
import com.vaadin.flow.server.SessionDestroyListener;
import com.vaadin.flow.server.SessionInitEvent;
import com.vaadin.flow.server.SessionInitListener;
import com.vaadin.flow.server.VaadinServlet;
import jakarta.servlet.ServletException;

public class AppServlet extends VaadinServlet implements SessionInitListener, SessionDestroyListener {

    @Override
    protected void servletInitialized() throws ServletException {
        super.servletInitialized();
        getService().addSessionInitListener(this);
        getService().addSessionDestroyListener(this);
    }

    @Override
    public void sessionInit(SessionInitEvent sessionInitEvent) throws ServiceException {
        System.out.println("sessionInit: " + sessionInitEvent);
    }

    @Override
    public void sessionDestroy(SessionDestroyEvent sessionDestroyEvent) {
        System.out.println("sessionDestroy: " + sessionDestroyEvent);
    }
}
