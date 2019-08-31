package testcases.dispatcher;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.JobDetailPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import com.nexttrucking.automation.mobile.dispatcher.MyLoadsPage;
import com.nexttrucking.automation.mobile.property.Utils;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import property.SetProperty;

import java.net.MalformedURLException;

import static org.hamcrest.core.IsCollectionContaining.hasItem;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DispatcherAvailableTest extends SetProperty {
    public static JobDetailPage jobDetailPage;
    public static MyLoadsPage   myLoadsPage;

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        setUpDriver();
        pageProperty = new PageProperty(driver, attributeName) {};
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        jobDetailPage = new JobDetailPage(driver, attributeName);
        myLoadsPage=new MyLoadsPage(driver,attributeName);
        signInPage.signIn(getTestData("dispatcherEmail"), getTestData("dispatcherPassword"));
    }

    @Test
    public void checkAvailableLoadPage() throws InterruptedException {
        Assert.assertTrue(availableLoadsAllPage.getTitle("Available").contains("Available"));
        Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.allButton, 1), "All");
        Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.localButton, 1), "Local");
        Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.shortHaulButton, 1), "Short Haul");
        Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.longHaulButton, 1), "Long Haul");
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
        if (isPresentLoad) {
            Assert.assertTrue(Utils.isInteger(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.allNumber)));
            Assert.assertNotNull(Utils.isInteger(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.localNumber)));
            Assert.assertNotNull(Utils.isInteger(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.shortHaulNumber)));
            Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.equipmentType)));
            Assert.assertTrue(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.payout).contains("$"));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.originationAddress));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.destinationAddress));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.pickupTime));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.deliveryTime));
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoad), "Please try another type of load or let us know what you like and we'll text you loads that match your preferences.");
            Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.allNumber), "0");
            Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.shortHaulNumber), "0");
            Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.localNumber), "0");
        }
    }

    @Test
    public void checkSecondLoadOfAll() {
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
        if (isPresentLoad) {
            int size = availableLoadsAllPage.driver.findElementsByXPath(availableLoadsAllPage.availableCardMap.get("numberOfLoad")).size();
            if (size > 1) {
//                availableLoadsAllPage.swipeToUpForAndroid();
                Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.equipmentType)));
                Assert.assertTrue(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.payout).contains("$"));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.originationAddress));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.destinationAddress));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.pickupTime));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.deliveryTime));
            }
        }
    }

    @Test
    public void checkFirstLoadOfLocal() throws InterruptedException {
        availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.localButton);
        boolean isPresentMessage = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.localHaulMile);
        if (isPresentMessage) {
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.allButton);
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.localButton);
            Thread.sleep(3000);
        }
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
        if (isPresentLoad) {
            Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.equipmentType)));
            Assert.assertTrue(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.payout).contains("$"));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.originationAddress));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.destinationAddress));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.pickupTime));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.deliveryTime));
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoad), "Please try another type of load or let us know what you like and we'll text you loads that match your preferences.");
        }
        availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.allButton);
    }

    @Test
    public void checkFirstLoadOfShortHaul() throws InterruptedException {
        availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.shortHaulButton);
        boolean isPresentMessage = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.shortHaulMile);
        if (isPresentMessage) {
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.allButton);
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.shortHaulButton);
            Thread.sleep(3000);
        }
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
        if (isPresentLoad) {
            Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.equipmentType)));
            Assert.assertTrue(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.payout).contains("$"));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.originationAddress));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.destinationAddress));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.pickupTime));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.deliveryTime));
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoad), "Please try another type of load or let us know what you like and we'll text you loads that match your preferences.");
        }
        availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.allButton);
    }

    @Test
    public void checkFirstLoadOfLongHaul() throws InterruptedException {
        availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.longHaulButton);
        boolean isPresentMessage = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.longHaulMile);
        if (isPresentMessage) {
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.allButton);
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.longHaulButton);
            Thread.sleep(3000);
        }
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
        if (isPresentLoad) {
            Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.equipmentType)));
            Assert.assertTrue(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.payout).contains("$"));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.originationAddress));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.destinationAddress));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.pickupTime));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.deliveryTime));
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoad), "Please try another type of load or let us know what you like and we'll text you loads that match your preferences.");
        }
        availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.allButton);

    }

    @Test
    public void filterLoadPage() throws InterruptedException {
        availableLoadsAllPage.clickElement(availableLoadsAllPage.buttonMap.get("filterButton"));
//        Assert.assertFalse(availableLoadsAllPage.getElement(availableLoadsAllPage.buttonMap.get("reeferRadio")).isSelected());
//        Assert.assertFalse(availableLoadsAllPage.getElement(availableLoadsAllPage.buttonMap.get("dryVanRadio")).isSelected());
//        Assert.assertFalse(availableLoadsAllPage.getElement(availableLoadsAllPage.buttonMap.get("flatbedRadio")).isSelected());
//        Assert.assertFalse(availableLoadsAllPage.getElement(availableLoadsAllPage.buttonMap.get("powerOnlyRadio")).isSelected());
//        Assert.assertFalse(availableLoadsAllPage.getElement(availableLoadsAllPage.buttonMap.get("boxTruckRadio")).isSelected());

        availableLoadsAllPage.clickElement(availableLoadsAllPage.buttonMap.get("powerOnlyRadio"));
        Thread.sleep(3000);
        //Assert.assertTrue(availableLoadsAllPage.getElement(availableLoadsAllPage.powerOnlyRadio).isSelected());
        if (!(availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.noLoadsButton))) {
            availableLoadsAllPage.clickElement(availableLoadsAllPage.showButton);
        } else {
            availableLoadsAllPage.clickElement(availableLoadsAllPage.buttonMap.get("backButton"));
            Thread.sleep(3000);
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoadAfterFiltering), "Your list is currently filtered so you aren't seeing all of our loads.");
        }
        Assert.assertTrue(availableLoadsAllPage.getTitle("Available").contains("Available"));

        availableLoadsAllPage.clickElement(availableLoadsAllPage.buttonMap.get("filterButton"));
        availableLoadsAllPage.clickElement(availableLoadsAllPage.clearButton);
//        Assert.assertFalse(availableLoadsAllPage.getElement(availableLoadsAllPage.buttonMap.get("powerOnlyRadio")).isSelected());
        if (!(availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.noLoadsButton))) {
            availableLoadsAllPage.clickElement(availableLoadsAllPage.showButton);
        } else {
            availableLoadsAllPage.clickElement(availableLoadsAllPage.buttonMap.get("backButton"));
        }
        Assert.assertTrue(availableLoadsAllPage.getTitle("Available").contains("Available"));
    }

    @Test
    public void checkLoadDetail() {
        Boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
        if (isPresentLoad) {
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.equipmentType);
            Boolean isTrips = jobDetailPage.isElementPresent("xpath", jobDetailPage.isTrips);
            if (isTrips) {
//                Assert.assertTrue(jobDetailPage.getElementText("id",jobDetailPage.payment).contains("$"));
//                Assert.assertNull(jobDetailPage.getElementText("id",jobDetailPage.jobStatus));
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.originationAddress));
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.destinationAddress));
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.pickupTime));
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.deliveryTime));
                Boolean isLiveOnLoad=jobDetailPage.isElementPresent("id",jobDetailPage.liveLoadAddress);
                if(isLiveOnLoad)
                {
                    Assert.assertNotNull(jobDetailPage.getElementText("id",jobDetailPage.liveLoadAddress));
                    jobDetailPage.swipeToUpForAndroid();
                    Assert.assertNotNull(jobDetailPage.getElementText("id",jobDetailPage.liveLoadTime));
                }
            }else{
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.originationAddress));
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.destinationAddress));
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.pickupTime));
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.deliveryTime));
            }
            jobDetailPage.swipeToUpForAndroid();
            jobDetailPage.swipeToUpForAndroid();
            Assert.assertThat(Utils.equipmentTypeListOnDetail, hasItem(jobDetailPage.getElementText("id", jobDetailPage.equipment)));
            Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.distance));
            //Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.packaging));
            //Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.weight));
            //Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.commodity));
            //Assert.assertThat(Utils.jobTypeList, hasItem(jobDetailPage.getElementText("id", jobDetailPage.specification.toUpperCase().substring(1))));
            jobDetailPage.clickElementByLocator("path", jobDetailPage.jobDetailCard.get("backButton"));
        }
    }

    @Test
    public void bookJobOnly() throws InterruptedException {
        Boolean isPresentException = false;
        do {
            Boolean isPresentLoad = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.availableCardMap.get("numberOfLoad"));
            if (isPresentLoad) {
                availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.equipmentType);
                jobDetailPage.clickElementByLocator("path", jobDetailPage.bookButton);
                Thread.sleep(3000);
                jobDetailPage.bookTender();
                isPresentException = jobDetailPage.checkBookJobOrAssignDriverForErrors();
                if (isPresentException) {
                    jobDetailPage.goToMyLoadsOrAvailableLoadsPage(jobDetailPage.goToAvailableLoadsButton);
                    continue;
                }
                Assert.assertTrue(jobDetailPage.getElementText("path", jobDetailPage.booked).contains("You're booked!"));
                jobDetailPage.skipAssignDriver();
            }
        } while (isPresentException);
    }

    @Test
    public void bookJobAndAssignDriver() throws InterruptedException {
        Boolean isPresentException = false;
        do {
            for (int i = 0; i < 3; i++) {
                Boolean isPresentLoad = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.availableCardMap.get("numberOfLoad"));
                if (isPresentLoad) {
                    availableLoadsAllPage.findLiveUnloadJob();
                    pageProperty.clickElementByLocator("path", availableLoadsAllPage.availableCardMap.get("liveUnloadJobAddress2"));
                    jobDetailPage.clickElementByLocator("path", jobDetailPage.bookButton);
                    Thread.sleep(3000);
                    jobDetailPage.bookTender();
                    isPresentException = jobDetailPage.checkBookJobOrAssignDriverForErrors();
                    if (isPresentException) {
                        jobDetailPage.goToMyLoadsOrAvailableLoadsPage(jobDetailPage.goToAvailableLoadsButton);
                        continue;
                    }
                    Assert.assertTrue(jobDetailPage.getElementText("path", jobDetailPage.booked).contains("You're booked!"));
                    jobDetailPage.assignDriver(jobDetailPage.jobDetailCard.get("driver"));
                }
            }
        } while (isPresentException);
    }

    @Test
    public void checkLiveUnloadJobDetail() throws InterruptedException {
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
        if (isPresentLoad) {
            availableLoadsAllPage.findLiveUnloadJob();
            pageProperty.clickElementByLocator("id", availableLoadsAllPage.liveLoadAddress);
            Assert.assertTrue(jobDetailPage.isliveUnloadJobStatusCorrect());
            Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.liveUnloadAddress[0]));
            Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.liveUnloadAddress[1]));
            Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.liveUnloadAddress[2]));
            Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.liveUnloadTime[0]));
            Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.liveUnloadTime[1]));
            Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.liveUnloadTime[2]));
            pageProperty.swipeForAnyPlatform();
            Assert.assertTrue(pageProperty.isTextPresent("Equipment"));
            Assert.assertTrue(pageProperty.isTextPresent("Total Distance"));
            Assert.assertTrue(pageProperty.isTextPresent("Specifications"));
            Assert.assertTrue(pageProperty.isTextPresent("You'll make"));
            Assert.assertTrue(pageProperty.isTextPresent("Book Now"));
            Assert.assertTrue(pageProperty.isTextPresent("$"));
            signInPage.clickBackButton();
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoad), "Please try another type of load or let us know what you like and we'll text you loads that match your preferences.");
        }
    }

}
