package com.github.isenseebastian.vaadinplainauthdemo;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@Route(value = "", layout = MainLayout.class)
@PermitAll
public class MainView extends VerticalLayout {

    public MainView() {
        var title = new H1("Welcome");
        title.setId("h1-title");

        add(title);
        addClassName("centered-content");
    }

}
