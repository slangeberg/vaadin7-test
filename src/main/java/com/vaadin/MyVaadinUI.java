package com.vaadin;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.server.WrappedRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

/**
 * The Application's "main" class
 */
@PreserveOnRefresh
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

    private static Integer staticCount = 0;

    public Integer localCount = 0;

    @Override
    protected void init(WrappedRequest request) {

        Button button = new Button("(preserve) LocalClick count");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                MyVaadinUI target = (MyVaadinUI)event.getButton().getUI();
                target.addUpdateLabel();
            }
        });
        addComponent(button);

        addUpdateLabel();
    }

    public void addUpdateLabel() {
        addComponent(
                new Label("local#: " + (localCount++)
                        + ", static#: " + (staticCount++)));
    }

}
