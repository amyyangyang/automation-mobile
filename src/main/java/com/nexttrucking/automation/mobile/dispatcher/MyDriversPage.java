package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;



public class MyDriversPage extends PageProperty {

    private String addDriverButton = "(//*[contains(@%s, 'Add a Driver')])[last()]";
    private String emailInput = "//*[@%s='Email']/following-sibling::*[1]";
    private String passwordInput = "(//*[contains(@%s, 'Password')]/following-sibling::*)[1]";
    private String continueButton = "(//*[@%s='Continue'])[last()]";
    private String radioButtonElement = "(//*[contains(@%1$s, \"%2$s\")])[last()]";
    private String firstNameInput = "createAccount_input_fistName";
    private String lastNameInput = "createAccount_input_lastName";
    private String phoneNumberInput = "createAccount_input_phone";
    private String sendInviteButton = "(//*[@%s='Send Invite'])[last()]";
    private String firstDriver = "(//*[contains(@%1$s, \"%2$s\")])[last()]";

    public MyDriversPage(AppiumDriver< MobileElement > driver, String attributeName) {
        super(driver, attributeName);
    }



    public void clickAddDriverButton(){
       clickElement(addDriverButton);
    }

    public void typeEmail(String email){
        sendKeyToElement(emailInput, email);
    }

    public void typePassword(String password){
        sendKeyToElement(passwordInput, password);
    }

    public void clickContinueButton(){
        clickElement(continueButton);
    }

    public void selectDriverType(String driverType){
        selectRadioButton(radioButtonElement, driverType);
    }

    public void selectDriverSize(String driverSize){
        selectRadioButton(radioButtonElement, driverSize);
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

    public void clickSignUpButton() throws InterruptedException {
        clickElement(sendInviteButton);
        Thread.sleep(5000);
    }

    public String getFirstDriverName(String driverFirstName){
        return getText(firstDriver, driverFirstName);
    }
}
