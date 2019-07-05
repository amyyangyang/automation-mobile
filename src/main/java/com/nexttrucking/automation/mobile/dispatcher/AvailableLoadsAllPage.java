package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AvailableLoadsAllPage extends PageProperty {


    private String title = "(//*[contains(@%1$s, \"%2$s\")])[last()]";
    private String menuButtonIOS = "(//XCUIElementTypeStaticText)[1]";
    private String menuButtonAndroid = "//*[@%s='\uF1C3']";
    private String menuNameButton = "(//*[contains(@%1$s, \"%2$s\")])[last()]";
    private String confirmLogOutButton = "(//*[contains(@%s, 'Yes')])[last()]";

    public String localButton = "LOCAL";
    public String shortHaulButton = "SHORT_HAUL";
    public String longHaulButton = "LONG_HAUL";
    public String allButton = "ALL";

    public String shortHaulNumber = "//*[contains(@%s, 'Short Haul')]/following-sibling::*[1]/child::*[1]";
    public String longHaulNumber = "//*[contains(@%s, 'Long Haul')]/following-sibling::*[1]/child::*[1]";
    public String localNumber = "//*[contains(@%s, 'Local')]/following-sibling::*[1]/child::*[1]";
    public String allNumber = "//*[contains(@%s, 'All')]/following-sibling::*[1]/child::*[1]";

    public String jobType = "job_action";
    public String equipmentType = "job_equipmentType";
    public String originAddress = "origination_address";
    public String destinationAddress = "origination_date";
    public String pickupTime = "destination_address";
    public String deliveryTime = "destination_date";
    public String payout = "job_price";

    public Map<String, String> buttonMap;
    public String clearButton = "(//*[contains(@%s,'Clear')])[last()]";
    public String showButton = "(//*[contains(@%s,'Show')])[last()]";
    public String noLoad = "(//*[contains(@%s,'Please try another type of load')])[last()]";
    public String noLoadAfterFiltering = "(//*[contains(@%s,'Your list is currently filtered so you aren't seeing all of our loads.')])[last()]";

    public AvailableLoadsAllPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
        buttonMap = new HashMap<>();
        if (attributeName.equals("text")) {
            buttonMap.put("filterButton", "//*[contains(@text,'\uF182')]");
            buttonMap.put("backButton", "//*[contains(@text,'\uF406')]");
            buttonMap.put("dryVanRadio", "//*[contains(@text, 'Dry Van')]/following-sibling::*[1]/child::*[1]");
            buttonMap.put("reeferRadio", "//*[contains(@text, 'Reefer')]/following-sibling::*[1]/child::*[1]");
            buttonMap.put("flatbedRadio", "//*[contains(@text, 'Flatbed')]/following-sibling::*[1]/child::*[1]");
            buttonMap.put("powerOnlyRadio", "//*[contains(@text, 'Power Only')]/following-sibling::*[1]/child::*[1]");
            buttonMap.put("boxTruckRadio", "//*[contains(@text, 'Box Truck')]/following-sibling::*[1]/child::*[1]");
        } else {
            buttonMap.put("filterButton", "//XCUIElementTypeStaticText[@name=\"\uF182\"]");
            buttonMap.put("backButton", "//XCUIElementTypeStaticText[@name=\"\uF406\"]");
            buttonMap.put("dryVanRadio", "(//*[contains(@name, 'Dry Van')])[last()]");
            buttonMap.put("reeferRadio", "(//*[contains(@name, 'Reefer')])[last()]");
            buttonMap.put("flatbedRadio", "(//*[contains(@name, 'Flatbed')])[last()]");
            buttonMap.put("powerOnlyRadio", "(//*[contains(@name, 'Power Only')])[last()]");
            buttonMap.put("boxTruckRadio", "(//*[contains(@name, 'Box Truck')])[last()]");
        }
    }

    public String getTitle(String titleText) {
        return getText(title, titleText);
    }

    public void clickMenuButtonFirstLevel(String menuName) throws InterruptedException {
        if (attributeName.equals("text")) {
            clickElement(menuButtonAndroid);
        } else driver.findElement(By.xpath(menuButtonIOS)).click();
        Thread.sleep(3000);
        clickMenu(menuNameButton, menuName);
        Thread.sleep(3000);
    }

    public void clickMenuButtonSecondLevel(String menuName) throws InterruptedException {
        clickMenu(menuNameButton, menuName);
        Thread.sleep(3000);
    }

    public WelcomePage confirmLogout() throws InterruptedException {
        if (attributeName.equals("text")) {
            clickElement(confirmLogOutButton);
        } else if (attributeName.equals("name")) {
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(PointOption.point(270, 600)).perform();
        }
        Thread.sleep(3000);
        return new WelcomePage(driver, attributeName);
    }

}

