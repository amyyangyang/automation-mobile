package testcases.owneroperator;

import com.nexttrucking.automation.mobile.aguest.SignInPage;
import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.dispatcher.AvailableLoadsAllPage;
import com.nexttrucking.automation.mobile.dispatcher.JobDetailPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import com.nexttrucking.automation.mobile.property.Utils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import property.SetProperty;
import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;

import static org.hamcrest.core.IsCollectionContaining.hasItem;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OwnerAvailableTest extends SetProperty {
    public static JobDetailPage jobDetailPage;

    @BeforeClass
    public static void setUp() throws MalformedURLException, InterruptedException, ParserConfigurationException {
        setUpDriver();
        pageProperty = new PageProperty(driver, attributeName) {};
        availableLoadsAllPage = new AvailableLoadsAllPage(driver, attributeName);
        allowLocationPage = new AllowLocationPage(driver, attributeName);
        welcomePage = new WelcomePage(driver, attributeName);
        signInPage = new SignInPage(driver, attributeName);
        jobDetailPage = new JobDetailPage(driver, attributeName);
        signInPage.signIn(getTestData("ownerOperatorEmail"), getTestData("ownerOperatorPassword"));
    }

    @Test
    public void checkAvailableLoadPage() throws InterruptedException {
        Assert.assertTrue(availableLoadsAllPage.getTitle("Available").contains("Available"));
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
        if (isPresentLoad) {
            Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.allButton, 1), "All");
            Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.localButton, 1), "Local");
            Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.shortHaulButton, 1), "Short Haul");
            Assert.assertEquals(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.longHaulButton, 1), "Long Haul");
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
            Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoadAllType).contains("All of our loads have been taken"));
        }
    }

    @Test
    public void checkSecondLoadOfAll() {
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
        if (isPresentLoad) {
            int size = availableLoadsAllPage.driver.findElementsByXPath(availableLoadsAllPage.availableCardMap.get("numberOfLoad")).size();
            if (size > 1) {
                //availableLoadsAllPage.swipeToUpForAndroid();
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
    public void checkFirstLoadOfLocal()throws InterruptedException {
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
        if (isPresentLoad) {
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.localButton);
            boolean isPresentMessage = availableLoadsAllPage.isElementPresent("path", availableLoadsAllPage.localHaulMile);
            if (isPresentMessage) {
                availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.allButton);
                availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.localButton);
                Thread.sleep(3000);
            }
            boolean isPresentLocalLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
            if (isPresentLocalLoad) {
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
        }else {
            Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoadAllType).contains("All of our loads have been taken"));
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
                Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.equipmentType)));
                Assert.assertTrue(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.payout).contains("$"));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.originationAddress));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.destinationAddress));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.pickupTime));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.deliveryTime));
            } else {
                Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoad), "Please try another type of load or let us know what you like and we'll text you loads that match your preferences.");
            }
            availableLoadsAllPage.clickMenuButtonFirstLevel("Available Loads");
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.allButton);
        }else {
            Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoadAllType).contains("All of our loads have been taken"));
        }
    }

    @Test
    public void checkFirstLoadOfLongHaul() throws InterruptedException{
        boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
        if (isPresentLoad) {
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.longHaulButton);
            Thread.sleep(5000);
            boolean isPresentLongHaulLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
            if (isPresentLongHaulLoad) {
                Assert.assertThat(Utils.equipmentTypeList, hasItem(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.equipmentType)));
                Assert.assertTrue(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.payout).contains("$"));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.originationAddress));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.destinationAddress));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.pickupTime));
                Assert.assertNotNull(availableLoadsAllPage.getElementText("id", availableLoadsAllPage.deliveryTime));
            } else {
                Assert.assertEquals(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoad), "Please try another type of load or let us know what you like and we'll text you loads that match your preferences.");
            }
            availableLoadsAllPage.clickMenuButtonFirstLevel("Available Loads");
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.allButton);
        }else {
            Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoadAllType).contains("All of our loads have been taken"));
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
        }else {
            Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoadAllType).contains("All of our loads have been taken"));
        }
    }

    @Test
    public void checkLoadDetail() throws InterruptedException {
        Boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
        if (isPresentLoad) {
            availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.equipmentType);
            Boolean isTrips = jobDetailPage.isElementPresent("xpath", jobDetailPage.isTrips);
            if (isTrips) {
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.originationAddress));
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.destinationAddress));
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.pickupTime));
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.deliveryTime));
                Boolean isLiveOnLoad=jobDetailPage.isElementPresent("id",jobDetailPage.liveLoadAddress);
                if(isLiveOnLoad)
                {
                    Assert.assertNotNull(jobDetailPage.getElementText("id",jobDetailPage.liveLoadAddress));
                    jobDetailPage.swipeForAnyPlatform();
                    Assert.assertNotNull(jobDetailPage.getElementText("id",jobDetailPage.liveLoadTime));
                }
            }else{
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.originationAddress));
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.destinationAddress));
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.pickupTime));
                Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.deliveryTime));
            }
            jobDetailPage.swipeForAnyPlatform();
            jobDetailPage.swipeForAnyPlatform();
            Assert.assertThat(Utils.equipmentTypeListOnDetail, hasItem(jobDetailPage.getElementText("id", jobDetailPage.equipment)));
            Assert.assertNotNull(jobDetailPage.getElementText("id", jobDetailPage.distance));
            jobDetailPage.clickElementByLocator("path", jobDetailPage.jobDetailCard.get("backButton"));
        }
    }
    @Test
    public void bookLiveUnLoadJobOnly() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Boolean isPresentException=true;
            int loop=0;
            do {
                ++loop;
                Boolean isPresentLoad = availableLoadsAllPage.isElementPresent("id", availableLoadsAllPage.originationAddress);
                if (isPresentLoad) {
                    availableLoadsAllPage.findLiveUnloadJob();
                    availableLoadsAllPage.clickElementByLocator("id", availableLoadsAllPage.liveLoadAddress);
                    jobDetailPage.clickElementByLocator("path", jobDetailPage.bookButton);
                    Thread.sleep(3000);
                    jobDetailPage.bookTender();
                    isPresentException = availableLoadsAllPage.isElementPresent("path", jobDetailPage.goToMyLoadsButton);
                    if (isPresentException) {
                        Assert.assertTrue(jobDetailPage.getElementText("path", jobDetailPage.booked).contains("You're booked!"));
                        jobDetailPage.goToMyLoadsOrAvailableLoadsPage(jobDetailPage.goToMyLoadsButton);
                    } else {
                        jobDetailPage.goToMyLoadsOrAvailableLoadsPage(jobDetailPage.goToAvailableLoadsButton);
                        continue;
                    }
                    availableLoadsAllPage.clickMenuButtonFirstLevel("Available Loads");
                }
            }while((!isPresentException)&&(loop<3));
        }
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
            Assert.assertTrue(availableLoadsAllPage.getElementText("path", availableLoadsAllPage.noLoadAllType).contains("All of our loads have been taken"));
        }
    }


}
