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

    public void clickElementByName(String element, String elementName){
        driver.findElement(By.xpath(String.format(element, attributeName, elementName))).click();
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

    public void selectRadioButton(String element, String radioButtonName){
        driver.findElement(By.xpath(String.format(element, attributeName, radioButtonName))).click();
    }

    public void deleteValue(String element) throws InterruptedException {
        driver.findElement(By.xpath(String.format(element, attributeName))).clear();
        driver.findElement(By.xpath(String.format(element, attributeName))).clear();
        Thread.sleep(2000);
    }

    public void editInputValue(String inputFieldForiOS, String inputFieldForAndroid, String newValue) throws InterruptedException {
        if (attributeName.equals("name")) {
            deleteValue(inputFieldForiOS);
            Thread.sleep(1000);
            sendKeyToElement(inputFieldForiOS, newValue);
        } else if (attributeName.equals("text")){
            deleteValue(inputFieldForAndroid);
            Thread.sleep(1000);
            sendKeyToElement(inputFieldForAndroid, newValue);
        }
    }

}
