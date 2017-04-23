package de.bestplaces.view.others;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.data.Validator;
import com.vaadin.data.validator.AbstractStringValidator;
import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Runo;
import de.bestplaces.controller.UserDataController;
import de.bestplaces.controller.UserNameValidator;
import de.bestplaces.model.User;
import javafx.scene.layout.Pane;

import java.util.*;

/**
 * Created by franz on 24.11.2016.
 */
public class RegistrationWindow extends Window {


    protected FormLayout form;
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField hometownField;
    private TextField userNameField;
    private TextField emailField;
    private PasswordField passwordField;
    private PasswordField confirmPasswordField;
    private UserDataController userDataController;
    private Button registerButton;



    public RegistrationWindow()
    {
        super("Registration on BestPlaces"); // Set window caption
        center();
        setSizeUndefined();
        userDataController = new UserDataController(this);
        init();
    }

    public void init()
    {
        Panel panel = new Panel();
        form = new FormLayout();

        //TODO: Funktion: ueberpruefung, ob alle Felder wirklich gefuellt sind und die daten übereinstimmen mit dem validator
        //TODO: https://vaadin.com/docs/-/part/framework/components/components-textfield.html#figure.components.textfield.textchangeevents
        //TODO: Handling errors https://vaadin.com/book/vaadin6/-/page/application.errors.html

        getConfirmPasswordField().addValidator(new MyValidator());
        getConfirmPasswordField().setImmediate(true);

        form.addComponents(getFirstNameField(), getLastNameField(), getHometownField(), getEmailField(),
                getUserNameField(), getPasswordField(), getConfirmPasswordField(), getRegisterButton());
        form.setSizeFull();
        form.setMargin(true);

        panel.setContent(form);
        panel.getContent().setSizeUndefined();

        setContent(panel);
    }

    public void closeWindow()
    {
        close();
    }


//    private void createUser(String password)
//    {
//        getUI().addWindow(new Success());
//        close();
//
//    }

    public TextField getFirstNameField() {
        if (firstNameField == null)
        {
        firstNameField = new TextField("First name");
        firstNameField.setRequired(true);
        firstNameField.focus();
        }
        return firstNameField;
    }

    public void setFirstNameField(TextField firstNameField) {
        this.firstNameField = firstNameField;
    }

    public TextField getLastNameField() {
    if (lastNameField == null)
    {
        lastNameField = new TextField("Last name");
        lastNameField.setRequired(true);
    }
        return lastNameField;
    }

    public void setLastNameField(TextField lastNameField) {
        this.lastNameField = lastNameField;
    }

    public TextField getHometownField() {
        if (hometownField == null)
        {
            hometownField = new TextField("Hometown");
        }
        return hometownField;
    }

    public void setHometownField(TextField hometownField) {
        this.hometownField = hometownField;
    }

    public TextField getUserNameField() {
        if (userNameField == null)
        {
            userNameField = new TextField("Username");
            userNameField.setRequired(true);

            UserNameValidator validator = new UserNameValidator();
            userNameField.addValidator(validator);
            userNameField.setImmediate(true);
            validator.validate(userNameField.getValue());
        }
        return userNameField;
    }

    public void setUserNameField(TextField userNameField) {
        this.userNameField = userNameField;
    }

    public PasswordField getPasswordField() {
        if (passwordField == null)
        {
            passwordField = new PasswordField("Password");
            passwordField.setRequired(true);
        }
        return passwordField;
    }

    public void setPasswordField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public PasswordField getConfirmPasswordField() {
        if (confirmPasswordField == null)
        {
            confirmPasswordField = new PasswordField("Confirm Password");
            confirmPasswordField.setRequired(true);

        }
        return confirmPasswordField;
    }

    public void setConfirmPasswordField(PasswordField confirmPasswordField) {
        this.confirmPasswordField = confirmPasswordField;
    }

    public Button getRegisterButton() {
        if (registerButton == null)
        {
            registerButton = new Button("Register");
            registerButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);
            registerButton.addClickListener(new Button.ClickListener() {
                public void buttonClick(Button.ClickEvent event) {

                    try {
                        userDataController.createUser();
                    } catch (UnirestException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        return registerButton;
    }

    public TextField getEmailField() {
        if (emailField == null)
        {
            emailField = new TextField("Email");
        }
        return emailField;
    }

    public void setRegisterButton(Button registerButton) {
        this.registerButton = registerButton;
    }

    class MyValidator implements Validator {
        @Override
        public void validate(Object value)
                throws InvalidValueException {
            if ( ((String)value).equals((String) getPasswordField().getData()))
            {
                throw new InvalidValueException("Password is not the same");
            }
        }
    }
}
