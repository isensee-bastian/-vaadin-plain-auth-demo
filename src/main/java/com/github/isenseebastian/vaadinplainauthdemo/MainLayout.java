package com.github.isenseebastian.vaadinplainauthdemo;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

// This class has been copied and adapted from: https://vaadin.com/docs/latest/security/advanced-topics/securing-plain-java-app
public class MainLayout extends AppLayout {

    public MainLayout() {
        H1 logo = new H1("Vaadin Auth Demo");
        logo.addClassName("logo");

        HorizontalLayout header;
        if (AuthUtils.isAuthenticated()) {
            Button logout = new Button("Logout", click -> AuthUtils.logout());
            header = new HorizontalLayout(logo, logout);
        } else {
            header = new HorizontalLayout(logo);
        }

        addToNavbar(header);
    }
}
