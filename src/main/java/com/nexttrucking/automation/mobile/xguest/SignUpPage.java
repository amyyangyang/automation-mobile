package com.nexttrucking.automation.mobile.xguest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;

public class SignUpPage {

    private AppiumDriver<MobileElement> driver;
    private By backButton = xpath("//*[contains(@text, '\uF3CF')]");

    public SignUpPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public WelcomePage clickBackButton() {
        driver.findElement(backButton).click();
        return new WelcomePage(driver);
    }
}
