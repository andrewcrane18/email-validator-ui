package com.assignment3.email_validator_ui;
import javax.servlet.annotation.WebServlet;

import com.assignment3.email_validator_backend.Validator;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        final TextField email = new TextField();
        email.setCaption("Enter your email-address to check if it's valid!:");
    	Label valid = new Label("The email-address "+ email.getValue()+ " is valid! :)");
    	Label invalid = new Label("The email-address "+ email.getValue()+ " is not valid. :(");

        Button button = new Button("Check if valid");
        button.addClickListener( e -> {
        	valid.setValue("The email-address "+ email.getValue()+ " is valid! :)");
        	invalid.setValue("The email-address "+ email.getValue()+ " is not valid. :(");
            if(Validator.validate(email.getValue())==true){
            	valid.setVisible(true);
            	invalid.setVisible(false);
            }
            else{
            	valid.setVisible(false);
            	invalid.setVisible(true);
            }
        });
        
        layout.addComponents(email, button, valid, invalid);
    	valid.setVisible(false);
    	invalid.setVisible(false);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
