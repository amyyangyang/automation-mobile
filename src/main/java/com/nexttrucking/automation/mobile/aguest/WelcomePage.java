package com.nexttrucking.automation.mobile.aguest;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;


public class WelcomePage extends PageProperty {


    public WelcomePage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
    }

    private String saveButton = "(//*[@%s='Save'])[last()]";
    private String signInButton = "//*[@%s='Sign In']";
    private String signUpButton = "(//*[@%s='Sign Up'])[last()]";
    private String title = "(//*[contains(@%1$s, \"%2$s\")])[last()]";
    private String allowButton = "//*[@%s='Allow']";



    public void clickAllowNotificationsButton() throws InterruptedException {
        Thread.sleep(5000);
        if (attributeName.equals("name") && sizeOfElements(allowButton)>0) {
            clickElement(allowButton);
        }
    }

    public String getTitle(String titleText) {
        return getText(title, titleText);
    }

    public void clickSaveButton() {
        if (sizeOfElements(saveButton)>0){
            clickElement(saveButton);
        }
    }

    public SignInPage clickSignInButton() {
        clickElement(signInButton);
        return new SignInPage(driver, attributeName);
    }

    public SignUpPage clickSignUpButton() {
        clickElement(signUpButton);
        return new SignUpPage(driver, attributeName);
    }

    public void getWelcomePage() throws InterruptedException {
        clickAllowNotificationsButton();
        Thread.sleep(3000);
        clickSaveButton();
        Thread.sleep(3000);
    }

}
