package testcases.dispatcher;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.JobDetailPage;
import com.nexttrucking.automation.mobile.property.Utils;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import property.SetProperty;

import java.net.MalformedURLException;

import static org.hamcrest.core.IsCollectionContaining.hasItem;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AvailableLoadsTest extends SetProperty {
    public static JobDetailPage jobDetailPage;

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        setUpDriver();
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        jobDetailPage = new JobDetailPage(driver, attributeName);
        signInPage.signIn(getTestData("dispatcherEmail"), getTestData("dispatcherPassword"));
    }

    @Test
    public void checkAvailableLoadPage() throws InterruptedException {
        Assert.assertTrue(availableLoadsAllPage.getTitle("Available").contains("Available"));
        Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.allButton,1), "All");
        Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.localButton,1), "Local");
        Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.shortHaulButton,1), "Short Haul");
        Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.longHaulButton,1), "Long Haul");
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.availableCardMap.get("numberOfLoad"));
        if (isPresentLoad) {
            Assert.assertTrue(Utils.isInteger(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.allNumber)));
            Assert.assertNotNull(Utils.isInteger(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.localNumber)));
            Assert.assertNotNull(Utils.isInteger(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.shortHaulNumber)));
            Assert.assertThat(Utils.jobTypeList, hasItem(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("jobType"))));
            Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("equipmentType"))));
            //Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("payout")).contains("$"));
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
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.availableCardMap.get("numberOfLoad"));
        if (isPresentLoad) {
            int size = availableLoadsAllPage.driver.findElementsByXPath(availableLoadsAllPage.availableCardMap.get("numberOfLoad")).size();
            if (size > 1) {
                //availableLoadsAllPage.swipeToUp();
                Assert.assertThat(Utils.jobTypeList, hasItem(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("jobType"))));
                Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("equipmentType"))));
                //Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("payout")).contains("$"));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.originationAddress));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.destinationAddress));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.pickupTime));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.deliveryTime));
            }
        }
    }

    @Test
    public void checkFirstLoadOfLocal() throws InterruptedException{
        availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.localButton);
        boolean isPresentMessage = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.localHaulMile);
        if (isPresentMessage) {
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.allButton);
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.localButton);
            Thread.sleep(3000);
        }
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.availableCardMap.get("numberOfLoad"));
        if (isPresentLoad) {
            Assert.assertThat(Utils.jobTypeList, hasItem(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("jobType"))));
            Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("equipmentType"))));
            //Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("payout")).contains("$"));
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
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.availableCardMap.get("numberOfLoad"));
        if (isPresentLoad) {
            Assert.assertThat(Utils.jobTypeList, hasItem(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("jobType"))));
            Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("equipmentType"))));
            //Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("payout")).contains("$"));
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
    public void checkFirstLoadOfLongHaul ()throws InterruptedException {
        availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.longHaulButton);
        boolean isPresentMessage = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.longHaulMile);
        if (isPresentMessage) {
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.allButton);
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.longHaulButton);
            Thread.sleep(3000);
        }
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.availableCardMap.get("numberOfLoad"));
        if (isPresentLoad) {
            Assert.assertThat(Utils.jobTypeList, hasItem(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("jobType"))));
            Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("equipmentType"))));
            //Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("payout")).contains("$"));
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

    //@Test
    public void checkLoadDetail() {
        Boolean isPresentLoad = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.availableCardMap.get("numberOfLoad"));
        if (isPresentLoad) {
            availableLoadsAllPage.clickElementByLocator("path", availableLoadsAllPage.availableCardMap.get("jobType"));
            Boolean isManyLoad = jobDetailPage.isElementPresent("path", jobDetailPage.theLoadNumberOfJob);
            if (isManyLoad) {
                Assert.assertNotNull(jobDetailPage.getElementText("path", jobDetailPage.jobDetailCard.get("originationAddressOfTwo")));
                Assert.assertNotNull(jobDetailPage.getElementText("path", jobDetailPage.jobDetailCard.get("destinationAddressOfTwo")));
                Assert.assertNotNull(jobDetailPage.getElementText("path", jobDetailPage.jobDetailCard.get("pickupTimeOfTwo")));
                Assert.assertNotNull(jobDetailPage.getElementText("path", jobDetailPage.jobDetailCard.get("deliveryTimeOfTwo")));
                Assert.assertNotNull(jobDetailPage.getElementText("path", jobDetailPage.jobDetailCard.get("loadOfTwo")));
                Assert.assertNotNull(jobDetailPage.getElementText("path", jobDetailPage.jobDetailCard.get("payoutOfTwo")));
            } else {
                Assert.assertNotNull(jobDetailPage.getElementText("path", jobDetailPage.jobDetailCard.get("originationAddress")));
                Assert.assertNotNull(jobDetailPage.getElementText("path", jobDetailPage.jobDetailCard.get("destinationAddress")));
                Assert.assertNotNull(jobDetailPage.getElementText("path", jobDetailPage.jobDetailCard.get("pickupTime")));
                Assert.assertNotNull(jobDetailPage.getElementText("path", jobDetailPage.jobDetailCard.get("deliveryTime")));
            }
//            jobDetailPage.swipeToUp();
//            jobDetailPage.swipeToUp();
//            Assert.assertThat(Utils.equipmentTypeList, hasItem(jobDetailPage.getElementText("path", jobDetailPage.jobDetailCard.get("equipment"))));
//            Assert.assertNotNull(jobDetailPage.getElementText("path", jobDetailPage.jobDetailCard.get("packaging")));
//            Assert.assertNotNull(jobDetailPage.getElementText("path", jobDetailPage.jobDetailCard.get("weight")));
//            Assert.assertNotNull(jobDetailPage.getElementText("path", jobDetailPage.jobDetailCard.get("distance")));
//            //Assert.assertNotNull(jobDetailPage.getElementText("path", jobDetailPage.jobDetailCard.get("commodity")));
//            Assert.assertThat(Utils.jobTypeList, hasItem(jobDetailPage.getElementText("path", jobDetailPage.jobDetailCard.get("specification")).toUpperCase().substring(1)));
            jobDetailPage.clickElementByLocator("path", jobDetailPage.jobDetailCard.get("backButton"));
        }
    }

    @Test
    public void bookTenderOnly() throws InterruptedException {
        Boolean isPresentLoad = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.availableCardMap.get("numberOfLoad"));
        if (isPresentLoad) {
            availableLoadsAllPage.clickElementByLocator("path", availableLoadsAllPage.availableCardMap.get("jobType"));
            jobDetailPage.clickElementByLocator("path", jobDetailPage.bookButton);
            Thread.sleep(3000);
            if (attributeName.equals("text")) {
                jobDetailPage.clickElementByLocator("path", jobDetailPage.isBookButton);
                Thread.sleep(3000);
                Assert.assertTrue(jobDetailPage.getElementText("path", jobDetailPage.booked).contains("You're booked!"));
                jobDetailPage.clickElementByLocator("path", jobDetailPage.skipButton);
                Thread.sleep(3000);
            }else{
                new TouchAction(driver).press(PointOption.point(229,612)).perform();
                Thread.sleep(3000);
                Assert.assertTrue(jobDetailPage.getElementText("path", jobDetailPage.booked).contains("You're booked!"));
                new TouchAction(driver).press(PointOption.point(95,607)).perform();
                Thread.sleep(3000);
            }
        }
    }

    //@Test
    public void bookTenderAndAssignDriver() throws InterruptedException {
        Boolean isPresentLoad = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.availableCardMap.get("numberOfLoad"));
        if (isPresentLoad) {
            availableLoadsAllPage.clickElementByLocator("path", availableLoadsAllPage.availableCardMap.get("jobType"));
            jobDetailPage.clickElementByLocator("path", jobDetailPage.bookButton);
            Thread.sleep(3000);
            if (attributeName.equals("text")) {
                jobDetailPage.clickElementByLocator("path", jobDetailPage.isBookButton);
                Thread.sleep(3000);
                Assert.assertTrue(jobDetailPage.getElementText("path", jobDetailPage.booked).contains("You're booked!"));
                jobDetailPage.clickElementByLocator("path", jobDetailPage.assignOkButton);
                Thread.sleep(3000);
            }else{
                new TouchAction(driver).press(PointOption.point(229,612)).perform();
                Thread.sleep(3000);
                Assert.assertTrue(jobDetailPage.getElementText("path", jobDetailPage.booked).contains("You're booked!"));
                new TouchAction(driver).press(PointOption.point(270,600)).perform();
                Thread.sleep(3000);
            }
            jobDetailPage.clickElementByLocator("path", jobDetailPage.jobDetailCard.get("driverButton"));
            jobDetailPage.clickElementByLocator("path", jobDetailPage.assignButton);
            Thread.sleep(3000);
        }
    }
}
