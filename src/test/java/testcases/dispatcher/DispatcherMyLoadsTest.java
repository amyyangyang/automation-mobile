package testcases.dispatcher;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.MyLoadsPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import com.nexttrucking.automation.mobile.dispatcher.MyLoadDetailsPage;
import com.nexttrucking.automation.mobile.property.Utils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;

import java.net.MalformedURLException;

import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class DispatcherMyLoadsTest extends SetProperty {
    public static MyLoadsPage myLoadsPage;
    public static MyLoadDetailsPage myLoadDetailsPage;

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        setUpDriver();
        pageProperty = new PageProperty(driver, attributeName) {};
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        myLoadsPage= new MyLoadsPage(driver, attributeName);
        myLoadDetailsPage = new MyLoadDetailsPage(driver, attributeName);
        signInPage.signIn(getTestData("dispatcherEmail"), getTestData("dispatcherPassword"));
        availableLoadsAllPage.clickMenuButtonFirstLevel("My Loads");
        Thread.sleep(10000);
    }

    @Test
    public void myLoadsPage() {
        Assert.assertTrue(availableLoadsAllPage.getTitle("My Loads").contains("My Loads"));
        boolean isPresentLoad = myLoadsPage.isElementPresent("path", myLoadsPage.myLoadsCardMap.get("numberOfLoad"));
        if (isPresentLoad) {
            Assert.assertThat(Utils.jobStateList, hasItem(pageProperty.getElementText("id", myLoadsPage.jobState, 0)));
            Assert.assertNotNull(pageProperty.getElementText("id", myLoadsPage.jobNumber, 0));
            Assert.assertTrue(pageProperty.getElementText("id", myLoadsPage.payment).contains("$"));
            Assert.assertNotNull(pageProperty.getElementText("id", myLoadsPage.originationAddress), 0);
            Assert.assertNotNull(pageProperty.getElementText("id", myLoadsPage.destinationAddress), 0);
            Assert.assertNotNull(pageProperty.getElementText("id", myLoadsPage.pickUpTime), 0);
            Assert.assertNotNull(pageProperty.getElementText("id", myLoadsPage.deliveryTime), 0);
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", myLoadsPage.noLoadOnMyLoads), "Go claim some loads in the \"Available Loads\" section and get loaded.");
        }
    }

    @Test
    public void modifyJobStatusToCompleted()throws InterruptedException{
        availableLoadsAllPage.clickMenuButtonFirstLevel("Account");
        availableLoadsAllPage.clickMenuButtonSecondLevel("Logout");
        availableLoadsAllPage.confirmLogout();
        welcomePage.clickSignInButton();
        signInPage.typeEmail(getTestData("driverEmail"));
        signInPage.typePassword(getTestData("driverPassword"));
        signInPage.clickSignInButton();
        Thread.sleep(10000);
        String type = myLoadsPage.getElementText("id",myLoadsPage.jobNumber);
        System.out.println(type);
        myLoadsPage.clickElementByLocator("id",myLoadsPage.jobNumber);
        Thread.sleep(3000);
        if(type.contains("J")){
            myLoadDetailsPage.changeTripJobStatus(allowLocationPage);
        } else{
            myLoadDetailsPage.changeLegacyJobStatus(allowLocationPage);
        }
        availableLoadsAllPage.getTitle("My Loads");
    }
}


