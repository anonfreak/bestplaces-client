package de.bestplaces.view.dashboard.components;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import static de.bestplaces.MyUI.navigator;

/**
 * Created by franz on 25.11.2016.
 */
public class EditUserData extends FormLayout implements View {

    public static final String EDITUSERDATA = "Edit User Data";


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        init();
    }

    public void init(){

        //TODO: Controller echte Daten holen
        Label labelEditUserData = new Label("Edit User Data");
        labelEditUserData.setStyleName("huge");

        TextField firstNameField = new TextField("First name");
        firstNameField.setRequired(true);
        //hier über den Controller auf die Nutzerdaten zugreifen
        firstNameField.setInputPrompt("Franziska");


        TextField lastNameField = new TextField("Last name");
        lastNameField.setRequired(true);
        lastNameField.setInputPrompt("Neumann");

        TextField hometownField = new TextField("Hometown");
        hometownField.setRequired(true);
        hometownField.setInputPrompt("Karlsruhe");

        TextField userNameField = new TextField("Username");
        userNameField.setRequired(true);
        userNameField.setInputPrompt("IskaNeumann");

        PasswordField passwordField = new PasswordField("Password");
        passwordField.setRequired(true);
        passwordField.setInputPrompt("1234");

        Button saveChances = new Button("Save Changes");
        saveChances.addClickListener(clickEvent -> save());

        addComponents(labelEditUserData, firstNameField, lastNameField, hometownField, userNameField, passwordField, saveChances);
        setSizeFull();
        setMargin(true);

        }

        public void save()
        {   navigator.navigateTo(Timeline.TIMELINE);
            //Funktioniert nicht
//            UserDataController.saveData();
            Notification.show("Changes successfully saved");
        }
}
