package testcases.dispatcher;

import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import org.junit.*;

import property.SetProperty;
import java.net.MalformedURLException;


public class SignInAsDispatcherTest extends SetProperty {

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        setUpDriver();
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
    }

    @Before
    public void signIn() throws MalformedURLException, InterruptedException {
        signInPage.signIn(getTestData("ownerOperatorEmail"), getTestData("ownerOperatorPassword"));
    }

    @Test
    public void signInAsDispatcher() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(availableLoadsAllPage.getTitle("All").contains("All"));
        Thread.sleep(3000);
    }

    @After
    public void logOut() throws InterruptedException {
        availableLoadsAllPage.clickMenuButtonFirstLevel("Account");
        availableLoadsAllPage.clickMenuButtonSecondLevel("Logout");
        availableLoadsAllPage.confirmLogout();
    }


}
