package testcases.dispatcher;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.MyLoadsDetailPage;
import com.nexttrucking.automation.mobile.dispatcher.MyLoadsPage;
import com.nexttrucking.automation.mobile.property.Utils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;

import java.net.MalformedURLException;

import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class DispatcherMyLoadsTest extends SetProperty {
    public static MyLoadsPage myLoadsPage;
    public static MyLoadsDetailPage myLoadsDetailPage;

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        setUpDriver();
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        myLoadsPage= new MyLoadsPage(driver, attributeName);
        myLoadsDetailPage = new MyLoadsDetailPage(driver, attributeName);
        signInPage.signIn(getTestData("dispatcherEmail"), getTestData("dispatcherPassword"));
        availableLoadsAllPage.clickMenuButtonFirstLevel("My Loads");
    }

//    @Test
    public void MyLoadPage() {
        Assert.assertTrue(availableLoadsAllPage.getTitle("My Loads").contains("My Loads"));
        if (attributeName.equals("text")) {
            boolean isPresentLoad = myLoadsPage.isElementPresent("path", myLoadsPage.myLoadsCardMap.get("numberOfLoad"));
            if (isPresentLoad) {
                Assert.assertThat(Utils.jobStateList, hasItem(myLoadsPage.getElementText("path", myLoadsPage.myLoadsCardMap.get("jobState"))));
                Assert.assertNotNull(myLoadsPage.getElementText("path", myLoadsPage.myLoadsCardMap.get("jobNum")));
                Assert.assertTrue(myLoadsPage.getElementText("path", myLoadsPage.myLoadsCardMap.get("payout")).contains("$"));
                Assert.assertNotNull(myLoadsPage.getElementText("path", myLoadsPage.myLoadsCardMap.get("originationAddress")));
                Assert.assertNotNull(myLoadsPage.getElementText("path", myLoadsPage.myLoadsCardMap.get("destinationAddress")));
                Assert.assertNotNull(myLoadsPage.getElementText("path", myLoadsPage.myLoadsCardMap.get("pickupTime")));
                Assert.assertNotNull(myLoadsPage.getElementText("path", myLoadsPage.myLoadsCardMap.get("deliveryTime")));
            } else {
                Assert.assertEquals(availableLoadsAllPage.getElementText("path", myLoadsPage.noLoadOnMyLoads), "Go claim some loads in the \"Available Loads\" section and get loaded.");
            }
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
            myLoadsDetailPage.changeTripJobStatus(allowLocationPage);
        } else{
            myLoadsDetailPage.changeLegacyJobStatus(allowLocationPage);
        }
        availableLoadsAllPage.getTitle("My Loads");
    }
}


