package com.nexttrucking.automation.mobile.aguest;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;


public class SignUpPage extends PageProperty {


    private AppiumDriver<MobileElement> driver;
    public static String attributeName;
    private String backButton = "//*[contains(@%s, '\uF3CF')]";
    private String closeButton = "//*[contains(@%s, '\uF406')]";
    private String emailInput = "//*[contains(@%s, 'Email')]/following-sibling::*[1]";
    private String passwordInput = "//*[contains(@%s, 'Password')]/following-sibling::*[1]";
    private String ownerCheckbox = "//*[contains(@%s, 'Owner')]/following-sibling::*[1]";
    private String dispatcherCheckbox = "//*[contains(@%s, 'Dispatcher')]/following-sibling::*[1]";
    private String typeCityInput = "//*[contains(@%s, 'Type')]";
    private String continueButton = "//*[contains(@%s, 'Continue')]";
    private String saveHomeButton = "//*[contains(@%s, 'Save Home')]";
    private String firstNameInput = "//*[contains(@%s, 'First')]/following-sibling::*[2]";
    private String lastNameInput = "//*[contains(@%s, 'Last')]/following-sibling::*[2]";
    private String phoneNumberInput = "//*[contains(@%s, 'Phone')]/following-sibling::*[1]";
    private String signUpButton = "//*[contains(@%s, 'Sign Up')]";
    private String selectCityCheckbox = "//*[contains(@%1$s, \"%2$s\") and contains(@%1$s, 'USA')]";
    private String closeButtonIOS = "(//XCUIElementTypeStaticText)[1]";

    public SignUpPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
    }


    public WelcomePage clickBackButton() {
        if (attributeName=="text") {
            clickElement(backButton);
        } else if (attributeName=="name"){
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

    public void chooseCity(String city){
        sendKeyToElement(typeCityInput, city);
        clickMenu(selectCityCheckbox, city);
    }

    public SignUpPage clickSaveHomeButton() {
        clickElement(saveHomeButton);
        return this;
    }

    public void typeFirstName(String firstName){
        sendKeyToElement(firstNameInput, firstName);
    }

    public void typeLastName(String lastName){
        sendKeyToElement(lastNameInput, lastName);
    }

    public void typePhoneNumber(String phoneNumber){
        sendKeyToElement(phoneNumberInput, phoneNumber);
    }

    public void clickSignUpButton(){
        clickElement(signUpButton);
    }

    public void clickCloseButton(){
        if (attributeName=="text") {
            clickElement(closeButton);
        } else if (attributeName=="name"){
            driver.findElement(By.xpath(closeButtonIOS)).click();
        }

    }

}
