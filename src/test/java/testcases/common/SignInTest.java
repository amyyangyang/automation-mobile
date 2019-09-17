package testcases.common;

import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import org.junit.*;
import property.SetProperty;

import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;


public class SignInTest extends SetProperty {


    @BeforeClass
    public static void setUp() throws MalformedURLException {
        setUpDriver();
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
    }


    @Test
    public void signInAsDispatcher() throws InterruptedException, ParserConfigurationException {
        signInPage.signIn(getTestData("dispatcherEmail"), getTestData("dispatcherPassword"));
        Thread.sleep(3000);
        Assert.assertTrue(availableLoadsAllPage.getTitle("Available").contains("Available"));
        Thread.sleep(3000);
    }


    @Test
    public void signInAsDriver() throws InterruptedException, ParserConfigurationException {
        signInPage.signIn(getTestData("driverEmail"), getTestData("driverPassword"));
        Thread.sleep(3000);
        Assert.assertTrue(availableLoadsAllPage.getTitle("My Loads").contains("My Loads"));
        Thread.sleep(3000);
    }


    @Test
    public void signInAsOwnerOperator() throws InterruptedException, ParserConfigurationException {
        signInPage.signIn(getTestData("ownerOperatorEmail"), getTestData("ownerOperatorPassword"));
        Thread.sleep(3000);
        Assert.assertTrue(availableLoadsAllPage.getTitle("Available").contains("Available"));
        Thread.sleep(3000);
    }


    @After
    public void logOut() throws InterruptedException {
        availableLoadsAllPage.clickMenuButtonFirstLevel("Account");
        availableLoadsAllPage.clickMenuButtonSecondLevel("Logout");
        availableLoadsAllPage.confirmLogout();
    }

}
