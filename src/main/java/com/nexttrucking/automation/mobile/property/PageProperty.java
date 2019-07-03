package com.nexttrucking.automation.mobile.property;

import io.appium.java_client.*;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

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
    public AppiumDriver<MobileElement> driver;

    public int sizeOfElements(String element) {
        return driver.findElements(By.xpath(String.format(element, attributeName))).size();
    }

    public void clickElement(String element) {
        driver.findElement(By.xpath(String.format(element, attributeName))).click();
    }

    public void sendKeyToElement(String element, String keys) {
        driver.findElement(By.xpath(String.format(element, attributeName))).sendKeys(keys);
    }

    public String getText(String element, String titleText) {
        return driver.findElement(By.xpath(String.format(element, attributeName, titleText))).getText();
    }

    public void clickMenu(String element, String menuName) {
        driver.findElement(By.xpath(String.format(element, attributeName, menuName))).click();
    }

    public void clickElementWithDifferentLocator(String androidElement, String iOSElement) {
        if (attributeName == "text") {
            clickElement(androidElement);
        } else if (attributeName == "name") {
            driver.findElement(By.xpath(iOSElement)).click();
        }
    }

    public void selectRadioButton(String element, String radioButtonName){
        driver.findElement(By.xpath(String.format(element, attributeName, radioButtonName))).click();
    }

    public String getElementText(String locator, String element) {
        if (locator.equals("id")) {
            return driver.findElementByAccessibilityId(element).getText();
        } else {
            return driver.findElement(By.xpath(String.format(element, attributeName))).getText();
        }
    }

    public MobileElement getElement(String element) {
        return driver.findElement(By.xpath(String.format(element, attributeName)));
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
