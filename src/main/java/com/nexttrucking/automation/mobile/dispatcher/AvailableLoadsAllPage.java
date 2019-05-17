package com.nexttrucking.automation.mobile.dispatcher;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;

public class AvailableLoadsAllPage {

    public AvailableLoadsAllPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private AppiumDriver<MobileElement> driver;
    private String title = "//*[contains(@text, \"%s\")]";
    private By localButton = xpath("//*[contains(@text, 'Local')]");

    public String getTitle(String titleText) {
        return driver.findElement(xpath(String.format(title, titleText))).getText();
    }

    public void clickLocalButton(){
        driver.findElement(localButton).click();
    }



}
