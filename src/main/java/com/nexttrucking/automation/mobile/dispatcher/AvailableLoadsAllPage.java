package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.aguest.WelcomePage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import com.nexttrucking.automation.mobile.property.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
    public String portButton = "PORT";

    public String shortHaulNumber = "SHORT_HAUL_Count";
    public String longHaulNumber = "LONG_HAUL_Count";
    public String localNumber = "LOCAL_Count";
    public String allNumber = "ALL_Count";
    public String portNumber = "PORT_Count";

    public Map<String, String> buttonMap;
    public Map<String, String> availableCardMap;

    public String originationAddress = "addressGroup_0";
    public String destinationAddress = "addressGroup_0";
    public String liveLoadAddress = "timeGroup_2";
    public String liveLoadTime = "timeGroup_2";
    public String pickupTime = "time_0";
    public String deliveryTime = "time_1";
    public String getTextInAddress = "textGroupValue_1";
    public String getTextInTime = "textGroupValue_0";
    public String getTextInArriveBetweenTime = "textGroupValue_1";
    public String timeElementListOfTripsJob = "//*[contains(@content-desc,'timeGroup')]";
    public String timeElementListOfLegacyJob = "//*[contains(@content-desc,'time_')]";
    public String jobIdElement = "jobID";

    public String jobType = "jobType";
    public String equipmentType = "equipmentView";
    public String payout = "priceView";

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
            availableCardMap.put("numberOfLoad", "(//*[@content-desc='available_view_list']//*[@content-desc])[1]");
            availableCardMap.put("jobNumber", "//*[contains(@content-desc, 'available_view_list')]/child::*[1]/child::*/child::*/child::*[1]");
        } else {
            buttonMap.put("filterButton", "//XCUIElementTypeStaticText[@name=\"\uF182\"]");
            buttonMap.put("backButton", "//XCUIElementTypeStaticText[@name=\"\uF406\"]");
            buttonMap.put("dryVanRadio", "(//*[contains(@name, 'Dry Van')])[last()]");
            buttonMap.put("reeferRadio", "(//*[contains(@name, 'Reefer')])[last()]");
            buttonMap.put("flatbedRadio", "(//*[contains(@name, 'Flatbed')])[last()]");
            buttonMap.put("powerOnlyRadio", "(//*[contains(@name, 'Power Only')])[last()]");
            buttonMap.put("boxTruckRadio", "(//*[contains(@name, 'Box Truck')])[last()]");
            availableCardMap.put("numberOfLoad", "(//XCUIElementTypeScrollView/*/*[2]/*)[2]");
            availableCardMap.put("jobNumber", "//*[contains(@content-desc, 'available_view_list')]/child::*[1]/child::*/child::*/child::*[1]");
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
            touchAction.tap(PointOption.point(270, 750)).perform();
        }
        Thread.sleep(3000);
        return new WelcomePage(driver, attributeName);
    }

    public void findLiveUnloadJob() throws InterruptedException {
        int i = 1;
        if (attributeName.equals("text")) {
            Boolean isPresentLiveUnloadJob = isElementPresent("id", liveLoadAddress);
            while (!isPresentLiveUnloadJob && i < 16) {
                System.out.println("SWIPE STEP: " + i);
                swipeToUpForAndroid();
                isPresentLiveUnloadJob = isElementPresent("id", liveLoadAddress);
                i++;
            }
        } else if (attributeName.equals("name")) {
            Boolean isPresentLiveUnloadJob = isElementPresent("id", liveLoadAddress);
            if (isPresentLiveUnloadJob) {
                int location = driver.findElementByAccessibilityId(liveLoadAddress).getLocation().y;
                while (location > 800 && i < 16) {
                    System.out.println("SWIPE STEP: " + i);
                    swipeToUpForIOS();
                    location = driver.findElementByAccessibilityId(liveLoadAddress).getLocation().y;
                    i++;
                }
            }
        }
    }

    public void bookTenderForFleet(int times, JobDetailPage jobDetailPage) throws InterruptedException {
        for (int loop = 0; loop < times; ++loop) {
            Boolean isPresentException = false;
            do {
                boolean isPresentLoad = isElementPresent("id", originationAddress);
                if (isPresentLoad) {
                    clickElementByLocator("id", equipmentType);
                    jobDetailPage.clickElementByLocator("path", jobDetailPage.bookButton);
                    Thread.sleep(3000);
                    isPresentException = jobDetailPage.checkBookJobForErrors();
                    if (isPresentException) {
                        continue;
                    }
                    jobDetailPage.bookTender();
                    isPresentException = jobDetailPage.checkBookJobForErrors();
                    if (isPresentException) {
                        continue;
                    }
                    isPresentException = jobDetailPage.assignDriver(jobDetailPage.jobDetailCard.get("driver"));
                    if (isPresentException) {
                        clickMenuButtonFirstLevel("Available Loads");
                    }
                }
            } while (isPresentException);
        }
    }

    public void bookTenderForOwnerOperator(int times, JobDetailPage jobDetailPage) throws InterruptedException {
        for (int step = 0; step < times; step++) {
            boolean isPresentException = false;
            int loop = 0;
            do {
                ++loop;
                boolean isPresentLoad = isElementPresent("id", originationAddress);
                if (isPresentLoad) {
                    findLiveUnloadJob();
                    boolean isLiveUnloadPresent = isElementPresent("id", liveLoadAddress);
                    if (isLiveUnloadPresent) {
                        clickElementByLocator("id", originationAddress);
                        jobDetailPage.clickElementByLocator("path", jobDetailPage.bookButton);
                        isPresentException = jobDetailPage.checkBookJobForErrors();
                        if (isPresentException) {
                            continue;
                        }
                        Thread.sleep(3000);
                        jobDetailPage.bookTender();
                        isPresentException = jobDetailPage.checkBookJobForErrors();
                        if (isPresentException) {
                            continue;
                        }
                        jobDetailPage.goToMyLoadsOrAvailableLoadsPage(jobDetailPage.goToMyLoadsButton);
                        clickMenuButtonFirstLevel("Available Loads");
                    }
                }
            } while ((isPresentException) && (loop < 3));
        }
    }

    public HashMap getLoadCardData(MobileElement jobCard) {
        HashMap jobCardData = new HashMap();
        String jobNumber = jobCard.getAttribute("content-desc");
        List<MobileElement> addressElements = jobCard.findElementsByAccessibilityId(originationAddress);
        int addressCount = jobCard.findElementsByAccessibilityId(originationAddress).size();
        for (int i = 0; i < addressCount; i++) {
            jobCardData.put("address" + i, addressElements.get(i).findElementByAccessibilityId(getTextInAddress).getText());
        }
        jobCardData.put("equipmentType", jobCard.findElementsByAccessibilityId(jobIdElement).get(0).findElementByAccessibilityId(equipmentType).getText());
        jobCardData.put("payout", jobCard.findElementsByAccessibilityId(jobIdElement).get(0).findElementByAccessibilityId(payout).getText());
        List<MobileElement> timeElements;
        int timeCount;
        if (jobNumber.contains("J-")) {
            timeElements = jobCard.findElementsByXPath(timeElementListOfTripsJob);
            timeCount = timeElements.size();
            for (int i = 0; i < timeCount; i++) {
                String time = timeElements.get(i).findElementByAccessibilityId(getTextInTime).getText();
                jobCardData.put("time" + i, timeElements.get(i).findElementByAccessibilityId(getTextInTime).getText());
                boolean isPresentArriveBetweenTime = isSubElementPresent("id", timeElements.get(i), getTextInArriveBetweenTime);
                if (isPresentArriveBetweenTime) {
                    jobCardData.put("time" + i, time + timeElements.get(i).findElementByAccessibilityId(getTextInArriveBetweenTime).getText());
                }
            }
        } else {
            timeElements = jobCard.findElementsByXPath(timeElementListOfLegacyJob);
            timeCount = timeElements.size();
            for (int i = 0; i < timeCount; i++) {
                jobCardData.put("time" + i, timeElements.get(i).getText());
            }
        }
        jobCardData.put("addressCount", addressCount);
        jobCardData.put("timeCount", timeCount);
        return jobCardData;
    }

    public MobileElement getMobileElementOfFirstCard() {
        int size = driver.findElementsByXPath(availableCardMap.get("jobNumber")).size();
        for (int index = 0; index < size; index++) {
            String text = driver.findElementsByXPath(availableCardMap.get("jobNumber")).get(index).getAttribute("content-desc");
            if (text != null) {
                return driver.findElementsByXPath(availableCardMap.get("jobNumber")).get(index);
            }
        }
        return null;
    }
}

