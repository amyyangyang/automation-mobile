package testcases.dispatcher;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.MyDriversPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;
import java.net.MalformedURLException;



public class MyDriversTest extends SetProperty {


    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        setUpDriver();
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        myDriversPage = new MyDriversPage(driver, attributeName);
        // SignIn as Dispatcher
        signInPage.signIn(getTestData("dispatcherEmail"), getTestData("dispatcherPassword"));
        Thread.sleep(3000);
    }


//    @Test
    public void addDriver() throws InterruptedException {
        availableLoadsAllPage.clickMenuButtonFirstLevel("My Drivers");
        myDriversPage.clickAddDriverButton();
        myDriversPage.typeEmail(getTestData("driverAddEmail"));
        myDriversPage.typePassword(getTestData("driverAddPassword"));
        myDriversPage.clickContinueButton();
        myDriversPage.selectDriverType("Reefer");
        myDriversPage.clickContinueButton();
        myDriversPage.selectDriverSize("48");
        myDriversPage.clickContinueButton();
        myDriversPage.typeFirstName(getTestData("driveFirstName"));
        myDriversPage.typeLastName(getTestData("driveLastName"));
        myDriversPage.typePhoneNumber(getTestData("drivePhoneNumber"));
        myDriversPage.clickSignUpButton();
        Thread.sleep(5000);
        Assert.assertTrue(myDriversPage.getFirstDriverName("TestFirst").contains("Test"));
    }
}
