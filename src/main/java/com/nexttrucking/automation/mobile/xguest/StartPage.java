package com.nexttrucking.automation.mobile.xguest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.xpath;


public class StartPage {
    private AppiumDriver<MobileElement> driver;

    public StartPage(AppiumDriver<MobileElement> driver){
        this.driver = driver;
    }


    private By saveButton = xpath("//*[contains(@text, 'Save')]");
    private By signUpButton = xpath("//*[contains(@text, 'Sign Up')]");

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public SignUpPage clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }



}
