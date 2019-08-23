package testcases.dispatcher;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.MyLoadsPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import com.nexttrucking.automation.mobile.property.Utils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;

import java.net.MalformedURLException;

import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class DispatcherMyLoadsTest extends SetProperty {
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
        signInPage.signIn(getTestData("dispatcherEmail"), getTestData("dispatcherPassword"));
        availableLoadsAllPage.clickMenuButtonFirstLevel("My Loads");
        Thread.sleep(10000);
    }

    @Test
    public void myLoadsPage() {
        Assert.assertTrue(availableLoadsAllPage.getTitle("My Loads").contains("My Loads"));
        boolean isPresentLoad = myloadsPage.isElementPresent("path", myloadsPage.myLoadsCardMap.get("numberOfLoad"));
        if (isPresentLoad) {
            Assert.assertThat(Utils.jobStateList, hasItem(pageProperty.getElementText("id", myloadsPage.jobState, 0)));
            Assert.assertNotNull(pageProperty.getElementText("id", myloadsPage.jobNum, 0));
            Assert.assertTrue(pageProperty.getElementText("id", myloadsPage.payout).contains("$"));
            Assert.assertNotNull(pageProperty.getElementText("id", myloadsPage.originationAddress), 0);
            Assert.assertNotNull(pageProperty.getElementText("id", myloadsPage.destinationAddress), 0);
            Assert.assertNotNull(pageProperty.getElementText("id", myloadsPage.pickupTime), 0);
            Assert.assertNotNull(pageProperty.getElementText("id", myloadsPage.deliveryTime), 0);
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", myloadsPage.noLoadOnMyLoads), "Go claim some loads in the \"Available Loads\" section and get loaded.");
        }
    }

}


