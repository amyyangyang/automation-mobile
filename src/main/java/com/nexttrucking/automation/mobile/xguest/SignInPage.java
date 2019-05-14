package com.nexttrucking.automation.mobile.xguest;

import com.nexttrucking.automation.mobile.dispatcher.AllowLocationPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;

public class SignInPage {

    public SignInPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private AppiumDriver<MobileElement> driver;
    public WelcomePage welcomePage;
    public SignInPage signInPage;
    private By backButton = xpath("//*[contains(@text, '\uF3CF')]");
    private String emailInput = "login_input_email";
    private String passwordInput = "login_input_password";
    private By signInButton = xpath("//*[contains(@text, 'Sign In')]");
    private By email = xpath("//*[contains(@text, 'Email')]");


    public void signIn(String Email, String Password) throws InterruptedException {
        welcomePage = new WelcomePage(driver);
        signInPage = new SignInPage(driver);
        welcomePage.clickSaveButton();
        welcomePage.clickSignInButton();
        //LogIn as Dispatcher
        signInPage.findEmail();
        signInPage.typeEmail(Email);
        signInPage.typePassword(Password);
        signInPage.clickSignInButton();

    }

    public WelcomePage clickBackButton() {
        driver.findElement(backButton).click();
        return new WelcomePage(driver);
    }
    public void findEmail(){
        driver.findElement(email);
    }

    public void typeEmail(String email){
        driver.findElementByAccessibilityId(emailInput).sendKeys(email);
    }

    public void typePassword(String password){
        driver.findElementByAccessibilityId(passwordInput).sendKeys(password);
    }

    public AllowLocationPage clickSignInButton() {
        driver.findElement(signInButton).click();

        return new AllowLocationPage(driver);
    }







}
