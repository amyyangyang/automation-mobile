package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.property.PageProperty;
import com.nexttrucking.automation.mobile.property.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.util.HashMap;

import static org.openqa.selenium.By.xpath;

public class JobDetailPage extends PageProperty {

    //public String callButton = "//*[contains(@text, 'ALLOW')]";
    public String bookButton = "(//*[contains(@%s, 'Book Now')])[last()]";
    public String theLoadNumberOfJob = "(//*[contains(@%s,'This job contains')])[last()]";
    public String isBookButton = "(//*[contains(@%s, 'Book Now')])[last()]";
    public By isNotBookButton = xpath("//*[contains(@text, '\uF406')]");
    public String isThisOK = "//*[contains(@%s, 'Is this ok?')]";
    public String booked = "(//*[contains(@%s, \"You're booked!\")])[last()]";
    public String isTrips = "//*[contains(@%s, 'Container')]";

    //button for dispatcher , skip assign driver or assign driver
    public String skipButton = "(//*[contains(@%s,'Skip')])[last()]";
    public String assignOkButton = "(//*[@%s='OK'])[last()]";
    public String driverButton = "//*[contains(@%s, 'Test Test')]/following-sibling::*[1]";
    public String assignButton = "(//*[@%s='Assign'])[last()]";

    //button for ownerOperator, only go to my loads button and go to available loads button
    public String refreshButton = "(//*[contains(@%s,\"Refresh Now\")])[last()]";
    public String goToAvailableLoadsButton = "(//*[contains(@%s,'Go to Available Loads')])[last()]";
    public String goToMyLoadsButton = "(//*[contains(@%s,'Go to My Loads')])[last()]";
    public String somethingIsWrong = "(//*[contains(@%s,\"thing\")])[last()]";
    public String[] liveUnloadAddress = {"address_0", "address_1", "address_2"};
    public String[] liveUnloadTime = {"time_0", "time_1", "time_2"};

    public String originationAddress = "address_0";
    public String destinationAddress = "address_1";
    public String liveLoadAddress = "address_2";
    public String liveLoadTime = "time_2";
    public String pickupTime = "time_0";
    public String deliveryTime = "time_1";
    public String jobStatus = "";
    public String payment = "";
    public String getTextInAddress = "textGroupValue_1";
    public String getTextInTime = "textGroupValue_0";

    public String equipment = "Equipment_value";
    public String distance = "Total Distance_key";
    public String packaging = "Packaging_value";
    public String weight = "Weight_value";
    public String container = "";
    public String specification = "";
    public String commodity = "";

    public HashMap<String, String> jobDetailCard;

    public JobDetailPage(AppiumDriver<MobileElement> driver, String attributeNme) {
        super(driver, attributeNme);
        jobDetailCard = new HashMap<>();
        if (attributeNme.equals("text")) {
            jobDetailCard.put("originationAddress", "//*[@class='android.widget.ScrollView']/child::*[1]/child::*[4]");
            jobDetailCard.put("destinationAddress", "//*[@class='android.widget.ScrollView']/child::*[1]/child::*[9]");
            jobDetailCard.put("pickupTime", "//*[@class='android.widget.ScrollView']/child::*[1]/child::*[6]");
            jobDetailCard.put("deliveryTime", "//*[@class='android.widget.ScrollView']/child::*[1]/child::*[11]");
            jobDetailCard.put("loadOfTwo", "//*[@class='android.widget.ScrollView']/child::*[1]/child::*[3]/child::*[1]");
            jobDetailCard.put("payoutOfTwo", "//*[@class='android.widget.ScrollView']/child::*[1]/child::*[3]/child::*[2]");
            jobDetailCard.put("originationAddressOfTwo", "//*[@class='android.widget.ScrollView']/child::*[1]/child::*[3]/child::*[5]");
            jobDetailCard.put("destinationAddressOfTwo", "//*[@class='android.widget.ScrollView']/child::*[1]/child::*[3]/child::*[10]");
            jobDetailCard.put("pickupTimeOfTwo", "//*[@class='android.widget.ScrollView']/child::*[1]/child::*[3]/child::*[7]");
            jobDetailCard.put("deliveryTimeOfTwo", "//*[@class='android.widget.ScrollView']/child::*[1]/child::*[3]/child::*[12]");
            jobDetailCard.put("equipment", "//*[contains(@text, 'Equipment')]/following-sibling::*[3]");
            jobDetailCard.put("packaging", "//*[contains(@text, 'Packaging')]/following-sibling::*[3]");
            jobDetailCard.put("weight", "//*[contains(@text, 'Weight')]/following-sibling::*[3]");
            jobDetailCard.put("distance", "//*[contains(@text, 'Total Distance')]/following-sibling::*[1]");
            jobDetailCard.put("commodity", "//*[contains(@text, 'Commodity')]/following-sibling::*[1]");
            jobDetailCard.put("specification", "//*[contains(@text, 'Specification')]/following-sibling::*[3]");
            jobDetailCard.put("backButton", "//*[contains(@text, '\uF3CF')]");
            jobDetailCard.put("driverButton", "//*[contains(@text, 'Assign Driver')]/parent::*[1]/following-sibling::*[1]/*/*/*/*[1]/*/*[2]");
            jobDetailCard.put("driver", "//*[contains(@text, 'Test Test')]/following-sibling::*[1]");
            jobDetailCard.put("liveUnloadJobStatus", "//android.widget.FrameLayout[last()]/following-sibling::*[1]/*[1]");
        } else {
            jobDetailCard.put("originationAddress", "//XCUIElementTypeScrollView/child::*[1]/child::*[2]/child::*[1]/child::*[1]/child::*[1]/child::*[2]/child::*[1]");
            jobDetailCard.put("destinationAddress", "//XCUIElementTypeScrollView/child::*[1]/child::*[2]/child::*[1]/child::*[1]/child::*[1]/child::*[2]/child::*[2]");
            jobDetailCard.put("pickupTime", "//XCUIElementTypeScrollView/child::*[1]/child::*[2]/child::*[1]/child::*[1]/child::*[2]/child::*[2]/child::*[1]");
            jobDetailCard.put("deliveryTime", "//XCUIElementTypeScrollView/child::*[1]/child::*[2]/child::*[1]/child::*[1]/child::*[2]/child::*[2]/child::*[2]");
            jobDetailCard.put("loadOfTwo", "//XCUIElementTypeScrollView/child::*[1]/child::*[2]/child::*[1]/child::*[1]/child::*[1]");
            jobDetailCard.put("payoutOfTwo", "//XCUIElementTypeScrollView/child::*[1]/child::*[2]/child::*[1]/child::*[1]/child::*[2]");
            jobDetailCard.put("originationAddressOfTwo", "//XCUIElementTypeScrollView/child::*[1]/child::*[2]/child::*[1]/child::*[2]/child::*[1]/child::*[2]/child::*[1]");
            jobDetailCard.put("destinationAddressOfTwo", "//XCUIElementTypeScrollView/child::*[1]/child::*[2]/child::*[1]/child::*[2]/child::*[1]/child::*[2]/child::*[2]");
            jobDetailCard.put("pickupTimeOfTwo", "//XCUIElementTypeScrollView/child::*[1]/child::*[2]/child::*[1]/child::*[2]/child::*[2]/child::*[2]/child::*[1]");
            jobDetailCard.put("deliveryTimeOfTwo", "//XCUIElementTypeScrollView/child::*[1]/child::*[2]/child::*[1]/child::*[2]/child::*[2]/child::*[2]/child::*[2]");
            jobDetailCard.put("equipment", "//*[@name='Equipment']/following-sibling::*[1]");
            jobDetailCard.put("packaging", "//*[@name='Packaging']/following-sibling::*[1]");
            jobDetailCard.put("weight", "//*[@name='Weight']/following-sibling::*[1]");
            jobDetailCard.put("distance", "//*[@name='Total Distance']/following-sibling::*[1]");
            jobDetailCard.put("commodity", "//*[@name='Commodity']/following-sibling::*[1]");
            jobDetailCard.put("specification", "//*[@name='Specifications']/parent::*[1]/following-sibling::*[1]/child::*[1]/child::*[2]");
            jobDetailCard.put("backButton", "//XCUIElementTypeStaticText[@name=\"\uF3CF\"]");
            jobDetailCard.put("driverButton", "//*[@name='Assign Driver']/following-sibling::*/*/*/*/*/*[1]");
            jobDetailCard.put("liveUnloadJobStatus", "(//XCUIElementTypeStaticText)[3]");
            jobDetailCard.put("driver", "(//*[contains(@name, 'Test Test')])[last()]");
        }

    }

    public void bookTender() throws InterruptedException {
        if (attributeName.equals("text")) {
            clickElementByLocator("path", isBookButton);
        } else {
            new TouchAction(driver).tap(PointOption.point(190, 750)).perform();
        }
        Thread.sleep(3000);
    }

    public Boolean assignDriver(String driverElement) throws InterruptedException {
        if (attributeName.equals("text")) {
            clickElementByLocator("path", assignOkButton);
        } else {
            new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
        }
        Thread.sleep(3000);
        clickElementByLocator("path", driverElement);
        clickElementByLocator("path", assignButton);
        Thread.sleep(3000);
        Boolean isPresentException = isElementPresent("path", somethingIsWrong);
        if (isPresentException) {
            if (attributeName.equals("text")) {
                clickElementByLocator("path", assignOkButton);
            } else {
                new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
            }
            return true;
        }
        return false;
    }

    public void assignDriver() throws InterruptedException {
        assignDriver(jobDetailCard.get("driverButton"));
    }

    public void skipAssignDriver() throws InterruptedException {
        if (attributeName.equals("text")) {
            clickElementByLocator("path", skipButton);
        } else {
            new TouchAction(driver).tap(PointOption.point(95, 750)).perform();
        }
        Thread.sleep(3000);
    }

    public void goToMyLoadsOrAvailableLoadsPage(String element) throws InterruptedException {
        if (attributeName.equals("text")) {
            clickElementByLocator("path", element);
        } else {
            new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
        }
        //Thread.sleep(3000);
    }

    public boolean checkBookJobForErrors() throws InterruptedException {
        boolean isPresentAvailableLoadButton = isElementPresent("path", goToAvailableLoadsButton);
        if (isPresentAvailableLoadButton) {
            if (attributeName.equals("text")) {
                clickElementByLocator("path", goToAvailableLoadsButton);
            } else {
                new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
            }
        }
        Thread.sleep(3000);
        swipeForAnyPlatform();
        return isPresentAvailableLoadButton;
    }

    public boolean isLiveUnloadJobStatusCorrect() {
        boolean correctStatus = false;
        String paymentStatus = getElementText("path", jobDetailCard.get("liveUnloadJobStatus"));
        for (int i = 0; i < 2; i++) {
            if (paymentStatus.contains(Utils.liveUnloadJobStatus.get(i))) {
                correctStatus = true;
            }
        }
        return correctStatus;
    }

}
