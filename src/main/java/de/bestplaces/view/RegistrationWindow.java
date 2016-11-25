package de.bestplaces.view;


import com.vaadin.ui.*;
import de.bestplaces.model.User;

/**
 * Created by franz on 24.11.2016.
 */
public class RegistrationWindow extends Window {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String hometown;
    private Calendar createTime;
    protected FormLayout form;

    public RegistrationWindow()
    {
        super("Registration on BestPlaces"); // Set window caption
        center();
        init();
    }

    public void init()
    {
        setWidth("25%");
        setHeight("55%");

        form = new FormLayout();

        //TODO: Funktion: ueberpruefung, ob alle Felder wirklich gefuellt sind
        TextField firstNameField = new TextField("First name");
        firstNameField.setRequired(true);

        TextField lastNameField = new TextField("Last name");
        lastNameField.setRequired(true);

        TextField hometownField = new TextField("Hometown");
        hometownField.setRequired(true);

        TextField userNameField = new TextField("Username");
        userNameField.setRequired(true);

        PasswordField passwordField = new PasswordField("Password");
        passwordField.setRequired(true);

        PasswordField confirmPasswordField = new PasswordField("Confirm Password");
        confirmPasswordField.setRequired(true);

        Button register = new Button("Register");
        register.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                //TODO: wie hole ich daten aus textfeldern?
                checkPassword("passwort","passwort");
            }
        });
        form.addComponents(firstNameField, lastNameField, hometownField, userNameField, passwordField, confirmPasswordField, register);
        form.setSizeFull();
        form.setMargin(true);

        setContent(form);
    }

    //TODO: diese methoden in den Controller auslagern
    private void checkPassword(String password, String passwordConfirm)
    {
        //wenn richtig
        createUser(password);
        //sonst Fehlermeldung
    }

    private void createUser(String password)
    {
        User user = new User(username, firstName, lastName, email, password, hometown, createTime);
        writeInDatabase(user);
    }


    private void writeInDatabase(User user){
        // Daten in Datenbank schreiben --passende user daten holen
        //wenn erfolgreich öffne neues Fenster:
        getUI().addWindow(new Success());
        close();
    }

}
