package testcases.dispatcher;

import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.xguest.SignInPage;
import com.nexttrucking.automation.mobile.xguest.WelcomePage;
import org.junit.*;
import property.SetProperty;
import java.net.MalformedURLException;


public class SignInAsDispatcherTest extends SetProperty {


    @BeforeClass
    public static void setUp() throws InterruptedException {
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        welcomePage.getWelcomePage();
    }

    @Before
    public void signIn() throws MalformedURLException, InterruptedException {
        signInPage.signIn(getTestData("ownerOperatorEmail"), getTestData("ownerOperatorPassword"));
        allowLocationPage.clickOkAllowLocationButton();
        allowLocationPage.clickAllowLocationButton();
    }

    @Test
    public void dispatcherSignIn() throws InterruptedException {
        Assert.assertTrue(availableLoadsAllPage.getTitle("All").contains("All"));
        Thread.sleep(7000);
    }

    @After
    public void logOut() throws InterruptedException {
        availableLoadsAllPage.clickMenuButtonFirstLevel("Account");
        availableLoadsAllPage.clickMenuButtonSecondLevel("Logout");
        availableLoadsAllPage.confirmLogout();
    }

}
