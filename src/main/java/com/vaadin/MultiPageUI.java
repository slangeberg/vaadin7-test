package com.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.WrappedRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.view.CountView;
import com.vaadin.view.MainView;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class MultiPageUI extends UI {

    @Override
    protected void init(final WrappedRequest request) {

        // Create ViewDisplay, and set as UI content
        Navigator.SimpleViewDisplay display = new Navigator.SimpleViewDisplay();
        setContent(display);

        // Create Navigator, make it control the ViewDisplay
        Navigator navigator = new Navigator(Page.getCurrent(), display);

        // Add some Views
        navigator.addView(MainView.NAME, new MainView()); // no fragment

        // #count will be a new instance each time we navigate to it, counts:
        navigator.addView(CountView.NAME, new CountView() );

        // Navigate to view
        navigator.navigateTo(MainView.NAME);

//--> TODO: Should be able to do something similar, for multi-tab support
        //navigator.navigateTo(Page.getCurrent().getFragment());
    }
}
