package com.nexttrucking.automation.mobile.aguest;

import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;


public class SignInPage extends PageProperty {


    private String backButtonAndroid = "//*[@%s='\uF3CF']";
    private String backButtonIOS = "//XCUIElementTypeStaticText";
    private String passwordInput = "//*[@%s='Password']/following-sibling::*[1]";
    private String emailInput = "//*[@%s='Email']/following-sibling::*[1]";
    private String signInButton = "//*[@%s='Sign In']";
    private String email = "//*[@%s='Email']";
    private String forgotPasswordButton = "//*[@%s='Forgot?']";
    private String forgotPasswordEmail = "(//*[@%s='Enter your email to find your account']/following-sibling::*[1])[1]";
    private String sendNewPasswordButton = "//*[@%s='Send']";
    private String emailSentOKButton = "//*[@%s='OK']";


    public SignInPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
    }


    public void signIn(String Email, String Password) throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(driver, attributeName);
        AllowLocationPage allowLocationPage = new AllowLocationPage(driver, attributeName);
        SignInPage signInPage = new SignInPage(driver, attributeName);
        Thread.sleep(5000);
        welcomePage.clickAllowNotificationsButton();
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
        clickElementWithDifferentLocator(backButtonAndroid, backButtonIOS);
        return new WelcomePage(driver, attributeName);
    }

    public void typeEmail(String email) {
        sendKeyToElement(emailInput, email);
    }

    public void typePassword(String password) {
        sendKeyToElement(passwordInput, password);
    }

    public AllowLocationPage clickSignInButton() {
        clickElement(signInButton);
        return new AllowLocationPage(driver, attributeName);
    }

    public void clickForgotButton() {
        clickElement(forgotPasswordButton);
    }

    public void inputEmailForForgotPassword(String email) {
        sendKeyToElement(forgotPasswordEmail, email);
    }

    public void clickSendNewPasswordButton() {
        clickElement(sendNewPasswordButton);
    }

    public void clickEmailSentOKButton() throws InterruptedException {
        if (attributeName.equals("text")) {
            clickElement(emailSentOKButton);
        } else if (attributeName.equals("name")) {
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(PointOption.point(190, 750)).perform();
        }
        Thread.sleep(3000);
    }

}
