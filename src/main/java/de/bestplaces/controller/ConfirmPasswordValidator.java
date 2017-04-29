package de.bestplaces.controller;

import com.vaadin.data.Validator;

/**
 * Created by franz on 29.04.2017.
 */
public class ConfirmPasswordValidator implements Validator {

    boolean isValid;
    String password;

    public ConfirmPasswordValidator(String password) {
        this.password = password;
    }

    @Override
    public void validate(Object o) throws InvalidValueException {

        String confirmPassword = o.toString();
        if(confirmPassword.equals(password))
        {
            isValid = true;
        }else
        {
            isValid = false;
        }
    }


    public boolean isValid()
    {
        return isValid;
    }


}
