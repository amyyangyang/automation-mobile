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
    public By addButton = xpath("//*[contains(@text, 'Add')]");
    public String noLoadOnMyLoads = "//*[contains(@%s, 'Go claim')]";
    public String jobState = "jobStatusText";
    public String jobNumber = "jobNumText";
    public String payment = "priceText";
    public String originationAddress = "address_0";
    public String destinationAddress = "address_1";
    public String liveLoadAddress = "address_2";
    public String liveLoadTime = "time_2";
    public String pickUpTime = "time_0";
    public String deliveryTime = "time_1";



    public Map<String, String> myLoadsCardMap;

    public MyLoadsPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
        myLoadsCardMap = new HashMap<>();
        if (attributeName.equals("text")) {
            myLoadsCardMap.put("numberOfLoad", "//*[@content-desc='address_0']");
            myLoadsCardMap.put("getLiveUnloadJobID", "//*[@content-desc='address_2']/..");
            myLoadsCardMap.put("liveUnloadJobButton", "//*[@content-desc=\"%s\"]/*[@content-desc='buttonView']");
        } else {
            myLoadsCardMap.put("numberOfLoad", "//XCUIElementTypeScrollView/*[1]/*[1]/*[1]");
            myLoadsCardMap.put("getLiveUnloadJobID", "//*[@name='address_2']/../../../../../..");
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

    public void findAndClickNotStartedLiveUnloadJob() throws InterruptedException {
        int iterationNumber = 1;
        int liveUnloadJobNumber = 0;
        boolean isLiveUnloadJobStarted = true;
        if (attributeName.equals("text")) {
            boolean isPresentLiveUnloadJob = isElementPresent("id", liveLoadAddress);
            while ((!isPresentLiveUnloadJob || isLiveUnloadJobStarted)  && iterationNumber < 16) {
                swipeToUpForAndroid();
                isPresentLiveUnloadJob = isElementPresent("id", liveLoadAddress);
                if (isPresentLiveUnloadJob) {
                    String jobID = driver.findElementByXPath(myLoadsCardMap.get("getLiveUnloadJobID")).getAttribute("content-desc");
                    System.out.println(jobID);
                    isLiveUnloadJobStarted = isElementPresent("path", String.format(myLoadsCardMap.get("liveUnloadJobButton"), jobID));
                    System.out.println(isLiveUnloadJobStarted);
                }
                iterationNumber++;
            }
            clickElementByLocator("id", liveLoadAddress);
        } else if (attributeName.equals("name")) {
            String jobID = null;
            while (isLiveUnloadJobStarted) {
                jobID = driver.findElementsByXPath(myLoadsCardMap.get("getLiveUnloadJobID")).get(liveUnloadJobNumber).getAttribute("name");
                isLiveUnloadJobStarted = isElementPresent("path", String.format(myLoadsCardMap.get("liveUnloadJobButton"), jobID));
                liveUnloadJobNumber++;
            }
            System.out.println(jobID);
            System.out.println(isLiveUnloadJobStarted);
            int location = driver.findElementByAccessibilityId(jobID).getLocation().y;
            while (location > 660 && iterationNumber < 16) {
                swipeToUpForiOS();
                iterationNumber++;
                location = driver.findElementByAccessibilityId(jobID).getLocation().y;
            }
            driver.findElementByAccessibilityId(jobID).click();
        }
        Thread.sleep(5000);
    }


}
