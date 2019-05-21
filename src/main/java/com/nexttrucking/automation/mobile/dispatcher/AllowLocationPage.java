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
    private By okAllowLocationButton = xpath("//*[contains(@text, 'OK')]");
    private By allowLocationSysButton = xpath("//*[contains(@text, 'ALLOW')]");
    private By locationTitle = xpath("//*[contains(@text, 'Can we have your location?')]");



    public void clickOkAllowLocationButton() {
        if (driver.findElements(okAllowLocationButton).size()>0) {
            driver.findElement(okAllowLocationButton).click();
        }

    }

    public void clickAllowLocationButton() {
        if (driver.findElements(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).size()>0){
            driver.findElement(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).click();
        }
//            driver.execute('mobile:alert',  {'accept'});

//            driver.findElement(allowLocationSysButton).click();
    }

}