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

    public String localButton = "//*[contains(@%s,'Local')]";
    public String shortHaulButton = "//*[contains(@%s,'Short Haul')]";
    public String longHaulButton = "//*[contains(@%s,'Long Haul')]";
    public String allButton = "//*[contains(@%s,'All')]";

    public String shortHaulNumber = "//*[contains(@%s, 'Short Haul')]/following-sibling::*[1]/child::*[1]";
    public String longHaulNumber = "//*[contains(@%s, 'Long Haul')]/following-sibling::*[1]/child::*[1]";
    public String localNumber = "//*[contains(@%s, 'Local')]/following-sibling::*[1]/child::*[1]";
    public String allNumber = "//*[contains(@%s, 'All')]/following-sibling::*[1]/child::*[1]";

    public Map<String, String> buttonMap;
    public Map<String, String> availableCardMap;
    public String longHaulMile = "//*[contains(@%s,'Loads that are 250 mi or more')]";
    public String shortHaulMile = "//*[contains(@%s,'Loads between 100 - 150 mi')]";
    public String localHaulMile = "//*[contains(@%s,'Loads that are less than 100 mi')]";
    public String clearButton = "(//*[contains(@%s,'Clear')])[last()]";
    public String showButton = "(//*[contains(@%s,'Show')])[last()]";
    public String noLoad = "(//*[contains(@%s,'Please try another type of load')])[last()]";
    public String noLoadAfterFiltering = "(//*[contains(@%s,'Your list is currently filtered so you aren't seeing all of our loads.')])[last()]";

    public AvailableLoadsAllPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
        buttonMap = new HashMap<>();
        availableCardMap=new HashMap<>();
        if (attributeName.equals("text")) {
            buttonMap.put("filterButton", "//*[contains(@text,'\uF182')]");
            buttonMap.put("backButton", "//*[contains(@text,'\uF406')]");
            buttonMap.put("dryVanRadio", "//*[contains(@text, 'Dry Van')]/following-sibling::*[1]/child::*[1]");
            buttonMap.put("reeferRadio", "//*[contains(@text, 'Reefer')]/following-sibling::*[1]/child::*[1]");
            buttonMap.put("flatbedRadio", "//*[contains(@text, 'Flatbed')]/following-sibling::*[1]/child::*[1]");
            buttonMap.put("powerOnlyRadio", "//*[contains(@text, 'Power Only')]/following-sibling::*[1]/child::*[1]");
            buttonMap.put("boxTruckRadio", "//*[contains(@text, 'Box Truck')]/following-sibling::*[1]/child::*[1]");
            availableCardMap.put("jobType","//*[contains(@content-desc, 'available_view_list')]/child::*[1]/child::*[1]/child::*[1]/child::*[1]/child::*[1]");
            availableCardMap.put("equipmentType","//*[contains(@content-desc, 'available_view_list')]/child::*[1]/child::*[1]/child::*[1]/child::*[2]");
            availableCardMap.put("originationAddress","//*[contains(@content-desc, 'available_view_list')]/child::*[1]/child::*[1]/child::*[1]/child::*[6]");
            availableCardMap.put("destinationAddress","//*[contains(@content-desc, 'available_view_list')]/child::*[1]/child::*[1]/child::*[1]/child::*[11]");
            availableCardMap.put("pickupTime","//*[contains(@content-desc, 'available_view_list')]/child::*[1]/child::*[1]/child::*[1]/child::*[8]");
            availableCardMap.put("deliveryTime","//*[contains(@content-desc, 'available_view_list')]/child::*[1]/child::*[1]/child::*[1]/child::*[13]");
            availableCardMap.put("payout","//*[contains(@content-desc, 'available_view_list')]/child::*[1]/child::*[1]/child::*[1]/child::*[3]");
            availableCardMap.put("numberOfLoad","//*[contains(@content-desc, 'available_view_list')]/child::*[1]/child::*[1]/child::*[1]/child::*[1]/child::*[1]");
            availableCardMap.put("numberOfLoadTwo","//*[contains(@content-desc, 'available_view_list')]/child::*[1]/child::*[2]/child::*[1]/child::*[1]/child::*[1]");
        } else {
            buttonMap.put("filterButton", "//XCUIElementTypeStaticText[@name=\"\uF182\"]");
            buttonMap.put("backButton", "//XCUIElementTypeStaticText[@name=\"\uF406\"]");
            buttonMap.put("dryVanRadio", "(//*[contains(@name, 'Dry Van')])[last()]");
            buttonMap.put("reeferRadio", "(//*[contains(@name, 'Reefer')])[last()]");
            buttonMap.put("flatbedRadio", "(//*[contains(@name, 'Flatbed')])[last()]");
            buttonMap.put("powerOnlyRadio", "(//*[contains(@name, 'Power Only')])[last()]");
            buttonMap.put("boxTruckRadio", "(//*[contains(@name, 'Box Truck')])[last()]");
            availableCardMap.put("jobType","//*[contains(@name, 'available_view_list')]/child::*[1]/child::*[1]/child::*[1]/child::*[1]/child::*[1]");
            availableCardMap.put("equipmentType","//*[contains(@name, 'available_view_list')]/child::*[1]/child::*[1]/child::*[1]/child::*[2]");
            availableCardMap.put("originationAddress","//*[contains(@name, 'available_view_list')]/child::*[1]/child::*[1]/child::*[1]/child::*[6]");
            availableCardMap.put("destinationAddress","//*[contains(@name, 'available_view_list')]/child::*[1]/child::*[1]/child::*[1]/child::*[11]");
            availableCardMap.put("pickupTime","//*[contains(@name, 'available_view_list')]/child::*[1]/child::*[1]/child::*[1]/child::*[8]");
            availableCardMap.put("deliveryTime","//*[contains(@name, 'available_view_list')]/child::*[1]/child::*[1]/child::*[1]/child::*[13]");
            availableCardMap.put("payout","//*[contains(@name, 'available_view_list')]/child::*[1]/child::*[1]/child::*[1]/child::*[3]");
            availableCardMap.put("numberOfLoad","//*[contains(@name, 'available_view_list')]/child::*[1]/child::*[1]/child::*[1]/child::*[1]/child::*[1]");
            availableCardMap.put("numberOfLoadTwo","//*[contains(@name, 'available_view_list')]/child::*[1]/child::*[2]/child::*[1]/child::*[1]/child::*[1]");

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

