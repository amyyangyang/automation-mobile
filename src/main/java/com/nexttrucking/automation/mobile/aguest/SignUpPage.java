package com.nexttrucking.automation.mobile.aguest;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;


public class SignUpPage extends PageProperty {


    private String backButton = "//*[contains(@%s, '\uF3CF')]";
    private String closeButton = "//*[contains(@%s, '\uF406')]";
    private String emailInput = "//*[contains(@%s, 'Email')]/following-sibling::*[1]";
    private String passwordInput = "//*[contains(@%s, 'Password')]/following-sibling::*[1]";
    private String ownerCheckbox = "(//*[contains(@%s, 'Owner')])[last()]";
    private String dispatcherCheckbox = "(//*[contains(@%s, 'Dispatcher')])[last()]";
    private String typeCityInput = "(//*[contains(@%s, 'city')])[last()]";
    private String continueButton = "(//*[contains(@%s, 'Continue')])[last()]";
    private String saveHomeButton = "(//*[contains(@%s, 'Save Home')])[last()]";
    private String firstNameInput = "createAccount_input_fistName";
    private String lastNameInput = "createAccount_input_lastName";
    private String phoneNumberInput = "createAccount_input_phone";
    private String signUpButton = "(//*[@%s='Sign Up'])[last()]";
    private String selectCityCheckbox = "(//*[contains(@%1$s, \"%2$s, NY\")])[last()]";
    private String closeButtonIOS = "(//XCUIElementTypeStaticText)[1]";
    private String editPhoneInputForIOS = "(//*[@name='createAccount_input_phone'])[last()]";
    private String editPhoneInputForAndroid = "(//*[@text='createAccount_input_phone'])[last()]";
    public String pageTitle = "(//*[contains(@%s, \"You’re already registered\")])[last()]";
    public String equipmentTitle = "(//*[contains(@%s, 'What do you have?')])[last()]";
    private String usDocketInput = "selectCarrier_input_docket";
    private String companyNameInput = "selectCarrier_input_company";
    private String firstModal = "(//*[contains(@%s, 'Which modes do you do?')]/parent::*/following-sibling::*)[2]/child::*/child::*";
    private String firstModalForIOS = "(//*[contains(@%s,'Full Truckload')]/following-sibling::*)[1]";
    private String submitInformationButton = "(//*[contains(@%s, 'Submit Information')])[last()]";
    public String promptMessage = "(//*[contains(@%s, 'Just so you')])[last()]";
    private String showWhatButton = "(//*[contains(@%s, 'Show')])[last()]";
    public String messageAfterSigningUp = "(//*[contains(@%s, \"We're working hard\")])[last()]";
    public String followingMessageAfterSigningUp = "(//*[contains(@%s, 'As soon as ')])[last()]";
    public String messageAfterSigningUpText = "We're working hard to expand the first trucker-centric marketplace, but aren't prepared to service your preferences just yet.";
    public String followingMessageAfterSigningUpText = "As soon as we're ready to get your wheels turning, we'll be in touch.";

    public SignUpPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
    }

    public WelcomePage clickBackButton() {
        clickElementWithDifferentLocator(backButton, closeButtonIOS);
        return new WelcomePage(driver, attributeName);
    }

    public void typeEmail(String email) {
        sendKeyToElement(emailInput, email);
    }

    public void typePassword(String password) {
        sendKeyToElement(passwordInput, password);
    }

    public SignUpPage clickContinueButton() {
        clickElement(continueButton);
        return this;
    }

    public void chooseUserRole(String role) {
        if (role.equals("OwnerOperator")) {
            clickElement(ownerCheckbox);
        } else if (role.equals("Dispatcher")) {
            clickElement(dispatcherCheckbox);
        } else System.out.println("Please choose correct User role");
    }

    public void chooseCity(String city) throws InterruptedException {
        sendKeyToElement(typeCityInput, city);
        Thread.sleep(4000);
        clickMenu(selectCityCheckbox, city);
        Thread.sleep(2000);
    }

    public SignUpPage clickSaveHomeButton() {
        clickElement(saveHomeButton);
        return this;
    }

    public void typeFirstName(String firstName) {
        driver.findElementByAccessibilityId(firstNameInput).sendKeys(firstName);
    }

    public void typeLastName(String lastName) {
        driver.findElementByAccessibilityId(lastNameInput).sendKeys(lastName);
    }

    public void typePhoneNumber(String phoneNumber) throws InterruptedException {
        driver.findElementByAccessibilityId(phoneNumberInput).sendKeys(phoneNumber);
        if (attributeName.equals("name")) {
            String newPhoneNumber = phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");
            while (!getElementTextWithDifferentLocator(editPhoneInputForAndroid, editPhoneInputForIOS).contains(newPhoneNumber)) {
                editInputValue(editPhoneInputForIOS, editPhoneInputForAndroid, phoneNumber, "number", 10);
            }
        }
        Thread.sleep(3000);
    }

    public void clickSignUpButton() throws InterruptedException {
        clickElement(signUpButton);
        Thread.sleep(5000);
    }

    public void clickCloseButton() {
        clickElementWithDifferentLocator(closeButton, closeButtonIOS);
    }

    public void clickSignInButton() {
        if (attributeName.equals("name")) {
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(PointOption.point(100, 750)).perform();
        } else {
            clickAnyElementByName("Sign In");
        }
    }

    public void typeCompanyInformation(String usDocket, String companyName) {
        driver.findElementByAccessibilityId(usDocketInput).sendKeys(usDocket);
        driver.findElementByAccessibilityId(companyNameInput).sendKeys(companyName);
    }

    public void chooseMode(String mode) throws InterruptedException {
        if (attributeName.equals("text")) {
            clickElement(firstModal);
        } else {
            clickElement(firstModalForIOS);
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(PointOption.point(190, 200)).perform();
            touchAction.tap(PointOption.point(190, 260)).perform();
            touchAction.tap(PointOption.point(190, 290)).perform();
            touchAction.tap(PointOption.point(190, 330)).perform();
            touchAction.tap(PointOption.point(190, 360)).perform();
            touchAction.tap(PointOption.point(190, 390)).perform();
            Thread.sleep(3000);
        }
    }

    public void submitInformation() {
        clickElement(submitInformationButton);
    }

    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    public void clickAlert() {
        clickElement(showWhatButton);
    }
}
