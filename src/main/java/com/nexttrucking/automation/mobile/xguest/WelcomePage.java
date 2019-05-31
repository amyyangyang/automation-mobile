package com.nexttrucking.automation.mobile.xguest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.xpath;


public class WelcomePage {
    private AppiumDriver<MobileElement> driver;

    public WelcomePage(AppiumDriver<MobileElement> driver){
        this.driver = driver;
    }


    private By saveButton = xpath("//*[@name='Save']");
    private By signInButton = xpath("//*[@name='Sign In']");
    private By signUpButton = xpath("(//*[@name='Sign Up'])[last()]");
    private String title = "(//*[contains(@name, \"%s\")])[last()]";
    private By allowButton = xpath("(//*[contains(@name, 'Allow')])[last()]");

//    private By saveButton = xpath("//*[contains(@text, 'Save')]");
//    private By signInButton = xpath("//*[contains(@text, 'Sign In')]");
//    private By signUpButton = xpath("//*[contains(@text, 'Sign Up')]");
//    private String title = "//*[contains(@text, \"%s\")]";

    public WelcomePage clickAllowNotificationsButton(){
        if (driver.findElements(allowButton).size()>0) {
            driver.findElement(allowButton).click();
        }
        return new WelcomePage(driver);
    }


    public String getTitle(String titleText) {
        return driver.findElement(By.xpath(String.format(title, titleText))).getText();
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public SignInPage clickSignInButton() {
        driver.findElement(signInButton).click();
        return new SignInPage(driver);
    }


    public SignUpPage clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }



}
