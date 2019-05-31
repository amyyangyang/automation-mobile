package com.nexttrucking.automation.mobile.dispatcher;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.xpath;

public class AllowLocationPage {

    public AllowLocationPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }


    private AppiumDriver<MobileElement> driver;
    private By okAllowLocationButton = xpath("//*[@name='OK']");
    private By allowLocationButtonAndroid = xpath("//*[@class='android.widget.Button'][2]");
    private By allowLocationButtonIOS = xpath("//XCUIElementTypeButton[@name='Allow']");
//    private By okAllowLocationButton = xpath("//*[contains(@text, 'OK')]");




    public void clickOkAllowLocationButton() {
        if (driver.findElements(okAllowLocationButton).size()>0) {
            driver.findElement(okAllowLocationButton).click();
        }

    }

    public void clickAllowLocationButton() {
        if (driver.findElements(allowLocationButtonAndroid).size()>0){
            driver.findElement(allowLocationButtonAndroid).click();
        } else if (driver.findElements(allowLocationButtonIOS).size()>0){
            driver.findElement(allowLocationButtonIOS).click();
        }
    }

}
