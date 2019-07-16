package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;


public class AllowLocationPage extends PageProperty {


    private String okAllowLocationButton = "(//*[@%s='OK'])[last()]";
    private String allowLocationButtonAndroid = "(//*[@class='android.widget.Button'])[2]";
    private String allowLocationButtonIOS12 = "//*[@%s='Always Allow']";
    private String allowLocationButtonIOS10 = "//*[@%s='Allow']";

    public AllowLocationPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
    }


    public void clickOkAllowLocationButton() throws InterruptedException {
        if (sizeOfElements(okAllowLocationButton) > 0) {
            clickElement(okAllowLocationButton);
            Thread.sleep(3000);
        }
    }

    public void clickAllowLocationButton() throws InterruptedException {
        if (attributeName.equals("text") && driver.findElements(By.xpath(allowLocationButtonAndroid)).size() > 0) {
            driver.findElement(By.xpath(allowLocationButtonAndroid)).click();
            Thread.sleep(3000);
        } else if (attributeName.equals("name") && sizeOfElements(allowLocationButtonIOS10) > 0) {
            clickElement(allowLocationButtonIOS10);
            Thread.sleep(3000);
        } else if (attributeName.equals("name") && sizeOfElements(allowLocationButtonIOS12) > 0) {
            clickElement(allowLocationButtonIOS12);
            Thread.sleep(3000);
        }
    }

}

