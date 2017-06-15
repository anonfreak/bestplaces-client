package cucumber;

import org.openqa.selenium.WebDriver;

/**
 * Created by kolbm on 15.06.2017.
 */
public class PageObject {
    protected SeleniumTest helper;
    private String pagename;

    public PageObject(SeleniumTest helper, String pagename){
        this.helper = helper;
        this.pagename = pagename;
    }

    public void isOnPage(){
        helper.onPage(pagename);
    }
}
