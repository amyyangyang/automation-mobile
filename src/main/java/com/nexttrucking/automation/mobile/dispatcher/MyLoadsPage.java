package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.openqa.selenium.By.xpath;

public class MyLoadsPage extends PageProperty {

    public By backButton = xpath("//*[contains(@text, '\uF1C3')]");
    public By assignDriverButton = xpath("//*[contains(@text, 'Assign a')]");
    public By reassignDriverButton = xpath("//*[contains(@text, 'reassign a Driver')]");
    public By driverButton = xpath("//*[contains(@text, '2 Ui')]/following-sibling::*[1]");
    public By anotherDriverButton = xpath("//*[contains(@text, 'driver1 Ui')]/following-sibling::*[1]");
    public By assignButton = xpath("(//*[contains(@text, 'Assign')])[last()]");
    public By addDriverButton = xpath("//*[contains(@text, 'Add a Driver')]");
    public By addButton = xpath("(//*[contains(@text, 'Add')])[last()]");
    public String noLoadOnMyLoads = "(//*[contains(@%s, 'You don')])[last()]";
    public String jobState = "jobStatusText";
    public String jobNumber = "jobNumText";
    public String payment = "priceText";
    public String originationAddress = "addressGroup_0";
    public String destinationAddress = "addressGroup_0";
    public String liveLoadAddress = "timeGroup_2";
    public String liveLoadTime = "timeGroup_2";
    public String pickUpTime = "timeGroup_0";
    public String deliveryTime = "timeGroup_1";
    public String getTextInAddress = "textGroupValue_1";
    public String getTextInTime = "textGroupValue_0";

    public Map<String, String> myLoadsCardMap;

    public MyLoadsPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
        myLoadsCardMap = new HashMap<>();
        if (attributeName.equals("text")) {
            myLoadsCardMap.put("numberOfLoad", "//*[@content-desc='address_0']");
            myLoadsCardMap.put("getLiveUnloadJobID", "//*[@content-desc='timeGroup_0']/..");
            myLoadsCardMap.put("liveUnloadJobButton", "//*[@content-desc=\"%s\"]/*[@content-desc='buttonView']");
        } else {
            myLoadsCardMap.put("numberOfLoad", "//XCUIElementTypeScrollView/*[1]/*[1]/*[1]");
            myLoadsCardMap.put("getLiveUnloadJobID", "//*[@name='timeGroup_2']/../../../../../..");
            myLoadsCardMap.put("liveUnloadJobButton", "//*[@name=\"%s\"]//*[@name='buttonView']");
        }
    }

    public void assignDriver() {
        driver.findElement(assignDriverButton).click();
        driver.findElement(driverButton).click();
        driver.findElement(assignButton).click();
    }

    public void reassignDriver() {
        driver.findElement(reassignDriverButton).click();
        driver.findElement(anotherDriverButton).click();
        driver.findElement(assignButton).click();
    }

    public boolean findAndClickNotStartedJob() throws InterruptedException {
        boolean isJobStarted = true;
        int iterationNumber = 1;
        String jobID = null;
        boolean isPresentJob = isElementPresent("id", originationAddress);
        while ((isPresentJob && isJobStarted) && iterationNumber < 16) {
            System.out.println("SWIPE STEP: " + iterationNumber);
            swipeToUpForAndroid();
            isPresentJob = isElementPresent("id", originationAddress);
            if (isPresentJob) {
                jobID = driver.findElementByXPath(myLoadsCardMap.get("getLiveUnloadJobID")).getAttribute("content-desc");
                if(jobID.contains("Load")){
                    continue;
                }
                isJobStarted = isElementPresent("path", String.format(myLoadsCardMap.get("liveUnloadJobButton"), jobID));
            }
            iterationNumber++;
        }
        System.out.println("JOB ID: " + jobID);
        if (!isJobStarted) {
            driver.findElementByAccessibilityId(jobID).click();
            Thread.sleep(8000);
            return true;
        }
        return false;
    }

    public boolean findAndClickNotStartedLiveUnloadJob() throws InterruptedException {
        boolean isLiveUnloadJobStarted = true;
        if (attributeName.equals("text")) {
            int iterationNumber = 1;
            String jobID = null;
            boolean isPresentLiveUnloadJob = isElementPresent("id", liveLoadAddress);
            while ((!isPresentLiveUnloadJob || isLiveUnloadJobStarted) && iterationNumber < 16) {
                System.out.println("SWIPE STEP: " + iterationNumber);
                swipeToUpForAndroid();
                isPresentLiveUnloadJob = isElementPresent("id", liveLoadAddress);
                if (isPresentLiveUnloadJob) {
                    jobID = driver.findElementByXPath(myLoadsCardMap.get("getLiveUnloadJobID")).getAttribute("content-desc");
                    System.out.println(jobID);
                    if(jobID.contains("Load")){
                        continue;
                    }
                    isLiveUnloadJobStarted = isElementPresent("path", String.format(myLoadsCardMap.get("liveUnloadJobButton"), jobID));
                }
                iterationNumber++;
            }
            System.out.println("NOT STARTED LiveUnload JOB ID: " + jobID);
            if (!isLiveUnloadJobStarted) {
                driver.findElementByAccessibilityId(jobID).click();
                Thread.sleep(5000);
                return true;
            }
            return false;
        } else if (attributeName.equals("name")) {
            int iterationNumber = 1;
            int liveUnloadJobNumber = 0;
            String jobID = null;
            while (isLiveUnloadJobStarted) {
                jobID = driver.findElementsByXPath(myLoadsCardMap.get("getLiveUnloadJobID")).get(liveUnloadJobNumber).getAttribute("name");
                isLiveUnloadJobStarted = isElementPresent("path", String.format(myLoadsCardMap.get("liveUnloadJobButton"), jobID));
                liveUnloadJobNumber++;
            }
            int location = driver.findElementByAccessibilityId(jobID).getLocation().y;
            while (location > 660 && iterationNumber < 16) {
                System.out.println("SWIPE STEP: " + iterationNumber);
                swipeToUpForIOS();
                iterationNumber++;
                location = driver.findElementByAccessibilityId(jobID).getLocation().y;
            }
            System.out.println("NOT STARTED LiveUnload JOB ID: " + jobID);
            if (!isLiveUnloadJobStarted) {
                driver.findElementByAccessibilityId(jobID).click();
                //Thread.sleep(5000);
                return true;
            }
            return false;
        }
        return false;
    }
}
