# Vaadin Auth Demo Using Plain Java and Tomcat


## General Overview

This small demo project is based on the official [Vaadin documentation about plain Java authentication](https://vaadin.com/docs/latest/security/advanced-topics/securing-plain-java-app).
It uses plain Java 17 plus Vaadin 23 and is intended for deployment to a servlet container like Apache Tomcat.
No additional frameworks are used to provide authentication.


## Features

* Login view
* Authentication based on Vaadin mechanisms and a servlet based realm for fetching credentials
* Logout button


## How to Run

* Prerequisites: Java 17, Tomcat 10 (or another servlet container), Maven (Maven wrapper is included and can be used, see `mvnw` in project directory)
* Build the application with Maven, e.g.: `mvn clean package`
* Deploy the built war file to your Tomcat installation
* Configure test users in a realm, for Tomcat see the [realm documentation](https://tomcat.apache.org/tomcat-10.0-doc/realm-howto.html#Configuring_a_Realm)
* Start tomcat, the application will start on port 8080 by default, unless configured differently in Tomcat. Check the configured application context if you cannot see the application.

As an example for testing, I added following test users in `conf/tomcat-users.xml` inside the `<tomcat-user>` tag:
```
    <!-- Test users added, DO NOT use this for real production services.  -->
    <user username="admin" password="admin" roles="ADMIN"/>
    <user username="user" password="user" roles="USER"/>
```
DO NOT use these for real production services. This is just a simple example for local testing with dummy users.


## Known Issues

### Logout:  Cannot invoke "com.vaadin.flow.component.UI.getPage()"

When pressing the logout button, logout works as expected and the user is redirect to the login view.
However, an exception is thrown by Vaadin:
```
[http-nio-8080-exec-2] ERROR com.vaadin.flow.server.DefaultErrorHandler - 
java.lang.NullPointerException: Cannot invoke "com.vaadin.flow.component.UI.getPage()" because the return value of "com.vaadin.flow.component.UI.getCurrent()" is null
	at com.github.isenseebastian.vaadinplainauthdemo.AuthUtils.logout(AuthUtils.java:39)
	at com.github.isenseebastian.vaadinplainauthdemo.MainLayout.lambda$new$c89cdfec$1(MainLayout.java:17)
	at com.vaadin.flow.component.ComponentEventBus.fireEventForListener(ComponentEventBus.java:239)
	at com.vaadin.flow.component.ComponentEventBus.handleDomEvent(ComponentEventBus.java:488)
	...
```

It seems like this is a bug that is still present in version 23. A similar issue has been fixed previously, possibly for a different version, see [GitHub Issue 12807](https://github.com/vaadin/flow/issues/12807).
The issue was reproduced with both Chrome and Firefox.
