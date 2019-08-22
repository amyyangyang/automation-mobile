package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.openqa.selenium.By.xpath;

public class MyLoadsPage extends PageProperty {

    private AppiumDriver<MobileElement> driver;
    private String attributeName;

    public By backButton = xpath("//*[contains(@text, '\uF1C3')]");
    public By assignDriverButton = xpath("//*[contains(@text, 'Assign a')]");
    public By reassignDriverButton = xpath("//*[contains(@text, 'reassign a Driver')]");
    public By driverButton = xpath("//*[contains(@text, '2 Ui')]/following-sibling::*[1]");
    public By anotherDriverButton = xpath("//*[contains(@text, 'driver1 Ui')]/following-sibling::*[1]");
    public By assignButton = xpath("(//*[contains(@text, 'Assign')])[last()]");
    public By addDriverButton = xpath("//*[contains(@text, 'Add a Driver')]");
    public By addButton = xpath("//*[contains(@text, 'Add')]");
    public String noLoadOnMyLoads = "//*[contains(@%s, 'Go claim')]";

    public Map<String, String> myLoadsCardMap;

    public MyLoadsPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
        myLoadsCardMap = new HashMap<>();
        if (attributeName.equals("text")) {
            myLoadsCardMap.put("jobState", "//*[contains(@content-desc, 'myloads_view_list')]/*[1]/*/*[1]/*[1]/*[1]");
            myLoadsCardMap.put("jobNum", "//*[contains(@content-desc, 'myloads_view_list')]/*[1]/*/*[1]/*[2]");
            myLoadsCardMap.put("originationAddress", "//*[contains(@content-desc, 'myloads_view_list')]/*[1]/*/*[1]/*[6]");
            myLoadsCardMap.put("destinationAddress", "//*[contains(@content-desc, 'myloads_view_list')]/*[1]/*/*[1]/*[11]");
            myLoadsCardMap.put("pickupTime", "//*[contains(@content-desc, 'myloads_view_list')]/*[1]/*/*[1]/*[8]");
            myLoadsCardMap.put("deliveryTime", "//*[contains(@content-desc, 'myloads_view_list')]/*[1]/*/*[1]/*[13]");
            myLoadsCardMap.put("payout", "//*[contains(@content-desc, 'myloads_view_list')]/*[1]/*/*[1]/*[3]");
            myLoadsCardMap.put("numberOfLoad", "//*[@content-desc='myloads_view_list']/*/*/*");
        } else {
            myLoadsCardMap.put("jobState", "//XCUIElementTypeScrollView/*[1]/*[1]/*[1]//*[@name='jobStatusText']");
            myLoadsCardMap.put("jobNum", "//XCUIElementTypeScrollView/*[1]/*[1]/*[1]//*[@name='jobNumText']");
            myLoadsCardMap.put("originationAddress", "//XCUIElementTypeScrollView/*[1]/*[1]/*[1]//*[@name='address_0']");
            myLoadsCardMap.put("destinationAddress", "//XCUIElementTypeScrollView/*[1]/*[1]/*[1]//*[@name='address_1']");
            myLoadsCardMap.put("pickupTime", "//XCUIElementTypeScrollView/*[1]/*[1]/*[1]//*[@name='time_0']");
            myLoadsCardMap.put("deliveryTime", "///XCUIElementTypeScrollView/*[1]/*[1]/*[1]//*[@name='time_1']");
            myLoadsCardMap.put("payout", "//XCUIElementTypeScrollView/*[1]/*[1]/*[1]//*[@name='priceText']");
            myLoadsCardMap.put("numberOfLoad", "//XCUIElementTypeScrollView/*[1]/*[1]/*[1]");
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
