package testcases.driver;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.*;
import com.nexttrucking.automation.mobile.property.PageProperty;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;

import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;

import static org.hamcrest.CoreMatchers.containsString;


public class DriverMyLoadsTest extends SetProperty {
    public static MyLoadsPage myLoadsPage;
    public static MyLoadDetailsPage myLoadDetailsPage;
    public static PaymentDetailPage paymentDetailPage;
    public static JobDetailPage jobDetailPage;

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException, ParserConfigurationException {
        setUpDriver();
        pageProperty = new PageProperty(driver, attributeName) {
        };
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        jobDetailPage = new JobDetailPage(driver, attributeName);
        myLoadsPage = new MyLoadsPage(driver, attributeName);
        myLoadDetailsPage = new MyLoadDetailsPage(driver, attributeName);
        paymentDetailPage = new PaymentDetailPage(driver, attributeName);
        signInPage.signIn(getTestData("dispatcherEmail"), getTestData("dispatcherPassword"));
        availableLoadsAllPage.bookTenderForFleet(1,jobDetailPage);
        availableLoadsAllPage.clickMenuButtonFirstLevel("Account");
        availableLoadsAllPage.clickMenuButtonSecondLevel("Logout");
        availableLoadsAllPage.confirmLogout();
        signInPage.signIn(getTestData("driverEmail"), getTestData("driverPassword"));
        Thread.sleep(15000);
    }

    @Test
    public void myLoadsPage() {
        Assert.assertTrue(availableLoadsAllPage.getTitle("My Loads").contains("My Loads"));
        boolean isPresentLoad = myLoadsPage.isElementPresent("id", myLoadsPage.originationAddress);
        if (isPresentLoad) {
            Assert.assertNotNull(pageProperty.getElementText("id", myLoadsPage.jobNumber));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("id", myLoadsPage.getTextInAddress, 0));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("id", myLoadsPage.getTextInAddress, 1));
            boolean isLegacy = availableLoadsAllPage.isElementPresent("id", myLoadsPage.pickUpTime);
            if (isLegacy) {
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", myLoadsPage.pickUpTime));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", myLoadsPage.deliveryTime));
            } else {
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", myLoadsPage.getTextInTime, 0));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", myLoadsPage.getTextInTime, 1));
            }
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", myLoadsPage.noLoadOnMyLoads), "You don't have any loads");
        }
    }

    @Test
    public void modifyJobStatusToCompleted() throws InterruptedException {
        boolean isPresentJob = myLoadsPage.isElementPresent("id", myLoadsPage.originationAddress);
        if (isPresentJob) {
            Boolean isPresent = myLoadsPage.findAndClickNotStartedLiveUnloadJob();
            if (isPresent) {
                myLoadDetailsPage.changeTripJobStatus(allowLocationPage);
                availableLoadsAllPage.getTitle("My Loads");
            }
            Thread.sleep(3000);
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", myLoadsPage.noLoadOnMyLoads), "You don't have any loads");
        }
    }

    //@Test
    public void modifyLiveUnLoadJobStatusToCompletedAtLastToUploadPOD() throws InterruptedException {
        boolean isPresentJob = myLoadsPage.isElementPresent("id", myLoadsPage.originationAddress);
        if (isPresentJob) {
            Boolean isPresent = myLoadsPage.findAndClickNotStartedLiveUnloadJob();
            if (isPresent) {
                Thread.sleep(3000);
                myLoadDetailsPage.changeTripJobStatusAtLastToUploadPOD(allowLocationPage);
                availableLoadsAllPage.getTitle("My Loads");
            }
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", myLoadsPage.noLoadOnMyLoads), "You don't have any loads");
        }
    }

    //@Test
    public void checkLiveUnLoadJobPreOperation() throws InterruptedException {
        boolean isPresentJob = myLoadsPage.isElementPresent("id", myLoadsPage.originationAddress);
        if (isPresentJob) {
            Boolean isPresent = myLoadsPage.findAndClickNotStartedLiveUnloadJob();
            if (isPresent) {
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

    //@Test
    public void undoOperationInProgressUploadPOD() throws InterruptedException {
        Boolean isPresentJob = myLoadsPage.isElementPresent("id", myLoadsPage.originationAddress);
        if (isPresentJob) {
            Boolean isPresent = myLoadsPage.findAndClickNotStartedLiveUnloadJob();
            if (isPresent) {
                Thread.sleep(3000);
                myLoadDetailsPage.checkUndoOperationInProgressUploadPOD(allowLocationPage);
                availableLoadsAllPage.getTitle("My Loads");
            }
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", myLoadsPage.noLoadOnMyLoads), "You don't have any loads");
        }
    }


    @Test
    public void checkMyLoadDetail() throws InterruptedException {
        Boolean isPresentJob = myLoadsPage.isElementPresent("id", myLoadsPage.jobNumber);
        if (isPresentJob) {
            Boolean isPresent = myLoadsPage.findAndClickNotStartedLiveUnloadJob();
            if (isPresent) {
                Thread.sleep(3000);
                Assert.assertEquals(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.myLoadsDetailCardMap.get("summaryTab")), "Summary");
                Assert.assertEquals(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.myLoadsDetailCardMap.get("hookTab")), "1. Hook");
                Assert.assertEquals(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.myLoadsDetailCardMap.get("liveUnloadPanel")), "2. Live Unload");
                Assert.assertEquals(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.myLoadsDetailCardMap.get("dropTab")), "3. Drop");
                Assert.assertThat(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.locationPanel), containsString("Locations"));
                Assert.assertThat(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.detailPanel), containsString("Details for Job"));

                myLoadsPage.clickElementByLocator("path", myLoadDetailsPage.locationPanel);
                Assert.assertNotNull(myLoadDetailsPage.getElementText("id", myLoadDetailsPage.getTextInAddress, 0));
                Assert.assertNotNull(myLoadDetailsPage.getElementText("id", myLoadDetailsPage.getTextInAddress, 1));
                Assert.assertNotNull(myLoadDetailsPage.getElementText("id", myLoadDetailsPage.getTextInAddress, 2));
                Assert.assertThat(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.containerStatus), containsString("Container"));
                boolean isTerminalJob = paymentDetailPage.isTerminalJob(myLoadDetailsPage.addressText);
                myLoadsPage.clickElementByLocator("path", myLoadDetailsPage.locationPanel);

                myLoadsPage.clickElementByLocator("path", myLoadDetailsPage.detailPanel);
                Assert.assertEquals(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.myLoadsDetailCardMap.get("GoodsValueText")), "Goods Value");
                Assert.assertNotNull(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.myLoadsDetailCardMap.get("GoodsValueValue")));
                Assert.assertEquals(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.myLoadsDetailCardMap.get("equipmentText")), "Equipment");
                Assert.assertNotNull(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.myLoadsDetailCardMap.get("equipmentValue")));
                Assert.assertEquals(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.myLoadsDetailCardMap.get("containerNumberText")), "Container Number");
                Assert.assertNotNull(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.myLoadsDetailCardMap.get("containerNumberValue")));
                Assert.assertEquals(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.myLoadsDetailCardMap.get("commodityText")), "Commodity");
                Assert.assertNotNull(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.myLoadsDetailCardMap.get("commodityValue")));
                if (isTerminalJob) {
                    Assert.assertFalse(pageProperty.isTextPresent("Rate Contract"));
                } else {
                    Assert.assertTrue(pageProperty.isTextPresent("Rate Contract"));
                }

                String[] actionNames = {"hookTab", "liveUnloadPanel", "dropTab"};
                for (String name : actionNames) {
                    myLoadsPage.clickElementByLocator("path", myLoadDetailsPage.myLoadsDetailCardMap.get(name));
                    myLoadDetailsPage.swipeToUpForAndroid();
                    Assert.assertEquals(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.myLoadsDetailCardMap.get("masterBillOfLadingText")), "Master Bill of Lading");
                    Assert.assertNotNull(myLoadDetailsPage.getElementText("path", myLoadDetailsPage.myLoadsDetailCardMap.get("masterBillOfLadingValue")));
                }
                myLoadDetailsPage.clickElementByLocator("path", myLoadDetailsPage.myLoadsDetailCardMap.get("backToMyLoads"));

            }
        }
    }


}


