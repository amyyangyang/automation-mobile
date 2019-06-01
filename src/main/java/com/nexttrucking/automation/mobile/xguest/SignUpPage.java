package com.nexttrucking.automation.mobile.xguest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;

public class SignUpPage {

    public SignUpPage(AppiumDriver<MobileElement> driver, String attributeName) {
        this.driver = driver;
        this.attributeName = attributeName;
    }
    //  Notice:
    //  All xPath locators from this class should be modified according new way for create xPath locators for both (Android and iOS) systems
    private AppiumDriver<MobileElement> driver;
    public static String attributeName;
    private By backButton = xpath("//*[contains(@text, '\uF3CF')]");
    private By closeButton = xpath("//*[contains(@text, '\uF406')]");
    private By emailInput = xpath("//*[contains(@text, 'Email')]/following-sibling::*[1]");
    private By passwordInput = xpath("//*[contains(@text, 'Password')]/following-sibling::*[1]");
    private By ownerCheckbox = xpath("//*[contains(@text, 'Owner')]/following-sibling::*[1]");
    private By dispatcherCheckbox = xpath("//*[contains(@text, 'Dispatcher')]/following-sibling::*[1]");
    private By typeCityInput = xpath("//*[contains(@text, 'Type')]");
    private String selectCityCheckbox = "//*[contains(@text, \"%s\") and contains(@text, 'USA')]";
    private By continueButton = xpath("//*[contains(@text, 'Continue')]");
    private By saveHomeButton = xpath("//*[contains(@text, 'Save Home')]");
    private By firstNameInput = xpath("//*[contains(@text, 'First')]/following-sibling::*[2]");
    private By lastNameInput = xpath("//*[contains(@text, 'Last')]/following-sibling::*[2]");
    private By phoneNumberInput = xpath("//*[contains(@text, 'Phone')]/following-sibling::*[1]");
    private By signUpButton = xpath("//*[contains(@text, 'Sign Up')]");



    public WelcomePage clickBackButton() {
        driver.findElement(backButton).click();
        return new WelcomePage(driver, attributeName);
    }

    public void typeEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void typePassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public SignUpPage clickContinueButton() {
        driver.findElement(continueButton).click();
        return this;
    }

    public void chooseUserRole(String role){
        if (role.equals("OwnerOperator")){
            driver.findElement(ownerCheckbox).click();
        } else if (role.equals("Dispatcher")) {
            driver.findElement(dispatcherCheckbox).click();
        } else System.out.println("Please choose correct User role");
    }

    public void chooseCity(String city){
        driver.findElement(typeCityInput).sendKeys(city);
        driver.findElement(By.xpath(String.format(selectCityCheckbox, city))).click();
    }

    public SignUpPage clickSaveHomeButton() {
        driver.findElement(saveHomeButton).click();
        return this;
    }

    public void typeFirstName(String firstName){
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void typeLastName(String lastName){
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void typePhoneNumber(String phoneNumber){
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
    }

    public void clickSignUpButton(){
        driver.findElement(signUpButton).click();

    }

    public void clickCloseButton(){
        driver.findElement(closeButton).click();
    }

}
