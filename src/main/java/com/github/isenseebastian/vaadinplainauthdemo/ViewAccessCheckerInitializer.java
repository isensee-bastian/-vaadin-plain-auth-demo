package com.github.isenseebastian.vaadinplainauthdemo;

import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.flow.server.auth.ViewAccessChecker;

// This class has been copied and adapted from: https://vaadin.com/docs/latest/security/advanced-topics/securing-plain-java-app
public class ViewAccessCheckerInitializer implements VaadinServiceInitListener {

    private ViewAccessChecker viewAccessChecker;

    public ViewAccessCheckerInitializer() {
        viewAccessChecker = new ViewAccessChecker();
        viewAccessChecker.setLoginView(LoginView.class);
    }

    @Override
    public void serviceInit(ServiceInitEvent serviceInitEvent) {
        serviceInitEvent.getSource().addUIInitListener(uiInitEvent ->
                uiInitEvent.getUI().addBeforeEnterListener(viewAccessChecker));
    }
}
