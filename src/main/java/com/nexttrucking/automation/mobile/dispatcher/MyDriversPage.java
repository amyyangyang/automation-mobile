package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;


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
    private String selectedDriverForIOS = "//*[@name='driver_view_list']/*/*/*[2]/*";
    private String selectedDriverForAndroid = "//*[@content-desc='driver_view_list']/*/*/*/*";
    private String selectedField = "(//*[contains(@%1$s, \"%2$s\")])[last()]";
    private String saveButtonAndroid = "(//*[contains(@%s, 'Save')])[last()]/..";
    private String saveButtonIOS = "(//*[contains(@%s, 'Save')])[last()]";
    private String editFirstNameInputForIOS = "(//*[contains(@name, 'First')]/following-sibling::*/*)[1]";
    private String editFirstNameInputForAndroid = "(//*[contains(@text, 'First')]/following-sibling::*)[2]";
    private String editLastNameInputForIOS = "(//*[contains(@name, 'Last')]/following-sibling::*/*)[1]";
    private String editLastNameInputForAndroid = "(//*[contains(@text, 'Last')]/following-sibling::*)[2]";
    private String editPhoneInputForIOS = "(//*[contains(@name, 'Phone')]/*/*)[last()]";
    private String editPhoneInputForAndroid = "(//*[contains(@text, 'Phone')]/following-sibling::*)[1]";
    private String editedData = "(//*[contains(@%1$s, \"%2$s\")])[last()]";
    private String addDriverTitle = "//*[contains(@%s, 'You')]";
    private String loadDriverInfo = "//*[contains(@text, 'load')]";
    private String earnedDriverInfo = "//*[contains(@text, 'earned')]";
    private String newPasswordInputForIOS = "//*[contains(@name, 'New Password')]/*/XCUIElementTypeSecureTextField";
    private String newPasswordInputForAndroid = "//*[contains(@text, 'New')]/following-sibling::*[1]";
    private String editedEquipmentForIOS = "(//*[contains(@name, 'Equipment')])[last()]";
    private String editedEquipmentForAndroid = "//*[contains(@text, '53 ft Reefer')]";
    private String fixedEquipmentForIOS = "//*[contains(@name, 'Equipment')]";
    private String fixedEquipmentForAndroid = "//*[contains(@text, '48 ft Flatbed')]";
    private String closeModal="//*[contains(@%s, '\uF406')]";

    public MyDriversPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
    }


    public void clickAddDriverButton() {
        clickElement(addDriverButton);
    }

    public void typeEmail(String email) {
        sendKeyToElement(emailInput, email);
    }

    public void typePassword(String password) {
        sendKeyToElement(passwordInput, password);
    }

    public void clickContinueButton() {
        clickElement(continueButton);
    }

    public void selectDriverType(String driverType) {
        selectRadioButton(radioButtonElement, driverType);
    }


    public void selectDriverSize(String driverSize) {
        selectRadioButton(radioButtonElement, driverSize);
    }

    public void typeFirstName(String firstName) {
        driver.findElementByAccessibilityId(firstNameInput).sendKeys(firstName);
    }

    public void typeLastName(String lastName) {
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

    public String getFirstDriverName(String driverFirstName) {
        return getText(firstDriver, driverFirstName);
    }

    public void selectFirstDriver() {
        clickElementWithDifferentLocator(selectedDriverForAndroid, selectedDriverForIOS);
    }

    public void selectField(String elementName) throws InterruptedException {
        clickElementByName(selectedField, elementName);
        Thread.sleep(2000);
    }

    public void clickSaveButton() throws InterruptedException {
        clickElementWithDifferentLocator(saveButtonAndroid, saveButtonIOS);
        Thread.sleep(2000);
    }

    public void editFirstName(String newFirstName) throws InterruptedException {
        String currentFirstName = getCurrentName("FirstName");
        int clickDeleteAmount = currentFirstName.length();
        editInputValue(editFirstNameInputForIOS, editFirstNameInputForAndroid, newFirstName, "words", clickDeleteAmount);
        while (!getWrittenData("FirstName").contains(newFirstName)) {
            editInputValue(editFirstNameInputForIOS, editFirstNameInputForAndroid, newFirstName, "words", clickDeleteAmount);
        }
    }

    public void editLastName(String newLastName) throws InterruptedException {
        String currentFirstName = getCurrentName("LastName");
        int clickDeleteAmount = currentFirstName.length();
        editInputValue(editLastNameInputForIOS, editLastNameInputForAndroid, newLastName, "words", clickDeleteAmount);
        while (!getWrittenData("LastName").contains(newLastName)) {
            editInputValue(editLastNameInputForIOS, editLastNameInputForAndroid, newLastName, "words", clickDeleteAmount);
        }
    }

    public void editPhone(String newPhone) throws InterruptedException {
        int round = 2;
        String currentFirstName = getCurrentName("Phone");
        int clickDeleteAmount = currentFirstName.length();
        editInputValue(editPhoneInputForIOS, editPhoneInputForAndroid, newPhone, "number", clickDeleteAmount);
        String newPhoneNumber = newPhone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");
        while (!getWrittenData("Phone").contains(newPhoneNumber)) {
            editInputValue(editPhoneInputForIOS, editPhoneInputForAndroid, newPhone, "number", clickDeleteAmount);
            System.out.println("ROUND NUMBER IS: " + round);
            round++;
        }
    }

    public String getDrivers() {
        if (attributeName.equals("text")) {
            return selectedDriverForAndroid;
        } else {
            return selectedDriverForIOS;
        }
    }

    public String getAnyTitle() {
        return editedData;
    }

    public void clickDarnOkButton() {
        if (attributeName.equals("text")) {
            clickElementByName(editedData, "OK");
        } else if (attributeName.equals("name")) {
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(PointOption.point(190, 670)).perform();
        }
     //   clickElementByLocator("path",closeModal);
    }

    public void selectPriceVisibilityRadio(String radioButton) {
        if (attributeName.equals("text")) {
            clickElementByName(editedData, radioButton);
        } else if (attributeName.equals("name")) {
            TouchAction touchAction = new TouchAction(driver);
            if (radioButton.equals("Hide")) {
                touchAction.tap(PointOption.point(190, 610)).perform();
            } else if (radioButton.equals("Show")) {
                touchAction.tap(PointOption.point(190, 680)).perform();
            } else if (radioButton.equals("Save")) {
                touchAction.tap(PointOption.point(190, 750)).perform();
            }
        }
    }


    public String getAddDriverTitle() {
        return addDriverTitle;
    }

    public String getDriverLoadInfo() {
        return getElementTextWithDifferentLocator(loadDriverInfo, selectedDriverForIOS);
    }

    public String getDriverEarnedInfo() {
        return getElementTextWithDifferentLocator(earnedDriverInfo, selectedDriverForIOS);
    }

    public String getWrittenData(String dataName) {
        String newString = null;
        switch (dataName) {
            case "FirstName":
                newString = getElementTextWithDifferentLocator(editFirstNameInputForAndroid, editFirstNameInputForIOS);
                break;
            case "LastName":
                newString = getElementTextWithDifferentLocator(editLastNameInputForAndroid, editLastNameInputForIOS);
                break;
            case "Phone":
                newString = getElementTextWithDifferentLocator(editPhoneInputForAndroid, editPhoneInputForIOS);
                break;
        }
        return newString;
    }

    public String getCurrentName(String dataName) {
        String currentname = null;
        switch (dataName) {
            case "FirstName":
                currentname = getElementTextWithDifferentLocator(editFirstNameInputForAndroid, editFirstNameInputForIOS);
                break;
            case "LastName":
                currentname = getElementTextWithDifferentLocator(editLastNameInputForAndroid, editLastNameInputForIOS);
                break;
            case "Phone":
                currentname = getElementTextWithDifferentLocator(editPhoneInputForAndroid, editPhoneInputForIOS);
                break;
        }
        return currentname;
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
                newString = getValue(editedData, "2");
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

    public void typeNewPassword(String keys) {
        sendKeyToElementWithDifferentLocators(newPasswordInputForAndroid, newPasswordInputForIOS, keys);
    }

    public boolean isEquipmentEdited() {
        if (attributeName.equals("text")) {
            return isElementPresent("path", editedEquipmentForAndroid);
        } else {
            return isElementPresent("path", editedEquipmentForIOS);
        }
    }

    public boolean isEquipmentFixed() {
        if (attributeName.equals("text")) {
            return isElementPresent("path", fixedEquipmentForAndroid);
        } else {
            return isElementPresent("path", fixedEquipmentForIOS);
        }
    }

}
