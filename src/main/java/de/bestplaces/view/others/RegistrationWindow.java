package de.bestplaces.view.others;


import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.data.Validator;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.event.FieldEvents;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.UserError;
import com.vaadin.ui.*;
import de.bestplaces.controller.ConfirmPasswordValidator;
import de.bestplaces.controller.UserDataController;
import de.bestplaces.controller.UserNameValidator;

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

            validateRequiredField(firstNameField, "Give first Name");
        }
        return firstNameField;
    }

    private void validateRequiredField(TextField textField, String errorMessage) {
        textField.setRequiredError(errorMessage);
        textField.setImmediate(true);
        textField.setValidationVisible(true);
        textField.addValidator(new StringLengthValidator("Must have at least 4 characters", 4, 100, false));
    }

    public void setFirstNameField(TextField firstNameField) {
        this.firstNameField = firstNameField;
    }

    public TextField getLastNameField() {
    if (lastNameField == null)
    {
        lastNameField = new TextField("Last name");
        lastNameField.setRequired(true);
        validateRequiredField(lastNameField, "Give last Name");
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

            validateRequiredField(userNameField, "Give a user name");
        }

        userNameField.addBlurListener(new FieldEvents.BlurListener() {
            private static final long serialVersionUID = 7055180877355044203L;

            public void blur(FieldEvents.BlurEvent event) {
                boolean usernameFree;
                if((userNameField.getValue()).length() == 0 || userNameField.getValue() == null)
                {
                    return;
                }
                else
                {
                    UserNameValidator validator = new UserNameValidator();
                    userNameField.addValidator(validator);
                    validator.validate(userNameField.getValue());
                    usernameFree = validator.isValid();
                    userNameField.removeAllValidators();

                }

                if(!usernameFree)
                {
                    userNameField.setComponentError(new UserError("Username is already in use"));
                }
                else
                {
                    userNameField.setComponentError(null);
                }
            }
        });

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

            validateRequiredPasswordField(passwordField, "Give a password");
        }
        return passwordField;
    }

    public void setPasswordField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }

    private void validateRequiredPasswordField(PasswordField passwordField, String errorMessage) {
        passwordField.setRequiredError(errorMessage);
        passwordField.setImmediate(true);
        passwordField.setValidationVisible(true);
        passwordField.addValidator(new StringLengthValidator("Must have 4 characters", 4, 100, false));
    }

    public PasswordField getConfirmPasswordField() {
        if (confirmPasswordField == null)
        {
            confirmPasswordField = new PasswordField("Confirm Password");
            confirmPasswordField.setRequired(true);

            validateRequiredPasswordField(confirmPasswordField, "Confirm Password");

            confirmPasswordField.addBlurListener(new FieldEvents.BlurListener() {
                @Override
                public void blur(FieldEvents.BlurEvent blurEvent) {
                    ConfirmPasswordValidator confirmPasswordValidator = new ConfirmPasswordValidator(passwordField.getValue());
                    confirmPasswordValidator.validate(confirmPasswordField.getValue());
                    if(confirmPasswordValidator.isValid())
                    {
                        confirmPasswordField.setComponentError(null);
                    }else
                    {
                        confirmPasswordField.setComponentError(new UserError("Passwords doesn't match"));
                    }
                }
            });
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
            emailField.addValidator(new EmailValidator("This is not a valid email address"));
        }
        return emailField;
    }

    public void setRegisterButton(Button registerButton) {
        this.registerButton = registerButton;
    }


}
