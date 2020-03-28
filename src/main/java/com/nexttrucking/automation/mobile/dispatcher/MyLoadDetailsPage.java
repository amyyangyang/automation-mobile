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
    public String arrivedInOrigination = "(//*[contains(@%s, \"Hook Completed\")])[last()]";
    public String arrivedInDestination = "(//*[contains(@%s, \"Drop Completed\")])[last()]";
    public String liveUnloadCompletedButton = "(//*[contains(@%s, \"Live Unload Completed\")])[last()]";

    //status for legacy job
    public String arrived = "(//*[contains(@%s, \"I've Arrived\")])[last()]";
    public String pickUp = "(//*[contains(@%s, \"Pickup Completed\")])[last()]";
    public String readyToLeave = "(//*[contains(@%s, \"I'm Leaving\")])[last()]";
    public String delivered = "(//*[contains(@%s, \"Delivery Completed\")])[last()]";

    //button to upload pod or not
    public String continueButton = "(//*[contains(@%s, 'Continue')])[last()]";
    public String upLoadDocumentsButton = "(//*[@%s='Upload Documents'])[last()]";

    //submit carrier invoice
    public String resume = "(//*[@%s='Resume'])[last()]";
    public String reviewInvoiceButton = "//*[contains(@%s, 'Review Invoice')]";
    public String completeInvoiceButton = "(//*[contains(@%s, 'Complete Invoice')])[last()]";
    public String submitInvoice = "(//*[@%s='Submit Invoice'])[last()]";
    public String skipInvoice = "(//*[@%s='Skip invoice for now'])[last()]";
    public String goToMyLoadsButton = "(//*[contains(@%s,'Go back to My Loads')])[last()]";
    public String getPayment = "//*[contains(@%s, 'Payment will arrive in 3-5 days')]";
    public String editPODButton = "(//*[contains(@%s,'Edit POD')])[last()]";
    public String invoiceTitle = "(//*[@%s='Invoice'])[last()]";

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

    //button
    public String undoButton = "(//*[contains(@%s, 'Undo')])[last()]";
    public String confirmButton = "//*[contains(@%s, 'Yes,I Confirm')]";
    public String confirmChassisSizeButton = "//*[contains(@%s, 'Yes,I'm Sure')]";

    //status button
    public String chassisHooked = "//*[contains(@%s, 'Chassis Hooked')]";
    public String containerMounted = "//*[contains(@%s, 'Container Mounted')]";
    public String containerDismounted = "//*[contains(@%s, 'Container Dismounted')]";
    public String chassisDropped = "//*[contains(@%s, 'Chassis Dropped')]";

    //add chassis
    public String addButton = "//*[contains(@%s, 'Add')]";
    public String nextButton = "//*[@%s='Next']";
    public String addChassisNumberButton = "//*[contains(@%s, 'Add Chassis Number')]";
    public String chassisNumberInput = "//*[contains(@%s, \"What's the chassis number?\")]/following-sibling::*/following-sibling::*/child::*[2]";
    public String chassisSizeRadio = "(//*[contains(@%s,'20 ft')]/following-sibling::*)[1]";

    public Map<String, String> myLoadsDetailCardMap;

    public MyLoadDetailsPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
        if (attributeName.equals("text")) {
            myLoadsDetailCardMap = new HashMap<>();
            myLoadsDetailCardMap.put("takePhoto", "(//*[@class='android.widget.ImageView'])[2]");
            myLoadsDetailCardMap.put("submitPOD", "(//*[@class='android.widget.ImageView'])[3]");
            myLoadsDetailCardMap.put("PODForSecond", "//*[contains(@text, 'Upload POD')]/parent::*/parent::*/following-sibling::*/*/*/*/*[2]");
            myLoadsDetailCardMap.put("PODForFirst", "//*[contains(@text, 'Upload POD')]/parent::*/parent::*/following-sibling::*/*/*/*/*[1]");
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
        } else {
            myLoadsDetailCardMap = new HashMap<>();
            myLoadsDetailCardMap.put("takePhoto", "//*[@name='camera']");
            myLoadsDetailCardMap.put("submitPOD", "//*[@name='right']");
            myLoadsDetailCardMap.put("PODForSecond", "//XCUIElementTypeScrollView/*/*[2]");
            myLoadsDetailCardMap.put("PODForFirst", "//XCUIElementTypeScrollView/*/*[1]");
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

    public void changeTripJobStatus(AllowLocationPage allowLocationPage) throws InterruptedException {
        clickElementByLocator("path", readyToStart);
        Thread.sleep(3000);
        clickElementByLocator("path", arrivedInOrigination);
        Thread.sleep(3000);
        Boolean isLiveLoad = isElementPresent("path", liveUnloadCompletedButton);
        if (isLiveLoad) {
            clickElementByLocator("path", liveUnloadCompletedButton);
            Thread.sleep(6000);
            clickElementByLocator("path", continueButton);
            Thread.sleep(3000);
            clickElementByLocator("path", myLoadsDetailCardMap.get("PODForFirst"));
            uploadPOD(allowLocationPage, true, 0);
        }
        clickElementByLocator("path", arrivedInDestination);
        Thread.sleep(6000);
        clickElementByLocator("path", continueButton);
        Thread.sleep(3000);
        if (isLiveLoad) {
            clickElementByLocator("path", myLoadsDetailCardMap.get("PODForSecond"));
        } else {
            clickElementByLocator("path", myLoadsDetailCardMap.get("PODForFirst"));
        }
        uploadPOD(allowLocationPage, !isLiveLoad, 1);
    }


    public void changeLegacyJobStatus(AllowLocationPage allowLocationPage) throws InterruptedException {
        List<String> status = new ArrayList<String>() {
        };
        status.add(readyToStart);
        status.add(arrived);
        status.add(pickUp);
        status.add(readyToLeave);
        status.add(arrived);
        status.add(delivered);
        for (int step = 0; step < status.size(); step++) {
            clickElementByLocator("path", status.get(step));
            Thread.sleep(6000);
        }
        clickElementByLocator("path", continueButton);
        uploadPOD(allowLocationPage, true, 0);
    }

    public void uploadPOD(AllowLocationPage allowLocationPage, Boolean isFirst, int index) throws InterruptedException {
        if (isFirst) {
            allowLocationPage.clickOkAllowLocationButton();
            if (attributeName.equals("text")) {
                allowLocationPage.clickAllowLocationButton();
            } else {
                allowLocationPage.clickOkAllowLocationButton();
            }
        }
        driver.findElements(By.xpath(String.format(addButton, attributeName))).get(index).click();
        clickElementByLocator("path", myLoadsDetailCardMap.get("takePhoto"));
        Thread.sleep(10000);
        clickElementByLocator("path", myLoadsDetailCardMap.get("submitPOD"));
        Thread.sleep(10000);
    }

    public void skipSubmitInvoice() {
        clickElementByLocator("path", myLoadsDetailCardMap.get("closeSubmitPage"));
        if (attributeName.equals("text")) {
            clickElementByLocator("path", skipInvoice);
        } else {
            new TouchAction(driver).press(PointOption.point(171, 750)).perform();
        }
        clickElementByLocator("path", myLoadsDetailCardMap.get("backToMyLoads"));
    }

    public void submitInvoice() throws InterruptedException {
        boolean isPresentReviewInvoiceButton = isElementPresent("path", reviewInvoiceButton);
        if (isPresentReviewInvoiceButton) {
            clickElementByLocator("path", reviewInvoiceButton);
        } else {
            clickElementByLocator("path", completeInvoiceButton);
        }
        clickElementByLocator("path", submitInvoice);
        Thread.sleep(6000);
        if (attributeName.equals("text")) {
            clickElementByLocator("path", goToMyLoadsButton);
        } else {
            new TouchAction(driver).press(PointOption.point(183, 766)).perform();
            new TouchAction(driver).press(PointOption.point(150, 760)).perform();
            new TouchAction(driver).press(PointOption.point(180, 765)).perform();
        }
        Thread.sleep(3000);
    }

    public void changeTripJobStatusAtLastToUploadPOD(AllowLocationPage allowLocationPage) throws InterruptedException {
        clickElementByLocator("path", readyToStart);
        Thread.sleep(3000);
        clickElementByLocator("path", arrivedInOrigination);
        Thread.sleep(6000);
        Boolean isLiveLoad = isElementPresent("path", liveUnloadCompletedButton);
        if (isLiveLoad) {
            clickElementByLocator("path", liveUnloadCompletedButton);
            Thread.sleep(6000);
            clickElementByLocator("path", myLoadsDetailCardMap.get("notContinueUploadPOD"));
            Thread.sleep(3000);
        }
        clickElementByLocator("path", arrivedInDestination);
        Thread.sleep(6000);
        clickElementByLocator("path", myLoadsDetailCardMap.get("notContinueUploadPOD"));
        Thread.sleep(3000);
        clickElementByLocator("path", upLoadDocumentsButton);
        clickElementByLocator("path", myLoadsDetailCardMap.get("PODForFirst"));
        uploadPOD(allowLocationPage, true, 0);
        if (isLiveLoad) {
            clickElementByLocator("path", myLoadsDetailCardMap.get("PODForSecond"));
            uploadPOD(allowLocationPage, false, 1);
        }
        Thread.sleep(3000);
    }

    public void completeJobAfterCheckPreOperation(AllowLocationPage allowLocationPage) throws InterruptedException {
        clickElementByLocator("path", upLoadDocumentsButton);
        clickElementByLocator("path", myLoadsDetailCardMap.get("PODForFirst"));
        uploadPOD(allowLocationPage, true, 0);
        clickElementByLocator("path", arrivedInDestination);
        Thread.sleep(6000);
        clickElementByLocator("path", continueButton);
        clickElementByLocator("path", myLoadsDetailCardMap.get("PODForSecond"));
        uploadPOD(allowLocationPage, false, 1);

    }

    public void checkPreOperation() throws InterruptedException {
        clickElementByLocator("path", readyToStart);
        Thread.sleep(3000);
        clickElementByLocator("path", arrivedInOrigination);
        Thread.sleep(3000);
        clickElementByLocator("path", liveUnloadCompletedButton);
        Thread.sleep(3000);
        clickElementByLocator("path", myLoadsDetailCardMap.get("notContinueUploadPOD"));
        Thread.sleep(3000);
        if (attributeName.equals("text")) {
            clickElementByLocator("path", liveUnload);
        } else {
            clickElementByLocator("path", liveUnLoadByLabel);
        }
        Thread.sleep(6000);
    }

    public void checkUndoOperationInProgressUploadPOD(AllowLocationPage allowLocationPage) throws InterruptedException {
        clickElementByLocator("path", readyToStart);
        Thread.sleep(3000);
        clickElementByLocator("path", undoButton);
        Assert.assertEquals(getElementText("path", readyToStart), "I'm Ready to Start Driving");
        clickElementByLocator("path", readyToStart);
        clickElementByLocator("path", arrivedInOrigination);
        Thread.sleep(3000);
        clickElementByLocator("path", undoButton);
        Assert.assertEquals(getElementText("path", arrivedInOrigination), "Hook Completed");
        clickElementByLocator("path", arrivedInOrigination);
        clickElementByLocator("path", liveUnloadCompletedButton);
        //upload first instruction POD
        clickElementByLocator("path", continueButton);
        clickElementByLocator("path", myLoadsDetailCardMap.get("PODForFirst"));
        uploadPOD(allowLocationPage, true, 0);
        Assert.assertEquals(getElementText("path", arrivedInDestination), "Drop Completed");
        clickElementByLocator("path", arrivedInDestination);
        //upload second instruction POD
        clickElementByLocator("path", continueButton);
        clickElementByLocator("path", myLoadsDetailCardMap.get("PODForSecond"));
        uploadPOD(allowLocationPage, false, 1);
    }

    public String getTypeOfTripsJob() {
        int count = driver.findElementsByAccessibilityId(originalAddress).size();
        String addressList = new String();
        for (int i = 0; i < count; i++) {
            System.out.print(driver.findElementsByAccessibilityId(originalAddress).get(i).getText());
            addressList+=(driver.findElementsByAccessibilityId(originalAddress).get(i).getText());
        }
        if (addressList.toString().contains("Hook") && addressList.toString().contains("Drop")) {
            return "hookAndDrop";
        } else if (addressList.toString().contains("Hook") && addressList.toString().contains("Mount")) {
            return "hookAndMount";
        } else if (addressList.toString().contains("Hook") && addressList.toString().contains("Dismount")) {
            return "HookAndDismount";
        } else {
            return "HookAndLiveUnload";
        }
    }

    public void addChassisNumber(String chassisNumber) throws InterruptedException {
        clickElement(addChassisNumberButton);
        driver.findElementByXPath(String.format(chassisNumberInput,attributeName)).sendKeys(chassisNumber);
        clickElement(nextButton);
        Thread.sleep(3000);
        clickElement(chassisSizeRadio);
        boolean isPresentConfirmSizeButton = isElementPresent("path", confirmChassisSizeButton);
        if (isPresentConfirmSizeButton) {
            clickElementByLocator("path", confirmChassisSizeButton);
        }
        clickElement(addButton);
        Thread.sleep(6000);
    }

    public String generateChassisNumber() {
        String chassisNumber = "NEXT";
        int number = (int) ((Math.random() * 9 + 1) * 100000);
        chassisNumber += String.valueOf(number);
        return chassisNumber;
    }

    public void changeHookDropJobToCompleted(AllowLocationPage allowLocationPage) throws InterruptedException {
        clickElementByLocator("path", readyToStart);
        Thread.sleep(3000);
        clickElementByLocator("path", arrivedInOrigination);
        Thread.sleep(3000);
        clickElementByLocator("path", arrivedInDestination);
        Thread.sleep(3000);
        clickElementByLocator("path", upLoadDocumentsButton);
        uploadPOD(allowLocationPage, true, 0);
        clickElementByLocator("path", continueButton);
    }

    public void changeHookLiveUnloadJobToCompleted(AllowLocationPage allowLocationPage) throws InterruptedException {
        clickElementByLocator("path", readyToStart);
        Thread.sleep(3000);
        clickElementByLocator("path", arrivedInOrigination);
        Thread.sleep(3000);
        String chassisNumber = generateChassisNumber();
        addChassisNumber(chassisNumber);
        clickElementByLocator("path", liveUnloadCompletedButton);
        Thread.sleep(6000);
        clickElementByLocator("path", upLoadDocumentsButton);
        uploadPOD(allowLocationPage, true, 0);
        boolean isPresentDroppedButton = isElementPresent("path", arrivedInDestination);
        if (isPresentDroppedButton) {
            clickElementByLocator("path", arrivedInDestination);
            Thread.sleep(3000);
            clickElementByLocator("path", upLoadDocumentsButton);
            uploadPOD(allowLocationPage, false, 1);
        } else {
            clickElementByLocator("path", containerDismounted);
            Thread.sleep(3000);
            clickElementByLocator("path", upLoadDocumentsButton);
            uploadPOD(allowLocationPage, false, 1);
            clickElementByLocator("path", continueButton);
            clickElementByLocator("path", chassisDropped);
            Thread.sleep(3000);
        }
    }

    public void changeHookMountJobToCompleted(AllowLocationPage allowLocationPage) throws InterruptedException {
        clickElementByLocator("path", readyToStart);
        Thread.sleep(3000);
        clickElementByLocator("path", chassisHooked);
        Thread.sleep(6000);
        String chassisNumber = generateChassisNumber();
        addChassisNumber(chassisNumber);
        clickElementByLocator("path", containerMounted);
        Thread.sleep(3000);
        boolean isLiveUnloadJob = isElementPresent("path", liveUnloadCompletedButton);
        if (!isLiveUnloadJob) {
            clickElementByLocator("path", arrivedInDestination);
            Thread.sleep(3000);
            clickElementByLocator("path", upLoadDocumentsButton);
            uploadPOD(allowLocationPage, true, 0);
        } else {
            clickElementByLocator("path", liveUnloadCompletedButton);
            Thread.sleep(3000);
            clickElementByLocator("path", upLoadDocumentsButton);
            uploadPOD(allowLocationPage, true, 0);
            clickElementByLocator("path", continueButton);
            boolean isDropButton = isElementPresent("path", arrivedInDestination);
            if (isDropButton) {
                clickElementByLocator("path", arrivedInDestination);
                clickElementByLocator("path", upLoadDocumentsButton);
                uploadPOD(allowLocationPage, false, 1);
            } else {
                clickElement(containerDismounted);
                clickElementByLocator("path", upLoadDocumentsButton);
                uploadPOD(allowLocationPage, false, 1);
                clickElementByLocator("path", chassisDropped);
                Thread.sleep(3000);
            }
            clickElementByLocator("path", continueButton);
        }
    }

    public void changeHookDisMountJobToCompleted(AllowLocationPage allowLocationPage) throws InterruptedException {
        clickElementByLocator("path", readyToStart);
        Thread.sleep(3000);
        clickElementByLocator("path", arrivedInOrigination);
        Thread.sleep(3000);
        clickElementByLocator("path", confirmButton);
        clickElementByLocator("path", containerDismounted);
        Thread.sleep(3000);
        clickElementByLocator("path", upLoadDocumentsButton);
        uploadPOD(allowLocationPage, true, 0);
        clickElementByLocator("path", continueButton);
        clickElementByLocator("path", chassisDropped);
        Thread.sleep(3000);
    }

    public void changeJobStatus(AllowLocationPage allowLocationPage)throws InterruptedException{
        String jobType=getTypeOfTripsJob();
        switch(jobType){
            case "hookAndDrop" :
                changeHookDropJobToCompleted(allowLocationPage);
                break;
            case "hookAndMount" :
                changeHookMountJobToCompleted(allowLocationPage);
                break; //可选
            case "hookAndDismount ":
                changeHookDisMountJobToCompleted(allowLocationPage);
                break;
            default :
                changeHookLiveUnloadJobToCompleted(allowLocationPage);
        }
    }

}
