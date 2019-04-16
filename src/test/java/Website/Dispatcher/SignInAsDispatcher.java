package Website.Dispatcher;

import WebSite.Dispatcher.AvailableLoadsPage;
import WebSite.xGuest.SignInAsDispatcherPage;
import zProperty.SetProperty;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SignInAsDispatcher extends SetProperty {


    @Before
    public void setUp() {
        setUpWebDriver("Chrome");
        availableLoadsPage = new AvailableLoadsPage(driver);
        signInAsDispatcherPage = new SignInAsDispatcherPage(driver);
    }


    @Test
    public void dispatcherSignIn(){
        driver.get(getTestData("defaultURLs") + "/signin/dispatcher");
        signInAsDispatcherPage.typeEmail(getTestData("dispatcherEmail"));
        signInAsDispatcherPage.typePassword(getTestData("dispatcherPassword"));
        signInAsDispatcherPage.clickSignIn();

        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
        Assert.assertEquals("Available Loads", availableLoadsPage.getTitle());
    }
}
