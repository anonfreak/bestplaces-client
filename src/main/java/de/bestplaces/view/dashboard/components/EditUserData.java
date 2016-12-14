package de.bestplaces.view.dashboard.components;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import de.bestplaces.controller.UserDataController;

import static de.bestplaces.MyUI.navigator;

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
    private Button saveChances;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        try {
            init();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public void init() throws UnirestException {

            labelEditUserData = new Label("Edit User Data");
            labelEditUserData.setStyleName("huge");

            addComponents(labelEditUserData, getFirstNameField(), getLastNameField(), getHometownField(), getEmailField(), getPasswordField(), getSaveChances());

            userDataController = new UserDataController(this);
            userDataController.getUserData();

            setSizeFull();
            setMargin(true);

        }

        public void navigateToTimeline()
        {
            navigator.navigateTo(Timeline.TIMELINE);
        }

    public TextField getFirstNameField() {
        if (firstNameField == null)
        {
            firstNameField = new TextField("First name");
            firstNameField.setRequired(true);
        }
        return firstNameField;
    }

    public TextField getLastNameField() {
        if (lastNameField == null)
        {
            lastNameField = new TextField("Last name");
            lastNameField.setRequired(true);
        }
        return lastNameField;
    }

    public TextField getHometownField() {
        if (hometownField == null)
        {
            hometownField = new TextField("Hometown");
        }
        return hometownField;
    }

    public TextField getEmailField() {
        if (emailField == null)
        {
            emailField = new TextField("Email");
        }
        return emailField;
    }

    public PasswordField getPasswordField() {
        if(passwordField == null)
        {
            passwordField = new PasswordField("Password");
            passwordField.setRequired(true);
        }
        return passwordField;
    }

    public Button getSaveChances() {
        if (saveChances == null)
        {

            saveChances = new Button("Save Changes");
            saveChances.addClickListener(new Button.ClickListener() {
                public void buttonClick(Button.ClickEvent event) {

                    try {
                        userDataController.editUserData();
                    } catch (UnirestException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        return saveChances;
    }
}
