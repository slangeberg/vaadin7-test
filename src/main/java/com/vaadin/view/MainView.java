package com.vaadin.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;

public class MainView extends Panel implements View {

    public static final String NAME = "";

    public MainView() {

        Link lnk = new Link("Count", new ExternalResource( "#!" + CountView.NAME));
        addComponent(lnk);

    }

    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

}