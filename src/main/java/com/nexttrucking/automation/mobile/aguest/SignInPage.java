package com.nexttrucking.automation.mobile.aguest;

import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.xpath;


public class SignInPage extends PageProperty {


    private String backButtonAndroid = "//*[@%s='\uF3CF']";
    private String backButtonIOS = "//XCUIElementTypeStaticText";
    private String passwordInput = "//*[@%s='Password']/following-sibling::*[1]";
    private String emailInput = "//*[@%s='Email']/following-sibling::*[1]";
    private String signInButton = "//*[@%s='Sign In']";
    private String email = "//*[@%s='Email']";


    public SignInPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
    }


    public void signIn(String Email, String Password) throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(driver, attributeName);
        AllowLocationPage allowLocationPage = new AllowLocationPage(driver, attributeName);
        SignInPage signInPage = new SignInPage(driver, attributeName);
        Thread.sleep(5000);
        welcomePage.clickAllowNotificationsButton();
        welcomePage.clickSaveButton();
        welcomePage.clickSignInButton();
        //LogIn as Dispatcher
        signInPage.typeEmail(Email);
        signInPage.typePassword(Password);
        signInPage.clickSignInButton();
        Thread.sleep(10000);
        allowLocationPage.clickOkAllowLocationButton();
        allowLocationPage.clickAllowLocationButton();
    }

    public WelcomePage clickBackButton() {
        if (attributeName=="text") {
            clickElement(backButtonAndroid);
        } else if (attributeName=="name"){
            driver.findElement(By.xpath(backButtonIOS)).click();
        }
        return new WelcomePage(driver, attributeName);
    }

    public void typeEmail(String email){
        sendKeyToElement(emailInput, email);
    }

    public void typePassword(String password){
        sendKeyToElement(passwordInput, password);
    }

    public AllowLocationPage clickSignInButton() {
        clickElement(signInButton);
        return new AllowLocationPage(driver, attributeName);
    }

}
