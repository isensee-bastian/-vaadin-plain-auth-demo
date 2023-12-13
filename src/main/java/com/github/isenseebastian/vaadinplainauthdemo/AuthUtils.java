package com.github.isenseebastian.vaadinplainauthdemo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;
import com.vaadin.flow.server.VaadinSession;

// This class has been copied and adapted from: https://vaadin.com/docs/latest/security/advanced-topics/securing-plain-java-app
public class AuthUtils {

    private static final String LOGOUT_SUCCESS_URL = "/login";

    public static boolean isAuthenticated() {
        VaadinServletRequest request = VaadinServletRequest.getCurrent();
        return request != null && request.getUserPrincipal() != null;
    }

    public static boolean authenticate(String username, String password) {
        VaadinServletRequest request = VaadinServletRequest.getCurrent();
        if (request == null) {
            // This is in a background thread and we can't access the request to
            // log in the user
            return false;
        }
        try {
            request.login(username, password);

            // change session ID to protect against session fixation
            request.getHttpServletRequest().changeSessionId();

            return true;
        } catch (Exception e) {
            // login exception handle code omitted
            return false;
        }
    }

    public static void logout() {
        VaadinSession.getCurrent().getSession().invalidate();
        UI.getCurrent().getPage().setLocation(LOGOUT_SUCCESS_URL);
    }
}
