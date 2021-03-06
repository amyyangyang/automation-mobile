package testcases.owneroperator;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.JobDetailPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import com.nexttrucking.automation.mobile.property.Utils;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import property.SetProperty;

import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;
import java.util.HashMap;

import static org.hamcrest.core.IsCollectionContaining.hasItem;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OwnerAvailableTest extends SetProperty {
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
        signInPage.signIn(getTestData("ownerOperatorEmail"), getTestData("ownerOperatorPassword"));
        Thread.sleep(6000);
    }

    @Test
    public void checkAvailableLoadPage() throws InterruptedException {
        if(attributeName.equals("text")){
            Assert.assertTrue(availableLoadsAllPage.getTitle("Available").contains("Available"));
            Thread.sleep(6000);
            boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
            if (isPresentLoad) {
                Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.allButton, 1), "All");
                Assert.assertTrue(Utils.isInteger(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.allNumber)));
                Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.portButton, 1), "Port");
                Assert.assertTrue(Utils.isInteger(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.portNumber)));
                Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.localButton, 1), "Local");
                Assert.assertTrue(Utils.isInteger(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.localNumber)));

                MobileElement cardElement = availableLoadsAllPage.getMobileElementOfFirstCard();
                HashMap cardData = availableLoadsAllPage.getLoadCardData(cardElement);
                Assert.assertThat(Utils.equipmentTypeList, hasItem(cardData.get("equipmentType").toString()));
                Assert.assertTrue(cardData.get("payout").toString().contains("$"));
                int addressCount = Integer.parseInt(cardData.get("addressCount").toString());
                for (int count = 0; count < addressCount; count++) {
                    Assert.assertNotNull(cardData.get("address" + count).toString());
                }
                int timeCount = Integer.parseInt(cardData.get("timeCount").toString());
                for (int count = 0; count < timeCount; count++) {
                    Assert.assertNotNull(cardData.get("time" + count).toString());
                }

                Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.shortHaulButton, 1), "Short Haul");
                availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.shortHaulButton);
                Assert.assertTrue(Utils.isInteger(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.shortHaulNumber)));
                Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.longHaulButton, 1), "Long Haul");
                Assert.assertTrue(Utils.isInteger(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.longHaulNumber)));
                availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.localButton);
                Thread.sleep(10000);
                availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.portButton);
                Thread.sleep(10000);
                availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.allButton);
                Thread.sleep(10000);
            } else {
                Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoadAllType).contains("All of our loads have been taken"));
            }
        }
    }

    @Test
    public void checkSecondLoadOfAll() {
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
        if (isPresentLoad) {
            int size = availableLoadsAllPage.driver.findElementsByXPath(availableLoadsAllPage.availableCardMap.get("numberOfLoad")).size();
            if (size > 1) {
                availableLoadsAllPage.swipeToUpForAndroid();
                MobileElement cardElement = availableLoadsAllPage.getMobileElementOfFirstCard();
                HashMap cardData = availableLoadsAllPage.getLoadCardData(cardElement);
                Assert.assertThat(Utils.equipmentTypeList, hasItem(cardData.get("equipmentType").toString()));
                Assert.assertTrue(cardData.get("payout").toString().contains("$"));
                int addressCount = Integer.parseInt(cardData.get("addressCount").toString());
                for (int count = 0; count < addressCount; count++) {
                    Assert.assertNotNull(cardData.get("address" + count).toString());
                }
                int timeCount = Integer.parseInt(cardData.get("timeCount").toString());
                for (int count = 0; count < timeCount; count++) {
                    Assert.assertNotNull(cardData.get("time" + count).toString());
                }
            }
        } else {
            Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoadAllType).contains("All of our loads have been taken"));
        }
    }

    @Test
    public void checkFirstLoadOfLocal() throws InterruptedException {
        if(attributeName.equals("text")){
            boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
            if (isPresentLoad) {
                availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.localButton);
                Thread.sleep(10000);
                boolean isPresentLocalLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
                if (isPresentLocalLoad) {
                    MobileElement cardElement = availableLoadsAllPage.getMobileElementOfFirstCard();
                    HashMap cardData = availableLoadsAllPage.getLoadCardData(cardElement);
                    Assert.assertThat(Utils.equipmentTypeList, hasItem(cardData.get("equipmentType").toString()));
                    Assert.assertTrue(cardData.get("payout").toString().contains("$"));
                    int addressCount = Integer.parseInt(cardData.get("addressCount").toString());
                    for (int count = 0; count < addressCount; count++) {
                        Assert.assertNotNull(cardData.get("address" + count).toString());
                    }
                    int timeCount = Integer.parseInt(cardData.get("timeCount").toString());
                    for (int count = 0; count < timeCount; count++) {
                        Assert.assertNotNull(cardData.get("time" + count).toString());
                    }
                } else {
                    Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoad), "Please try another type of load or let us know what you like and we'll text you loads that match your preferences.");
                }
                availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.allButton);
                Thread.sleep(10000);
            } else {
                Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoadAllType).contains("All of our loads have been taken"));
            }
        }
    }

    @Test
    public void checkFirstLoadOfShortHaul() throws InterruptedException {
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
        if (isPresentLoad) {
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.shortHaulButton);
            Thread.sleep(5000);
            boolean isPresentShortHaulLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
            if (isPresentShortHaulLoad) {
                MobileElement cardElement = availableLoadsAllPage.getMobileElementOfFirstCard();
                HashMap cardData = availableLoadsAllPage.getLoadCardData(cardElement);
                Assert.assertThat(Utils.equipmentTypeList, hasItem(cardData.get("equipmentType").toString()));
                Assert.assertTrue(cardData.get("payout").toString().contains("$"));
                int addressCount = Integer.parseInt(cardData.get("addressCount").toString());
                for (int count = 0; count < addressCount; count++) {
                    Assert.assertNotNull(cardData.get("address" + count).toString());
                }
                int timeCount = Integer.parseInt(cardData.get("timeCount").toString());
                for (int count = 0; count < timeCount; count++) {
                    Assert.assertNotNull(cardData.get("time" + count).toString());
                }
            } else {
                Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoad), "Please try another type of load or let us know what you like and we'll text you loads that match your preferences.");
            }
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.localButton);
            Thread.sleep(10000);
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.portButton);
            Thread.sleep(10000);
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.allButton);
            Thread.sleep(10000);
        } else {
            Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoadAllType).contains("All of our loads have been taken"));
        }
    }

    @Test
    public void checkFirstLoadOfLongHaul() throws InterruptedException {
        if(attributeName.equals("text")){
            boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
            if (isPresentLoad) {
                availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.shortHaulButton);
                Thread.sleep(3000);
                availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.longHaulButton);
                Thread.sleep(10000);
                boolean isPresentLongHaulLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
                if (isPresentLongHaulLoad) {
                    MobileElement cardElement = availableLoadsAllPage.getMobileElementOfFirstCard();
                    HashMap cardData = availableLoadsAllPage.getLoadCardData(cardElement);
                    Assert.assertThat(Utils.equipmentTypeList, hasItem(cardData.get("equipmentType").toString()));
                    Assert.assertTrue(cardData.get("payout").toString().contains("$"));
                    int addressCount = Integer.parseInt(cardData.get("addressCount").toString());
                    for (int count = 0; count < addressCount; count++) {
                        Assert.assertNotNull(cardData.get("address" + count).toString());
                    }
                    int timeCount = Integer.parseInt(cardData.get("timeCount").toString());
                    for (int count = 0; count < timeCount; count++) {
                        Assert.assertNotNull(cardData.get("time" + count).toString());
                    }
                } else {
                    Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoad), "Please try another type of load or let us know what you like and we'll text you loads that match your preferences.");
                }
                availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.localButton);
                Thread.sleep(10000);
                availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.allButton);
                Thread.sleep(10000);
            } else {
                Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoadAllType).contains("All of our loads have been taken"));
            }
        }
    }

    @Test
    public void filterLoadPage() throws InterruptedException {
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
        if (isPresentLoad) {
            availableLoadsAllPage.clickElement(availableLoadsAllPage.buttonMap.get("filterButton"));
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
        } else {
            Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoadAllType).contains("All of our loads have been taken"));
        }
    }

    @Test
    public void checkLoadDetail() throws InterruptedException {
        Boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
        if (isPresentLoad) {
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.equipmentType);
            Thread.sleep(3000);
            Boolean isTrips = jobDetailPage.isElementPresent("xpath", jobDetailPage.isTrips);
            if (isTrips) {
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.getTextInAddress, 0));
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.getTextInAddress, 1));
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.getTextInTime, 0));
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.getTextInTime, 1));
                Boolean isLiveOnLoad = jobDetailPage.isElementPresent("id", jobDetailPage.liveLoadAddress);
                if (isLiveOnLoad) {
                    Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.getTextInAddress, 2));
                    jobDetailPage.swipeForAnyPlatform();
                    Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.getTextInTime, 2));
                }
            } else {
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.getTextInAddress, 0));
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.getTextInAddress, 1));
                boolean isLegacy = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.pickupTime);
                if (isLegacy) {
                    Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.pickupTime));
                    Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.deliveryTime));
                } else {
                    Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.getTextInTime, 0));
                    Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.getTextInTime, 1));
                }
            }
            jobDetailPage.swipeForAnyPlatform();
            jobDetailPage.swipeForAnyPlatform();
            Assert.assertThat(Utils.equipmentTypeListOnDetail, hasItem(jobDetailPage.getElementText("id", jobDetailPage.equipment)));
            Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.distance));
            //Assert.assertTrue(pageProperty.isTextPresent("Specifications"));
            Assert.assertTrue(pageProperty.isTextPresent("You'll make"));
            Assert.assertTrue(pageProperty.isTextPresent("Book Now"));
            Assert.assertTrue(pageProperty.isTextPresent("$"));
            jobDetailPage.clickElementByLocator("path", jobDetailPage.jobDetailCard.get("backButton"));
        } else {
            Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoadAllType).contains("All of our loads have been taken"));
        }
    }
}
