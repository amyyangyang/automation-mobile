package testcases.owneroperator;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import org.junit.*;
import property.SetProperty;

import java.net.MalformedURLException;


public class SignInAsOwnerOperatorTest extends SetProperty {

    @BeforeClass
    public static void setUp() throws MalformedURLException {
//        if (driver == null) {
//            setUpDriver();
//        }
//        driver.launchApp();
        setUpDriver();
//        driver.launchApp();
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
    }

    @Test
    public void signInAsOwnerOperator() throws InterruptedException {
        signInPage.signIn(getTestData("ownerOperatorEmail"), getTestData("ownerOperatorPassword"));
        Thread.sleep(3000);
        Assert.assertTrue(availableLoadsAllPage.getTitle("All").contains("All"));
        Thread.sleep(3000);
    }

//    @After
//    public void logOut() throws InterruptedException {
//        availableLoadsAllPage.clickMenuButtonFirstLevel("Account");
//        availableLoadsAllPage.clickMenuButtonSecondLevel("Logout");
//        availableLoadsAllPage.confirmLogout();
//    }

}
