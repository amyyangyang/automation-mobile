package com.nexttrucking.automation.mobile.property;

import io.appium.java_client.*;
import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public abstract class PageProperty {
    private int width;
    private int height;
    public int nanos = (int) (2 * 1000);
    public Duration duration = Duration.ofNanos(nanos);
    String anyElement = "(//*[contains(@%1$s, \"%2$s\")])[last()]";

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

    public void clickAnyElementByName(String elementName){
        driver.findElement(By.xpath(String.format(anyElement, attributeName, elementName))).click();
    }

    public void sendKeyToElement(String element, String keys) {
        driver.findElement(By.xpath(String.format(element, attributeName))).sendKeys(keys);
    }

    public void sendKeyToElementWithDifferentLocators(String androidElement, String iOSElement, String keys){
        if (attributeName.equals("text")) {
            driver.findElement(By.xpath(androidElement)).sendKeys(keys);
        } else {
            driver.findElement(By.xpath(iOSElement)).sendKeys(keys);
        }
    }

    public String getText(String element, String titleText) {
        return driver.findElement(By.xpath(String.format(element, attributeName, titleText))).getText();
    }

    public String getTextByName(String titleText) {
        String element = "(//*[contains(@%1$s, \"%2$s\")])[last()]";
        return driver.findElement(By.xpath(String.format(element, attributeName, titleText))).getText();
    }

    public boolean isTextPresent(String text) {
        String element = "(//*[contains(@%1$s, \"%2$s\")])[last()]";
        try {
            driver.findElement(By.xpath(String.format(element, attributeName, text)));
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        } catch (WebDriverException exception) {
            return false;
        }
    }

    public String getValue(String element, String titleText) {
        if (attributeName.equals("name")) {
            attributeValue = "value";
        } else {
            attributeValue = "text";
        }
        return driver.findElement(By.xpath(String.format(element, attributeValue, titleText))).getText();
    }

    public String getValueByElement(String element) {
        if (attributeName.equals("name")) {
            attributeValue = "value";
        } else {
            attributeValue = "text";
        }
        return driver.findElement(By.xpath(String.format(element, attributeValue))).getText();
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

    public String getElementTextWithDifferentLocator(String androidElement, String iOSElement){
        if (attributeName.equals("text")) {
            return driver.findElement(By.xpath(androidElement)).getText();
        } else {
            return driver.findElement(By.xpath(iOSElement)).getText();
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
//        String selectAllButton = "//*[contains(@name, 'Select All')]";
//        Thread.sleep(2000);
        driver.findElement(By.xpath(element)).click();
//        Thread.sleep(1000);
//        if (clickAmount == 2) {
//            driver.findElement(By.xpath(element)).click();
//        }
//        int loopIteration = 1;
//        boolean selectAllButtonIsPresent = isElementPresent("path", selectAllButton);
//        while (!selectAllButtonIsPresent && loopIteration < 5) {
//            driver.findElement(By.xpath(element)).click();
//            selectAllButtonIsPresent = isElementPresent("path", selectAllButton);
//            System.out.println("LOOP ITERATION AMOUNT IS: " + loopIteration);
//            loopIteration++;
//        }
//        driver.findElement(By.xpath(selectAllButton)).click();
        for (int i=0; i<clickAmount; i++) {
            if (valueType.equals("number")) {
                driver.findElement(By.xpath(deleteNumbersButton)).click();
            } else {
                driver.findElement(By.xpath(deleteWordsButton)).click();
            }
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

    public String getElementText(String locator, String element, int index) {
        if (locator.equals("id")) {
            if (index == 0) {
                return driver.findElementsByAccessibilityId(element).get(0).getText();
            } else {
                if (attributeName.equals("text")) {
                    return driver.findElementsByAccessibilityId(element).get(0).getText();
                } else {
                    int size = driver.findElementsByAccessibilityId(element).size();
                    return driver.findElementsByAccessibilityId(element).get(size - 1).getText();
                }
            }
        } else {
            return driver.findElement(By.xpath(String.format(element, attributeName))).getText();
        }
    }

    public String getElementText(String locator, String element) {
        return getElementText(locator, element, 0);
    }


    public void clickElementByLocator(String locator, String element) {
        if (locator.equals("id")) {
            driver.findElementByAccessibilityId(element).click();
        } else {
            driver.findElement(By.xpath(String.format(element, attributeName))).click();
        }
    }

    public MobileElement getElement(String locator, String element) {
        if (locator.equals("id")) {
            return driver.findElementByAccessibilityId(element);
        } else {
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
        } catch (WebDriverException exception) {
            return false;
        }
    }

    public void swipeToUpForAndroid() {
        if (attributeName.equals("text")) {
            try {
                new TouchAction(driver).press(PointOption.point(width / 2, height * 3 / 4)).
                        waitAction(WaitOptions.waitOptions(duration)).
                        moveTo(PointOption.point(width / 2, height * 1 / 4)).release().perform();
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void swipeToUpForiOS() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Map<String, Object> params = new HashMap<>();
        params.put("duration", 1.0);
        params.put("fromX", 200);
        params.put("fromY", 500);
        params.put("toX", 200);
        params.put("toY", 300);
        js.executeScript("mobile: dragFromToForDuration", params);
        Thread.sleep(1000);
    }


    public void swipeForAnyPlatform() throws InterruptedException {
        if (attributeName.equals("text")) {
            swipeToUpForAndroid();
        } else {
            swipeToUpForiOS();
        }
    }

    public String getELementAttribute(String locator, String element, String attribute) {
        if (locator.equals("id")) {
            return driver.findElementByAccessibilityId(element).getAttribute(attribute);
        } else {
            return driver.findElementByXPath(element).getAttribute(attribute);
        }
    }


}
