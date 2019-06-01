package com.nexttrucking.automation.mobile.xguest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.concurrent.ThreadPoolExecutor;

import static org.openqa.selenium.By.xpath;


public class WelcomePage {
    private AppiumDriver<MobileElement> driver;
    public static String attributeName;


    public WelcomePage(AppiumDriver<MobileElement> driver, String attributeName){
        this.driver = driver;
        this.attributeName = attributeName;
    }

    private String saveButton = "(//*[@%s='Save'])[last()]";
    private By signInButton = xpath("//*[@name='Sign In']");
    private By signUpButton = xpath("(//*[@name='Sign Up'])[last()]");
    private String title = "(//*[contains(@%1$s, \"%2$s\")])[last()]";
    private String allowButton = "//*[@%s='Allow']";

//    private By saveButton = xpath("//*[contains(@text, 'Save')]");
//    private By signInButton = xpath("//*[contains(@text, 'Sign In')]");
//    private By signUpButton = xpath("//*[contains(@text, 'Sign Up')]");
//    private String title = "//*[contains(@text, \"%s\")]";

    public void clickAllowNotificationsButton(){
        if (driver.findElements(By.xpath(String.format(allowButton, attributeName))).size()>0) {
            driver.findElement(By.xpath(String.format(allowButton, attributeName))).click();
        }
    }

    public String getTitle(String titleText) {
        System.out.println(String.format(title, attributeName, titleText));
        return driver.findElement(By.xpath(String.format(title, attributeName, titleText))).getText();
    }

    public void clickSaveButton() {
        if (driver.findElements(By.xpath(String.format(saveButton, attributeName))).size()>0){
            driver.findElement(By.xpath(String.format(saveButton, attributeName))).click();
        }
    }

    public SignInPage clickSignInButton() {
        driver.findElement(signInButton).click();
        return new SignInPage(driver, attributeName);
    }

    public SignUpPage clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver, attributeName);
    }

    public void getWelcomePage() throws InterruptedException {
        System.out.println(String.format(saveButton, attributeName));
        clickAllowNotificationsButton();
        Thread.sleep(2000);
        clickSaveButton();
        Thread.sleep(2000);
    }

}
