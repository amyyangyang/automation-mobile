package com.nexttrucking.automation.mobile.property;

import io.appium.java_client.*;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.time.Duration;

public abstract class PageProperty {
    private int width;
    private int height;
    public int nanos = (int) (2 * 1000);
    public Duration duration = Duration.ofNanos(nanos);

    public PageProperty(AppiumDriver<MobileElement> driver, String attributeName) {
        this.driver = driver;
        this.attributeName = attributeName;
        width = driver.manage().window().getSize().width;
        height = driver.manage().window().getSize().height;
    }

    public String attributeName;
    public String attributeValue;
    public AppiumDriver<MobileElement> driver;

    public int sizeOfElements(String element) {
        return driver.findElements(By.xpath(String.format(element, attributeName))).size();
    }

    public void clickElement(String element) {
        driver.findElement(By.xpath(String.format(element, attributeName))).click();
    }

    public void clickElementByName(String element, String elementName){
        driver.findElement(By.xpath(String.format(element, attributeName, elementName))).click();
    }

    public void sendKeyToElement(String element, String keys) {
        driver.findElement(By.xpath(String.format(element, attributeName))).sendKeys(keys);
    }

    public String getText(String element, String titleText) {
        return driver.findElement(By.xpath(String.format(element, attributeName, titleText))).getText();
    }

    public String getValue(String element, String titleText) {
        if (attributeName.equals("name")) {
            attributeValue = "value";
        } else {
            attributeValue = "text";
        }
        return driver.findElement(By.xpath(String.format(element, attributeValue, titleText))).getText();
    }

    public void clickMenu(String element, String menuName) {
        driver.findElement(By.xpath(String.format(element, attributeName, menuName))).click();
    }

    public void clickElementWithDifferentLocator(String androidElement, String iOSElement){
        if (attributeName.equals("text")) {
            clickElement(androidElement);
        } else if (attributeName.equals("name")){
            clickElement(iOSElement);
        }
    }

    public void selectRadioButton(String element, String radioButtonName){
        driver.findElement(By.xpath(String.format(element, attributeName, radioButtonName))).click();
    }
    public void deleteValueForAndroid(String element) throws InterruptedException {
        driver.findElement(By.xpath(String.format(element, attributeName))).clear();
    }

    public void deleteValueForiOS(String element, String valueType, int clickAmount) throws InterruptedException {
        String deleteNumbersButton = "//XCUIElementTypeKey[@name='Delete']";
        String deleteWordsButton = "//XCUIElementTypeKey[@name='delete']";
        String selectAllButton = "//*[contains(@name, 'Select All')]";
        WebElement inputField = driver.findElement(By.xpath(String.format(element, attributeName)));
        inputField.click();
        Thread.sleep(1000);
        if (clickAmount == 2) {
            inputField.click();
        }
        driver.findElement(By.xpath(selectAllButton)).click();
        if (valueType.equals("number")) {
            driver.findElement(By.xpath(deleteNumbersButton)).click();
        } else {
            driver.findElement(By.xpath(deleteWordsButton)).click();
        }
    }

    public void editInputValue(String inputFieldForiOS, String inputFieldForAndroid, String newValue, String valueType, int clickAmount) throws InterruptedException {
        if (attributeName.equals("name")) {
            deleteValueForiOS(inputFieldForiOS, valueType, clickAmount);
            Thread.sleep(1000);
            sendKeyToElement(inputFieldForiOS, newValue);
        } else if (attributeName.equals("text")) {
            deleteValueForAndroid(inputFieldForAndroid);
            Thread.sleep(1000);
            sendKeyToElement(inputFieldForAndroid, newValue);
        }
    }

    public String getElementText(String locator, String element) {
        if (locator.equals("id")) {
            return driver.findElementByAccessibilityId(element).getText();
        } else {
            return driver.findElement(By.xpath(String.format(element, attributeName))).getText();
        }
    }

    public void clickElementByLocator(String locator, String element) {
        if (locator.equals("id")) {
            driver.findElementByAccessibilityId(element).click();
        } else {
            driver.findElement(By.xpath(String.format(element, attributeName))).click();
        }
    }

    public MobileElement getElement(String locator,String element) {
        if(locator.equals("id")) {
            return driver.findElementByAccessibilityId(element);
        }else{
            return driver.findElement(By.xpath(String.format(element, attributeName)));
        }
    }

    public boolean isElementPresent(String locator, String element) {
        try {
            if (locator.equals("id")) {
                driver.findElementByAccessibilityId(element);
            } else {
                driver.findElement(By.xpath(String.format(element, attributeName)));
            }
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public void swipeToUp() {
        try {
            new TouchAction(driver).press(PointOption.point(width / 2, height * 3 / 4)).
                    waitAction(WaitOptions.waitOptions(duration)).
                    moveTo(PointOption.point(0, height / 4)).release().perform();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
