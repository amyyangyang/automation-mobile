package Website.xGuest;

import WebSite.xGuest.HomeWebPage;
import WebSite.xGuest.SignInAsDispatcherPage;
import WebSite.xGuest.SignInAsOwnerOperatorPage;
import WebSite.xGuest.SignInAsShipperPage;
import WebSite.xGuest.SignInPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import zProperty.SetProperty;


public class SignInErrorMassages extends SetProperty {

    @Before
    public void setUp() {
        setUpWebDriver("Chrome");
        signInPage = new SignInPage(driver);
        homeWebPage = new HomeWebPage(driver);
        signInAsDispatcherPage = new SignInAsDispatcherPage(driver);
        signInAsShipperPage = new SignInAsShipperPage(driver);
        signInAsOwnerOperatorPage = new SignInAsOwnerOperatorPage(driver);
    }

    @Test
    public void getSignInPage(){
        driver.get(getTestData("defaultURLsGuest"));
        homeWebPage.clickSingInButton();
        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
        Assert.assertEquals("Sign in", signInPage.getTitle());
    }

// for SignIn as Dispatcher page

    @Test
    public void getSignInAsDispatcherPage(){
        driver.get(getTestData("defaultURLs") + "/signin");
        signInPage.clickDispatcherButton();
        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
        Assert.assertEquals("Fleet Dispatchers", signInAsDispatcherPage.getTitle());
    }

    @Test
    public void invalidEmailErrorAsDispatcher(){
        driver.get(getTestData("defaultURLs") + "/signin/dispatcher");
        signInAsDispatcherPage.typeEmail(getTestData("invalidEmail"));
        Assert.assertEquals("Your email is invalid.", signInAsDispatcherPage.gerErrorByText(" Your email is invalid. ").getText());
        Assert.assertTrue(signInAsDispatcherPage.isSignInButtonDisable());
    }

    @Test
    public void invalidPasswordErrorAsDispatcher(){
        driver.get(getTestData("defaultURLs") + "/signin/dispatcher");
        signInAsDispatcherPage.typePassword(getTestData("shortPassword"));
        Assert.assertEquals("Your password is invalid.", signInAsDispatcherPage.gerErrorByText(" Your password is invalid. ").getText());
        Assert.assertTrue(signInAsDispatcherPage.isSignInButtonDisable());
    }

// for SignIn as Owner-Operator page

    @Test
    public void getSignInAsOwnerOperatorPage(){
        driver.get(getTestData("defaultURLs") + "/signin");
        signInPage.clickOwnerOperatorButton();
        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
        Assert.assertEquals("Owner Operator", signInAsOwnerOperatorPage.getTitle());
    }

    @Test
    public void invalidEmailErrorAsOwnerOperator(){
        driver.get(getTestData("defaultURLs") + "/signin/owneroperator");
        signInAsOwnerOperatorPage.typeEmail(getTestData("invalidEmail"));
        Assert.assertEquals("Your email is invalid.", signInAsOwnerOperatorPage.gerErrorByText(" Your email is invalid. ").getText());
        Assert.assertTrue(signInAsOwnerOperatorPage.isSignInButtonDisable());
    }

    @Test
    public void invalidPasswordErrorAsOwnerOperator(){
        driver.get(getTestData("defaultURLs") + "/signin/owneroperator");
        signInAsOwnerOperatorPage.typePassword(getTestData("shortPassword"));
        Assert.assertEquals("Your password is invalid.", signInAsOwnerOperatorPage.gerErrorByText(" Your password is invalid. ").getText());
        Assert.assertTrue(signInAsOwnerOperatorPage.isSignInButtonDisable());
    }

// for SignIn as Shipper page

    @Test
    public void getSignInAsShipperPage(){
        driver.get(getTestData("defaultURLs") + "/signin");
        signInPage.clickShipperButton();
        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
        Assert.assertEquals("Shipper", signInAsShipperPage.getTitle());
    }

    @Test
    public void invalidEmailErrorAsShipper(){
        driver.get(getTestData("defaultURLs") + "/signin/shipper");
        signInAsShipperPage.typeEmail(getTestData("invalidEmail"));
        Assert.assertEquals("Your email is invalid.", signInAsShipperPage.gerErrorByText(" Your email is invalid. ").getText());
        Assert.assertTrue(signInAsShipperPage.isSignInButtonDisable());
    }



//    BUG!!! Status - In Progress

//    @Test
//    public void invalidPasswordErrorAsShipper(){
//        driver.get("https://devxa2web01.dev.aws.nexttrucking.com/signin/shipper");
//        signInAsShipperPage.typePassword("111");
//        Assert.assertEquals("Your password is invalid.", signInAsShipperPage.gerErrorByText(" Your password is invalid. ").getText());
//        Assert.assertTrue(signInAsShipperPage.isSignInButtonDisable());
//    }

}
