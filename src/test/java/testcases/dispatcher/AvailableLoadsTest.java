package testcases.dispatcher;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.common.Utils;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import property.SetProperty;

import java.net.MalformedURLException;

import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class AvailableLoadsTest extends SetProperty {

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException {
        setUpDriver();
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        signInPage.signIn(getTestData("dispatcherEmail"), getTestData("dispatcherPassword"));
    }

    @Test
    public void AvailableLoadPage() {
        Assert.assertTrue(availableLoadsAllPage.getTitle("Available").contains("Available"));
        if (attributeName.equals("text")) {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.allButton), "All");
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.localButton), "Local");
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.shortHaulButton), "Short Haul");
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.longHaulButton), "Long Haul");
            boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.jobType);
            if (isPresentLoad) {
                Assert.assertTrue(Utils.isInteger(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.allNumber)));
                Assert.assertNotNull(Utils.isInteger(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.localNumber)));
                Assert.assertNotNull(Utils.isInteger(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.shortHaulNumber)));
                Assert.assertThat(Utils.jobTypeList, hasItem(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.jobType)));
                Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.equipmentType)));
                Assert.assertTrue(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.payout).contains("$"));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.originAddress));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.destinationAddress));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.pickupTime));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.deliveryTime));
            } else {
                Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoad), "Please try another type of load or let us know what you like and we'll text you loads that match your preferences.");
                Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.allNumber), "0");
                Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.shortHaulNumber), "0");
                Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.localNumber), "0");
            }
        } else {
            Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.allButton).contains("All"));
            Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.localButton).contains("Local"));
            Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.shortHaulButton).contains("Short Haul"));
            Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.longHaulButton).contains("Long Haul"));
        }
    }

//    @Test
    public void theSecondLoadOfAll() {
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.jobType);
        if (isPresentLoad) {
            int size = availableLoadsAllPage.driver.findElementsByAccessibilityId(availableLoadsAllPage.jobType).size();
            if (size > 1) {
                availableLoadsAllPage.swipeToUp();
                Assert.assertThat(Utils.jobTypeList, hasItem(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.jobType)));
                Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.equipmentType)));
                Assert.assertTrue(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.payout).contains("$"));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.originAddress));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.destinationAddress));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.pickupTime));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.deliveryTime));
            }
        }
    }

    @Test
    public void theFirstLoadOfLocal() {
        availableLoadsAllPage.clickElement(availableLoadsAllPage.localButton);
        if (attributeName.equals("text")) {
            boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.jobType);
            if (isPresentLoad) {
                Assert.assertThat(Utils.jobTypeList, hasItem(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.jobType)));
                Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.equipmentType)));
                Assert.assertTrue(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.payout).contains("$"));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.originAddress));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.destinationAddress));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.pickupTime));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.deliveryTime));
            } else {
                Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoad), "Please try another type of load or let us know what you like and we'll text you loads that match your preferences.");
            }
        }
        availableLoadsAllPage.clickElement(availableLoadsAllPage.allButton);
    }

    @Test
    public void theFirstLoadOfShortHaul() {
        availableLoadsAllPage.clickElement(availableLoadsAllPage.shortHaulButton);
        if (attributeName.equals("text")) {
            boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.jobType);
            if (isPresentLoad) {
                Assert.assertThat(Utils.jobTypeList, hasItem(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.jobType)));
                Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.equipmentType)));
                Assert.assertTrue(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.payout).contains("$"));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.originAddress));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.destinationAddress));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.pickupTime));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.deliveryTime));
            } else {
                Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoad), "Please try another type of load or let us know what you like and we'll text you loads that match your preferences.");
            }
        }
        availableLoadsAllPage.clickElement(availableLoadsAllPage.allButton);
    }

    @Test
    public void theFirstLoadOfLongHaul() {
        availableLoadsAllPage.clickElement(availableLoadsAllPage.longHaulButton);
        if (attributeName.equals("text")) {
            boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.jobType);
            if (isPresentLoad) {
                Assert.assertThat(Utils.jobTypeList, hasItem(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.jobType)));
                Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.equipmentType)));
                Assert.assertTrue(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.payout).contains("$"));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.originAddress));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.destinationAddress));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.pickupTime));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.deliveryTime));
            } else {
                Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoad), "Please try another type of load or let us know what you like and we'll text you loads that match your preferences.");
            }
        }
        availableLoadsAllPage.clickElement(availableLoadsAllPage.allButton);

    }

    @Test
    public void filterPage() throws InterruptedException {
        availableLoadsAllPage.clickElement(availableLoadsAllPage.buttonMap.get("filterButton"));
//        Assert.assertFalse(availableLoadsAllPage.getElement(availableLoadsAllPage.buttonMap.get("reeferRadio")).isSelected());
//        Assert.assertFalse(availableLoadsAllPage.getElement(availableLoadsAllPage.buttonMap.get("dryVanRadio")).isSelected());
//        Assert.assertFalse(availableLoadsAllPage.getElement(availableLoadsAllPage.buttonMap.get("flatbedRadio")).isSelected());
//        Assert.assertFalse(availableLoadsAllPage.getElement(availableLoadsAllPage.buttonMap.get("powerOnlyRadio")).isSelected());
//        Assert.assertFalse(availableLoadsAllPage.getElement(availableLoadsAllPage.buttonMap.get("boxTruckRadio")).isSelected());

        availableLoadsAllPage.clickElement(availableLoadsAllPage.buttonMap.get("powerOnlyRadio"));
        //Assert.assertTrue(availableLoadsAllPage.getElement(availableLoadsAllPage.powerOnlyRadio).isSelected());
        if (availableLoadsAllPage.getElement(availableLoadsAllPage.showButton).isEnabled()) {
            availableLoadsAllPage.clickElement(availableLoadsAllPage.showButton);
        } else {
            availableLoadsAllPage.clickElement(availableLoadsAllPage.buttonMap.get("backButton"));
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoadAfterFiltering), "Your list is currently filtered so you aren't seeing all of our loads.");
        }
        Assert.assertTrue(availableLoadsAllPage.getTitle("Available").contains("Available"));

        availableLoadsAllPage.clickElement(availableLoadsAllPage.buttonMap.get("filterButton"));
        availableLoadsAllPage.clickElement(availableLoadsAllPage.clearButton);
//        Assert.assertFalse(availableLoadsAllPage.getElement(availableLoadsAllPage.buttonMap.get("powerOnlyRadio")).isSelected());
        if (availableLoadsAllPage.getElement(availableLoadsAllPage.showButton).isEnabled()) {
            availableLoadsAllPage.clickElement(availableLoadsAllPage.showButton);
        } else {
            availableLoadsAllPage.clickElement(availableLoadsAllPage.buttonMap.get("backButton"));
        }
        Assert.assertTrue(availableLoadsAllPage.getTitle("Available").contains("Available"));
    }
}
