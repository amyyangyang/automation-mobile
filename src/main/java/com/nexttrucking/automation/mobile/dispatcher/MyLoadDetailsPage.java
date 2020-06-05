package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyLoadDetailsPage extends PageProperty {

    public String readyToStart = "(//*[contains(@%s, \"I'm Ready to Start Driving\")])[last()]";

    //status for trips job
    public String hookCompletedButton = "(//*[contains(@%s, \"Hook Completed\")])[last()]";
    public String dropCompletedButton = "(//*[contains(@%s, \"Drop Completed\")])[last()]";
    public String liveUnloadCompletedButton = "(//*[contains(@%s, \"Live Unload Completed\")])[last()]";
    public String chassisHookedButton = "//*[contains(@%s, 'Chassis Hooked')]";
    public String containerMountedButton = "//*[contains(@%s, 'Container Mounted')]";
    public String containerDismountedButton = "//*[contains(@%s, 'Container Dismounted')]";
    public String chassisDroppedButton = "//*[contains(@%s, 'Chassis Dropped')]";

    //status for legacy job
    public String arrivedButton = "(//*[contains(@%s, \"I've Arrived\")])[last()]";
    public String pickUpCompletedButton = "(//*[contains(@%s, \"Pickup Completed\")])[last()]";
    public String readyToLeaveButton = "(//*[contains(@%s, \"I'm Leaving\")])[last()]";
    public String deliveryCompletedButton = "(//*[contains(@%s, \"Delivery Completed\")])[last()]";

    //confirm buttons
    public String undoButton = "(//*[contains(@%s, 'Undo')])[last()]";
    public String confirmButton = "(//*[contains(@%s, 'Yes, I Confirm')])[last()]";
    public String confirmChassisSizeModal = "(//*[contains(@%s, \"Are you sure\")])[last()]";
    public String confirmChassisSizeOkButton = "//*[contains(@%s, \"Yes, I’m Sure\")]";

    //add chassis
    public String addButton = "//*[@%s='Add']";
    public String nextButton = "//*[@%s='Next']";
    public String addChassisNumberButton = "//*[contains(@%s, 'Add Chassis Number')]";
    public String chassisNumberInput = "//*[contains(@%s, \"What's the chassis number?\")]/following-sibling::*/following-sibling::*/child::*[2]";
    public String chassisNumberInputForIOS = "//XCUIElementTypeTextField";
    public String chassisSizeRadio = "(//*[contains(@%s,'20 ft')]/following-sibling::*)[1]";
    public String useADifferentChassis = "(//*[@%s='Use a Different Chassis'])[last()]";

    //buttons to upload pod or not
    public String continueButton = "(//*[contains(@%s, 'Continue')])[last()]";
    public String upLoadDocumentsButton = "(//*[@%s='Upload Documents'])[last()]";

    //submit carrier invoice
    public String resume = "(//*[@%s='Resume'])[last()]";
    public String reviewInvoiceButton = "//*[contains(@%s, 'Review Invoice')]";
    public String completeInvoiceButton = "(//*[contains(@%s, 'Complete Invoice')])[last()]";
    public String submitInvoiceButton = "(//*[@%s='Submit Invoice'])[last()]";
    public String skipInvoiceButton = "(//*[@%s='Skip invoice for now'])[last()]";
    public String goToMyLoadsButton = "(//*[contains(@%s,'Go back to My Loads')])[last()]";
    public String addInvoiceButton = "(//*[contains(@%s,'Add')])[last()]";
    public String detentionFee = "(//*[contains(@%s,'Detention')])[last()]";
    public String chassisSplitFee = "(//*[contains(@%s,'Chassis Split')])[last()]";
    public String stopChargeFee = "(//*[contains(@%s,'Stop Charge')])[last()]";
    public String tounFee = "(//*[contains(@%s,'TONU')])[last()]";
    public String scaleFee = "(//*[contains(@%s,'Scale')])[last()]";
    public String driverAssistFee = "(//*[contains(@%s,'Driver Assist')])[last()]";
    public String otherFee = "(//*[contains(@%s,'Other')])[last()]";
    public String continueFeeButton = "(//*[contains(@%s,'Continue')])[last()]";
    public String addStopChargeButton = "(//*[contains(@%s,'Add Stop Charge')])[last()]";

    //tab
    public String liveUnload = "(//*[contains(@text,'Live Unload')])[last()]";
    public String liveUnLoadByLabel = "(//*[contains(@label,'Live Unload')])[last()]";
    public String locationPanel = "(//*[contains(@%s,'Locations')])[last()]";
    public String detailPanel = "(//*[contains(@%s,'Details for')])[last()]";
    public String containerStatus = "(//*[contains(@%s,'Container')])[last()]";
    public String originalAddress = "address_0";
    public String secondAddress = "address_1";
    public String thirdAddress = "address_2";
    public String getTextInAddress = "textGroupValue_0";
    public String getTextInTime = "textGroupValue_0";
    public String addressText = "textGroupValue_0";
    public String promptMessage = "(//*[contains(@%s,'Complete the previous load before starting this one')])[last()]";

    public Map<String, String> myLoadsDetailCardMap;

    public MyLoadDetailsPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
        if (attributeName.equals("text")) {
            myLoadsDetailCardMap = new HashMap<>();
            myLoadsDetailCardMap.put("takePhoto", "(//*[@class='android.widget.ImageView'])[2]");
            myLoadsDetailCardMap.put("cropButton", "(//*[@class='android.widget.ImageView'])[3]");
            myLoadsDetailCardMap.put("submitPOD", "(//*[@class='android.widget.ImageView'])[3]");
            myLoadsDetailCardMap.put("firstInstructionAction", "//*[contains(@text, 'Upload POD')]/parent::*/parent::*/following-sibling::*/*/*/*/*[1]/*/*/*[1]");
            myLoadsDetailCardMap.put("secondInstructionAction", "//*[contains(@text, 'Upload POD')]/parent::*/parent::*/following-sibling::*/*/*/*/*[2]/*/*/*[1]");
            myLoadsDetailCardMap.put("firstInstructionAddress", "//*[contains(@text, 'Upload POD')]/parent::*/parent::*/following-sibling::*/*/*/*/*[1]/*/*/*[3]");
            myLoadsDetailCardMap.put("secondInstructionAddress", "//*[contains(@text, 'Upload POD')]/parent::*/parent::*/following-sibling::*/*/*/*/*[2]/*/*/*[3]");
            myLoadsDetailCardMap.put("firstInstructionBlueIcon", "//*[contains(@text, 'Upload POD')]/parent::*/parent::*/following-sibling::*/*/*/*/*[1]/*/*/*[2]");
            myLoadsDetailCardMap.put("secondInstructionBlueIcon", "//*[contains(@text, 'Upload POD')]/parent::*/parent::*/following-sibling::*/*/*/*/*[2]/*/*/*[2]");
            myLoadsDetailCardMap.put("closeSubmitPage", "//*[contains(@text, '\uF406')]");
            myLoadsDetailCardMap.put("backToMyLoads", "//*[contains(@text, '\uF3CF')]");
            myLoadsDetailCardMap.put("notContinueUploadPOD", "//*[contains(@text, '\uF406')]");
            myLoadsDetailCardMap.put("locationArrow", "//*[contains(@text, '\uF3D0')]");
            myLoadsDetailCardMap.put("summaryTab", "//*[@text='Summary']");
            myLoadsDetailCardMap.put("hookTab", "//*[@text='1. Hook']");
            myLoadsDetailCardMap.put("liveUnloadPanel", "//*[@text='2. Live Unload']");
            myLoadsDetailCardMap.put("dropTab", "//*[@text='3. Drop']");
            myLoadsDetailCardMap.put("youWillMakeText", "//*[@text=\"You'll Make\"]");
            myLoadsDetailCardMap.put("youWillMakeValue", "//*[@text=\"You'll Make\"]/following-sibling::*[1]");
            myLoadsDetailCardMap.put("rateContractText", "//*[@text='Rate Contract']");
            myLoadsDetailCardMap.put("rateContractValue", "//*[@text='Rate Contract']/following-sibling::*[1]");
            myLoadsDetailCardMap.put("masterBillOfLadingText", "//*[@text='Master Bill of Lading']");
            myLoadsDetailCardMap.put("masterBillOfLadingValue", "//*[@text='Master Bill of Lading']/following-sibling::*[1]");
            myLoadsDetailCardMap.put("commodityText", "//*[@text='Commodity']");
            myLoadsDetailCardMap.put("commodityValue", "//*[@text='Commodity']/following-sibling::*[1]");
            myLoadsDetailCardMap.put("GoodsValueText", "//*[@text='Goods Value']");
            myLoadsDetailCardMap.put("GoodsValueValue", "//*[@text='Goods Value']/following-sibling::*[1]");
            myLoadsDetailCardMap.put("equipmentText", "//*[@text='Equipment']");
            myLoadsDetailCardMap.put("equipmentValue", "//*[@text='Equipment']/following-sibling::*[1]");
            myLoadsDetailCardMap.put("containerNumberText", "//*[@text='Container Number']");
            myLoadsDetailCardMap.put("containerNumberValue", "//*[@text='Container Number']/following-sibling::*[1]");
            myLoadsDetailCardMap.put("stopChargeAudio", "//*[contains(@text, 'Stop Charge')]/..");
        } else {
            myLoadsDetailCardMap = new HashMap<>();
            myLoadsDetailCardMap.put("takePhoto", "//*[@name='camera']");
            myLoadsDetailCardMap.put("cropButton", "//*[@name='right']");
            myLoadsDetailCardMap.put("submitPOD", "//*[@name='right']");
            myLoadsDetailCardMap.put("firstInstructionAction", "(//XCUIElementTypeStaticText[@name='action'])[1]");
            myLoadsDetailCardMap.put("firstInstructionAddress", "(//XCUIElementTypeStaticText[@name='address'])[1]");
            myLoadsDetailCardMap.put("secondInstructionAction", "(//XCUIElementTypeStaticText[@name='action'])[2]");
            myLoadsDetailCardMap.put("secondInstructionAddress", "(//XCUIElementTypeStaticText[@name='address'])[2]");
            myLoadsDetailCardMap.put("firstInstructionBlueIcon", "(//XCUIElementTypeStaticText[@name=\"\uF14A\"])[1]");
            myLoadsDetailCardMap.put("secondInstructionBlueIcon", "(//XCUIElementTypeStaticText[@name=\"\uF14A\"])[2]");
            myLoadsDetailCardMap.put("closeSubmitPage", "//XCUIElementTypeStaticText[@name=\"\uF406\"]");
            myLoadsDetailCardMap.put("backToMyLoads", "//XCUIElementTypeStaticText[@name=\"\uF3CF\"]");
            myLoadsDetailCardMap.put("notContinueUploadPOD", "//XCUIElementTypeStaticText[@name=\"\uF406\"]");
            myLoadsDetailCardMap.put("summaryTab", "//XCUIElementTypeStaticText[@name=\"0\"]");
            myLoadsDetailCardMap.put("hookTab", "(//XCUIElementTypeStaticText[@name=\"1\"])[1]");
            myLoadsDetailCardMap.put("liveUnloadPanel", "(//XCUIElementTypeStaticText[@name=\"2\"])[1]");
            myLoadsDetailCardMap.put("dropTab", "(//XCUIElementTypeStaticText[@name=\"3\"])[1]");
            myLoadsDetailCardMap.put("youWillMakeText", "(//XCUIElementTypeStaticText[@value=\"You'll Make\"])");
            myLoadsDetailCardMap.put("youWillMakeValue", "(//XCUIElementTypeStaticText[@value=\"You'll Make\"])/../*[2]");
            myLoadsDetailCardMap.put("rateContractText", "(//XCUIElementTypeStaticText[@value=\"Rate Contract\"])");
            myLoadsDetailCardMap.put("rateContractValue", "//XCUIElementTypeStaticText[@value=\"Rate Contract\"]/../*[2]");
            myLoadsDetailCardMap.put("equipmentText", "(//XCUIElementTypeStaticText[@value=\"Equipment\"])");
            myLoadsDetailCardMap.put("equipmentValue", "(//XCUIElementTypeStaticText[@value=\"Equipment\"])/../*[2]");
            myLoadsDetailCardMap.put("masterBillOfLadingText", "//XCUIElementTypeStaticText[@name='Master Bill of Lading']");
            myLoadsDetailCardMap.put("masterBillOfLadingValue", "(//XCUIElementTypeStaticText[@name=‘Master Bill of Lading’])/../*[2]");
            myLoadsDetailCardMap.put("commodityText", "//XCUIElementTypeStaticText[@value='Commodity']");
            myLoadsDetailCardMap.put("commodityValue", "(//XCUIElementTypeStaticText[@value='Commodity'])/../*[2]");
            myLoadsDetailCardMap.put("GoodsValueText", "//XCUIElementTypeStaticText[@value='Goods Value']");
            myLoadsDetailCardMap.put("GoodsValueValue", "(//XCUIElementTypeStaticText[@value='Goods Value'])/../*[2]");
            myLoadsDetailCardMap.put("containerNumberText", "//XCUIElementTypeStaticText[@value='Container Number']");
            myLoadsDetailCardMap.put("containerNumberValue", "(//XCUIElementTypeStaticText[@value='Container Number'])/../*[2]");
        }
    }

    public void changeLegacyJobStatusToCompleted(AllowLocationPage allowLocationPage) throws InterruptedException {
        List<String> status = new ArrayList<String>() {
        };
        status.add(readyToStart);
        status.add(arrivedButton);
        status.add(pickUpCompletedButton);
        status.add(readyToLeaveButton);
        status.add(arrivedButton);
        status.add(deliveryCompletedButton);
        for (int step = 0; step < status.size(); step++) {
            clickElementByLocator("path", status.get(step));
            Thread.sleep(6000);
        }
        clickElementByLocator("path", upLoadDocumentsButton);
        uploadDoc(allowLocationPage, true, 0);
        clickElementByLocator("path", continueButton);
    }

    public void uploadDoc(AllowLocationPage allowLocationPage, Boolean isFirst, int index) throws InterruptedException {
        driver.findElements(By.xpath(String.format(addButton, attributeName))).get(index).click();
        if (isFirst) {
            allowLocationPage.clickOkAllowLocationButton();
            if (attributeName.equals("text")) {
                allowLocationPage.clickAllowLocationButton();
            } else {
                allowLocationPage.clickOkAllowLocationButton();
            }
        }
        clickElementByLocator("path", myLoadsDetailCardMap.get("takePhoto"));
        Thread.sleep(10000);
        clickElementByLocator("path", myLoadsDetailCardMap.get("cropButton"));
        Thread.sleep(10000);
        clickElementByLocator("path", myLoadsDetailCardMap.get("submitPOD"));
        Thread.sleep(10000);
    }

    public void skipSubmitInvoice() {
        clickElementByLocator("path", myLoadsDetailCardMap.get("closeSubmitPage"));
        if (attributeName.equals("text")) {
            clickElementByLocator("path", skipInvoiceButton);
        } else {
            new TouchAction(driver).tap(PointOption.point(171, 750)).perform();
        }
        clickElementByLocator("path", myLoadsDetailCardMap.get("backToMyLoads"));
    }

    public void submitInvoice() throws InterruptedException {
        boolean isPresentReviewInvoiceButton = isElementPresent("path", reviewInvoiceButton);
        if (isPresentReviewInvoiceButton) {
            if (attributeName.equals("text")) {
                clickElementByLocator("path", reviewInvoiceButton);
            } else {
                new TouchAction(driver).tap(PointOption.point(190, 750)).perform();
            }
        } else {
            if (attributeName.equals("text")) {
                clickElementByLocator("path", completeInvoiceButton);
            } else {
                new TouchAction(driver).tap(PointOption.point(190, 750)).perform();
            }
        }
        Thread.sleep(6000);
        clickElementByLocator("path", submitInvoiceButton);
        Thread.sleep(6000);
        if (attributeName.equals("text")) {
            clickElementByLocator("path", goToMyLoadsButton);
        } else {
            new TouchAction(driver).tap(PointOption.point(183, 766)).perform();
            new TouchAction(driver).tap(PointOption.point(150, 760)).perform();
            new TouchAction(driver).tap(PointOption.point(180, 765)).perform();
        }
        Thread.sleep(3000);
    }

    //We have 7 types of job.I divided them into 4 classes.hookAndDrop,hookAndMount,hookAndLiveUnload,hookAndDismount
    //hookAndDrop: Hook-Drop
    //hookAndMount: Hook-Mount-Drop  Hook-Mount-LiveUnload-Dismount-Drop  Hook-Mount-LiveUnload-Drop
    //hookAndLiveUnload: Hook-LiveUnload-Drop  Hook-LiveUnload-Dismount-Drop
    //hookAndDismount: Hook-Dismount-Drop
    public String getTypeOfTripsJob() {
        int count = driver.findElementsByAccessibilityId(originalAddress).size();
        String addressList = new String();
        for (int i = 0; i < count; i++) {
            System.out.print(driver.findElementsByAccessibilityId(originalAddress).get(i).getText());
            addressList += (driver.findElementsByAccessibilityId(originalAddress).get(i).getText());
        }
        if (addressList.contains("Pick Up") && addressList.contains("Drop Off")) {
            return "legacyJob";
        } else if (addressList.contains("Hook") && addressList.contains("Mount")) {
            return "hookAndMount";
        } else if (addressList.contains("Hook") && addressList.contains("Live Unload")) {
            return "HookAndLiveUnload";
        } else if (addressList.contains("Hook") && addressList.contains("Dismount")) {
            return "HookAndDismount";
        } else {
            return "hookAndDrop";
        }
    }

    public boolean checkJobIsHasManyLoads() {
        return isElementPresent("path", promptMessage);
    }

    public void addChassisNumber(String chassisNumber) throws InterruptedException {
        boolean isPresentChassis = isElementPresent("xpath", useADifferentChassis);
        TouchAction touchAction = new TouchAction(driver);
        if (isPresentChassis) {
            if (attributeName.equals("name")) {
                touchAction.tap(PointOption.point(190, 700)).perform();
            } else {
                clickElementByLocator("path", confirmButton);
            }
            Thread.sleep(2000);
            isPresentChassis = isElementPresent("xpath", useADifferentChassis);
            if (isPresentChassis) {
                if (attributeName.equals("name")) {
                    touchAction.tap(PointOption.point(190, 700)).perform();
                } else {
                    clickElementByLocator("path", confirmButton);
                }
            }
        } else {
            if (attributeName.equals("text")) {
                clickElement(addChassisNumberButton);
                driver.findElementByXPath(String.format(chassisNumberInput, attributeName)).sendKeys(chassisNumber);
            } else {
                touchAction.tap(PointOption.point(190, 700)).perform();
                Thread.sleep(3000);
                driver.findElementByXPath(chassisNumberInputForIOS).sendKeys(chassisNumber);
            }
            clickElement(nextButton);
            Thread.sleep(3000);
            clickElement(chassisSizeRadio);
            if (attributeName.equals("text")) {
                clickElement(addButton);
            } else {
                new TouchAction(driver).tap(PointOption.point(190, 600)).perform();
                new TouchAction(driver).tap(PointOption.point(190, 630)).perform();
                new TouchAction(driver).tap(PointOption.point(190, 660)).perform();
                new TouchAction(driver).tap(PointOption.point(190, 690)).perform();
                Thread.sleep(3000);
            }
            boolean isPresentConfirmSizeButton = isElementPresent("path", confirmChassisSizeModal);
            if (isPresentConfirmSizeButton) {
                if (attributeName.equals("text")) {
                    clickElementByLocator("path", confirmChassisSizeOkButton);
                } else {
                    new TouchAction(driver).tap(PointOption.point(190, 700)).perform();
                }
            }
            Thread.sleep(6000);
        }
    }

    public String generateChassisNumber() {
        String chassisNumber = "NEXT";
        int number = (int) ((Math.random() * 9 + 1) * 100000);
        chassisNumber += String.valueOf(number);
        return chassisNumber;
    }

    public void changeHookDropJobToCompleted(AllowLocationPage allowLocationPage) throws InterruptedException {
        if (attributeName.equals("text")) {
            clickElementByLocator("path", readyToStart);
            Thread.sleep(3000);
            clickElementByLocator("path", hookCompletedButton);
            Thread.sleep(3000);
            String chassisNumber = generateChassisNumber();
            addChassisNumber(chassisNumber);
            clickElementByLocator("path", dropCompletedButton);
        } else {
            getElementText("xpath", readyToStart);
            new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
            Thread.sleep(3000);
            getElementText("xpath", hookCompletedButton);
            new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
            Thread.sleep(3000);
            String chassisNumber = generateChassisNumber();
            addChassisNumber(chassisNumber);
            getElementText("xpath", dropCompletedButton);
            new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
        }
        Thread.sleep(3000);
        clickElementByLocator("path", upLoadDocumentsButton);
        uploadDoc(allowLocationPage, true, 0);
        clickElementByLocator("path", continueButton);
    }

    public void changeHookLiveUnloadJobToCompleted(AllowLocationPage allowLocationPage) throws InterruptedException {
        if (attributeName.equals("text")) {
            clickElementByLocator("path", readyToStart);
            Thread.sleep(3000);
            clickElementByLocator("path", hookCompletedButton);
            Thread.sleep(3000);
            String chassisNumber = generateChassisNumber();
            addChassisNumber(chassisNumber);
            clickElementByLocator("path", liveUnloadCompletedButton);
            Thread.sleep(6000);
            clickElementByLocator("path", upLoadDocumentsButton);
            uploadDoc(allowLocationPage, true, 0);
            clickElementByLocator("path", continueButton);
            boolean isPresentDroppedButton = isElementPresent("path", dropCompletedButton);
            if (isPresentDroppedButton) {
                clickElementByLocator("path", dropCompletedButton);
                Thread.sleep(3000);
                clickElementByLocator("path", upLoadDocumentsButton);
                uploadDoc(allowLocationPage, false, 0);
                clickElementByLocator("path", continueButton);
            } else {
                clickElementByLocator("path", containerDismountedButton);
                Thread.sleep(3000);
                clickElementByLocator("path", upLoadDocumentsButton);
                uploadDoc(allowLocationPage, false, 0);
                clickElementByLocator("path", continueButton);
                clickElementByLocator("path", chassisDroppedButton);
                Thread.sleep(3000);
            }
        } else {
            System.out.println(getElementText("path", readyToStart));
            new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
            Thread.sleep(3000);
            System.out.println(getElementText("path", hookCompletedButton));
            new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
            Thread.sleep(3000);
            String chassisNumber = generateChassisNumber();
            addChassisNumber(chassisNumber);
            System.out.println(getElementText("xpath", liveUnloadCompletedButton));
            new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
            Thread.sleep(6000);
            clickElementByLocator("path", upLoadDocumentsButton);
            uploadDoc(allowLocationPage, true, 0);
            clickElementByLocator("path", continueButton);
            boolean isPresentDroppedButton = isElementPresent("path", dropCompletedButton);
            if (isPresentDroppedButton) {
                System.out.println(getElementText("path", dropCompletedButton));
            } else {
                System.out.println(getElementText("path", containerDismountedButton));
            }
            new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
            Thread.sleep(3000);
            clickElementByLocator("path", upLoadDocumentsButton);
            uploadDoc(allowLocationPage, false, 0);
            clickElementByLocator("path", continueButton);
            if (!isPresentDroppedButton) {
                System.out.println(getElementText("path", chassisDroppedButton));
                new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
                Thread.sleep(3000);
            }
        }
    }

    public void changeHookMountJobToCompleted(AllowLocationPage allowLocationPage) throws InterruptedException {
        if (attributeName.equals("text")) {
            clickElementByLocator("path", readyToStart);
            Thread.sleep(3000);
            clickElementByLocator("path", chassisHookedButton);
            Thread.sleep(6000);
            String chassisNumber = generateChassisNumber();
            addChassisNumber(chassisNumber);
            clickElementByLocator("path", containerMountedButton);
            Thread.sleep(3000);
            boolean isLiveUnloadJob = isElementPresent("path", liveUnloadCompletedButton);
            if (!isLiveUnloadJob) {
                clickElementByLocator("path", dropCompletedButton);
                Thread.sleep(3000);
                clickElementByLocator("path", upLoadDocumentsButton);
                uploadDoc(allowLocationPage, true, 0);
                clickElementByLocator("path", continueButton);
            } else {
                clickElementByLocator("path", liveUnloadCompletedButton);
                Thread.sleep(3000);
                clickElementByLocator("path", upLoadDocumentsButton);
                uploadDoc(allowLocationPage, true, 0);
                clickElementByLocator("path", continueButton);
                boolean isDropButton = isElementPresent("path", dropCompletedButton);
                if (isDropButton) {
                    clickElementByLocator("path", dropCompletedButton);
                } else {
                    clickElement(containerDismountedButton);
                }
                Thread.sleep(3000);
                clickElementByLocator("path", upLoadDocumentsButton);
                uploadDoc(allowLocationPage, false, 0);
                clickElementByLocator("path", continueButton);
                if (!isDropButton) {
                    clickElementByLocator("path", chassisDroppedButton);
                    Thread.sleep(3000);
                    clickElementByLocator("path", continueButton);
                }
            }
        } else {
            getElementText("path", readyToStart);
            new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
            Thread.sleep(3000);
            getElementText("path", chassisHookedButton);
            new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
            Thread.sleep(6000);
            String chassisNumber = generateChassisNumber();
            addChassisNumber(chassisNumber);
            getElementText("path", containerMountedButton);
            new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
            Thread.sleep(3000);
            boolean isLiveUnloadJob = isElementPresent("path", liveUnloadCompletedButton);
            if (!isLiveUnloadJob) {
                getElementText("path", dropCompletedButton);
                new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
                Thread.sleep(3000);
                clickElementByLocator("path", upLoadDocumentsButton);
                uploadDoc(allowLocationPage, true, 0);
                clickElementByLocator("path", continueButton);
            } else {
                getElementText("path", liveUnloadCompletedButton);
                new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
                Thread.sleep(3000);
                clickElementByLocator("path", upLoadDocumentsButton);
                uploadDoc(allowLocationPage, true, 0);
                clickElementByLocator("path", continueButton);
                boolean isDropButton = isElementPresent("path", dropCompletedButton);
                if (isDropButton) {
                    getElementText("path", dropCompletedButton);
                    new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
                    Thread.sleep(3000);
                    clickElementByLocator("path", upLoadDocumentsButton);
                    uploadDoc(allowLocationPage, false, 0);
                    clickElementByLocator("path", continueButton);
                } else {
                    getElementText("path", containerDismountedButton);
                    new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
                    clickElementByLocator("path", upLoadDocumentsButton);
                    uploadDoc(allowLocationPage, false, 0);
                    clickElementByLocator("path", continueButton);
                    getElementText("path", chassisDroppedButton);
                    new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
                    Thread.sleep(3000);
                    clickElementByLocator("path", continueButton);
                }
            }
        }
    }

    public void changeHookDisMountJobToCompleted(AllowLocationPage allowLocationPage) throws InterruptedException {
        if (attributeName.equals("text")) {
            clickElementByLocator("path", readyToStart);
            Thread.sleep(3000);
            clickElementByLocator("path", hookCompletedButton);
            Thread.sleep(3000);
            boolean isPresentConfirmButton = isElementPresent("path", confirmButton);
            if (isPresentConfirmButton) {
                clickElementByLocator("path", confirmButton);
            }
            clickElementByLocator("path", containerDismountedButton);
            Thread.sleep(3000);
            clickElementByLocator("path", upLoadDocumentsButton);
            uploadDoc(allowLocationPage, true, 0);
            clickElementByLocator("path", continueButton);
            clickElementByLocator("path", chassisDroppedButton);
            Thread.sleep(3000);
        } else {
            getElementText("path", readyToStart);
            new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
            Thread.sleep(3000);
            getElementText("path", hookCompletedButton);
            new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
            Thread.sleep(3000);
            boolean isPresentConfirmButton = isElementPresent("path", confirmButton);
            if (isPresentConfirmButton) {
                new TouchAction(driver).tap(PointOption.point(190, 750)).perform();
            }
            getElementText("path", containerDismountedButton);
            new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
            Thread.sleep(3000);
            clickElementByLocator("path", upLoadDocumentsButton);
            uploadDoc(allowLocationPage, true, 0);
            clickElementByLocator("path", continueButton);
            getElementText("path", chassisDroppedButton);
            new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
            Thread.sleep(3000);
        }
    }

    public void changeJobStatus(AllowLocationPage allowLocationPage) throws InterruptedException {
        String jobType = getTypeOfTripsJob();
        if ((checkJobIsHasManyLoads()) && (!jobType.equals("legacyJob"))) {
            if (attributeName.equals("text")) {
                clickElementByLocator("path", promptMessage);
            } else {
                new TouchAction(driver).tap(PointOption.point(270, 750)).perform();
            }
            Thread.sleep(6000);
            jobType = getTypeOfTripsJob();
        }
        switch (jobType) {
            case "legacyJob":
                changeLegacyJobStatusToCompleted(allowLocationPage);
                break;
            case "hookAndDrop":
                changeHookDropJobToCompleted(allowLocationPage);
                break;
            case "hookAndMount":
                changeHookMountJobToCompleted(allowLocationPage);
                break;
            case "hookAndDismount ":
                changeHookDisMountJobToCompleted(allowLocationPage);
                break;
            default:
                changeHookLiveUnloadJobToCompleted(allowLocationPage);
        }
    }

}
