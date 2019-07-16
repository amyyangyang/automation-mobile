package testcases.dispatcher;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.property.Utils;
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

//    @Test
    public void AvailableLoadPage() {
        Assert.assertTrue(availableLoadsAllPage.getTitle("Available").contains("Available"));
        Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.allButton), "All");
        Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.localButton), "Local");
        Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.shortHaulButton), "Short Haul");
        Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.longHaulButton), "Long Haul");
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.availableCardMap.get("numberOfLoad"));
        if (isPresentLoad) {
            Assert.assertTrue(Utils.isInteger(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.allNumber)));
            Assert.assertNotNull(Utils.isInteger(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.localNumber)));
            Assert.assertNotNull(Utils.isInteger(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.shortHaulNumber)));
            Assert.assertThat(Utils.jobTypeList, hasItem(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("jobType"))));
            Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("equipmentType"))));
            //Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("payout")).contains("$"));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("originationAddress")));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("destinationAddress")));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("pickupTime")));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("deliveryTime")));
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoad), "Please try another type of load or let us know what you like and we'll text you loads that match your preferences.");
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.allNumber), "0");
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.shortHaulNumber), "0");
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.localNumber), "0");
            }
    }

//    @Test
    public void theSecondLoadOfAll() {
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.availableCardMap.get("numberOfLoad"));
        if (isPresentLoad) {
            int size = availableLoadsAllPage.driver.findElementsByXPath(availableLoadsAllPage.availableCardMap.get("jobType")).size();
            if (size > 1) {
                availableLoadsAllPage.swipeToUp();
                Assert.assertThat(Utils.jobTypeList, hasItem(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("jobType"))));
                Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("equipmentType"))));
                //Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("payout")).contains("$"));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("originAddress")));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("destinationAddress")));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("pickupTime")));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("deliveryTime")));
            }
        }
    }

//    @Test
    public void theFirstLoadOfLocal() {
        availableLoadsAllPage.clickElementByLocator("path", availableLoadsAllPage.localButton);
        boolean isPresentMessage=availableLoadsAllPage.isElementPresent("path",availableLoadsAllPage.localHaulMile);
        boolean isPresentLoad;
        if(isPresentMessage) {
            isPresentLoad = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.availableCardMap.get("numberOfLoadTwo"));
            if(isPresentLoad){
                availableLoadsAllPage.clickElementByLocator("path", availableLoadsAllPage.allButton);
                availableLoadsAllPage.clickElementByLocator("path", availableLoadsAllPage.localButton);
            }
        }else{
            isPresentLoad = availableLoadsAllPage.isElementPresent("path",availableLoadsAllPage.availableCardMap.get("numberOfLoad" ));
        }
        if (isPresentLoad) {
            Assert.assertThat(Utils.jobTypeList, hasItem(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("jobType"))));
            Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("equipmentType"))));
            //Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("payout")).contains("$"));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("originationAddress")));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("destinationAddress")));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("pickupTime")));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("deliveryTime")));
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoad), "Please try another type of load or let us know what you like and we'll text you loads that match your preferences.");
        }
        availableLoadsAllPage.clickElementByLocator("path", availableLoadsAllPage.allButton);
    }

//    @Test
    public void theFirstLoadOfShortHaul() {
        availableLoadsAllPage.clickElementByLocator("path", availableLoadsAllPage.shortHaulButton);
        boolean isPresentMessage=availableLoadsAllPage.isElementPresent("path",availableLoadsAllPage.shortHaulMile);
        boolean isPresentLoad;
        if(isPresentMessage) {
            isPresentLoad = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.availableCardMap.get("numberOfLoadTwo"));
            if(isPresentLoad){
                availableLoadsAllPage.clickElementByLocator("path", availableLoadsAllPage.allButton);
                availableLoadsAllPage.clickElementByLocator("path", availableLoadsAllPage.shortHaulButton);
            }
        }else{
            isPresentLoad = availableLoadsAllPage.isElementPresent("path",availableLoadsAllPage.availableCardMap.get("numberOfLoad" ));
        }
        if (isPresentLoad) {
            Assert.assertThat(Utils.jobTypeList, hasItem(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("jobType"))));
            Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("equipmentType"))));
            //Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("payout")).contains("$"));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("originationAddress")));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("destinationAddress")));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("pickupTime")));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("deliveryTime")));
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoad), "Please try another type of load or let us know what you like and we'll text you loads that match your preferences.");
        }
        availableLoadsAllPage.clickElementByLocator("path", availableLoadsAllPage.allButton);
    }

//    @Test
    public void theFirstLoadOfLongHaul() {
        availableLoadsAllPage.clickElementByLocator("path", availableLoadsAllPage.longHaulButton);
        boolean isPresentMessage=availableLoadsAllPage.isElementPresent("path",availableLoadsAllPage.longHaulMile);
        boolean isPresentLoad;
        if(isPresentMessage) {
            isPresentLoad = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.availableCardMap.get("numberOfLoadTwo"));
            if(isPresentLoad){
                availableLoadsAllPage.clickElementByLocator("path", availableLoadsAllPage.allButton);
                availableLoadsAllPage.clickElementByLocator("path", availableLoadsAllPage.longHaulButton);
            }
        }else{
            isPresentLoad = availableLoadsAllPage.isElementPresent("path",availableLoadsAllPage.availableCardMap.get("numberOfLoad" ));
        }
        if (isPresentLoad) {
            Assert.assertThat(Utils.jobTypeList, hasItem(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("jobType"))));
            Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("equipmentType"))));
            //Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("payout")).contains("$"));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("originationAddress")));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("destinationAddress")));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("pickupTime")));
            Assert.assertNotNull(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.availableCardMap.get("deliveryTime")));
        } else {
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoad), "Please try another type of load or let us know what you like and we'll text you loads that match your preferences.");
        }
        availableLoadsAllPage.clickElementByLocator("path", availableLoadsAllPage.allButton);

    }

//    @Test
    public void filterPage() throws InterruptedException {
        availableLoadsAllPage.clickElement(availableLoadsAllPage.buttonMap.get("filterButton"));
//        Assert.assertFalse(availableLoadsAllPage.getElement(availableLoadsAllPage.buttonMap.get("reeferRadio")).isSelected());
//        Assert.assertFalse(availableLoadsAllPage.getElement(availableLoadsAllPage.buttonMap.get("dryVanRadio")).isSelected());
//        Assert.assertFalse(availableLoadsAllPage.getElement(availableLoadsAllPage.buttonMap.get("flatbedRadio")).isSelected());
//        Assert.assertFalse(availableLoadsAllPage.getElement(availableLoadsAllPage.buttonMap.get("powerOnlyRadio")).isSelected());
//        Assert.assertFalse(availableLoadsAllPage.getElement(availableLoadsAllPage.buttonMap.get("boxTruckRadio")).isSelected());

        availableLoadsAllPage.clickElement(availableLoadsAllPage.buttonMap.get("powerOnlyRadio"));
        //Assert.assertTrue(availableLoadsAllPage.getElement(availableLoadsAllPage.powerOnlyRadio).isSelected());
        if (availableLoadsAllPage.getElement("path", availableLoadsAllPage.showButton).isEnabled()) {
            availableLoadsAllPage.clickElement(availableLoadsAllPage.showButton);
        } else {
            availableLoadsAllPage.clickElement(availableLoadsAllPage.buttonMap.get("backButton"));
            Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoadAfterFiltering), "Your list is currently filtered so you aren't seeing all of our loads.");
        }
        Assert.assertTrue(availableLoadsAllPage.getTitle("Available").contains("Available"));

        availableLoadsAllPage.clickElement(availableLoadsAllPage.buttonMap.get("filterButton"));
        availableLoadsAllPage.clickElement(availableLoadsAllPage.clearButton);
//        Assert.assertFalse(availableLoadsAllPage.getElement(availableLoadsAllPage.buttonMap.get("powerOnlyRadio")).isSelected());
        if (availableLoadsAllPage.getElement("path", availableLoadsAllPage.showButton).isEnabled()) {
            availableLoadsAllPage.clickElement(availableLoadsAllPage.showButton);
        } else {
            availableLoadsAllPage.clickElement(availableLoadsAllPage.buttonMap.get("backButton"));
        }
        Assert.assertTrue(availableLoadsAllPage.getTitle("Available").contains("Available"));
    }
}
