package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import com.nexttrucking.automation.mobile.property.Utils;
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

    public String shortHaulNumber = "SHORT_HAUL_Count";
    public String longHaulNumber = "LONG_HAUL_Count";
    public String localNumber = "LOCAL_Count";
    public String allNumber = "ALL_Count";

    public Map<String, String> buttonMap;
    public Map<String, String> availableCardMap;

    public String originationAddress = "address_0";
    public String destinationAddress = "address_1";
    public String liveLoadAddress = "address_2";
    public String liveLoadTime = "time_2";
    public String pickupTime = "time_0";
    public String deliveryTime = "time_1";

    public String jobType="jobType";
    public String equipmentType="equipmentView";
    public String payout="priceView";

    public String longHaulMile = "//*[contains(@%s,'Loads that are 250 mi or more')]";
    public String shortHaulMile = "//*[contains(@%s,'Loads between 100 - 250 mi')]";
    public String localHaulMile = "//*[contains(@%s,'Loads that are less than 100 mi')]";
    public String clearButton = "(//*[contains(@%s,'Clear')])[last()]";
    public String showButton = "(//*[contains(@%s,'Show')])[last()]";
    public String noLoadsButton = "//*[contains(@%s,'No Loads')]";
    public String noLoad = "(//*[contains(@%s,'Please try another type of load')])[last()]";
    public String noLoadAllType = "(//*[contains(@%s,'All of our loads have been taken')])[last()]";
    public String noLoadAfterFiltering = "(//*[contains(@%s,\"Your list is currently filtered so you aren't seeing all of our loads.\")])[last()]";

    public AvailableLoadsAllPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
        buttonMap = new HashMap<>();
        availableCardMap = new HashMap<>();
        if (attributeName.equals("text")) {
            buttonMap.put("filterButton", "//*[contains(@text,'\uF182')]");
            buttonMap.put("backButton", "//*[contains(@text,'\uF406')]");
            buttonMap.put("dryVanRadio", "//*[contains(@text, 'Dry Van')]/following-sibling::*[1]/child::*[1]");
            buttonMap.put("reeferRadio", "//*[contains(@text, 'Reefer')]/following-sibling::*[1]/child::*[1]");
            buttonMap.put("flatbedRadio", "//*[contains(@text, 'Flatbed')]/following-sibling::*[1]/child::*[1]");
            buttonMap.put("powerOnlyRadio", "//*[contains(@text, 'Power Only')]/following-sibling::*[1]/child::*[1]");
            buttonMap.put("boxTruckRadio", "//*[contains(@text, 'Box Truck')]/following-sibling::*[1]/child::*[1]");
            //availableCardMap.put("jobType", "//*[contains(@content-desc, 'available_view_list')]/child::*[1]/child::*/child::*[1]/child::*[1]/child::*[1]");
            //availableCardMap.put("equipmentType", "//*[contains(@content-desc, 'available_view_list')]/child::*[1]/child::*/child::*[1]/child::*[2]");
            //availableCardMap.put("originationAddress", "//*[contains(@content-desc, 'available_view_list')]/child::*[1]/child::*/child::*[1]/child::*[6]");
            //availableCardMap.put("destinationAddress", "//*[contains(@content-desc, 'available_view_list')]/child::*[1]/child::*/child::*[1]/child::*[11]");
            //availableCardMap.put("pickupTime", "//*[contains(@content-desc, 'available_view_list')]/child::*[1]/child::*/child::*[1]/child::*[8]");
            //availableCardMap.put("deliveryTime", "//*[contains(@content-desc, 'available_view_list')]/child::*[1]/child::*/child::*[1]/child::*[13]");
            //availableCardMap.put("payout", "//*[contains(@content-desc, 'available_view_list')]/child::*[1]/child::*/child::*[1]/child::*[3]");
            availableCardMap.put("numberOfLoad", "(//*[@content-desc='available_view_list']//*[@content-desc])[1]");
            availableCardMap.put("numberOfLoadTwo", "//*[contains(@content-desc, 'available_view_list')]/child::*[1]/child::*");
            availableCardMap.put("jobNumber", "//*[contains(@content-desc, 'available_view_list')]/child::*[1]/child::*/child::*[1]");
            availableCardMap.put("liveUnloadJobAddress2", "//*[@content-desc='address_2']");
        } else {
            buttonMap.put("filterButton", "//XCUIElementTypeStaticText[@name=\"\uF182\"]");
            buttonMap.put("backButton", "//XCUIElementTypeStaticText[@name=\"\uF406\"]");
            buttonMap.put("dryVanRadio", "(//*[contains(@name, 'Dry Van')])[last()]");
            buttonMap.put("reeferRadio", "(//*[contains(@name, 'Reefer')])[last()]");
            buttonMap.put("flatbedRadio", "(//*[contains(@name, 'Flatbed')])[last()]");
            buttonMap.put("powerOnlyRadio", "(//*[contains(@name, 'Power Only')])[last()]");
            buttonMap.put("boxTruckRadio", "(//*[contains(@name, 'Box Truck')])[last()]");
            //availableCardMap.put("jobType", "//*[@name='available_view_list']/child::*[1]/child::*[1]/child::*[1]/child::*/child::*[1]/child::*[1]/child::*[1]");
            //availableCardMap.put("equipmentType", "(//*[@name='available_view_list']/child::*[1]/child::*[1]/child::*[1]/child::*/child::*[1]/child::*[2]/child::*[1]/child::*[1])[last()]");
            //availableCardMap.put("originationAddress", "//*[@name='available_view_list']/child::*[1]/child::*[1]/child::*[1]/child::*/child::*[1]/child::*[2]/child::*[2]/child::*[1]/child::*[1]/child::*[1]/child::*[2]/child::*[1]");
            //availableCardMap.put("destinationAddress", "//*[@name='available_view_list']/child::*[1]/child::*[1]/child::*[1]/child::*/child::*[1]/child::*[2]/child::*[2]/child::*[1]/child::*[1]/child::*[1]/child::*[2]/child::*[2]");
            //availableCardMap.put("pickupTime", "//*[@name='available_view_list']/child::*[1]/child::*[1]/child::*[1]/child::*/child::*[1]/child::*[2]/child::*[2]/child::*[1]/child::*[1]/child::*[2]/child::*[2]/child::*[1]");
            //availableCardMap.put("deliveryTime", "//*[@name='available_view_list']/child::*[1]/child::*[1]/child::*[1]/child::*/child::*[1]/child::*[2]/child::*[2]/child::*[1]/child::*[1]/child::*[2]/child::*[2]/child::*[2]");
            //availableCardMap.put("payout", "//*[@name='available_view_list']/child::*[1]/child::*[1]/child::*[1]/child::*/child::*[1]/child::*[2]/child::*[1]/child::*[2]");
            availableCardMap.put("numberOfLoad", "(//XCUIElementTypeScrollView/*/*[2]/*)[2]");
            //availableCardMap.put("numberOfLoadTwo","//*[@name='available_view_list']/child::*[1]/child::*[1]/child::*[1]/child::*[2]/child::*[1]/child::*[2]/child::*[1]/child::*[2]");
            availableCardMap.put("liveUnloadJobAddress2", "//*[@name='address_2']");
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

    public void findLiveUnloadJob() throws InterruptedException {
        int i = 1;
        if (attributeName.equals("text")) {
            Boolean isPresentLiveUnloadJob = isElementPresent("id", liveLoadAddress);
            while (!isPresentLiveUnloadJob && i < 16) {
                System.out.println("STEP: " + i);
                swipeToUpForAndroid();
                isPresentLiveUnloadJob = isElementPresent("id", liveLoadAddress);
                i++;
            }
        } else if (attributeName.equals("name")) {
            int location = driver.findElementByAccessibilityId(liveLoadAddress).getLocation().y;
            while (location > 660 && i < 16) {
                swipeToUpForiOS();
                location = driver.findElementByAccessibilityId(liveLoadAddress).getLocation().y;
                i++;
            }
        }
    }

}

