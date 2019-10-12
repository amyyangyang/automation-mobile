package testcases.driver;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.MyLoadDetailsPage;
import com.nexttrucking.automation.mobile.dispatcher.MyLoadsPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;
import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;


public class DriverMyLoadsTest extends SetProperty {
    public static MyLoadsPage myLoadsPage;
    public static MyLoadDetailsPage myLoadDetailsPage;

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException, ParserConfigurationException {
        setUpDriver();
        pageProperty = new PageProperty(driver, attributeName) {};
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        myLoadsPage= new MyLoadsPage(driver, attributeName);
        myLoadDetailsPage = new MyLoadDetailsPage(driver, attributeName);
        signInPage.signIn(getTestData("driverEmail"), getTestData("driverPassword"));
        Thread.sleep(15000);
    }

    @Test
    public void myLoadsPage() {
        Assert.assertTrue(availableLoadsAllPage.getTitle("My Loads").contains("My Loads"));
        boolean isPresentLoad = myLoadsPage.isElementPresent("id", myLoadsPage.originationAddress);
        if (isPresentLoad) {
            Assert.assertNotNull(pageProperty.getElementText("id", myLoadsPage.jobNumber));
            Assert.assertNotNull(pageProperty.getElementText("id", myLoadsPage.originationAddress));
            Assert.assertNotNull(pageProperty.getElementText("id", myLoadsPage.destinationAddress));
            Assert.assertNotNull(pageProperty.getElementText("id", myLoadsPage.pickUpTime));
            Assert.assertNotNull(pageProperty.getElementText("id", myLoadsPage.deliveryTime));
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", myLoadsPage.noLoadOnMyLoads), "You don't have any loads");
        }
    }

    @Test
    public void modifyLiveUnLoadJobStatusToCompleted()throws InterruptedException {
        boolean isPresentJob = myLoadsPage.isElementPresent("id", myLoadsPage.originationAddress);
        if (isPresentJob) {
            Boolean isPresent=myLoadsPage.findAndClickNotStartedLiveUnloadJob();
            if(isPresent){
                myLoadDetailsPage.changeTripJobStatus(allowLocationPage);
                availableLoadsAllPage.getTitle("My Loads");
            }
            Thread.sleep(3000);
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", myLoadsPage.noLoadOnMyLoads), "You don't have any loads");
        }
    }

    @Test
    public void modifyLiveUnLoadJobStatusToCompletedAtLastToUploadPOD()throws InterruptedException{
        boolean isPresentJob=myLoadsPage.isElementPresent("id",myLoadsPage.originationAddress);
        if(isPresentJob) {
            Boolean isPresent=myLoadsPage.findAndClickNotStartedLiveUnloadJob();
            if(isPresent) {
                Thread.sleep(3000);
                myLoadDetailsPage.changeTripJobStatusAtLastToUploadPOD(allowLocationPage);
                availableLoadsAllPage.getTitle("My Loads");
            }
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", myLoadsPage.noLoadOnMyLoads), "You don't have any loads");
        }
    }

    @Test
    public void checkLiveUnLoadJobPreOperation()throws InterruptedException{
        boolean isPresentJob=myLoadsPage.isElementPresent("id",myLoadsPage.originationAddress);
        if(isPresentJob){
            Boolean isPresent=myLoadsPage.findAndClickNotStartedLiveUnloadJob();
            if(isPresent) {
                Thread.sleep(3000);
                myLoadDetailsPage.checkPreOperation();
                Assert.assertTrue(myLoadDetailsPage.isElementPresent("path", myLoadDetailsPage.resume));
                Assert.assertTrue(myLoadDetailsPage.isElementPresent("path", myLoadDetailsPage.upLoadPODButton));
                myLoadDetailsPage.completeJobAfterCheckPreOperation(allowLocationPage);
            }
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", myLoadsPage.noLoadOnMyLoads), "You don't have any loads");
        }
    }

    @Test
    public void undoOperationInProgressUploadPOD()throws InterruptedException{
        Boolean isPresentJob = myLoadsPage.isElementPresent("id",myLoadsPage.originationAddress);
        if(isPresentJob){
            Boolean isPresent=myLoadsPage.findAndClickNotStartedLiveUnloadJob();
            if(isPresent) {
                Thread.sleep(3000);
                myLoadDetailsPage.checkUndoOperationInProgressUploadPOD(allowLocationPage);
                availableLoadsAllPage.getTitle("My Loads");
            }
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", myLoadsPage.noLoadOnMyLoads), "You don't have any loads");
        }
    }

}


