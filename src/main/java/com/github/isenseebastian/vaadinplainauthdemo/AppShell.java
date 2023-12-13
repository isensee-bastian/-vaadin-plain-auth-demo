package com.github.isenseebastian.vaadinplainauthdemo;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;

@PWA(name = "Vaadin Auth Demo", shortName = "Vaadin Auth Demo")
@Theme("my-theme")
public class AppShell implements AppShellConfigurator {
}
