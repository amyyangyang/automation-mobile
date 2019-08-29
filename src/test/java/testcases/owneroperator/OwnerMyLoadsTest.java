package testcases.owneroperator;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.MyLoadDetailsPage;
import com.nexttrucking.automation.mobile.dispatcher.MyLoadsPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import com.nexttrucking.automation.mobile.property.Utils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;

import java.net.MalformedURLException;

import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class OwnerMyLoadsTest extends SetProperty {
    public static MyLoadDetailsPage myLoadDetailsPage;
    public static MyLoadsPage myLoadsPage;

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        setUpDriver();
        pageProperty = new PageProperty(driver, attributeName) {};
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        myLoadDetailsPage = new MyLoadDetailsPage(driver, attributeName);
        myLoadsPage= new MyLoadsPage(driver, attributeName);
        signInPage.signIn(getTestData("ownerOperatorEmail"), getTestData("ownerOperatorPassword"));
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
        myLoadsPage.findAndClickNotStartedLiveUnloadJob();
        Thread.sleep(3000);
        myLoadDetailsPage.changeTripJobStatus(allowLocationPage);
        myLoadDetailsPage.submitInvoice();
        availableLoadsAllPage.getTitle("My Loads");
    }

    @Test
    public void modifyJobStatusToCompletedAtLastToUploadPOD()throws InterruptedException{
        myLoadsPage.findAndClickNotStartedLiveUnloadJob();
        Thread.sleep(3000);
        myLoadDetailsPage.changeTripJobStatusAtLastToUploadPOD(allowLocationPage);
        myLoadDetailsPage.submitInvoice();
        availableLoadsAllPage.getTitle("My Loads");
    }

    @Test
    public void checkPreOperation()throws InterruptedException{
        myLoadsPage.findAndClickNotStartedLiveUnloadJob();
        Thread.sleep(3000);
        myLoadDetailsPage.checkPreOperation();
        Assert.assertTrue(myLoadDetailsPage.isElementPresent("path",myLoadDetailsPage.resume));
        Assert.assertTrue(myLoadDetailsPage.isElementPresent("path",myLoadDetailsPage.upLoadPODButton));
        myLoadDetailsPage.completeJobAfterCheckPreOperation(allowLocationPage);
        myLoadDetailsPage.submitInvoice();
    }

}


