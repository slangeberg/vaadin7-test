package com.vaadin.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;

public class CountView extends Panel implements View {
    public static final String NAME = "count";

    private static int count = 1;

    public CountView() {
        addComponent(new Label("Created: " + count++));

        Link lnk = new Link("Main", new ExternalResource( "#!" + MainView.NAME));
        addComponent(lnk);
    }

    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

}
