package testcases.driver;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.MyLoadsPage;
import com.nexttrucking.automation.mobile.property.Utils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;

import java.net.MalformedURLException;

import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class DriverMyLoadsTest extends SetProperty {
    public static MyLoadsPage myloadsPage;

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        setUpDriver();
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        myloadsPage= new MyLoadsPage(driver, attributeName);
//        signInPage.signIn(getTestData("driverEmail"), getTestData("driverPassword"));
        Thread.sleep(40000);
    }

    @Test
    public void myLoadsPage() {
        Assert.assertTrue(availableLoadsAllPage.getTitle("My Loads").contains("My Loads"));
        boolean isPresentLoad = myloadsPage.isElementPresent("path", myloadsPage.myLoadsCardMap.get("numberOfLoad"));
        if (isPresentLoad) {
            Assert.assertNotNull(myloadsPage.getElementText("path", myloadsPage.myLoadsCardMap.get("jobState")));
            Assert.assertNotNull(myloadsPage.getElementText("path", myloadsPage.myLoadsCardMap.get("jobNum")));
            Assert.assertTrue(myloadsPage.getElementText("path", myloadsPage.myLoadsCardMap.get("payout")).contains("$"));
            Assert.assertNotNull(myloadsPage.getElementText("path", myloadsPage.myLoadsCardMap.get("originationAddress")));
            Assert.assertNotNull(myloadsPage.getElementText("path", myloadsPage.myLoadsCardMap.get("destinationAddress")));
            Assert.assertNotNull(myloadsPage.getElementText("path", myloadsPage.myLoadsCardMap.get("pickupTime")));
            Assert.assertNotNull(myloadsPage.getElementText("path", myloadsPage.myLoadsCardMap.get("deliveryTime")));
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", myloadsPage.noLoadOnMyLoads), "Go claim some loads in the \"Available Loads\" section and get loaded.");
        }

    }
}


