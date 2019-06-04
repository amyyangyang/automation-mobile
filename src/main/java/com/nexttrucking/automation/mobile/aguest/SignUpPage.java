package com.nexttrucking.automation.mobile.aguest;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;

public class SignUpPage extends PageProperty {

    //  Notice:
    //  All xPath locators from this class should be modified according new way for create xPath locators for both (Android and iOS) systems
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

    public SignUpPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
    }


    public WelcomePage clickBackButton() {
        clickElement(backButton);
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
        clickElement(closeButton); //you should fix this method to use it fot iOS testing. We can not use "//*[contains(@%s, '\uF406')]" locator for iOS.
    }

}
