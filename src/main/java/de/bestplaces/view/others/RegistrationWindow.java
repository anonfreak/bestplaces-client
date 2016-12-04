package de.bestplaces.view.others;


import com.vaadin.data.Validator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.*;
import de.bestplaces.controller.UserDataController;

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
    private PasswordField passwordField;
    private PasswordField confirmPasswordField;
    private Button registerButton;

    private UserDataController userDataController;

    public RegistrationWindow()
    {
        super("Registration on BestPlaces"); // Set window caption
        center();
        userDataController = new UserDataController(this);
        init();
    }

    public void init()
    {
        setWidth("25%");
        setHeight("55%");

        form = new FormLayout();

        //TODO: Funktion: ueberpruefung, ob alle Felder wirklich gefuellt sind und die daten übereinstimmen mit dem validator
        //TODO: https://vaadin.com/docs/-/part/framework/components/components-textfield.html#figure.components.textfield.textchangeevents
        //TODO: Handling errors https://vaadin.com/book/vaadin6/-/page/application.errors.html

        getConfirmPasswordField().addValidator(new MyValidator());
        getConfirmPasswordField().setImmediate(true);

        form.addComponents(getFirstNameField(), getLastNameField(), getHometownField(), getUserNameField(), getPasswordField(), getConfirmPasswordField(), getRegisterButton());
        form.setSizeFull();
        form.setMargin(true);


        setContent(form);
    }

    public void closeWindow()
    {
        getUI().addWindow(new Success());
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
            registerButton.addClickListener(new Button.ClickListener() {
                public void buttonClick(Button.ClickEvent event) {
                    //TODO: wie hole ich daten aus textfeldern?

                    userDataController.createUser();
                }
            });
        }
        return registerButton;
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
