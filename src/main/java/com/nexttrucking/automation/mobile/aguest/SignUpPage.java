package com.nexttrucking.automation.mobile.aguest;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;


public class SignUpPage extends PageProperty {


    private String backButton = "//*[contains(@%s, '\uF3CF')]";
    private String closeButton = "//*[contains(@%s, '\uF406')]";
    private String emailInput = "//*[contains(@%s, 'Email')]/following-sibling::*[1]";
    private String passwordInput = "//*[contains(@%s, 'Password')]/following-sibling::*[1]";
    private String ownerCheckbox = "//*[contains(@%s, 'Owner')]/following-sibling::*[1]";
    private String dispatcherCheckbox = "//*[contains(@%s, 'Dispatcher')]/following-sibling::*[1]";
    private String typeCityInput = "//*[contains(@%s, 'city')]";
    private String continueButton = "//*[contains(@%s, 'Continue')]";
    private String saveHomeButton = "(//*[contains(@%s, 'Save Home')])[last()]";
    private String firstNameInput = "createAccount_input_fistName";
    private String lastNameInput = "createAccount_input_lastName";
    private String phoneNumberInput = "createAccount_input_phone";
    private String signUpButton = "//*[@%s='Sign Up']";
    private String selectCityCheckbox = "(//*[contains(@%1$s, \"%2$s\") and contains(@%1$s, 'USA')])[last()]";
    private String closeButtonIOS = "(//XCUIElementTypeStaticText)[1]";

    public SignUpPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
    }


    public WelcomePage clickBackButton() {
        if (attributeName.equals("text")) {
            clickElement(backButton);
        } else if (attributeName.equals("name")){
            driver.findElement(By.xpath(closeButtonIOS)).click();
        }
        return new WelcomePage(driver, attributeName);
    }

    public void typeEmail(String email){
        sendKeyToElement(emailInput, email);
    }

    public void typePassword(String password){
        sendKeyToElement(passwordInput, password);
    }

    public SignUpPage clickContinueButton() {
        clickElement(continueButton);
        return this;
    }

    public void chooseUserRole(String role){
        if (role.equals("OwnerOperator")){
            clickElement(ownerCheckbox);
        } else if (role.equals("Dispatcher")) {
            clickElement(dispatcherCheckbox);
        } else System.out.println("Please choose correct User role");
    }

    public void chooseCity(String city) throws InterruptedException {
        sendKeyToElement(typeCityInput, city);
        Thread.sleep(2000);
        clickMenu(selectCityCheckbox, city);
        Thread.sleep(2000);
    }

    public SignUpPage clickSaveHomeButton() {
        clickElement(saveHomeButton);
        return this;
    }

    public void typeFirstName(String firstName){
        driver.findElementByAccessibilityId(firstNameInput).sendKeys(firstName);
    }

    public void typeLastName(String lastName){
        driver.findElementByAccessibilityId(lastNameInput).sendKeys(lastName);
    }

    public void typePhoneNumber(String phoneNumber) throws InterruptedException {
        driver.findElementByAccessibilityId(phoneNumberInput).sendKeys(phoneNumber);
        Thread.sleep(3000);
    }

    public void clickSignUpButton(){
        clickElement(signUpButton);
    }

    public void clickCloseButton(){
        if (attributeName.equals("text")) {
            clickElement(closeButton);
        } else if (attributeName.equals("name")){
            driver.findElement(By.xpath(closeButtonIOS)).click();
        }

    }

}
