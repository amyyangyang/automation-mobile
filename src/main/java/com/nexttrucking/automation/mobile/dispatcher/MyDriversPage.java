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
    private String selectedDriver = "(//*[contains(@%s, 'Sera')])[last()]";
    private String selectedField = "(//*[contains(@%1$s, \"%2$s\")])[last()]";
    private String saveButtonAndroid = "(//*[contains(@%s, 'Save')])[last()]/..";
    private String saveButtoniOS = "(//*[contains(@%s, 'Save')])[last()]";
    private String editFirstNameInputForiOS = "(//*[contains(@%s, 'First')]/following-sibling::*)[1]";
    private String editFirstNameInputForAndroid = "(//*[contains(@%s, 'First')]/following-sibling::*)[2]";
    private String editLastNameInputForiOS = "(//*[contains(@%s, 'Last')]/following-sibling::*)[1]";
    private String editLastNameInputForAndroid = "(//*[contains(@%s, 'Last')]/following-sibling::*)[2]";
    private String editPhoneInputForiOS = "(//*[contains(@%s, 'Phone')]/following-sibling::*)[1]";
    private String editPhoneInputForAndroid = "(//*[contains(@%s, 'Phone')]/following-sibling::*)[1]";
    private String editedData = "(//*[contains(@%1$s, \"%2$s\")])[last()]";



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

    public void selectDriver(){
        clickElement(selectedDriver);
    }

    public void selectField(String elementName){
        clickElementByName(selectedField, elementName);
    }

    public void clickSaveButton() throws InterruptedException {
        clickElementWithDifferentLocator(saveButtonAndroid, saveButtoniOS);
        Thread.sleep(2000);
        clickElementWithDifferentLocator(saveButtonAndroid, saveButtoniOS);
        Thread.sleep(5000);
    }

    public void editFirstName(String newFirstName) throws InterruptedException {
        editInputValue(editFirstNameInputForiOS, editFirstNameInputForAndroid, newFirstName);
    }

    public void editLastName(String newLastName) throws InterruptedException {
        editInputValue(editLastNameInputForiOS, editLastNameInputForAndroid, newLastName);
    }

    public void editPhone(String newPhone) throws InterruptedException {
        editInputValue(editPhoneInputForiOS, editPhoneInputForAndroid, newPhone);
    }

    public String getSavedData(String dataName) {
        String newString = null;
        switch (dataName) {
            case "FirstName":
                newString = getText(editedData, "Sera");
                break;
            case "LastName":
                newString = getText(editedData, "Abe");
                break;
            case "Phone":
                newString = getText(editedData, "234");
                break;
            case "Email":
                newString = getText(editedData, "sergii");
                break;
            case "Equipment":
                newString = getText(editedData, "48");
                break;
        }
        return newString;
    }

}
