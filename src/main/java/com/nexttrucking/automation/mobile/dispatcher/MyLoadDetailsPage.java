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

import static org.openqa.selenium.By.xpath;

public class MyLoadDetailsPage extends PageProperty {

    public String readyToStart="(//*[contains(@%s, \"I'm Ready to Start Driving\")])[last()]";

    //status for trips job
    public String arrivedInOrigination="(//*[contains(@%s, \"Hook Completed\")])[last()]";
    public String arrivedInDestination="(//*[contains(@%s, \"Drop Completed\")])[last()]";
    public String liveOnLoad="(//*[contains(@%s, \"Live Unload Completed\")])[last()]";

    //status for legacy job
    public String arrived="(//*[contains(@%s, \"I've Arrived\")])[last()]";
    public String pickUp="(//*[contains(@%s, \"Pickup Completed\")])[last()]";
    public String readyToLeave="(//*[contains(@%s, \"I'm Leaving\")])[last()]";
    public String delivered="(//*[contains(@%s, \"Delivery Completed\")])[last()]";

    //button to upload pod or not
    public String continuePOD="(//*[contains(@%s, 'Continue')])[last()]";
    public String upLoadPODButton="(//*[@%s='Upload POD'])[last()]";

    //submit carrier invoice
    public String resume="(//*[@%s='Resume'])[last()]";
    public String completeInvoiceButton="(//*[contains(@%s, 'Complete Invoice')])[last()]";
    public String submitInvoice="(//*[@%s='Submit Invoice'])[last()]";
    public String skipInvoice="(//*[@%s='Skip invoice for now'])[last()]";
    public String goToMyLoadsButton="(//*[contains(@%s,'Go back to My Loads')])[last()]";
    public String getPayment="//*[contains(@%s, 'Payment will arrive in 3-5 days')]";
    public String editPODButton = "(//*[contains(@%s,'Edit POD')])[last()]";
    public String invoiceTitle = "(//*[@%s='Invoice'])[last()]";

    //tab
    public String liveUnload="(//*[contains(@text,'Live Unload')])[last()]";
    public String liveUnLoadByLabel="(//*[contains(@label,'Live Unload')])[last()]";

    //undoButton
    public String undoButton="(//*[contains(@%s, 'Undo')])[last()]";


    public Map<String, String> myLoadsDetailCardMap;

    public MyLoadDetailsPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
        if (attributeName.equals("text")) {
            myLoadsDetailCardMap = new HashMap<>();
            myLoadsDetailCardMap.put("takePhoto","(//*[@class='android.widget.ImageView'])[2]");
            myLoadsDetailCardMap.put("submitPOD","(//*[@class='android.widget.ImageView'])[3]");
            myLoadsDetailCardMap.put("PODForSecond","//*[contains(@text, 'Upload POD')]/parent::*/parent::*/following-sibling::*/*/*/*/*[2]");
            myLoadsDetailCardMap.put("PODForFirst","//*[contains(@text, 'Upload POD')]/parent::*/parent::*/following-sibling::*/*/*/*/*[1]");
            myLoadsDetailCardMap.put("firstInstructionAction","//*[contains(@text, 'Upload POD')]/parent::*/parent::*/following-sibling::*/*/*/*/*[1]/*/*/*[1]");
            myLoadsDetailCardMap.put("secondInstructionAction","//*[contains(@text, 'Upload POD')]/parent::*/parent::*/following-sibling::*/*/*/*/*[2]/*/*/*[1]");
            myLoadsDetailCardMap.put("firstInstructionAddress","//*[contains(@text, 'Upload POD')]/parent::*/parent::*/following-sibling::*/*/*/*/*[1]/*/*/*[3]");
            myLoadsDetailCardMap.put("secondInstructionAddress","//*[contains(@text, 'Upload POD')]/parent::*/parent::*/following-sibling::*/*/*/*/*[2]/*/*/*[3]");
            myLoadsDetailCardMap.put("firstInstructionBlueIcon","//*[contains(@text, 'Upload POD')]/parent::*/parent::*/following-sibling::*/*/*/*/*[1]/*/*/*[2]");
            myLoadsDetailCardMap.put("secondInstructionBlueIcon","//*[contains(@text, 'Upload POD')]/parent::*/parent::*/following-sibling::*/*/*/*/*[2]/*/*/*[2]");
            myLoadsDetailCardMap.put("closeSubmitPage","//*[contains(@text, '\uF406')]");
            myLoadsDetailCardMap.put("backToMyLoads","//*[contains(@text, '\uF3CF')]");
            myLoadsDetailCardMap.put("notContinueUploadPOD","//*[contains(@text, '\uF406')]");
        }else{
            myLoadsDetailCardMap = new HashMap<>();
            myLoadsDetailCardMap.put("takePhoto","//*[@name='camera']");
            myLoadsDetailCardMap.put("submitPOD","//*[@name='right']");
            myLoadsDetailCardMap.put("PODForSecond","//XCUIElementTypeScrollView/*/*[2]");
            myLoadsDetailCardMap.put("PODForFirst","//XCUIElementTypeScrollView/*/*[1]");
            myLoadsDetailCardMap.put("firstInstructionAction","(//XCUIElementTypeStaticText[@name='action'])[1]");
            myLoadsDetailCardMap.put("firstInstructionAddress","(//XCUIElementTypeStaticText[@name='address'])[1]");
            myLoadsDetailCardMap.put("secondInstructionAction","(//XCUIElementTypeStaticText[@name='action'])[2]");
            myLoadsDetailCardMap.put("secondInstructionAddress","(//XCUIElementTypeStaticText[@name='address'])[2]");
            myLoadsDetailCardMap.put("firstInstructionBlueIcon","(//XCUIElementTypeStaticText[@name=\"\uF14A\"])[1]");
            myLoadsDetailCardMap.put("secondInstructionBlueIcon","(//XCUIElementTypeStaticText[@name=\"\uF14A\"])[2]");
            myLoadsDetailCardMap.put("closeSubmitPage","//XCUIElementTypeStaticText[@name=\"\uF406\"]");
            myLoadsDetailCardMap.put("backToMyLoads","//XCUIElementTypeStaticText[@name=\"\uF3CF\"]");
            myLoadsDetailCardMap.put("notContinueUploadPOD","//XCUIElementTypeStaticText[@name=\"\uF406\"]");
        }
    }

    public void changeTripJobStatus(AllowLocationPage allowLocationPage) throws InterruptedException{
        clickElementByLocator("path",readyToStart);
        Thread.sleep(3000);
        clickElementByLocator("path",arrivedInOrigination);
        Thread.sleep(3000);
        Boolean isLiveLoad=isElementPresent("path",liveOnLoad);
        if(isLiveLoad) {
            clickElementByLocator("path",liveOnLoad);
            Thread.sleep(6000);
            clickElementByLocator("path",continuePOD);
            Thread.sleep(3000);
            clickElementByLocator("path",myLoadsDetailCardMap.get("PODForFirst"));
            uploadPOD(allowLocationPage,true);
        }
        clickElementByLocator("path",arrivedInDestination);
        Thread.sleep(6000);
        clickElementByLocator("path",continuePOD);
        Thread.sleep(3000);
        if(isLiveLoad){
            clickElementByLocator("path",myLoadsDetailCardMap.get("PODForSecond"));
        }else{
            clickElementByLocator("path",myLoadsDetailCardMap.get("PODForFirst"));
        }
        uploadPOD(allowLocationPage,!isLiveLoad);
    }

    public void changeLegacyJobStatus(AllowLocationPage allowLocationPage) throws InterruptedException {
        List<String> status=new ArrayList<String>() {};
        status.add(readyToStart);
        status.add(arrived);
        status.add(pickUp);
        status.add(readyToLeave);
        status.add(arrived);
        status.add(delivered);
        for(int step=0;step<status.size();step++) {
            clickElementByLocator("path",status.get(step));
            Thread.sleep(6000);
        }
        clickElementByLocator("path",continuePOD);
        uploadPOD(allowLocationPage,true);
    }

    public void uploadPOD(AllowLocationPage allowLocationPage,Boolean isFirst) throws InterruptedException{
        //clickElementByLocator("path",upLoadPODButton);
        if(isFirst){
            allowLocationPage.clickOkAllowLocationButton();
            if(attributeName.equals("text")){
                allowLocationPage.clickAllowLocationButton();
            }else{
                allowLocationPage.clickOkAllowLocationButton();}
        }
        clickElementByLocator("path",myLoadsDetailCardMap.get("takePhoto"));
        Thread.sleep(10000);
        clickElementByLocator("path",myLoadsDetailCardMap.get("submitPOD"));
        Thread.sleep(10000);
    }

    public void skipSubmitInvoice(){
        clickElementByLocator("path",myLoadsDetailCardMap.get("closeSubmitPage"));
        if(attributeName.equals("text")){
            clickElementByLocator("path",skipInvoice);
        }else{
            new TouchAction(driver).press(PointOption.point(171,610)).perform();
        }
        clickElementByLocator("path",myLoadsDetailCardMap.get("backToMyLoads"));
    }

    public void submitInvoice()throws InterruptedException{
        //clickElementByLocator("path",completeInvoiceButton);
        clickElementByLocator("path",submitInvoice);
        Thread.sleep(6000);
        if(attributeName.equals("text")) {
            clickElementByLocator("path",goToMyLoadsButton);
        }else{
            new TouchAction(driver).press(PointOption.point(183,617)).perform();
            new TouchAction(driver).press(PointOption.point(183,570)).perform();
            new TouchAction(driver).press(PointOption.point(183,550)).perform();
            new TouchAction(driver).press(PointOption.point(183,600)).perform();
            new TouchAction(driver).press(PointOption.point(183,610)).perform();
            new TouchAction(driver).press(PointOption.point(183,590)).perform();
        }
        Thread.sleep(3000);
    }

    public void changeTripJobStatusAtLastToUploadPOD(AllowLocationPage allowLocationPage) throws InterruptedException{
        clickElementByLocator("path",readyToStart);
        Thread.sleep(3000);
        clickElementByLocator("path",arrivedInOrigination);
        Thread.sleep(6000);
        Boolean isLiveLoad=isElementPresent("path",liveOnLoad);
        if(isLiveLoad) {
            clickElementByLocator("path",liveOnLoad);
            Thread.sleep(6000);
            clickElementByLocator("path",myLoadsDetailCardMap.get("notContinueUploadPOD"));
            Thread.sleep(3000);
        }
        clickElementByLocator("path",arrivedInDestination);
        Thread.sleep(6000);
        clickElementByLocator("path",myLoadsDetailCardMap.get("notContinueUploadPOD"));
        Thread.sleep(3000);
        clickElementByLocator("path",upLoadPODButton);
        clickElementByLocator("path",myLoadsDetailCardMap.get("PODForFirst"));
        uploadPOD(allowLocationPage,true);
        if(isLiveLoad){
            clickElementByLocator("path",myLoadsDetailCardMap.get("PODForSecond"));
            uploadPOD(allowLocationPage,false);
        }
        Thread.sleep(3000);
    }

    public void completeJobAfterCheckPreOperation(AllowLocationPage allowLocationPage)throws InterruptedException{
        clickElementByLocator("path",upLoadPODButton);
        clickElementByLocator("path",myLoadsDetailCardMap.get("PODForFirst"));
        uploadPOD(allowLocationPage,true);
        clickElementByLocator("path",arrivedInDestination);
        Thread.sleep(6000);
        clickElementByLocator("path",continuePOD);
        clickElementByLocator("path",myLoadsDetailCardMap.get("PODForSecond"));
        uploadPOD(allowLocationPage,false);

    }
    public void checkPreOperation()throws InterruptedException{
        clickElementByLocator("path",readyToStart);
        Thread.sleep(3000);
        clickElementByLocator("path",arrivedInOrigination);
        Thread.sleep(3000);
        clickElementByLocator("path",liveOnLoad);
        Thread.sleep(3000);
        clickElementByLocator("path",myLoadsDetailCardMap.get("notContinueUploadPOD"));
        Thread.sleep(3000);
        if(attributeName.equals("text")){
            clickElementByLocator("path",liveUnload);
        }else{
            clickElementByLocator("path",liveUnLoadByLabel);
        }
        Thread.sleep(6000);
    }

    public void checkUndoOperationInProgressUploadPOD(AllowLocationPage allowLocationPage)throws InterruptedException{
        clickElementByLocator("path",readyToStart);
        clickElementByLocator("path",undoButton);
        Assert.assertEquals(getElementText("path", readyToStart),"I'm Ready to Start Driving");
        clickElementByLocator("path",readyToStart);
        clickElementByLocator("path",arrivedInOrigination);
        clickElementByLocator("path",undoButton);
        Assert.assertEquals(getElementText("path", arrivedInOrigination),"Hook Completed");
        clickElementByLocator("path",arrivedInOrigination);
        clickElementByLocator("path",liveOnLoad);
        //upload first instruction POD
        clickElementByLocator("path",continuePOD);
        clickElementByLocator("path",myLoadsDetailCardMap.get("PODForFirst"));
        uploadPOD(allowLocationPage,true);
        Assert.assertEquals(getElementText("path", arrivedInDestination),"Drop Completed");
        clickElementByLocator("path",arrivedInDestination);
        //upload second instruction POD
        clickElementByLocator("path",continuePOD);
        clickElementByLocator("path", myLoadsDetailCardMap.get("PODForSecond"));
        uploadPOD(allowLocationPage,false);
    }
}
