package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.*;

import static org.openqa.selenium.By.xpath;

public class MyloadsPage extends PageProperty {

    private AppiumDriver<MobileElement> driver;
    private String attributeName;

    public By backButton = xpath("//*[contains(@text, '\uF1C3')]");
    public By assignDriverButton = xpath("//*[contains(@text, 'Assign a')]");
    public By reassignDriverButton = xpath("//*[contains(@text, 'reassign a Driver')]");
    public By driverButton = xpath("//*[contains(@text, '2 Ui')]/following-sibling::*[1]");
    public By anotherDriverButton = xpath("//*[contains(@text, 'driver1 Ui')]/following-sibling::*[1]");
    public By assignButton = xpath("(//*[contains(@text, 'Assign')])[last()]");
    public By addDriverButton = xpath("//*[contains(@text, 'Add a Driver')]");
    public By addButton = xpath("//*[contains(@text, 'Add')]");
    public String noLoadOnMyLoads = "//*[contains(@%s, 'Go claim')]";

    public String jobState="jobStatusText";
    public String jobNumber="jobNumText";
    public String payment="priceText";
    public String originationAddress="address_0";
    public String desitinationAddress="address_1";
    public String pickUpTime="time_0";
    public String deliveryTime="time_1";

    public String readyToStart="(//*[contains(@%s, \"I'm ready to start driving\")])[last()]";

    //status for trips job
    public String arrivedInOrigination="(//*[contains(@%s, \"I've Hooked\")])[last()]";
    public String arrivedInDestination="(//*[contains(@%s, \"I've Dropped\")])[last()]";
    public String liveOnLoad="(//*[contains(@%s, \"I'm Unloaded\")])[last()]";

    //status for legacy job
    public String arrived="(//*[contains(@%s, \"I've Arrived\")])[last()]";
    public String pickUp="(//*[contains(@%s, \"I've Picked Up\")])[last()]";
    public String readyToLeave="(//*[contains(@%s, \"I'm Leaving\")])[last()]";
    public String delivered="(//*[contains(@%s, \"I've Delivered\")])[last()]";

    //button to upload pod or not
    public String continuePOD="//*[contains(@%s, 'Continue')]";
    public String PODFor="//*[contains(@%s, 'DROP')]";
    public String PODForLiveOnLoad="//*[contains(@%s, 'LIVE_UNLOAD')]";
    public String upLoadPODButton="//*[@%s='Upload POD']";
    public String notContinueUploadPOD="//*[contains(@%s, 'Not Now')]";
    public String backToMyLoads="//*[contains(@text, '\uF1C3')]";

    //submit carrier invoice
    public String resume="//*[contains(@%s,'Resume')]";
    public String completeButton="//*[contains(@%s, 'Complete')]";
    public String submitInvoice="//*[contains(@%s, 'Submit Invoice')]";
    public String getpayment="//*[contains(@%s, 'Payment will arrive in 3-5 days')]";

    public Map<String, String> myLoadsCardMap;

    public MyloadsPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
        if (attributeName.equals("text")) {
            myLoadsCardMap = new HashMap<>();
            myLoadsCardMap.put("jobState", "//*[contains(@content-desc, 'myloads_view_list')]/child::*[1]/child::*/child::*[1]/child::*[1]/child::*[1]");
            myLoadsCardMap.put("jobNum", "//*[contains(@content-desc, 'myloads_view_list')]/child::*[1]/child::*/child::*[1]/child::*[2]");
            myLoadsCardMap.put("originationAddress", "//*[contains(@content-desc, 'myloads_view_list')]/child::*[1]/child::*/child::*[1]/child::*[6]");
            myLoadsCardMap.put("destinationAddress", "//*[contains(@content-desc, 'myloads_view_list')]/child::*[1]/child::*/child::*[1]/child::*[11]");
            myLoadsCardMap.put("pickupTime", "//*[contains(@content-desc, 'myloads_view_list')]/child::*[1]/child::*/child::*[1]/child::*[8]");
            myLoadsCardMap.put("deliveryTime", "//*[contains(@content-desc, 'myloads_view_list')]/child::*[1]/child::*/child::*[1]/child::*[13]");
            myLoadsCardMap.put("payout", "//*[contains(@content-desc, 'myloads_view_list')]/child::*[1]/child::*/child::*[1]/child::*[3]");
            myLoadsCardMap.put("numberOfLoad", "//*[contains(@content-desc, 'myloads_view_list')]/child::*[1]/child::*/child::*[1]/child::*[1]/child::*[1]");
            myLoadsCardMap.put("takePhoto","(//*[@class='android.widget.ImageView'])[2]");
            myLoadsCardMap.put("submitPOD","(//*[@class='android.widget.ImageView'])[3]");
        }else{
            myLoadsCardMap.put("takePhoto","//*[@name='camera']");
            myLoadsCardMap.put("submitPOD","//*[@name='right']");
        }
    }

    public void assignDriver() {
        driver.findElement(assignDriverButton).click();
        driver.findElement(driverButton).click();
        driver.findElement(assignButton).click();
    }

    public void reassignDriver() {
        driver.findElement(reassignDriverButton).click();
        driver.findElement(anotherDriverButton).click();
        driver.findElement(assignButton).click();
    }

    public void changeTripJobStatus(AllowLocationPage allowLocationPage) throws InterruptedException{
        clickElementByLocator("path",readyToStart);
        Thread.sleep(3000);
        clickElementByLocator("path",arrivedInOrigination);
        Thread.sleep(3000);
        Boolean isLiveLoad=isElementPresent("path",liveOnLoad);
        if(isLiveLoad) {
            clickElementByLocator("path",liveOnLoad);
            clickElementByLocator("path",continuePOD);
            clickElementByLocator("path",PODForLiveOnLoad);
            uploadPOD(allowLocationPage,true);
        }
        clickElementByLocator("path",arrivedInDestination);
        Thread.sleep(3000);
        clickElementByLocator("path",continuePOD);
        clickElementByLocator("path",PODFor);
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
            Thread.sleep(3000);
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
        clickElementByLocator("path",myLoadsCardMap.get("takePhoto"));
        Thread.sleep(6000);
        clickElementByLocator("path",myLoadsCardMap.get("submitPOD"));
        Thread.sleep(6000);
    }

}
