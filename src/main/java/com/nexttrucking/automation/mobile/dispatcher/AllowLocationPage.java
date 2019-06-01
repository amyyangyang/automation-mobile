package com.nexttrucking.automation.mobile.dispatcher;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.xpath;

public class AllowLocationPage {

    public AllowLocationPage(AppiumDriver<MobileElement> driver, String attributeName) {
        this.driver = driver;
    }

    private AppiumDriver<MobileElement> driver;
    private By okAllowLocationButton = xpath("(//*[@name='OK'])[last()]");
    private By allowLocationButtonAndroid = xpath("//*[@class='android.widget.Button'][2]");
    private By allowLocationButtonIOS = xpath("//*[@name='Always Allow']");


    public void clickOkAllowLocationButton() throws InterruptedException {
        if (driver.findElements(okAllowLocationButton).size()>0) {
            driver.findElement(okAllowLocationButton).click();
            Thread.sleep(7000);
        }
    }

    public void clickAllowLocationButton() throws InterruptedException {
        if (driver.findElements(allowLocationButtonAndroid).size()>0){
            driver.findElement(allowLocationButtonAndroid).click();
            Thread.sleep(7000);
        } else if (driver.findElements(allowLocationButtonIOS).size()>0){
            driver.findElement(allowLocationButtonIOS).click();
            Thread.sleep(7000);
        }
    }

}
