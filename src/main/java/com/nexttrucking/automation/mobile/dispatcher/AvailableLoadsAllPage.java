package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;


public class AvailableLoadsAllPage extends PageProperty {


    private String title = "(//*[contains(@%1$s, \"%2$s\")])[last()]";
    private String menuButtonIOS = "(//XCUIElementTypeStaticText)[1]";
    private String menuButtonAndroid = "//*[@%s='\uF1C3']";
    private String menuNameButton = "(//*[contains(@%1$s, \"%2$s\")])[last()]";
    private String confirmLogOutButton = "(//*[contains(@%s, 'Yes')])[last()]";

    public String localButton = "(//*[contains(@%s, 'Local')])[last()]";
    public String shortHaulButton = "(//*[contains(@%s, 'Short Haul')])[last()]";
    public String longHaulButton = "(//*[contains(@%s, 'Long Haul')])[last()]";
    public String allButton = "(//*[contains(@%s, 'All')])[last()]";

    public String shortHaulNumber = "//*[contains(@text, 'Short Haul')]/following-sibling::*[1]/child::*[1]";
    public String longHaulNumber = "//*[contains(@text, 'Long Haul')]/following-sibling::*[1]/child::*[1]";
    public String localNumber = "//*[contains(@text, 'Local')]/following-sibling::*[1]/child::*[1]";
    public String allNumber = "//*[contains(@text, 'All')]/following-sibling::*[1]/child::*[1]";

    public String jobType = "job_action";
    public String equipmentType = "job_equipmentType";
    public String originAddress = "origination_address";
    public String destinationAddress = "origination_date";
    public String pickupTime = "destination_address";
    public String deliveryTime = "destination_date";
    public String payout = "job_price";

    public String selectButton = "//*[contains(@text,'\uF1C3')]";
    public String filterButton = "//*[contains(@text,'\uF182')]";
    public String detailButton = "//*[contains(@text,'\uF079')]";
    public String dryVanRadio = "//*[contains(@text, 'Dry Van')]/following-sibling::*[1]/child::*[1]";
    public String reeferRadio = "//*[contains(@text, 'Reefer')]/following-sibling::*[1]/child::*[1]";
    public String flatbedRadio = "//*[contains(@text, 'Flatbed')]/following-sibling::*[1]/child::*[1]";
    public String powerOnlyRadio = "//*[contains(@text, 'Power Only')]/following-sibling::*[1]/child::*[1]";
    public String boxTruckRadio = "//*[contains(@text, 'Box Truck')]/following-sibling::*[1]/child::*[1]";
    public String backButton = "//*[contains(@text,'\uF406')]";
    public String clearButton = "(//*[contains(@%s,'Clear')])[last()]";
    public String showButton = "(//*[contains(@%s,'Show')])[last()]";
    public String noLoad = "//*[contains(@%s,'Please try another type of load')]";
    public String noLoadAfterFiltering = "//*[contains(@%s,'Your list is currently filtered so you aren't seeing all of our loads.')]";

    public AvailableLoadsAllPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
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

