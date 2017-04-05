package cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class signup {

    private WebDriver browser = new FirefoxDriver();

    @Given("I am on the \"Welcome Page\" of BestPlaces$")
    public void openBrowser() {
        browser.navigate().to("http://mathtap.de:8080/bestplaces/#!Welcome");
    }

    @When("^I press the button \"Register now\"$")
    public void pressTheButtonRegisterNow() {
        browser.findElement(By.name("registerButton")).click();
    }

    @And("^I see the \"registration\" form$")
    public void showRegistrationForm()
    {
        browser.findElements(By.className("RegistrationWindow"));
    }

    @And("^I enter \"Maximilian\" in the input field \"first name\"$")
    public void enterFirstName()
    {
        // Hier weiß ich nicht wie ich an das Textfeld ran komme
        java.util.List<WebElement> registrationWindow = browser.findElements(By.className("RegistrationWindow"));
    }

    @And("^I enter \"Mustermann\" in the input field \"last name\"$")
    public void enterLastName()
    {

    }
    @And("^I enter \"Karlsruhe\" in the input field \"hometown\"$")
    public void enterHometown()
    {

    }
    @And("^I enter \"Max\" in the input field \"username\"$")
    public void enterUsername()
    {

    }
    @And("^I enter \"1234\" in the input field \"password\"$")
    public void enterPassword()
    {

    }
    @And("^I enter \"1234\" in the input field \"cornfirm password\"$")
    public void enterConfirmPassword()
    {

    }

    @And("^I click on the button \"Register\"$")
    public void clickButtonRegistration()
    {

    }



    @Then("^I should see the \"Succes Message\"$")
    public void showSuccesMessage() {

    }
}