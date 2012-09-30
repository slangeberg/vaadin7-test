package com.vaadin;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.server.WrappedRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * The Application's "main" class
 */
@PreserveOnRefresh
@SuppressWarnings("serial")
public class MultiClientUI extends UI {

    private static Set<Object> clients = new HashSet<Object>();

    @Override
    protected void init(final WrappedRequest request) {
        String cookie = request.getHeader("Cookie");

//==> Assuming only one cookie, now!! (JSESSIONID)
        final String user = cookie.split("=")[1];
        clients.add(new HashMap<String, String>(){{
            put("user", user);
        }});
        addComponent(
           new Label("Welcome: " + user ));
        addComponent(new Label("-----------------------------------"));
        addComponent(new Label("Currently " + clients.size() + " users online"));
    }

}
