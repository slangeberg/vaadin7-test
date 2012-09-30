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

@SuppressWarnings("serial")
public class MultiClientUI extends UI {

    private static Set<Object> clients = new HashSet<Object>();
    private static Set<MultiClientUI> clientUpdateListeners = new HashSet<MultiClientUI>();

    String user;

    @Override
    protected void init(final WrappedRequest request) {

        String cookie = request.getHeader("Cookie");


//==> Assuming only one cookie, now!! (JSESSIONID)
        user = cookie.split("=")[1];

        final String _user = user;

        clients.add(new HashMap<String, String>(){{
            put("user", _user);
        }});


        clientUpdateListeners.add(this);

        System.out.println("clientUpdateListeners#: " + clientUpdateListeners.size() );

        // Notify listeners
        for( MultiClientUI clientUI : clientUpdateListeners ){
            clientUI.clientsUpdated();
        }
    }

    public void clientsUpdated(){
        render();
    }

    protected void render() {

        removeAllComponents();

        addComponent(
                new Label("Welcome: " + user ));
        addComponent(new Label("-----------------------------------"));
        addComponent(new Label("Currently " + clients.size() + " users online"));
    }

}
