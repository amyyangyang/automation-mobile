package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.HashMap;

import static org.openqa.selenium.By.xpath;

public class JobDetailPage extends PageProperty {

    private AppiumDriver<MobileElement> driver;

    //public String callButton = "//*[contains(@text, 'ALLOW')]";
    public String bookButton = "(//*[contains(@%s, 'Book Now')])[last()]";
    public String theLoadNumberOfJob = "(//*[contains(@%s,'This job contains')])[last()]";
    public String isBookButton = "(//*[contains(@%s, 'Book Now')])[last()]";
    public By isNotBookButton = xpath("//*[contains(@text, '\uF406')]");
    public String isThisOK = "//*[contains(@%s, 'Is this ok?')]";
    public String booked = "(//*[contains(@%s, \"You're booked!\")])[last()]";

    //button for dispatcher , skip assign driver or assign driver
    public String skipButton = "(//*[contains(@%s,'Skip')])[last()]";
    public String assignOkButton = "(//*[@%s='OK'])[last()]";
    public String driverButton = "//*[contains(@%s, 'test han')]/following-sibling::*[1]";
    public String assignButton = "(//*[@%s='Assign'])[last()]";

    //button for ownerOperator, only go to my loads button and go to available loads button
    public String goToAvailableLoadsButton="(//*[contains(@%s,'Go to Available Loads')])[last()]";
    public String goToMyLoadsButton="(//*[contains(@%s,'Go to My Loads')])[last()]";

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
            jobDetailCard.put("driverButton","//*[contains(@text, 'Assign Driver')]/parent::*[1]/following-sibling::*[1]/*/*/*/*[1]/*/*[2]");
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
            jobDetailCard.put("driverButton","//*[@name='Assign Driver']/following-sibling::*/*/*/*/*/*[1]");
        }

    }

}
