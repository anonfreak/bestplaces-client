package cucumber.components;

import cucumber.PageObject;
import cucumber.SeleniumTest;

/**
 * Created by kolbm on 15.06.2017.
 */
public class Welcome extends PageObject {

    public Welcome(SeleniumTest helper) {
        super(helper, "Welcome");
    }

    public void openLogin(){
        helper.clickButton("login");
    }

    public void openRegister(){
        helper.clickButton("register");
    }
}
