package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.openqa.selenium.By.xpath;

public class MyLoadDetailsPage extends PageProperty {

    public String readyToStart="(//*[contains(@%s, \"I'm ready to start driving\")])[last()]";

    //status for trips job
    public String arrivedInOrigination="(//*[contains(@%s, \"I'm Hooked\")])[last()]";
    public String arrivedInDestination="(//*[contains(@%s, \"I've Dropped\")])[last()]";
    public String liveOnLoad="(//*[contains(@%s, \"I'm Unloaded\")])[last()]";

    //status for legacy job
    public String arrived="(//*[contains(@%s, \"I've Arrived\")])[last()]";
    public String pickUp="(//*[contains(@%s, \"I've Picked Up\")])[last()]";
    public String readyToLeave="(//*[contains(@%s, \"I'm Leaving\")])[last()]";
    public String delivered="(//*[contains(@%s, \"I've Delivered\")])[last()]";

    //button to upload pod or not
    public String continuePOD="(//*[contains(@%s, 'Continue')])[last()]";
    public String notContinueUploadPOD="//*[contains(@%s, 'Not Now')]";
    public String upLoadPODButton="//*[@%s='Upload POD']";

    //submit carrier invoice
    public String resume="//*[contains(@%s,'Resume')]";
    public String completeInvoiceButton="(//*[contains(@%s, 'Complete Invoice')])[last()]";
    public String submitInvoice="(//*[@%s='Submit Invoice'])[last()]";
    public String skipInvoice="(//*[@%s='Skip invoice for now'])[last()]";
    public String goToMyLoadsButton="(//*[contains(@%s,'Go back to My Loads')])[last()]";
    public String getpayment="//*[contains(@%s, 'Payment will arrive in 3-5 days')]";

    public Map<String, String> myLoadsDetailCardMap;

    public MyLoadDetailsPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
        if (attributeName.equals("text")) {
            myLoadsDetailCardMap = new HashMap<>();
            myLoadsDetailCardMap.put("takePhoto","(//*[@class='android.widget.ImageView'])[2]");
            myLoadsDetailCardMap.put("submitPOD","(//*[@class='android.widget.ImageView'])[3]");
            myLoadsDetailCardMap.put("PODForSecond","//*[contains(@text, 'Upload POD')]/parent::*/following-sibling::*/*/*[2]/*/*");
            myLoadsDetailCardMap.put("PODForFirst","//*[contains(@text, 'Upload POD')]/parent::*/following-sibling::*/*/*[1]/*/*");
            myLoadsDetailCardMap.put("closeSubmitPage","//*[contains(@text, '\uF406')]");
            myLoadsDetailCardMap.put("backToMyLoads","//*[contains(@text, '\uF3CF')]");
        }else{
            myLoadsDetailCardMap = new HashMap<>();
            myLoadsDetailCardMap.put("takePhoto","//*[@name='camera']");
            myLoadsDetailCardMap.put("submitPOD","//*[@name='right']");
            myLoadsDetailCardMap.put("PODForSecond","//XCUIElementTypeStaticText[@name='Upload POD']/parent::*/parent::*/following-sibling::*/*/*/*[2]");
            myLoadsDetailCardMap.put("PODForFirst","//XCUIElementTypeStaticText[@name='Upload POD']/parent::*/parent::*/following-sibling::*/*/*/*[1]");
            myLoadsDetailCardMap.put("closeSubmitPage","//XCUIElementTypeStaticText[@name=\"\uF406\"]");
            myLoadsDetailCardMap.put("backToMyLoads","//XCUIElementTypeStaticText[@name=\"\uF3CF\"]");
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
            new TouchAction(driver).press(PointOption.point(183,634)).perform();
        }
        Thread.sleep(3000);
    }
}
