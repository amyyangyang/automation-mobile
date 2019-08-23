package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.*;

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

    public String jobState="jobStatusText";
    public String jobNumber="jobNumText";
    public String payment="priceText";
    public String originationAddress="address_0";
    public String desitinationAddress="address_1";
    public String pickUpTime="time_0";
    public String deliveryTime="time_1";

    public Map<String, String> myLoadsCardMap;

    public MyLoadsPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
        if (attributeName.equals("text")) {
            myLoadsCardMap = new HashMap<>();
            myLoadsCardMap.put("jobState", "//*[contains(@content-desc, 'myloads_view_list')]/child::*[1]/child::*/child::*[1]/child::*[1]/child::*[1]");
            myLoadsCardMap.put("jobNum", "//*[contains(@content-desc, 'myloads_view_list')]/child::*[1]/child::*/child::*[1]/child::*[2]");
            myLoadsCardMap.put("originationAddress", "//*[contains(@content-desc, 'myloads_view_list')]/child::*[1]/child::*/child::*[1]/child::*[6]");
            myLoadsCardMap.put("destinationAddress", "//*[contains(@content-desc, 'myloads_view_list')]/child::*[1]/child::*/child::*[1]/child::*[11]");
            myLoadsCardMap.put("pickupTime", "//*[contains(@content-desc, 'myloads_view_list')]/child::*[1]/child::*/child::*[1]/child::*[8]");
            myLoadsCardMap.put("deliveryTime", "//*[contains(@content-desc, 'myloads_view_list')]/child::*[1]/child::*/child::*[1]/child::*[13]");
            myLoadsCardMap.put("payout", "//*[contains(@content-desc, 'myloads_view_list')]/child::*[1]/child::*/child::*[1]/child::*[3]");
            myLoadsCardMap.put("numberOfLoad", "//*[contains(@content-desc, 'myloads_view_list')]/child::*[1]/child::*/child::*[1]/child::*[1]/child::*[1]");

        }else{
            myLoadsCardMap = new HashMap<>();
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

}
