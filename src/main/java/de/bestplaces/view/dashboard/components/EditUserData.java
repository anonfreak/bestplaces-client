package de.bestplaces.view.dashboard.components;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.event.FieldEvents;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.UserError;
import com.vaadin.ui.*;
import de.bestplaces.controller.ConfirmPasswordValidator;
import de.bestplaces.controller.NavigatorController;
import de.bestplaces.controller.UserDataController;
import de.bestplaces.model.Pages;
import de.bestplaces.model.User;

/**
 * Created by franz on 25.11.2016.
 */
public class EditUserData extends FormLayout implements View {

    public static final String EDITUSERDATA = "Edit User Data";
    private UserDataController userDataController;
    private Label labelEditUserData;
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField hometownField;
    private TextField emailField;
    private PasswordField passwordField;
    private PasswordField newPasswordField;
    private PasswordField newPasswordConfirmField;

    private NavigatorController navigatorController;

    private Button saveChances;


    public EditUserData(NavigatorController controller){
        navigatorController = controller;
        userDataController = navigatorController.getUserDataController();

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        try {
            init();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public void init() throws UnirestException {

            addComponents(getLable(), getFirstNameField(), getLastNameField(), getHometownField(), getEmailField(),
                    getPasswordField(), getNewPasswordField(), getNewPasswordConfirmField(), getSaveChances());

            User aktuellerUser = userDataController.getUserData();

            getFirstNameField().setValue(aktuellerUser.getFirstName());
            getLastNameField().setValue(aktuellerUser.getLastName());
            getHometownField().setValue(aktuellerUser.getHometown());
            getEmailField().setValue(aktuellerUser.getEmail());

            setSizeFull();
            setMargin(true);

        }

    private Label getLable() {
        if(labelEditUserData==null)
        {
            labelEditUserData = new Label("Edit User Data");
            labelEditUserData.setStyleName("huge");
        }

        return labelEditUserData;
    }

    public void navigateToTimeline()
        {
            navigatorController.switchToView(Pages.TIMELINE);
        }

    private void validateRequiredField(TextField textField, String errorMessage) {
        textField.setRequiredError(errorMessage);
        textField.setImmediate(true);
        textField.setValidationVisible(true);
        textField.addValidator(new StringLengthValidator("Must have at least 4 characters", 4, 100, false));
    }

    public TextField getFirstNameField() {
        if (firstNameField == null)
        {
            firstNameField = new TextField("First name");
            firstNameField.setRequired(true);
            validateRequiredField(firstNameField, "Give first Name");
        }
        return firstNameField;
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

    public TextField getHometownField() {
        if (hometownField == null)
        {
            hometownField = new TextField("Hometown");
            hometownField.setId("hometownField");
        }
        return hometownField;
    }

    public TextField getEmailField() {
        if (emailField == null)
        {
            emailField = new TextField("Email");
            emailField.addValidator(new EmailValidator("This is not a valid email address"));
        }
        return emailField;
    }

    private void validateRequiredPasswordField(PasswordField passwordField, String errorMessage) {
        passwordField.setRequiredError(errorMessage);
        passwordField.setImmediate(true);
        passwordField.setValidationVisible(true);
        passwordField.addValidator(new StringLengthValidator("Must have 4 characters", 4, 100, false));
    }

    public PasswordField getPasswordField() {
        if(passwordField == null)
        {
            passwordField = new PasswordField("old Password");
            passwordField.setRequired(true);
            validateRequiredPasswordField(passwordField, "Password is required");

        }
        return passwordField;
    }

    public PasswordField getNewPasswordField() {
        if(newPasswordField == null)
        {
            newPasswordField = new PasswordField("new Password");
            newPasswordField.addBlurListener(new FieldEvents.BlurListener() {
                @Override
                public void blur(FieldEvents.BlurEvent blurEvent) {

                    newPasswordConfirmField.setRequired(true);
                    validateRequiredPasswordField(newPasswordConfirmField, "Confirm Password is required");
                }
            });

        }
        return newPasswordField;
    }

    public PasswordField getNewPasswordConfirmField() {
        if(newPasswordConfirmField == null)
        {
            newPasswordConfirmField = new PasswordField("Cornfirm new Password");

            newPasswordConfirmField.addBlurListener(new FieldEvents.BlurListener() {
                @Override
                public void blur(FieldEvents.BlurEvent blurEvent) {
                    ConfirmPasswordValidator confirmPasswordValidator = new ConfirmPasswordValidator(newPasswordField.getValue());
                    confirmPasswordValidator.validate(newPasswordConfirmField.getValue());
                    if(confirmPasswordValidator.isValid())
                    {
                        newPasswordConfirmField.setComponentError(null);
                    }else
                    {
                        newPasswordConfirmField.setComponentError(new UserError("Passwords doesn't match"));
                    }
                    newPasswordConfirmField.removeValidator(confirmPasswordValidator);
                }
            });
        }
        return newPasswordConfirmField;
    }

    public Button getSaveChances() {
        if (saveChances == null)
        {

            saveChances = new Button("Save Changes");
            saveChances.setId("saveButton");
            saveChances.addClickListener(new Button.ClickListener() {
                public void buttonClick(Button.ClickEvent event) {

                    try {
                        String password;
                        if(getNewPasswordConfirmField().getValue() == null || getNewPasswordConfirmField().getValue().length() ==0)
                        {
                            password = getPasswordField().getValue();
                        }
                        else
                        {
                            password = getNewPasswordConfirmField().getValue();
                        }
                        boolean changeSuccessfull = userDataController.editUserData(getFirstNameField().getValue(), getLastNameField().getValue(),
                                getHometownField().getValue(), getEmailField().getValue(), password);

                        if(changeSuccessfull)
                        {
                            Notification.show("Changes successfully saved");
                        } else
                        {
                            Notification.show("Error");
                        }

                    } catch (UnirestException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        return saveChances;
    }
}
