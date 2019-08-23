package testcases.driver;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.MyLoadsPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
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
        pageProperty = new PageProperty(driver, attributeName) {};
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        myloadsPage= new MyLoadsPage(driver, attributeName);
        signInPage.signIn(getTestData("driverEmail"), getTestData("driverPassword"));
        Thread.sleep(10000);
    }

    @Test
    public void myLoadsPage() {
        Assert.assertTrue(availableLoadsAllPage.getTitle("My Loads").contains("My Loads"));
        boolean isPresentLoad = myloadsPage.isElementPresent("path", myloadsPage.myLoadsCardMap.get("numberOfLoad"));
        if (isPresentLoad) {
            Assert.assertNotNull(pageProperty.getElementText("id", myloadsPage.jobState));
            Assert.assertNotNull(pageProperty.getElementText("id", myloadsPage.jobNumber));
            Assert.assertNotNull(pageProperty.getElementText("id", myloadsPage.originationAddress));
            Assert.assertNotNull(pageProperty.getElementText("id", myloadsPage.destinationAddress));
            Assert.assertNotNull(pageProperty.getElementText("id", myloadsPage.pickUpTime));
            Assert.assertNotNull(pageProperty.getElementText("id", myloadsPage.deliveryTime));
        }
    }

}


