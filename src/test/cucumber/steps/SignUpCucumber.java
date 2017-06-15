package cucumber.steps;

import com.google.common.base.CaseFormat;
import cucumber.SeleniumTest;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SignUpCucumber {

    private SeleniumTest helper;

    @Before
    public void setUp() throws Exception {
        helper = new SeleniumTest();
        helper.setUp();
        helper.home();
    }

    @Given("^I am on the \"(.*?)\" page$")
    public void openBrowser(String arg1) {
        helper.navigateTo(arg1);
    }

    @Given("^I am signed up$")
    public void signUp() {

    }

    @Given("^I am logged in$")
    public void login() {
        helper.login();
    }

    @When("^I press the \"(.*?)\"-Button$")
    public void pressButton(String name){
        helper.clickButton(name);
    }

    @When("^I type \"(.*?)\" in (?:the )?\"(.*?)\"(?:-field)?$")
    public void type(String content, String button){
        helper.fillField(button, content);
    }

    @When("^I select \"(.*?)\"")
    public void select(String arg1){

    }

    @Then("^I navigate to (?:the )\"(.*?)\"")
    public void navigate(String page){
        helper.navigateTo(page);
    }

    @When("^I see \"(.*?)\"")
    @Then("^I can see \"(.*?)\"")
    public void checkElement(String element){
        helper.check(element);
    }

    @After
    public void destroy(){
        helper.tearDown();
    }

}