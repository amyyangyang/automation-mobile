package testcases.driver;

import com.microsoft.appcenter.appium.Factory;
import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import org.junit.*;
import property.SetProperty;

import java.net.MalformedURLException;


public class SignInAsDriverTest extends SetProperty {

    @BeforeClass
    public static void setUp() throws InterruptedException, MalformedURLException {
//        setUpDriver();
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
    }

    @Test
    public void signInAsDriver() throws InterruptedException {
        signInPage.signIn(getTestData("driverEmail"), getTestData("driverPassword"));
        Thread.sleep(3000);
        Assert.assertTrue(availableLoadsAllPage.getTitle("My Loads").contains("My Loads"));
        Thread.sleep(3000);
    }

    @After
    public void logOut() throws InterruptedException {
        availableLoadsAllPage.clickMenuButtonFirstLevel("Account");
        availableLoadsAllPage.clickMenuButtonSecondLevel("Logout");
        availableLoadsAllPage.confirmLogout();
    }

}
