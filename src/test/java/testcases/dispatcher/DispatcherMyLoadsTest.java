package testcases.dispatcher;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.MyloadsDetailPage;
import com.nexttrucking.automation.mobile.dispatcher.MyloadsPage;
import com.nexttrucking.automation.mobile.property.Utils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;

import java.net.MalformedURLException;

import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class DispatcherMyLoadsTest extends SetProperty {
    public static MyloadsPage myloadsPage;
    public static MyloadsDetailPage myloadsDetailPage;

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        setUpDriver();
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        myloadsPage= new MyloadsPage(driver, attributeName);
        myloadsDetailPage = new MyloadsDetailPage(driver, attributeName);
        signInPage.signIn(getTestData("dispatcherEmail"), getTestData("dispatcherPassword"));
        availableLoadsAllPage.clickMenuButtonFirstLevel("My Loads");
    }

//    @Test
    public void MyLoadPage() {
        Assert.assertTrue(availableLoadsAllPage.getTitle("My Loads").contains("My Loads"));
        if (attributeName.equals("text")) {
            boolean isPresentLoad = myloadsPage.isElementPresent("path", myloadsPage.myLoadsCardMap.get("numberOfLoad"));
            if (isPresentLoad) {
                Assert.assertThat(Utils.jobStateList, hasItem(myloadsPage.getElementText("path", myloadsPage.myLoadsCardMap.get("jobState"))));
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
        String type = myloadsPage.getElementText("id",myloadsPage.jobNumber);
        System.out.println(type);
        myloadsPage.clickElementByLocator("id",myloadsPage.jobNumber);
        Thread.sleep(3000);
        if(type.contains("J")){
            myloadsDetailPage.changeTripJobStatus(allowLocationPage);
        } else{
            myloadsDetailPage.changeLegacyJobStatus(allowLocationPage);
        }
        availableLoadsAllPage.getTitle("My Loads");
    }
}


