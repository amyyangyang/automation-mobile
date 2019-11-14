package com.nexttrucking.automation.mobile.dispatcher;

import com.nexttrucking.automation.mobile.property.PageProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.List;
import java.util.regex.Pattern;

public class PaymentDetailPage extends PageProperty {

    public String addressText = "textGroupValue_0";
    public String locationPanel="(//*[contains(@%s,'Locations')])[last()]";

    public PaymentDetailPage(AppiumDriver<MobileElement> driver, String attributeName) {
        super(driver, attributeName);
    }

    public boolean isTerminalJob(String instructionAddress) throws InterruptedException{
        String pattern = ".*Terminal.*";
        boolean isTerminalJob = false;
        List<MobileElement> AddressElementsArray = driver.findElementsByAccessibilityId(instructionAddress);
        for (MobileElement addressElement : AddressElementsArray) {
            String addressName = addressElement.getText();
            if (Pattern.matches(pattern, addressName)) {
                isTerminalJob = true;
                break;
            }
        }
        return isTerminalJob;
    }
}
