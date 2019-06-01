package com.nexttrucking.automation.mobile.xguest;

import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;

public class SignInPage {


    public SignInPage(AppiumDriver<MobileElement> driver, String attributeName) {
        this.driver = driver;
        this.attributeName = attributeName;
    }


    public static String attributeName;
    private AppiumDriver<MobileElement> driver;
    private By backButtonAndroid = xpath("//*[@text='\uF3CF']");
    private By backButtonIOS = xpath("//XCUIElementTypeStaticText");
    private By emailInput = xpath("//*[@name='Email']/following-sibling::*[1]");
    private By passwordInput = xpath("//*[@name='Password']/following-sibling::*[1]");
    private By signInButton = xpath("//*[@name='Sign In']");
    private By email = xpath("//*[@name='Email']");


    public void signIn(String Email, String Password) throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(driver, attributeName);
        SignInPage signInPage = new SignInPage(driver, attributeName);
        AllowLocationPage allowLocationPage = new AllowLocationPage(driver, attributeName);
        Thread.sleep(5000);
        welcomePage.clickAllowNotificationsButton();
        welcomePage.clickSaveButton();
        welcomePage.clickSignInButton();
        //LogIn as Dispatcher
        signInPage.findEmail();
        signInPage.typeEmail(Email);
        signInPage.typePassword(Password);
        signInPage.clickSignInButton();
        Thread.sleep(10000);
        allowLocationPage.clickOkAllowLocationButton();
        allowLocationPage.clickAllowLocationButton();
    }

    public WelcomePage clickBackButton() {
        if (driver.findElements(backButtonAndroid).size()>0) {
            driver.findElement(backButtonAndroid).click();
        } else if (driver.findElements(backButtonIOS).size()>0){
            driver.findElement(backButtonIOS).click();
        }
        return new WelcomePage(driver, attributeName);
    }

    public void findEmail(){
        driver.findElement(email);
    }

    public void typeEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void typePassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public AllowLocationPage clickSignInButton() {
        driver.findElement(signInButton).click();
        return new AllowLocationPage(driver, attributeName);
    }

}
