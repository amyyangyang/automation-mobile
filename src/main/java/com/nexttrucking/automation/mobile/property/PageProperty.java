package com.nexttrucking.automation.mobile.property;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public abstract class PageProperty {

    public PageProperty(AppiumDriver<MobileElement> driver, String attributeName) {
        this.driver = driver;
        this.attributeName = attributeName;
    }

    public String attributeName;
    public AppiumDriver<MobileElement> driver;

    public int sizeOfElements(String element){
        return driver.findElements(By.xpath(String.format(element, attributeName))).size();
    }

    public void clickElement(String element){
        driver.findElement(By.xpath(String.format(element, attributeName))).click();
    }

    public void sendKeyToElement(String element, String keys){
        driver.findElement(By.xpath(String.format(element, attributeName))).sendKeys(keys);
    }

    public String getText(String element, String titleText) {
        return driver.findElement(By.xpath(String.format(element, attributeName, titleText))).getText();
    }

    public void clickMenu(String element, String menuName){
        driver.findElement(By.xpath(String.format(element, attributeName, menuName))).click();
    }

    public void clickElementWithDifferentLocator(String androidElement, String iOSElement){
        if (attributeName=="text") {
            clickElement(androidElement);
        } else if (attributeName=="name"){
            driver.findElement(By.xpath(iOSElement)).click();
        }
    }


}
