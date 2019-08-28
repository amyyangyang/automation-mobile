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
        Thread.sleep(20000);
    }

    @Test
    public void myLoadsPage() {
        Assert.assertTrue(availableLoadsAllPage.getTitle("My Loads").contains("My Loads"));
        boolean isPresentLoad = myLoadsPage.isElementPresent("id", myLoadsPage.originationAddress);
        if (isPresentLoad) {
            Assert.assertNotNull(pageProperty.getElementText("id", myLoadsPage.jobNumber));
            Assert.assertTrue(pageProperty.getElementText("id", myLoadsPage.payment).contains("$"));
            Assert.assertNotNull(pageProperty.getElementText("id", myLoadsPage.originationAddress));
            Assert.assertNotNull(pageProperty.getElementText("id", myLoadsPage.destinationAddress));
            Assert.assertNotNull(pageProperty.getElementText("id", myLoadsPage.pickUpTime));
            Assert.assertNotNull(pageProperty.getElementText("id", myLoadsPage.deliveryTime));
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

    @Test
    public void modifyJobStatusToCompletedAtLastToUploadPOD()throws InterruptedException{
        String type = myLoadsPage.getElementText("id",myLoadsPage.jobNumber);
        System.out.println(type);
        myLoadsPage.clickElementByLocator("id",myLoadsPage.jobNumber);
        Thread.sleep(3000);
        if(type.contains("J")){
            myLoadDetailsPage.changeTripJobStatusAtLastToUploadPOD(allowLocationPage);
        } else{
            myLoadDetailsPage.changeLegacyJobStatus(allowLocationPage);
        }
        availableLoadsAllPage.getTitle("My Loads");
    }

    @Test
    public void checkPreOperation()throws InterruptedException{
        myLoadsPage.clickElementByLocator("id",myLoadsPage.liveLoadAddress);
        Thread.sleep(3000);
        myLoadDetailsPage.checkPreOperation();
        Assert.assertTrue(myLoadDetailsPage.isElementPresent("path",myLoadDetailsPage.resume));
        Assert.assertTrue(myLoadDetailsPage.isElementPresent("path",myLoadDetailsPage.upLoadPODButton));
        myLoadDetailsPage.completeJobAfterCheckPreOperation(allowLocationPage);
    }
}


