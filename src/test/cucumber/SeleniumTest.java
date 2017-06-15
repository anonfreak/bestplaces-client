package cucumber;

        import static org.junit.Assert.assertTrue;

        import java.util.concurrent.TimeUnit;

        import org.openqa.selenium.By;
        import org.openqa.selenium.Capabilities;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class SeleniumTest {

    private WebDriver driver;
    private String baseUrl, browserName, browserVersion;

    public void setUp() throws Exception {

        driver = new FirefoxDriver();
        baseUrl = "http://socialfunnel.it.dh-karlsruhe.de:8080/SocialFunnel";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        browserName = caps.getBrowserName();
        browserVersion = caps.getVersion();
        System.out.println("Running on " + browserName + " on version " + browserVersion);
    }

    public void tearDown() {
        driver.quit();
    }

    public void goToHomePage() {
        driver.get(baseUrl);
    }

    public void clickRegister() {
        driver.findElement(By.id("btnRegistrieren")).click();
    }
    public void enterpassword() {
        driver.findElement(By.id("txtPassword")).sendKeys("test123");
    }

    public void enterpassword2() {
        driver.findElement(By.id("txtPassword2")).sendKeys("test123");
    }

    public void checkbox() {
        driver.findElement(By.id("checkbox")).click();
    }

    public void onPage(String string) {
        assertTrue(driver.getCurrentUrl().contains(string));
    }

    public void errorMessage() {
//		assertTrue(driver.findElement(By.linkText("Passwords do not match!")) != null);
    }

    public void notloggedin() {
        onPage("login");
        onPage("register");
    }

    public void chooseNetwork() {
        driver.findElement(By.id("listNetwork")).click();
    }

    public void titleAsExpected() {
        assertTrue(driver.getTitle().equalsIgnoreCase("SocialFunnel"));

    }

    public void networkListCheck() {
        assertTrue(driver.findElement(By.className("v-slot")) != null);
    }

    public void clickButton(String button) {
        driver.findElement(By.id("btn"+button)).click();
    }

    public void enterInto(String entry, String field) {
        driver.findElement(By.id("txt"+field)).sendKeys(entry);
    }

    public void checkpage(String arg1) {
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getCurrentUrl().endsWith(arg1)+ " " + arg1);
        assertTrue(driver.getCurrentUrl().contains(arg1));
    }

    public void loginstatus(boolean b) {
        // TODO Auto-generated method stub
        // testen ob eingeloggt
    }

    public void messageReceived(String message) {
        // TODO Auto-generated method stub
        // kann der nachricht keine id zuweisen
    }

    public void login() {
        driver.findElement(By.id("txtEmail")).sendKeys("dbetsche@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("daniel");
        driver.findElement(By.id("btnLogin")).click();
    }

    public void goToPage(String string) {
        driver.get(baseUrl+"/#!" + string);
    }
}
