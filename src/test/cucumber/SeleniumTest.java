package cucumber;

        import static org.junit.Assert.assertTrue;

        import java.util.concurrent.TimeUnit;

        import com.google.common.base.Function;
        import org.apache.commons.lang3.StringUtils;
        import org.apache.commons.lang3.text.WordUtils;
        import org.eclipse.jetty.util.Jetty;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Capabilities;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.remote.RemoteWebDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class SeleniumTest {

    private WebDriver driver;
    private WebDriverWait waiter;
    private String baseUrl, browserName, browserVersion;

    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kolbm\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://localhost:8080/";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        browserName = caps.getBrowserName();
        browserVersion = caps.getVersion();
        System.out.println("Running on " + browserName + " on version " + browserVersion);
        waiter = new WebDriverWait(driver, 10);
    }

    public void navigateTo(String page){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().to("http://localhost:8080//#!" + page.replaceAll(" ", ""));
    }

    public void tearDown() {
        driver.quit();
    }

    public void checkbox() {
        driver.findElement(By.id("checkbox")).click();
    }

    public void onPage(String string) {
        assertTrue(driver.getCurrentUrl().contains(string));
    }

    public void notloggedin() {
        onPage("login");
        onPage("register");
    }


    public boolean check(String element){
        return driver.findElements(By.id(toCamelCase(element))).size()>0;
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

    public void goToPage(String string) {
        driver.get(baseUrl+"/#!" + string);
    }

    public void fillField(String fieldName, String content){
        WebElement el = driver.findElement(By.id(toCamelCase(fieldName)+"Field"));
        el.clear();
        el.sendKeys(content);
    }

    public void login(){
        goToPage("Welcome");
        clickButton("login");
        fillField("userName", "test");
        fillField("password", "test");
        clickButton("loginWindow");
    }

    public void clickButton(String buttonName) {
        driver.findElement(By.id(toCamelCase(buttonName)+"Button")).click();
    }

    private String toCamelCase(String input){
        input = StringUtils.capitalize(input);
        input = StringUtils.remove(input, " ");
        return input.substring(0,1).toLowerCase() + input.substring(1);
    }

    public void home(){
        driver.navigate().to(baseUrl);
    }

    public boolean checkTextInField(String content, String elementId) {
        WebElement element = driver.findElement(By.id(toCamelCase(elementId)+"Field"));
        return element.getText()==content;
    }
}
